package com.sinosoft.testcases.fccb;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.UnhandledAlertException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sinosoft.test.fccp.common.LoginPage;
import com.sinosoft.test.fccp.hbrwcl.ApproveInfoPage;
import com.sinosoft.test.fccp.hbrwcl.TaskProcessQueryPage;
import com.sinosoft.test.fccp.hbrwcl.TaskProcessResultPage;
import com.sinosoft.test.fccp.tbcl.BasicInfoPage;
import com.sinosoft.test.fccp.tbcl.PolicyFeePage;
import com.sinosoft.test.fccp.tbcl.RiskDetailPage;
import com.sinosoft.test.fccp.tbcl.RiskDetail_AbstractInsuredObjPage;
import com.sinosoft.test.fccp.tbcl.RiskDetail_CoInsuredPage;
import com.sinosoft.test.fccp.tbcl.RiskDetail_TermsPage;
import com.sinosoft.test.fccp.tbcl.RiskDetail_TypePage;
import com.sinosoft.test.fccp.tbcl.RiskDetail_insuredObjPage;
import com.sinosoft.test.fccp.tbcl.RiskSelectPage;
import com.sinosoft.test.fccp.tbcl.SubmitReviewResult;
import com.sinosoft.test.util.ExcelDataProvider;
import com.sinosoft.test.util.TestUtil;
import com.sinosoft.test.base.TestBase;
import com.sinosoft.test.fccp.common.HomePage;

