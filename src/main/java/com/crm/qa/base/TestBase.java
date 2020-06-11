package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

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
				System.setProperty("webdriver.ie.driver", "D:\\Development\\driver\\IEDriverServer32.exe");	
				InternetExplorerOptions options = new InternetExplorerOptions();
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
				options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				driver = new InternetExplorerDriver(options);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().setScriptTimeout(TestUtil.SCRIPT_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				driver.manage().window().maximize();	
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
		driver.get(prop.getProperty("url"));
		
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
	
	/**
	 * @param timeout
	 *            time to wait, in second
	 * @param locator
	 *            position the element
	 */
	public boolean isElementPresent(By locator, long timeout) {
		boolean isFine = false;
		long timeBegins = System.currentTimeMillis();
		do {
			try {
				driver.findElement(locator);
				isFine = true;
				break;
			} catch (Exception e) {
				//screenshotToLocal(testCaseName);
				// logger.error("isElementPresent error :", e);
				System.out.println("等待发生异常 - isElementPresent");
			}
			pause(100);
			System.out.println("等待100毫秒，");
		} while (System.currentTimeMillis() - timeBegins <= timeout * 1000);

		return isFine;
	}
	
	/**
	 * rewrite findElement method   
	 * 
	 * @param loc
	 *            the locator of the element to be find
	 * @return WebElement
	 */
	public WebElement findElement(By loc) {
		WebElement element = null;
		try {
			element = driver.findElement(loc);
		} catch (Exception e) {
			//screenshotToLocal(testCaseName);
			// logger.error("Can not find element:", e);
			logger.error("Can not find element:", e);
		}
		return element;
	}	

}
