package com.sinosoft.test.fccp.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@CacheLookup
	WebElement frameset;
	// Initializing the Page Objects:
	public HomePage() {
		frameset = waitAndGetElement(By.tagName("frameset"),5);
		if (frameset==null){
		    throw new IllegalStateException("The HomePage is not loaded correctly,Current Page is "+ driver.getCurrentUrl()) ;
		}
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5) ,this);
	}
	
	
	//Actions
	/**
	 * 进入菜单 - 投保处理
	 */
	public void enterMenuTBCL() {
			if(!this.isWelcomePage()) {
				logger.info("不在欢迎页面，刷新页面");
				driver.navigate().refresh();
			}
			this.menuClick("承保子系统#投保管理#投保处理");
	}
	private void menuClick(String menuString) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("leftFrame");
		String[] menus = menuString.split("#");
		for(int i=0;i<menus.length;i++) {
			WebElement menu = waitAndGetElement(By.linkText(menus[i]), 1);
			runJS("arguments[0].click();", menu);
			pause(200);
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
	}
	private boolean isWelcomePage(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");	  		
		WebElement welcomeImg = waitAndGetElement(By.xpath("//img[contains(@src,'welcome')]"), 5);
		return	(null != welcomeImg);
			
	}
}
