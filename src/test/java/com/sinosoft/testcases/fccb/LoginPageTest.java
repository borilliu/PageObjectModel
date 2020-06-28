package com.sinosoft.testcases.fccb;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sinosoft.test.fccp.common.LoginPage;
import com.sinosoft.test.fccp.tbcl.BasicInfoPage;
import com.sinosoft.test.fccp.tbcl.PolicyFeePage;
import com.sinosoft.test.fccp.tbcl.RiskDetailPage;
import com.sinosoft.test.fccp.tbcl.RiskDetail_TermsPage;
import com.sinosoft.test.fccp.tbcl.RiskDetail_TypePage;
import com.sinosoft.test.fccp.tbcl.RiskDetail_insuredObjPage;
import com.sinosoft.test.fccp.tbcl.RiskSelectPage;
import com.sinosoft.test.fccp.tbcl.SubmitReviewResult;
import com.sinosoft.test.util.ExcelDataProvider;
import com.crm.qa.util.TestUtil;
import com.sinosoft.test.base.TestBase;
import com.sinosoft.test.fccp.common.HomePage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	RiskSelectPage riskSelected;
	BasicInfoPage basicInfo;
	RiskDetailPage riskDetail;
	RiskDetail_TypePage riskDetail_type;
	RiskDetail_insuredObjPage riskDetail_insrdObj;
	RiskDetail_TermsPage riskDetail_terms;
	PolicyFeePage policyFee;
	public LoginPageTest() {
		super();
	}

	@BeforeClass 
	public void Init() {
		System.out.println("执行了BeforeClass事件：Init");
		
	}
	@BeforeMethod
	public void setup() {
		System.out.println("执行了BoforeMethod事件：Setup");
		initialization();
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

	@Test(priority = 3, dataProvider = "getTBCLTestData",expectedExceptions=Exception.class)
	public void FCCB_TBCL(Map<String, String> map) {
		logger.info("开始运行测试脚本，获取到的测试数据《getTBCLTestData》如下:");
		logger.info(TestUtil.getMapString(map));
		try {
			homePage = loginPage.login_normal();
			homePage.enterMenuTBCL();
			riskSelected = new RiskSelectPage();
			riskSelected.InputRiskGeneralAction(map);
			basicInfo = riskSelected.saveForNext();
			basicInfo.inputSalesInfoAction(map);
			basicInfo.inputPolicyInfoAction(map);
			basicInfo.inputOwnerInfoAction(map);
			riskDetail_type = basicInfo.saveBasicInfoAction(map); 
			riskDetail_type.getProposalNumbes();
			riskDetail_type.InputRiskTypeInfoAction(map);
			riskDetail_type.inputInusredInfoAction(map);
			riskDetail_insrdObj = riskDetail_type.saveRiskDetailTypePage();
			riskDetail_insrdObj.inputInsuredObjectAction(map);
			riskDetail_insrdObj.inputRiskCodeAction(map);
			riskDetail_insrdObj.saveInsredObjectPage();
			riskDetail_terms = riskDetail_insrdObj.goToRiskTermsPage(map);
			riskDetail_terms.saveTermsPage();
			//riskDetail_terms.goToUnionPage(map);
			policyFee = riskDetail_terms.goToMainFrame_policyfee();
			policyFee.inputPolicyFeeAction(map);
			policyFee.savePolicyFee();
			SubmitReviewResult srr= policyFee.submitForReview(map);
			String fullText =srr.getFullResultText();
			Assert.assertTrue(fullText.contains("待双核审核"));
			logger.info("提交结果:"+"_"+fullText);
		}catch(Exception e) {
			logger.info("执行测试用例发生了异常，开始截屏",e);
			TestUtil.takeScreenshot(getTestCaseId(map)+"_异常截屏");
			logger.info("执行测试用例发生了异常，截屏结束！",e);
		}
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("执行了退出事件：tearDown");
		driver.quit();
	}

}
