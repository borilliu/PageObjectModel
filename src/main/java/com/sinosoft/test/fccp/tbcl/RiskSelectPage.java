package com.sinosoft.test.fccp.tbcl;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.sinosoft.test.fccp.common.FccbBase;

public class RiskSelectPage extends FccbBase {

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

	/**
	 * @Fields ed_renewalNoIn : 续保保单号
	 */
	@FindBy(how = How.NAME, using = "renewalNoIn")
	WebElement edt_renewalNoIn;
	// 0601
	/**
	 * @Fields rdo_prePayFee : 是否预收保费
	 */
	@FindBy(how = How.NAME, using = "prePayFeeFlag")
	List<WebElement> rdo_prePayFee;
	/**
	 * @Fields rdo_carrayOver : 是否关联结转保单
	 */
	@FindBy(how = How.NAME, using = "carryOverInd")
	List<WebElement> rdo_carrayOver;

	/**
	 * @Fields ed_transferPolicyNo : 关联结转保单号
	 */
	@FindBy(how = How.NAME, using = "transferPolicyNo")
	WebElement edt_transferPolicyNo;

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
	WebElement edt_relatedPolicy;

	// Initializing the Page Objects:
	public RiskSelectPage() {
		goToMainArea();
/*		PageFactory.initElements(driver, this);
		btn_nextStep = super.waitAndGetElement(By.name("buttonNextStep"), 2);
		if (btn_nextStep == null){
		    throw new IllegalStateException("The Page is not loaded correctly: "+ driver.getCurrentUrl());
		}*/
		PageFactory.initElements(new AjaxElementLocatorFactory(driver(), 5) ,this);
		logger.debug("投保处理/险种选择");
	}

	// Actions:

	private void InputRiskGeneralAction(String riskClass, String riskCode, String renewalInd, 
										String renewalPolicy,String prePay, String carrayOver,
										String carrayOverPolicy, String relatedInd, String relatedPolicy
									  ) {
		this.SetCodeEditBox(edt_riskClass, riskClass);
		this.SetCodeEditBox(edt_riskCode, riskCode);
		this.SetRadioValue(rdo_renewal, renewalInd);
		if ("1".equals(renewalInd)) {// 如果是续保保单，可以录入续保保单号
			this.setEditboxValue(edt_renewalNoIn, renewalPolicy);
		}
		this.SetRadioValue(rdo_prePayFee, prePay);
		this.SetRadioValue(rdo_carrayOver, carrayOver);
		if ("1".equals(carrayOver)) {// 如果是续保保单，可以录入续保保单号
			this.setEditboxValue(edt_transferPolicyNo, carrayOverPolicy);
		}
		this.SetRadioValue(rdo_related, relatedInd);
		if ("1".equals(relatedInd)) {
			this.setEditboxValue(edt_relatedPolicy, relatedPolicy);
		}
		
	}

	/**
	 *<p>InputRiskGeneralAction</p>
	 *<p>录入险种基本信息</p>
	 * @param map
	 */
	public void InputRiskGeneralAction(Map<String, String> map) {
		this.InputRiskGeneralAction(map.get("riskClass"), map.get("riskCode"), map.get("renewalInd"),
							  map.get("renewalPolicy"), map.get("prePay"), map.get("carrayOver"), 
							  map.get("carrayOverPolicy"),map.get("relatedInd"), map.get("relatedPolicy")
							  );
	}
	/**
	 *<p>saveForNext</p>
	 *<p>点击下一步按钮</p>
	 * @return
	 */
	public BasicInfoPage saveForNext() {
		this.clickButton(btn_nextStep);
		return new BasicInfoPage();
	}
}
