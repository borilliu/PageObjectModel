package com.sinosoft.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

/**
 * @author liu-b
 *
 */
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop; 
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger logger = Logger.getLogger(TestBase.class);
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Development\\driver\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("IE")){
			logger.info("start InternetExplorerDriver");
			try {
				System.setProperty("webdriver.ie.driver", "D:\\Development\\driver\\IEDriverServer.exe");	
				InternetExplorerOptions options = new InternetExplorerOptions();
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
				options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				
				driver = new InternetExplorerDriver(options);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().setScriptTimeout(TestUtil.SCRIPT_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				//driver.manage().window().maximize();	
			}catch(Exception e) {
				e.printStackTrace();
				logger.debug("加载IE驱动错误！",e);
			}
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		//driver.get(prop.getProperty("url"));
		
	}
	
	/**
	 * run the nominated js code
	 * 
	 * @param js
	 * @param element
	 */
	public void runJS(String js, WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript(js, element);
		} catch (Exception e) {
			//screenshotToLocal(testCaseName);
			logger.error(e);
		}
	}

	/**
	 * @param millisecond
	 *            time to wait, in millisecond
	 */
	public void pause(long millisecond) {
		try {
			Thread.sleep(millisecond);
		} catch (InterruptedException e) {
			// logger.error(e);
			e.printStackTrace();
		}
	}	
	
	/**
	 * rewrite the WebDriverWait method
	 *
	 * @param loc
	 *            the locator of the element to be find
	 * @param timeout
	 *            second
	 * @return the first element accord your locator until it is appeared in the
	 *         time range
	 */
	public WebElement waitAndGetElement(final By loc, long timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			element = wait.until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver d) {
					return d.findElement(loc);
				}
			});
		} catch (Exception e) {
			//screenshotToLocal(testCaseName);
			logger.error("Can not find element:"+e.getMessage());
		}
		return element;
	}	

	
	public void actionDoubleClick(WebElement element) {
		 new Actions(driver).doubleClick(element).perform();
	}
	public void actionClick(WebElement element) {
		 new Actions(driver).moveToElement(element, 10, 5).click().perform();
	}
	public void navigateToWindowByTitle(final String title, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			wait.until(new ExpectedCondition<String>() {
				@Override
				public String apply(WebDriver d) {
					for (String windowHandle : d.getWindowHandles()) {
						System.out.println(windowHandle);
						d.switchTo().window(windowHandle);
						System.out.println(d.getTitle());
						if (d.getTitle().contains(title))
							return d.getWindowHandle();
					}
					return null;
				}
			});
		} catch (Exception e) {
			// logger.error("Can not find element:", e);
		}
	}
	/**
	 *<p>openMenu</p>
	 *<p>打开菜单</p>
	 * @param menuString 使用“#”分割的菜单项目，如 传入"承保子系统#投保管理#投保处理" 将依次打开"承保子系统"->"投保管理" ->"投保处理"
	 */
	public void openMenu(String menuString) {
		this.goToMenuArea();
		String[] menus = menuString.split("#");
		for(int i=0;i<menus.length;i++) {
			WebElement menu = waitAndGetElement(By.linkText(menus[i]), 1);
			runJS("arguments[0].click();", menu);
			pause(200);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
	}		
	/**
	 *<p>goToURL</p>
	 *<p>打开链接</p>
	 * @param url 链接地址
	 */
	public void goToURL(String url) {
		driver.get(url);	
	}
	/**
	 *<p>goToWorkArea</p>
	 *<p>将浏览器工作区域切换到用户录入区域</p>
	 */
	public void goToWorkArea() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("myFrame");
	}
	/**
	 *<p>goToMenuArea</p>
	 *<p>将浏览器工作区域切换到带单工作区域</p>
	 */
	public void goToMenuArea() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("leftFrame");
	}
	/**
	 *<p>SetRadioValue</p>
	 *<p>为Radio设置值，选中给定的值</p>
	 * @param radioList 选项列表- WebElement list
	 * @param value 选中的值，对应Radio的Value
	 */
	public void SetRadioValue(List<WebElement> radioList,String value) {
		 for(WebElement radio:radioList) {
			 	String tmpVal = radio.getAttribute("value");
			 	if(value.equals(tmpVal)){
			 		if(!radio.isSelected()) {
			 			runJS("arguments[0].click();", radio);
			 		}
			 		break;
			 	}
	        }
	}
	
	/**
	 * 
	 *<p>setSelectText</p>
	 *<p>选中下拉列表的值</p>
	 * @param slcELe 下拉列表
	 * @param text  选中的列表项：使用显示文本。
	 */
	public void setSelectText(WebElement slcELe,String text) {
		Select  select = new Select(slcELe);
		select.selectByVisibleText(text);
	}
	
	/**
	 * 
	 *<p>setEditboxValue</p>
	 *<p>为文框赋值，复制前会清空原有值</p>
	 * @param edtEle 文本框
	 * @param text 输入值
	 */
	
	public void setEditboxValue(WebElement edtEle,String text) {
		edtEle.clear();
		edtEle.sendKeys(text);
	}
	/**
	 * 
	 *<p>setEditboxTValue</p>
	 *<p>为文本框赋值，并触发Tab键动作</p>
	 * @param edtEle 文本框
	 * @param text 输入值
	 */
	public void setEditboxTValue(WebElement edtEle,String text) {
		edtEle.clear();
		edtEle.sendKeys(text,Keys.TAB);
	}
	/**
	 * 
	 *<p>clickButton</p>
	 *<p>单击按钮</p>
	 * @param btnEle 按钮
	 */
	public void clickButton(WebElement btnEle) {
		this.jsClickButton(btnEle);
	}
	/**
	 * 
	 *<p>jsClickButton</p>
	 *<p>使用JS执行单击动作</p>
	 * @param btnEle
	 */
	public void jsClickButton(WebElement btnEle) {
		runJS("arguments[0].click();", btnEle);
	}
	/**
	 * 
	 *<p>dblclickButton</p>
	 *<p>双击按钮</p>
	 * @param btnEle 按钮
	 */
	public void dblclickButton(WebElement btnEle) {
		runJS("arguments[0].ondblclick();", btnEle);
	}


}
