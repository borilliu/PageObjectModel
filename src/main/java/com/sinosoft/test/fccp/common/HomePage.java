package com.sinosoft.test.fccp.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.sinosoft.test.fccp.hbrwcl.TaskProcessQueryPage;
import com.sinosoft.test.fccp.tbcl.RiskSelectPage;
public class HomePage extends FccbBase {

	@CacheLookup
	WebElement frameset;
	// Initializing the Page Objects:
	public HomePage() {
		frameset = waitAndGetElement(By.tagName("frameset"),5);
		if (frameset==null){
		    throw new IllegalStateException("The HomePage is not loaded correctly,Current Page is "+ driver().getCurrentUrl()) ;
		}
//		PageFactory.initElements(new AjaxElementLocatorFactory(driver(), 5) ,this);
		PageFactory.initElements(driver(), this);
	}
	
	
	//Actions
	/**
	 * 进入菜单 - 投保管理/投保处理
	 */
	public RiskSelectPage enterMenuTBCL() {
			if(!this.isWelcomePage()) {
				logger.info("不在欢迎页面，刷新页面");
				driver().navigate().refresh();
			}
			this.openMenu("承保子系统#投保管理#投保处理");
			return new RiskSelectPage();
	}
	/**
	 *<p>enterMenuHBRWCL</p>
	 *<p>进入菜单-核保审核/任务处理/</p>
	 */
	public TaskProcessQueryPage enterMenuHBRWCL() {
		if(!this.isWelcomePage()) {
			logger.info("不在欢迎页面，刷新页面");
			driver().navigate().refresh();
		}
		this.openMenu("审核平台子系统#核保审核#任务处理");
		return new TaskProcessQueryPage();
}
	private boolean isWelcomePage(){
		driver().switchTo().defaultContent();
		driver().switchTo().frame("mainFrame");	  		
		WebElement welcomeImg = waitAndGetElement(By.xpath("//img[contains(@src,'welcome')]"), 5);
		return	(null != welcomeImg);
		
	}
	/**
	 *<p>goToMenuArea</p>
	 *<p>将浏览器工作区域切换到带单工作区域</p>
	 */
	public void goToMenuArea() {
		driver().switchTo().defaultContent();
		driver().switchTo().frame("leftFrame");
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
	}		
}
