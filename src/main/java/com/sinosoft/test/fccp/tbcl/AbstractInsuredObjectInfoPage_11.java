package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sinosoft.test.fccp.common.FccbBase;

public abstract class AbstractInsuredObjectInfoPage_11 extends RiskDetailPage {

	public static AbstractInsuredObjectInfoPage_11 getInstance(String riskCode) {
		switch(riskCode) {
			case "1134": return new InsuredObjectInfoPage_1134();
			case "1137": return new InsuredObjectInfoPage_1137();
			default: return new InsuredObjectInfoPage_1134();
		}
	}
	public abstract void inputInsuredObjectAction(Map<String, String> map);

	
	/**
	 *<p>inputInsuredObjectCommmon</p>
	 *<p>录入公用标的物信息</p>
	 * @param map
	 */
	protected void inputInsuredObjectCommmon(Map<String, String> map) {
			
	}


}