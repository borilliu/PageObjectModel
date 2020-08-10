package com.sinosoft.test.fccp.tbcl;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.util.TestUtil;

public class RiskDetail_TypePage_1200 extends RiskDetail_TypePage {
	/*****************************************
	 * 险种信息
	 *****************************************/
	/**
	 * @Fields slc_ZRBXJC : 责任险保单基础
	 */
	@FindBy(how = How.NAME,using = "GuRiskCompensationType")
	WebElement slc_ZRBXJC;
	
	/**
	 * @Fields edt_FXZZRQ : 发现终止日期
	 */
	@FindBy(how = How.NAME,using = "GuRiskDiscoverEndDate")
	WebElement edt_FXZZRQ;
	
	public RiskDetail_TypePage_1200() {
		goToWorkArea();
		edt_TKMC = super.waitAndGetElement(By.name("GuRiskProductEdition"), 10);
		PageFactory.initElements(driver(), this);
		logger.debug("投保处理/险种信息");
	}
	/**
	 *<p>InputRiskClassInfoAction</p>
	 *<p>录入险种信息</p>
	 */
	public void InputRiskTypeInfoAction(Map<String, String> map) {
		logger.info("开始处理风险类别信息");
		super.InputRiskTypeInfoAction(map);
		super.setSelectWithStartText(slc_ZRBXJC, map.get("zrxbdjc"));
		super.SetDateEditBox(edt_FXZZRQ, map.get("fxzzrq"));
	
	}	
	
	public void inputInusredInfoAction(Map<String, String> map) {
		super.inputInusredInfoAction(map);
	}

}
