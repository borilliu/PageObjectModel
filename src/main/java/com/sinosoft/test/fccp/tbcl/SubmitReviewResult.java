package com.sinosoft.test.fccp.tbcl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SubmitReviewResult extends TbclMainFramePage {

	@FindBy(how = How.NAME, using = "GuProposalProposalNo")
	WebElement edt_proposalNo;
	public SubmitReviewResult() {
		this.goToMainArea();
		PageFactory.initElements(driver, this);
	}
	/**
	 *<p>getProposalNumber</p>
	 *<p>获取投保单号码</p>
	 * @return
	 */
	public String getProposalNumber() {
		return edt_proposalNo.getAttribute("value");
		
	}
	/**
	 *<p>getFullResultText</p>
	 *<p>获取提交复核的完成结果信息</p>
	 * @return
	 */
	public String getFullResultText() {
		return edt_proposalNo.findElement(By.xpath("..")).getText();
	}

}