public class TBGLTestCase extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	RiskSelectPage riskSelected;
	BasicInfoPage basicInfo;
	RiskDetailPage riskDetail;
	RiskDetail_TypePage riskDetail_type;
	RiskDetail_AbstractInsuredObjPage riskDetail_insrdObj;
	RiskDetail_TermsPage riskDetail_terms;
	RiskDetail_CoInsuredPage riskDetail_coInsured;
	PolicyFeePage policyFee;
	
	public TBGLTestCase() {
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
	}

	@DataProvider(name = "getTBCLTestData")
	public Iterator<Object[]> getTBCLTestData(Method method) throws FileNotFoundException {
        return (Iterator<Object[]>) new ExcelDataProvider(method.getName());
	}

	/**
	 *<p>FCCB_TBCL</p>
	 *<p>投保处理</p>
	 * @param context
	 * @param map
	 */
	@Test(priority = 1, dataProvider = "getTBCLTestData",enabled=true)
	public void FCCB_TBCL(ITestContext context ,Map<String, String> map) {
		logger.info("开始运行测试脚本，获取到的测试数据《getTBCLTestData》如下:");
		logger.info(TestUtil.getMapString(map));
		Reporter.log("CaseNo："+getTestCaseId(map),true);
		Reporter.log("测试数据："+TestUtil.getMapString(map),true);
		try {
			loginPage = new LoginPage();
			homePage = loginPage.login_normal();
			riskSelected = homePage.enterMenuTBCL();
			riskSelected.InputRiskGeneralAction(map);
			basicInfo = riskSelected.saveForNext();
			basicInfo.inputSalesInfoAction(map);
			basicInfo.inputPolicyInfoAction(map);
			basicInfo.inputOwnerInfoAction(map);
			riskDetail_type = basicInfo.saveBasicInfoAction(map); 
			String proposNO = riskDetail_type.saveProposalNumbes(map);
		    Reporter.log("投保单号码："+proposNO,true);
			riskDetail_type.InputRiskTypeInfoAction(map);
			riskDetail_type.inputInusredInfoAction(map);
			riskDetail_insrdObj = riskDetail_type.saveRiskDetailTypePage(map);
			//riskDetail_insrdObj = riskDetail_type.goToInsuredObjectPage(map);
			riskDetail_insrdObj.inputInsuredObjectAction(map);
			riskDetail_insrdObj.inputRiskCoverageAction(map);
			riskDetail_insrdObj.saveInsredObjectPage();
			riskDetail_terms = riskDetail_insrdObj.goToRiskTermsPage(map);
			riskDetail_terms.processTermsPage(map);
			riskDetail_coInsured = riskDetail_terms.goToCoInsuredPage(map);
			riskDetail_coInsured.processCoInsured(map);
			policyFee = riskDetail_terms.goToMainFrame_policyfee();
			policyFee.inputPolicyFeeAction(map);
			policyFee.savePolicyFee();
			SubmitReviewResult srr= policyFee.submitForReview(map);
			String fullText =srr.getFullResultText();
			Reporter.log("提交复核结果："+fullText,true);
			logger.debug("提交结果:"+"_"+fullText);
			String ExpectResult=map.get("submit_status");
			//Assert.assertTrue(fullText.contains("待双核审核"));
			Assert.assertTrue(fullText.contains(ExpectResult));

		}catch(UnhandledAlertException uae) {
			String scrn=TestUtil.takeDesktopScreenShot(getTestCaseId(map)+"_未知弹窗");
			map.put("message","未知弹窗_"+ uae.getAlertText());
			map.put("screenshot",scrn);
			waitAndAcceptAlert(uae.getAlertText(), 1);
			Assert.assertTrue(false);
		}catch(Exception e) {
			logger.info("执行测试用例发生了异常，开始截屏",e);
			String scrn=TestUtil.takeScreenshot(getTestCaseId(map)+"_异常截屏");
			map.put("message","未知异常"+ e.getMessage());
			map.put("screenshot",scrn);
			logger.info("执行测试用例发生了异常，截屏结束！");
			Assert.assertTrue(false);
		}finally {
			TestUtil.takeScreenshot(getTestCaseId(map)+"_退出前截屏");
			logger.info("进入Finally事件:RowID:"+map.get("ROW_ID"));
			logger.info("进入Finally事件:testCaseName:"+map.get("testCaseName"));
			logger.info("进入Finally事件:proposalNumber:"+map.get("proposalNumber"));
			logger.info("进入Finally事件:message:"+map.get("message"));
			logger.info("进入Finally事件:screenshot:"+map.get("screenshot"));
			Map<String,String> resMap= new HashMap<String,String>();
			resMap.put("proposalNumber", map.get("proposalNumber"));
			resMap.put("message", map.get("message"));
			resMap.put("screenshot", map.get("screenshot"));
			ExcelDataProvider.updateExcelCellValues(map.get("testCaseName"), map.get("ROW_ID"), resMap);
		}
	}
	/**
	 *<p>FCCB_HBCL</p>
	 *<p>核保处理</p>
	 * @param context
	 * @param map
	 */
	@Test(priority = 1, dataProvider = "getTBCLTestData" , enabled= false)
	public void FCCB_HBCL(ITestContext context ,Map<String, String> map) {
		context.setAttribute("case_id", getTestCaseId(map));
		try {
			loginPage = new LoginPage();
			homePage = loginPage.login_normal();
			TaskProcessQueryPage queryPage = homePage.enterMenuHBRWCL();
			ApproveInfoPage apv= queryPage.queryProposalForApprove("06201890101202000000000208");
			TaskProcessResultPage resPage=apv.approve("准予承保！", "同意");
			String ApvMsg=resPage.getApproveResult();
			Reporter.log("核保结果信息："+ApvMsg);		
		}catch(UnhandledAlertException uae) {
			String scrn=TestUtil.takeDesktopScreenShot(getTestCaseId(map)+"_未知弹窗");
			map.put("message","未知弹窗_"+ uae.getAlertText());
			map.put("screenshot",scrn);
			waitAndAcceptAlert(uae.getAlertText(), 1);
			Assert.assertTrue(false);
		}catch(Exception e) {
			logger.info("执行测试用例发生了异常，开始截屏",e);
			String scrn=TestUtil.takeScreenshot(getTestCaseId(map)+"_异常截屏");
			map.put("message","未知异常"+ e.getMessage());
			map.put("screenshot",scrn);
			Reporter.log("未知异常："+ e.getMessage());
			Reporter.log("截屏文件："+ scrn);
			logger.info("执行测试用例发生了异常，截屏结束！");
			Assert.assertTrue(false);
		}	
		
	}
	@AfterMethod
	public void tearDown(ITestContext context) {
		System.out.println("执行了退出事件：tearDown");
		driver.quit();
//		driver.navigate().refresh();
//		driver.get(driver.getCurrentUrl());
//		driver.navigate().to(driver.getCurrentUrl());
	}
	@AfterClass 
	public void Close() {
		System.out.println("执行了AfterClass事件：Close");
		
	}

}
