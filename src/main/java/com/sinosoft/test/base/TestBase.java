package com.sinosoft.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
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
import com.sinosoft.test.util.WebEventListener;


/**
 * @author liubenchao@sinsoft.com.cn
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
			//FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm/qa/config/config.properties");
			String path=System.getProperty("user.dir")+ "\\src\\main\\resources\\config.properties";
			System.out.println("配置文件路径："+path);
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("system.browser");
		
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
				options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ignore");
				options.setCapability(InternetExplorerDriver.LOG_LEVEL, "TRACE");
				options.setCapability(InternetExplorerDriver.LOG_FILE, "IE_LOG.log");

				
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
	 *<p>runJS</p>
	 *<p>在当前元素上运行脚本</p>
	 * @param js javascript 脚本
	 * @param element 选中的元素
	 * @param args JavaScript 参数
	 */
	public void runJS(String js, WebElement element) {
		logger.debug("RunJavaScript:"+ element.toString()+"->\r\n"+ js);
		try {
			((JavascriptExecutor) driver).executeScript(js, element);
		} catch (Exception e) {
			logger.error(e);
		}
	}


	/**
	 *<p>pause</p>
	 *<p>等待，停止执行</p>
	 * @param millisecond 毫秒 1000毫秒=1秒
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
	 *<p>waitAndGetElement</p>
	 *<p>通过等待获取页面元素</p>
	 * @param loc 查找条件
	 * @param timeout 超时设置 单位 秒
	 * @return 返回找到的元素，没有找到则返回 null
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
			logger.info("没有找到页面元素:"+loc.toString()+" - 错误信息"+e.getMessage());
		}
		return element;
	}	

	public boolean waitAndAcceptAlert(String title, long timeout) {
		boolean found = false;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			found = wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					Alert alt =d.switchTo().alert();
					System.out.println("Alert的标题是："+alt.getText());
					if(alt.getText().contains(title)) {
						alt.accept();
						return true;
					}else {
						return false;
					}
				}
			});
		} catch (Exception e) {
			System.out.println("没有找到标题为:"+title+" 的对话框");
			e.printStackTrace();
		}
		return found;
	}	
	
	public void actionDoubleClick(WebElement element) {
		 new Actions(driver).doubleClick(element).perform();
	}
	public void actionClick(WebElement element) {
		 new Actions(driver).click().perform();
	}
	public void navigateToWindowByTitle(final String title, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			wait.until(new ExpectedCondition<String>() {
				@Override
				public String apply(WebDriver d) {
					for (String windowHandle : d.getWindowHandles()) {
						//System.out.println(windowHandle);
						d.switchTo().window(windowHandle);
						//System.out.println(d.getTitle());
						System.out.println("切换到窗口【"+d.getTitle()+"】with handle -"+ windowHandle);
						if (d.getTitle().contains(title))
							// d.manage().window().maximize();
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
     *<p>highlight</p>
     *<p>高亮显示页面元素:黄色背景，红色边框</p>
     * @param element
     */
    public void highlight(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", 
                element,"background: yellow; border: 2px solid red;");
    }	
    /**
     *<p>取消高亮显示</p>
     *<p>该方法可能会改变原有按钮状态，需在后期改进</p>
     * @param element
     */
    public void resetHighlight(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", 
                element,"background: ''; border:'';");
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
	 *<p>SetRadioValue</p>
	 *<p>为Radio设置值，选中给定的值</p>
	 * @param radioList 选项列表- WebElement list
	 * @param value 选中的值，对应Radio的Value
	 */
	public void SetRadioValue(List<WebElement> radioList,String value) {
		if("".equals(value)) return;
		logger.debug("setEditboxTValue:"+ radioList.toString()+"->"+ value);
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
		logger.debug("setEditboxTValue:"+ slcELe.toString()+"->"+ text);
		this.highlight(slcELe);
		if("".equals(text)) {
			return;
		}
		Select  select = new Select(slcELe);
		select.selectByVisibleText(text);
	}
	/**
	 *<p>setSelectWithStartText</p>
	 *<p>根据起始字符选择列表项</p>
	 * @param slcELe
	 * @param startText
	 */
	public void setSelectWithStartText(WebElement slcELe,String startText) {
		logger.debug("setSelectWithStartText:"+ slcELe.toString()+"->"+ startText);
		this.highlight(slcELe);
		if("".equals(startText)) {
			return;
		}
		Select select = new Select(slcELe);
		List<WebElement> Options = select.getOptions();
		boolean found = false;
	    for (WebElement selectedOption : Options) {
	        String txt = selectedOption.getText();
	        if (null !=txt && txt.startsWith(startText)){
	        	logger.info("找到匹配【"+ startText+"】的选项："+ txt);
	        	select.selectByVisibleText(txt);
	        	found =true;
	        	break;
	        }
	    }
	    if(!found) {
	    	logger.error("没有找到以【"+startText+"】为起始的选项！" );
	    }
	}
	/**
	 * 
	 *<p>setEditboxValue</p>
	 *<p>为文框赋值，复制前会清空原有值</p>
	 * @param edtEle 文本框
	 * @param text 输入值
	 */
	
	public void setEditboxValue(WebElement edtEle,String text) {
		logger.debug("setEditboxValue:"+ edtEle.toString()+"->"+ text);
		this.highlight(edtEle);
		if("".equals(text)) {
			return;
		}
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
		logger.debug("setEditboxTValue:"+ edtEle.toString()+"->"+ text);
		if("".equals(text)) {
			return;
		}
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
		logger.debug("clickButton:"+ btnEle.toString());
		btnEle.click();
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
		logger.debug("dblclickButton:"+ btnEle.toString());
		this.actionDoubleClick(btnEle);
	}


}
