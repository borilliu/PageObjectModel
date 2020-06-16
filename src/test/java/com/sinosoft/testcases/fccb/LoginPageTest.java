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
	
	@Test(priority=1,enabled=false)
	public void loginTest(){
		loginPage.test();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		homePage.enterMenuTBCL();
//		riskSelected= new RiskSelectPage();
//		riskSelected.InputRiskGeneralAction("01", "0101", "0");
	}
	@Test(priority=2, dataProvider="getCRMTestData")
	public void tbclTest(String fbbs, String ywgs,String qdlx,String xstd,String ywy,String ywly,String cxywbs) {
		logger.info("开始运行测试脚本，获取到的测试数据如下");
		logger.info("fbbs="+fbbs+",ywgs="+ywgs+",qdlx="+qdlx);
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.enterMenuTBCL();
		riskSelected= new RiskSelectPage();
		riskSelected.InputRiskGeneralAction("01", "0101", "0");
		basicInfoPage = new BasicInfoPage();
		//basicInfoPage.inputSalesInfoAction("1-原保险保单", "01620189", "04", "T6209880101", "S000000029", "01010101", "HXXT-核心");
		basicInfoPage.inputSalesInfoAction(fbbs,ywgs, qdlx,xstd, ywy, ywly, cxywbs);
		basicInfoPage.inputPolicyInfoAction("0100000001", "1", "1","USA","美国黄河治理委员会", "1111", "0", "0", "1", "0001", "1", "1", "XBBDH000101");
		basicInfoPage.inputOwnerInfoAction("2", "测试团体", "0", "11112234", "4", "98767848", "投保人联系地址-新发地", "010", "65625058", "5058");
		basicInfoPage.inputContactInfoAction("测试联系人", "1", "测试部门", "13587654325", "abd@d234.com", "局长");
	}
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
	
	
	
	

}
