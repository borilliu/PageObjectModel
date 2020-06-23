package com.sinosoft.test.fccp.tbcl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RiskDetail_TermsPage extends RiskDetailPage {
	
	
	/**
	 * @Fields btn_savePage : 保存条款信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	public RiskDetail_TermsPage() {
		goToWorkArea();
		PageFactory.initElements(driver, this);
	}
	/**
	 *<p>saveTermsPage</p>
	 *<p>保存条款信息页面</p>
	 */
	public void saveTermsPage() {
		this.clickButton(btn_savePage);
	}
	
}
