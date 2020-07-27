package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.util.TestUtil;

public class RiskDetail_TermsPage extends RiskDetailPage {
	
	
	/**
	 * @Fields btn_savePage : 保存条款信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	public RiskDetail_TermsPage() {
		goToWorkArea();
		PageFactory.initElements(driver(), this);
	}
	/**
	 *<p>saveTermsPage</p>
	 *<p>保存条款信息页面</p>
	 */
	public void saveTermsPage(Map<String, String> map) {
		this.clickButton(btn_savePage);
	}
	
	public void processTermsPage(Map<String, String> map) {
		//this.saveTermsPage(map);  TODO：没有数据修改，不需执行保存操作
		TestUtil.takeScreenshot(getTestCaseId(map)+"条款信息页面");
	}
	
}
