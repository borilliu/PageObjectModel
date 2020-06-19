package com.sinosoft.testcases.fccb;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sinosoft.test.fccp.common.LoginPage;
import com.sinosoft.test.fccp.tbcl.BasicInfoPage;
import com.sinosoft.test.fccp.tbcl.RiskDetailPage;
import com.sinosoft.test.fccp.tbcl.RiskDetail_TypePage;
import com.sinosoft.test.fccp.tbcl.RiskDetail_insuredObjPage;
import com.sinosoft.test.fccp.tbcl.RiskSelectPage;
import com.sinosoft.test.util.ExcelDataProvider;
import com.crm.qa.util.TestUtil;
import com.sinosoft.test.base.TestBase;
import com.sinosoft.test.fccp.common.HomePage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	RiskSelectPage riskSelected;
	BasicInfoPage basicInfoPage;
	RiskDetailPage riskDetail;
	RiskDetail_TypePage riskDetail_Type;
	RiskDetail_insuredObjPage riskDetail_insrdObj;
	public LoginPageTest() {
		super();
	}

	@BeforeClass 
	public void Init() {
		System.out.println("执行了BeforeClass事件：Init");
		initialization();
		
	}
	@BeforeMethod
	public void setup() {
		System.out.println("执行了BoforeMethod事件：Setup");
		loginPage = new LoginPage();
	}

	@DataProvider(name = "getTBCLTestData")
	public Iterator<Object[]> getTBCLTestData(Method method) throws FileNotFoundException {
        return (Iterator<Object[]>) new ExcelDataProvider(method.getName());
	}
	@DataProvider(name = "getTBCLSimulateData")
	public Iterator<Object[]> getTBCLSimulateData(Method method) {
		System.out.println("调用的Method是："+method.getName());
		List<Object[]> list = new ArrayList<Object[]>();
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("riskClass", "01");
		map.put("riskCode", "0101");
		map.put("renewalInd", "0");
		map.put("renewalPolicy", "");
		map.put("prePay", "");
		map.put("carrayOver", "");
		map.put("carrayOverPolicy", "");
		map.put("relatedInd", "");
		map.put("relatedPolicy", "");


		map.put("fbbs", "1");
		map.put("ywgs", "01620189");
		map.put("qdlx", "04");
		map.put("xstd", "T6209880101");
		map.put("ywy", "S000000029");
		map.put("ywly", "01010101");
		map.put("cxywbs", "HXXT");
		
		map.put("cdjg", "0100000001");
		map.put("htzyjjfs", "1");
		map.put("jnwbz", "1");
		map.put("jw_country", "USA");
		map.put("jw_Addr", "美国黄河治理委员会");
		map.put("snbz", "1111");
		map.put("sftkbd", "0");
		map.put("sfdzbd", "0");
		map.put("sfxb", "0");
		map.put("fxqkyjytz", "0001");
		map.put("sfydyw", "1");
		map.put("sfsn", "1");
		map.put("xbbdh", "");
		Object[] object = new Object[1];
		object[0] = map;
		list.add(object);
		return list.iterator();

	}

	@Test(priority = 1, enabled = false)
	public void loginTest() {
		for (String windowHandle : driver.getWindowHandles()) {
			System.out.println("当前的共工作窗口：【"+driver.getTitle()+"】with handle -"+ windowHandle);
		}
	}

	@Test(priority = 2, dataProvider = "getCRMTestData",enabled = false)
	public void tbclTest(String fbbs, String ywgs, String qdlx, String xstd, String ywy, String ywly, String cxywbs) {
		logger.info("开始运行测试脚本，获取到的测试数据如下");
		logger.info("fbbs=" + fbbs + ",ywgs=" + ywgs + ",qdlx=" + qdlx);
		homePage = loginPage.login_normal();
		homePage.enterMenuTBCL();
		riskSelected = new RiskSelectPage();
		riskSelected.InputRiskGeneralAction("01", "0101", "0", "", "", "", "", "", "");
		basicInfoPage = new BasicInfoPage();
		// basicInfoPage.inputSalesInfoAction("1-原保险保单", "01620189", "04",
		// "T6209880101", "S000000029", "01010101", "HXXT-核心");
		basicInfoPage.inputSalesInfoAction(fbbs, ywgs, qdlx, xstd, ywy, ywly, cxywbs);
		basicInfoPage.inputPolicyInfoAction("0100000001", "1", "1", "USA", "美国黄河治理委员会", "1111", "0", "0", "0", "0001",
				"1", "1", "");
		basicInfoPage.inputOwnerInfoAction("2", "测试团体", "0", "G6200019603", "4", "98767848", "1901-01-01",
				"投保人联系地址-新发地", "010-65625058-5058", "测试联系人", "1", "局长", "13587654325", "abd@d234.com");
		basicInfoPage.saveBasicInfoAction();
	}

	@Test(priority = 3, dataProvider = "getTBCLTestData")
	public void FCCB_TBCL(Map<String, String> map) {
		logger.info("开始运行测试脚本，获取到的测试数据《getTBCLTestData》如下:");
		logger.info(TestUtil.getMapString(map));
		homePage = loginPage.login_normal();
		homePage.enterMenuTBCL();
		riskSelected = new RiskSelectPage();
		riskSelected.InputRiskGeneralAction(map);
		basicInfoPage = new BasicInfoPage();
		basicInfoPage.inputSalesInfoAction(map);
		basicInfoPage.inputPolicyInfoAction(map);
		basicInfoPage.inputOwnerInfoAction(map);
		//basicInfoPage.inputOwnerInfoAction("2", "测试团体", "0", "G6200019603", "4", "98767848", "1901-01-01","投保人联系地址-新发地", "010-65625058-5058", "测试联系人", "1", "局长", "13587654325", "abd@d234.com");
		basicInfoPage.saveBasicInfoAction();
		riskDetail = new RiskDetailPage();
		//riskDetail.InputRiskClassInfoAction(map);
		riskDetail_Type = riskDetail.goToRiskTypePage(map);
		riskDetail_Type.InputRiskClassInfoAction(map);
		riskDetail_insrdObj = riskDetail.goToInsuredObjectPage();
		riskDetail_insrdObj.InputInsuredObjectAction();
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();
		System.out.println("执行了退出事件：tearDown");
	}

}
