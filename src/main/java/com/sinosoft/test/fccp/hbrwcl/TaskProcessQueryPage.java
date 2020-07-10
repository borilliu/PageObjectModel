package com.sinosoft.test.fccp.hbrwcl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sinosoft.test.fccp.common.FccbBase;

public class TaskProcessQueryPage extends FccbBase {

	/**
	 * @Fields edt_SQDH : 申请单号
	 */
	@FindBy(how = How.NAME,using = "GwWfLogDtoBusinessNo")
	WebElement edt_SQDH;
	
	/**
	 * @Fields slc_FBBS : 是否包含下级任务池任务
	 */
	@FindBy(how = How.NAME,using = "GwWfLogDtoSubNodeSource")
	WebElement slc_XJRW;
	
	/**
	 * @Fields tbl_RESULT : 查询结果表
	 */
	@FindBy(how = How.ID,using = "ResultTable")
	WebElement tbl_RESULT;
	
	/**
	 * @Fields btn_query : 查询
	 */
	@FindBy(how = How.NAME,using = "buttonQuery")
	WebElement btn_query;
	public TaskProcessQueryPage() {
		PageFactory.initElements(driver, this);
	}
	/**
	 *<p>queryProposalForApprove</p>
	 *<p>查找需要审批的保单</p>
	 * @param proposalNo
	 * @return
	 */
	public ApproveInfoPage queryProposalForApprove(String proposalNo) {
		super.goToMainArea();
		this.setEditboxValue(edt_SQDH, proposalNo);
		this.setSelectWithStartText(slc_XJRW, "1");//包含下级任务
		this.clickButton(btn_query);
		gotoQueryResult();
		WebElement propNoCell= tbl_RESULT.findElement(By.tagName("a"));
		Assert.assertTrue(proposalNo.equals(propNoCell.getText()));
		propNoCell.click();
		waitAndAcceptAlert("本保单倒签单", 2);
		return new ApproveInfoPage();
	}
	private void gotoQueryResult() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame"); 
		driver.switchTo().frame("QueryResultFrame"); 
	}
}
