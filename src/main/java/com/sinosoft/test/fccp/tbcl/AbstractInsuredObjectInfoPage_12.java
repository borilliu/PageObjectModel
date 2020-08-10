package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sinosoft.test.fccp.common.FccbBase;

public abstract class AbstractInsuredObjectInfoPage_12 extends RiskDetailPage {

	/**
	 * @Fields edt_TBDM : 投保代码
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicItemCode")
	WebElement edt_TBDM;
	
	/**
	 * @Fields edt_BBDM : 币别代码/名称
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicCurrency")
	WebElement edt_BBDM;
	
	public static AbstractInsuredObjectInfoPage_12 getInstance(String riskCode) {
		switch(riskCode) {
			case "1254": return new InsuredObjectInfoPage_1254();
			case "1268": return new InsuredObjectInfoPage_1268();
			default: return new InsuredObjectInfoPage_1254();
		}
	}
	public abstract void inputInsuredObjectAction(Map<String, String> map);

	
	/**
	 *<p>inputInsuredObjectCommmon</p>
	 *<p>录入公用标的物信息</p>
	 * @param map
	 */
	protected void inputInsuredObjectCommmon(Map<String, String> map) {
		this.CodeSelect(edt_BBDM, map.get("bbdm"));
	}


}