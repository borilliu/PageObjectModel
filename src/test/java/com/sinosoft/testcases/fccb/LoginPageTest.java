package com.sinosoft.testcases.fccb;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.sinosoft.test.fccp.common.LoginPage;
import com.sinosoft.test.fccp.tbcl.RiskSelectPage;
import com.sinosoft.test.fccp.common.HomePage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}

	@Test(priority=1)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.enterMenuTBCL();
		RiskSelectPage riskSelected= new RiskSelectPage();
		riskSelected.doSelectAction("01", "0101", "0");
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
	
	
	

}
