package com.sinosoft.test.fccp.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(id="username")
	WebElement edt_username;
	
	@FindBy(id="password")
	WebElement edt_password;
	
	@FindBy(how = How.ID, using  ="bt_submit")
	WebElement btn_login;
	
	/**
	 * 继续登录按钮-使用时生成
	 */
	WebElement  btn_forceLogin;
	WebElement  txt_login;
	//Initializing the Page Objects:
	public LoginPage(){
		//PageFactory.initElements(driver, this);
		txt_login = super.waitAndGetElement(By.xpath("//p[text()='会员登录']"), 5);
		if (txt_login== null){
		    throw new IllegalStateException("The Page is not loaded correctly: "+ driver.getCurrentUrl());
		}
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5) ,this);

	}
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd){
		edt_username.sendKeys(un);
		edt_password.sendKeys(pwd);
		edt_password.sendKeys(Keys.TAB);
		btn_login.submit();

		btn_forceLogin = waitAndGetElement(By.xpath("//input[@value='继续登录']"),1);
		if(null != btn_forceLogin) {
			logger.info("重复登录，发现继续登录按钮，强制登录");
			super.runJS("arguments[0].click();", btn_forceLogin);
		}else{
			logger.info("常规登录，没有继续登录按钮");
		}
 	
		return new HomePage();
	}
	
}
