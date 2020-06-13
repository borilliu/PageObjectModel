package com.sinosoft.testcases.fccb;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sinosoft.test.fccp.common.LoginPage;
import com.sinosoft.test.fccp.tbcl.BasicInfoPage;
import com.sinosoft.test.fccp.tbcl.RiskSelectPage;
import com.crm.qa.util.TestUtil;
import com.sinosoft.test.base.TestBase;
import com.sinosoft.test.fccp.common.HomePage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	RiskSelectPage riskSelected;
	BasicInfoPage basicInfoPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData("TestData");
		return data;
	}
	
	@Test(priority=1, enabled=false)
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.enterMenuTBCL();
		riskSelected= new RiskSelectPage();
		riskSelected.InputRiskGeneralAction("01", "0101", "0");
	}
	@Test(priority=2, dataProvider="getCRMTestData")
	public void tbclTest(String fbbs, String ywgs,String qdlx,String xstd,String ywy,String ywly,String cxywbs) {
		logger.debug("开始运行测试脚本，获取到的测试数据如下");
		logger.debug("fbbs="+fbbs+",ywgs="+ywgs+",qdlx="+qdlx);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.enterMenuTBCL();
		riskSelected= new RiskSelectPage();
		riskSelected.InputRiskGeneralAction("01", "0101", "0");
		basicInfoPage = new BasicInfoPage();
		//basicInfoPage.inputSalesInfoAction("1-原保险保单", "01620189", "04", "T6209880101", "S000000029", "01010101", "HXXT-核心");
		basicInfoPage.inputSalesInfoAction(fbbs,ywgs, qdlx,xstd, ywy, ywly, cxywbs);
	}
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
	
	
	

}
