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

public class PGGLTestCase extends TestBase {
	public PGGLTestCase() {
		super();
	}
	@BeforeClass 
	public void Init() {
		System.out.println("PGGLTestCase执行了BoforeClass事件：Init");
	    long id = Thread.currentThread().getId();
	    System.out.println("Init. Thread id is: " + id);
	
	}
	@BeforeMethod
	public void setup() {
		System.out.println("PGGLTestCase执行了BoforeMethod事件：Setup");
	    long id = Thread.currentThread().getId();
	    System.out.println("setup. Thread id is: " + id);
	    initialization();
	}

	/**
	 *<p>FCCB_TBCL</p>
	 *<p>投保处理</p>
	 * @param context
	 * @param map
	 */
	@Test
	public void FCCB_TBCL1() {
//		initialization();
	    long id = Thread.currentThread().getId();
	    System.out.println("FCCB_TBCL1. Thread id is: " + id);
	    LoginPage loginPage = new LoginPage();
	    HomePage homePage = loginPage.login_normal();
	    TaskProcessQueryPage queryPage= homePage.enterMenuHBRWCL();
	    String title = queryPage.getTitle();
	    System.out.println("进程【"+id+"】的Title is "+title);
		pause(5000);
		System.out.println("-----------------执行了方法一");
		
	}
	@Test
	public void FCCB_TBCL2() {
		//initialization();
	    long id = Thread.currentThread().getId();
	    System.out.println("FCCB_TBCL2. Thread id is: " + id);
	    LoginPage loginPage = new LoginPage();
	    HomePage homePage = loginPage.login_normal();
	    TaskProcessQueryPage queryPage= homePage.enterMenuHBRWCL();
	    String title = queryPage.getTitle();
	    System.out.println("进程【"+id+"】的Title is "+title);
		pause(5000);
		System.out.println("-----------------执行了方法二");
	}	
	@Test
	public void FCCB_TBCL3() {
//		initialization();
	    long id = Thread.currentThread().getId();
	    System.out.println("FCCB_TBCL3. Thread id is: " + id);
	    LoginPage loginPage = new LoginPage();
	    HomePage homePage = loginPage.login_normal();
	    TaskProcessQueryPage queryPage= homePage.enterMenuHBRWCL();
	    String title = queryPage.getTitle();
	    System.out.println("进程【"+id+"】的Title is "+title);
		pause(5000);
		System.out.println("-----------------执行了方法三");
	}
	@Test
	public void FCCB_TBCL4() {
//		initialization();
	    long id = Thread.currentThread().getId();
	    System.out.println("FCCB_TBCL4. Thread id is: " + id);
	    LoginPage loginPage = new LoginPage();
	    HomePage homePage = loginPage.login_normal();
	    TaskProcessQueryPage queryPage= homePage.enterMenuHBRWCL();
	    String title = queryPage.getTitle();
	    System.out.println("进程【"+id+"】的Title is "+title);
		pause(5000);
		System.out.println("-----------------执行了方法四");
	}
	@Test
/*	public void FCCB_TBCL5() {
	    long id = Thread.currentThread().getId();
	    System.out.println("Before test-method. Thread id is: " + id);
		loginPage = new LoginPage();
		homePage = loginPage.login_normal();
		pause(5000);
		System.out.println("-----------------执行了方法五");
	}
	@Test
	public void FCCB_TBCL6() {
	    long id = Thread.currentThread().getId();
	    System.out.println("Before test-method. Thread id is: " + id);
		loginPage = new LoginPage();
		homePage = loginPage.login_normal();
		pause(5000);
		System.out.println("-----------------执行了方法六");
	}
	@Test
	public void FCCB_TBCL7() {
	    long id = Thread.currentThread().getId();
	    System.out.println("Before test-method. Thread id is: " + id);
		loginPage = new LoginPage();
		homePage = loginPage.login_normal();
		pause(5000);
		System.out.println("-----------------执行了方法七");
	}
	@Test
	public void FCCB_TBCL8() {
	    long id = Thread.currentThread().getId();
	    System.out.println("Before test-method. Thread id is: " + id);
		loginPage = new LoginPage();
		homePage = loginPage.login_normal();
		pause(5000);
		System.out.println("-----------------执行了方法八");
	}*/
	@AfterMethod
	public void tearDown(ITestContext context) {
		quitDriver();
	}
}
