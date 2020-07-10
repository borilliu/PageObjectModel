package com.sinosoft.test.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
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

import com.sinosoft.test.util.TestUtil;
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
	public static int WAIT_SHORTEST = 200;
	public static int WAIT_SHORTER = 500;
	public static int WAIT_SECOND = 1000;
	public static int WAIT_LONGGER = 2000;
	public static int WAIT_LONGGEST = 5000;
	public static Logger logger = Logger.getLogger(TestBase.class);
	public TestBase(){
		try {
			if(prop==null) {
				prop = new Properties();
				//FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm/qa/config/config.properties");
				//String path=System.getProperty("user.dir")+ "\\src\\main\\resources\\config.properties";
				String path="config.properties";
				logger.info("配置文件路径："+path);
				//FileInputStream ip = new FileInputStream(path);
				InputStream ip = this.getClass().getClassLoader().getResourceAsStream(path);
				prop.load(ip);
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("初始化"+this.getClass().toString());
	}
	
	
	public static void initialization(){
		try {
			WAIT_SHORTEST =  Integer.valueOf(prop.getProperty("system.wait.shorttest"));
			WAIT_SHORTER =  Integer.valueOf(prop.getProperty("system.wait.shorter"));
			WAIT_SECOND =  Integer.valueOf(prop.getProperty("system.wait.second"));
			WAIT_LONGGER =  Integer.valueOf(prop.getProperty("system.wait.longer"));
			WAIT_LONGGEST =  Integer.valueOf(prop.getProperty("system.wait.loggest"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		prop.getProperty("system.browser");
		String browserName = prop.getProperty("system.browser");
		String projectPath=System.getProperty("user.dir");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", projectPath+"\\driver\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("IE")){
			logger.info("start InternetExplorerDriver");
			try {
				System.setProperty("webdriver.ie.driver",  projectPath+"\\driver\\IEDriverServer.exe");	
				InternetExplorerOptions options = new InternetExplorerOptions();
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
				options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				//options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ignore");
				options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
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
	 *<p>getTestCaseId</p>
	 *<p>获取当前测试用例的标识号</p>
	 * @param map
	 * @return
	 */
	public String getTestCaseId(Map<String, String> map) {
		return map.get("TestCaseName")+"_"+map.get("TestCaseSeq");
	}	

	/**
	 *<p>runJS</p>
	 *<p>在当前元素上运行脚本</p>
	 * @param js javascript 脚本
	 * @param element 选中的元素
	 * @param args JavaScript 参数
	 */
	public void runJS(String js, WebElement element) {
		logger.info("RunJavaScript:"+ element.toString()+"\t"+ js);
		try {
			((JavascriptExecutor) driver).executeScript(js, element);
		} catch (Exception e) {
			logger.error(e);
		}
	}
	  /**
	 *<p>jsInputValue</p>
	 *<p>使用JavaScript为元素赋值</p>
	 * @param value
	 * @param element
	 */
	public void jsInputValue(String value, WebElement element) {
		logger.info("RunJavaScript:"+ element.toString()+"："+ value);
          try{
                  ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", element, value);
          } catch(Exception e) {
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
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
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

	/**
	 *<p>waitAndAcceptAlert</p>
	 *<p>等待预期的弹出窗口并点击确认</p>
	 * @param title
	 * @param timeout
	 * @return
	 */
	public boolean waitAndAcceptAlert(String title, long timeout) {
		boolean found = false;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		try {
			found = wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					Alert alt =d.switchTo().alert();
					logger.debug("Alert的标题是："+alt.getText());
					if(alt.getText().contains(title)) {
						alt.accept();
						return true;
					}else {
						return false;
					}
				}
			});
		} catch (Exception e) {
			logger.debug("没有找到标题为:"+title+" 的对话框");
		}
		return found;
	}	

	/**
	 *<p>catchUnexpectedAlert</p>
	 *<p>返回Alert框，如果存在返回弹出框内容，不存在则返回空字符串</p>
	 * @param timeout
	 * @return
	 */
	public String catchUnexpectedAlert(long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		String title="";
		try {
			title = wait.until(new ExpectedCondition<String>() {
				@Override
				public String apply(WebDriver d) {
					Alert alt =d.switchTo().alert();
						String ttl = alt.getText();
						//alt.accept();
						return ttl; 
				}
			});
		} catch (Exception e) {
		}
		return title;
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
						//logger.debug(windowHandle);
						d.switchTo().window(windowHandle);
						//logger.debug(d.getTitle());
						logger.debug("系统窗口【"+d.getTitle()+"】with handle -"+ windowHandle);
						if (d.getTitle().contains(title))
							// d.manage().window().maximize();
							return d.getWindowHandle();
					}
					return null;
				}
			});
		} catch (Exception e) {
			 logger.debug("窗口切换异常:", e);
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
		logger.info("setEditboxTValue:"+ radioList.toString()+"："+ value);
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
		if("".equals(text)) {
			return;
		}
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
		if("".equals(text)) {
			return;
		}		
		logger.info("setEditboxValue:"+ edtEle.toString()+"："+ text);
		edtEle.clear();
		edtEle.sendKeys(text);
		logger.info("setEditboxValue—End:"+ edtEle.toString()+"："+ text);
	}
	
	/**
	 *<p>setEditboxApndValue</p>
	 *<p>在原有值上面添加新的信息</p>
	 * @param edtEle
	 * @param text
	 */
	public void setEditboxApndValue(WebElement edtEle,String text) {
		if("".equals(text)) {
			return;
		}		
		logger.info("setEditboxApndValue:"+ edtEle.toString()+"："+ text);
		String val= edtEle.getAttribute("value")+text;
		edtEle.sendKeys(val);
	}
	/**
	 * 
	 *<p>setEditboxTValue</p>
	 *<p>为文本框赋值，并触发Tab键动作</p>
	 * @param edtEle 文本框
	 * @param text 输入值
	 */
	public void setEditboxTValue(WebElement edtEle,String text) {
		logger.info("setEditboxTValue:"+ edtEle.toString()+"->"+ text);
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
		logger.info("clickButton:"+ btnEle.toString());
		btnEle.click();
	}
	public void clickElement(WebElement btnEle) {
		logger.info("clickElement:"+ btnEle.toString());
		btnEle.click();
	}
	/**
	 * 
	 *<p>jsClickButton</p>
	 *<p>使用JS执行单击动作</p>
	 * @param btnEle
	 */
	public void jsClickButton(WebElement btnEle) {
		logger.info("jsClickButton:"+ btnEle.toString());
		runJS("arguments[0].click();", btnEle);
	}
	/**
	 * 
	 *<p>dblclickButton</p>
	 *<p>双击按钮</p>
	 * @param btnEle 按钮
	 */
	public void dblclickButton(WebElement btnEle) {
		logger.info("dblclickButton:"+ btnEle.toString());
		this.actionDoubleClick(btnEle);
	}


}
