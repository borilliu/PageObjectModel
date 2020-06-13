package com.sinosoft.test.fccp.tbcl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.base.TestBase; 
 
public class RiskSelectPage extends TestBase {

	// common widgets
	/**
	 * @Fields rdo_planrisk : 险种计划
	 */
	@FindBy(how = How.NAME, using = "planrisk")
	List<WebElement> rdo_planrisk;

	/**
	 * @Fields edt_riskClass : 险类代码
	 */
	@FindBy(how = How.NAME, using = "riskClassTemp")
	WebElement edt_riskClass;

	/**
	 * @Fields edt_riskCode : 险种代码
	 */
	@FindBy(how = How.NAME, using = "riskCode")
	WebElement edt_riskCode;

	/**
	 * @Fields btn_nextStep : 下一步
	 */
	@FindBy(how = How.NAME, using = "buttonNextStep")
	@CacheLookup
	WebElement btn_nextStep;
	// 01**
	/**
	 * @Fields rdo_renewal : 是否续保
	 */
	@FindBy(how = How.NAME, using = "renewInd")
	List<WebElement> rdo_renewal;

	// 0601
	/**
	 * @Fields rdo_prePayFee : 是否预收保费
	 */
	@FindBy(how = How.NAME, using = "prePayFeeFlag")
	List<WebElement> rdo_prePayFee;
	// 0601
	/**
	 * @Fields rdo_carrayOver : 是否关联结转保单
	 */
	@FindBy(how = How.NAME, using = "carryOverInd")
	List<WebElement> rdo_carrayOver;

	// 0613/0636
	/**
	 * @Fields rdo_related : 是否录入关联保单号码
	 */
	@FindBy(how = How.NAME, using = "relatedInd")
	List<WebElement> rdo_related;

	/**
	 * @Fields ed_relatedPolicy : 关联保单号码
	 */
	@FindBy(how = How.NAME, using = "relatePolicyN")
	WebElement ed_relatedPolicy;

	// Initializing the Page Objects:
	public RiskSelectPage() {
		PageFactory.initElements(driver, this);
//		btn_nextStep = super.waitAndGetElement(By.name("buttonNextStep"), 2);
//		if (btn_nextStep == null){
//		    throw new IllegalStateException("The Page is not loaded correctly: "+ driver.getCurrentUrl());
//		}
//		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 1) ,this);
	}
	
	
	// Actions:

	public void InputRiskGeneralAction(String riskClass, String riskCode, String renewalInd) {
		this.setEditboxTValue(edt_riskClass, riskClass);
		this.setEditboxTValue(edt_riskCode, riskCode);
		this.SetRadioValue(rdo_renewal, renewalInd);
		this.clickButton(btn_nextStep);
		this.goToWorkArea();
//		runJS("arguments[0].onclick();", btn_nextStep);

//		Actions actions = new Actions(driver); 
//		actions.release();
//		WebElement nextBtn = this.waitAndGetElement(By.name("buttonNextStep"), 5);
//		actions.click(nextBtn).perform();

		// actions.contextClick(nextBtn).perform();
		// runJS("arguments[0].onclick();", btn_nextStep);

//		js2 = "var q=document.getElementById('map-distance').children[3].click()"
//				browser.execute_script(js2)
	}
}
