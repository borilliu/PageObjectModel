package com.sinosoft.test.fccp.hbrwcl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.fccp.common.FccbBase;

public class TaskProcessResultPage extends FccbBase {
	@FindBy(how = How.XPATH, using = "//td[@class='tishi']")
	WebElement text_result;
	public TaskProcessResultPage() {
		this.goToMainArea();
		PageFactory.initElements(driver, this);
	}
	
	/**
	 *<p>getApproveResult</p>
	 *<p>获取核保结果信息</p>
	 * @return
	 */
	public String getApproveResult() {
		return text_result.getText();
	}

}
