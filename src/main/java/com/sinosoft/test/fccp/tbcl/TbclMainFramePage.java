package com.sinosoft.test.fccp.tbcl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.fccp.common.FccbBase;

public class TbclMainFramePage extends FccbBase {

	WebElement tbl_mainframe;
	
	@FindBy(how = How.NAME,using = "Save")
	WebElement btn_submitForReview;
	public TbclMainFramePage() {
		PageFactory.initElements(driver, this);
	}
	public PolicyFeePage goToMainFrame_policyfee() {
		goToMainFramePage("保单费用信息");
		return new PolicyFeePage();
	}
	public RiskDetail_TypePage goToMainFrame_riskType() {
		goToMainFramePage("险种信息");
		return new RiskDetail_TypePage();
	}
	public BasicInfoPage goToMainFrame_basicInfo() {
		goToMainFramePage("基本信息");
		return new BasicInfoPage();
	}
	private void goToMainFramePage(String TabName) {
		goToMainArea();
		tbl_mainframe = waitAndGetElement(By.xpath("//td[text()='"+TabName+"']"), 5);
		this.clickButton(tbl_mainframe);
		pause(WAIT_SECOND);
	}
	/**
	 *<p>submitForReview</p>
	 *<p>提交复核</p>
	 */
	public void submitForReview() {
		this.clickButton(btn_submitForReview);
	}
}
