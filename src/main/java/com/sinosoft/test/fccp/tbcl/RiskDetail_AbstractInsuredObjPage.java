package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class RiskDetail_AbstractInsuredObjPage extends RiskDetailPage {

	@FindBy(how = How.ID,using = "ItemPropertyDetail")
	//@FindBy(how = How.ID,using = "ItemPropertyDetailKind")
	WebElement tbl_BDWMX;

	/**
	 * @Fields btn_savePage : 保存标的信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	
	public static RiskDetail_AbstractInsuredObjPage getInstance(String riskClass) {
		switch (riskClass){
			case "07": 
				return new RiskDetail_JGX_insuredObjPage();
			default:
				return new RiskDetail_insuredObjPage();
		}
	}
	/**
	 *<p>InputInsuredObjectAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public  abstract void inputInsuredObjectAction(Map<String, String> map);

	/**
	 *<p>inputRiskCodeAction</p>
	 *<p>录入标的物险种信息</p>
	 * @param map
	 */
	public abstract  void inputRiskCoverageAction(Map<String, String> map);
	
	/**
	 *<p>saveInsredObjectPage</p>
	 *<p>保存标的物页面</p>
	 */
	public void saveInsredObjectPage(){
		this.clickButton(btn_savePage);
	}
	
}
