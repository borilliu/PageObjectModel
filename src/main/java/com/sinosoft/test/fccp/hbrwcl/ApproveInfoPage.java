package com.sinosoft.test.fccp.hbrwcl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApproveInfoPage extends RwclMainFramePage {

	
	/**
	 * @Fields txt_approveMsg : 审批意见
	 */
	@FindBy(how = How.NAME,using = "HandleText")
	WebElement txt_approveMsg;
	
	/**
	 * @Fields slc_approveNotion : 审批片语
	 */
	@FindBy(how = How.NAME,using = "NotionContent")
	WebElement slc_approveNotion;
	
	/**
	 * @Fields btn_SHTG : 审核通过
	 */
	@FindBy(how = How.NAME,using = "passBtn")
	WebElement  btn_Approve;
	
	/**
	 * @Fields btn_SHTG : 审核通过
	 */
	@FindBy(how = How.XPATH,using = "//td/input[@value='拒 保']")
	WebElement  btn_Refuse;
	
	/**
	 * @Fields btn_SHYJ : 审核意见
	 */
	@FindBy(how = How.NAME,using = "butViewTranceInfo")
	WebElement  btn_History;
	public ApproveInfoPage() {
		super();
		this.goToWorkArea();
		PageFactory.initElements(driver(), this);
	}
	
	/**
	 *<p>InputApproveMsg</p>
	 *<p>录入审批信息</p>
	 * @param msg
	 * @param notion
	 */
	public void InputApproveMsg(String msg,String notion) {
		this.goToWorkArea();
		this.setSelectText(slc_approveNotion, notion);
		this.setEditboxApndValue(txt_approveMsg, msg);
	
	}
	
	/**
	 *<p>refuse</p>
	 *<p>拒绝</p>
	 * @param msg
	 * @param notion
	 */
	public void refuse(String msg,String notion) {
		InputApproveMsg(msg,notion);
		btn_Refuse.click();
		waitAndAcceptAlert("确实要拒保吗", 5);
	}
	/**
	 *<p>approve</p>
	 *<p>审核通过</p>
	 * @param msg
	 * @param notion
	 */
	public TaskProcessResultPage approve(String msg,String notion) {
	/*	this.checkSpecialInfo();
		this.checkApproveInfo();
		this.checkTheReinsranceInfo();
		InputApproveMsg(msg,notion);
		this.jsClickButton(btn_History);*/
		pause(2000);
//		this.clickButton(btn_Approve);
//		waitAndAcceptAlert("确实要审核通过吗", 5);
		return new TaskProcessResultPage();
	}

}
