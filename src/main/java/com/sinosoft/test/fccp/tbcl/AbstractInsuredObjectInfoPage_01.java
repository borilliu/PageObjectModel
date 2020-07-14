package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sinosoft.test.fccp.common.FccbBase;

public abstract class AbstractInsuredObjectInfoPage_01 extends FccbBase {
	/**
	 * @Fields edt_JQBM : 街区编码
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyBlockCode")
	WebElement edt_JQBM;
	
	/**
	 * @Fields edt_BBDM : 币别代码/名称
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyCurrency")
	WebElement edt_BBDM;
	
	/**
	 * @Fields edt_SF : 省份
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyItemProvinceCode")
	WebElement edt_SF;

	
	/**
	 * @Fields edt_CS : 城市
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyItemCityCode")
	WebElement edt_CS;
	
	/**
	 * @Fields edt_QX : 区县
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyItemDistrictCode")
	WebElement edt_QX;
	
	/**
	 * @Fields edt_YB : 邮编
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyItemPostalCode")
	WebElement edt_YB;
	
	
	/**
	 * @Fields edt_BXCS : 保险处所
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertySituation")
	WebElement edt_BXCS;	
	public static AbstractInsuredObjectInfoPage_01 getInstance(String riskCode) {
		switch(riskCode) {
			case "0105": return new InsuredObjectInfoPage_0105();
			case "0107": return new InsuredObjectInfoPage_0107();
			case "0122": return new InsuredObjectInfoPage_0122();
			default: return new InsuredObjectInfoPage_0101();
		}
		
	}
	public abstract void inputInsuredObjectAction(Map<String, String> map);

	
	/**
	 *<p>inputInsuredObjectCommmon</p>
	 *<p>录入公用标的物信息</p>
	 * @param map
	 */
	protected void inputInsuredObjectCommmon(Map<String, String> map) {
		this.inputInsuredObjectCommmon(map.get("jqbm"),map.get("bbdm"),map.get("sf"),map.get("cs"),map.get("qx"),map.get("yb"));
	}
	/**
	 *<p>InputInsuredObjectAction</p>
	 *<p>录入公用标的物信息</p>
	 * @param jqbm 街区编码
	 * @param bbdm 币别代码/名称
	 * @param sf 省份
	 * @param cs 城市
	 * @param qx 区县
	 * @param yb 邮编
	 * @param jzdj 建筑等级
	 * @param bxcs 保险处所
	 */
	private void inputInsuredObjectCommmon(String jqbm,String bbdm,String sf,String cs,String qx,String yb) {
		this.setEditboxTValue(edt_JQBM, jqbm);
		this.CodeSelect(edt_BBDM, bbdm);
		this.SetCodeEditBox(edt_SF, sf);
		this.SetCodeEditBox(edt_CS, cs);
		//this.CodeSelect(edt_QX, qx);
		this.setEditboxValue(edt_YB, yb);
	}

}