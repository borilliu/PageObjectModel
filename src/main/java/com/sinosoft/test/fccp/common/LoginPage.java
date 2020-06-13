package com.sinosoft.test.fccp.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.sinosoft.test.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	/**
	 * @Fields edt_username : 用户名
	 */
	@FindBy(id="username")
	WebElement edt_username;

	/**
	 * @Fields edt_password : 密码
	 */
	@FindBy(id="password")
	WebElement edt_password;
	
	/**
	 * @Fields btn_login : 登录按钮
	 */
	@FindBy(how = How.ID, using  ="bt_submit")
	WebElement btn_login;
	
	/**
	 * 继续登录按钮-使用时生成
	 */
	/**
	 * @Fields btn_forceLogin : 继续登录
	 */
	WebElement  btn_forceLogin;
	/**
	 * @Fields txt_login : 会员登录
	 */
	WebElement  txt_login;

	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
//		txt_login = super.waitAndGetElement(By.xpath("//p[text()='会员登录']"), 5);
//		if (txt_login== null){
//		    throw new IllegalStateException("The Page is not loaded correctly: "+ driver.getCurrentUrl());
//		}
//		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5) ,this);

	}
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd){
		super.goToURL(prop.getProperty("url"));
		super.setEditboxValue(edt_username, un);
		super.setEditboxValue(edt_password, pwd);
		super.clickButton(btn_login);
		//btn_forceLogin = waitAndGetElement(By.xpath("//input[@value='继续登录']"),1);
		if(null != btn_forceLogin) {
			logger.info("重复登录，发现继续登录按钮，强制登录");
			super.clickButton(btn_forceLogin);
			//super.runJS("arguments[0].click();", btn_forceLogin);
		}else{
			logger.info("常规登录，没有继续登录按钮");
		}
		return new HomePage();
	}
	
}
