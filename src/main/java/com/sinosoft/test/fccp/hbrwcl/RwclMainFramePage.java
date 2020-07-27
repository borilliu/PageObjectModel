package com.sinosoft.test.fccp.hbrwcl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.fccp.common.FccbBase;
import com.sinosoft.test.fccp.tbcl.BasicInfoPage;

public class RwclMainFramePage extends FccbBase {
	WebElement tbl_mainframe;
	@FindBy(how = How.NAME,using = "Save")
	WebElement btn_submitForReview;

	/**
	 * @Fields btn_ViewSpecial : 	审核信息
	 */
	@FindBy(how = How.XPATH,using = "//td/input[@value='审核信息']")
	WebElement  btn_ApproveInfo;
	
	/**
	 * @Fields btn_ReInsuranceInfo : 	再保信息查看
	 */
	@FindBy(how = How.XPATH,using = "//td/input[@value='再保信息查看']")
	WebElement  btn_ReInsuranceInfo;
	
	/**
	 * @Fields btn_ReviewInfo : 	复核录单意见
	 */
	@FindBy(how = How.XPATH,using = "//td/input[@value='复核录单意见']")
	WebElement  btn_UWReviewInfo;
	
	/**
	 * @Fields btn_ReviewInfo : 	人工核保原因
	 */
	@FindBy(how = How.XPATH,using = "//td/input[@value='人工核保原因']")
	WebElement  btn_MannualUWReason;
	
	/**
	 * @Fields btn_ViewSpecial : 特约/免赔/限额信息查看
	 */
	@FindBy(how = How.XPATH,using = "//td/input[@value='特约/免赔/限额信息查看']")
	WebElement  btn_ViewSpecialInfo;
	public RwclMainFramePage() {
		PageFactory.initElements(driver(), this);
	}
	public BasicInfoPage goToMainFrame_basicInfo() {
		goToMainFramePage("审核信息");
		return new BasicInfoPage();
	}
	/**
	 *<p>checkTheReinsranceInfo</p>
	 *<p>检查再保信息</p>
	 */
	public void checkTheReinsranceInfo() {
		goToMainArea();
		this.jsClickButton(btn_ReInsuranceInfo);
		pause(2000);
		logger.info("点击了：检查再保信息");
	}
	
	/**
	 *<p>checkSpecialInfo</p>
	 *<p>特约/免赔/限额信息查看</p>
	 */
	public void checkSpecialInfo() {
		goToMainArea();
		this.jsClickButton(btn_ViewSpecialInfo);
		pause(2000);
		logger.info("点击了：特约/免赔/限额信息查看");
	}
	
	/**
	 *<p>checkApproveInfo</p>
	 *<p>审核信息</p>
	 */
	public void checkApproveInfo(){
		goToMainArea();
		this.jsClickButton(btn_ApproveInfo);
		pause(2000);
		logger.info("点击了：审核信息");
	}
	private void goToMainFramePage(String TabName) {
		goToMainArea();
		tbl_mainframe = waitAndGetElement(By.xpath("//td[text()='"+TabName+"']"), 5);
		//this.clickButton(tbl_mainframe);
		this.jsClickButton(tbl_mainframe);
		pause(WAIT_SECOND);
	}
}
