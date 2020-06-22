package com.sinosoft.test.fccp.tbcl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RiskDetail_insuredObjPage extends RiskDetailPage {

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
	 * @Fields edt_JZDJ : 建筑等级
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyConstruction")
	WebElement edt_JZDJ;
	
	/**
	 * @Fields edt_ZYXZ : 占用性质 
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyOccupation")
	WebElement edt_ZYXZ;
	
	/**
	 * @Fields edt_BXCS : 保险处所
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertySituation")
	WebElement edt_BXCS;
	
	public void InputInsuredObjectAction() {
		this.setEditboxTValue(edt_JQBM, "121121123123");
		this.SetCodeEditBox(edt_BBDM, "CNY");
		this.SetCodeEditBox(edt_SF, "130000");
		this.SetCodeEditBox(edt_CS, "130300");
		this.CodeSelect(edt_QX, "130302");
		this.setEditboxValue(edt_YB, "065201");
		this.SetCodeEditBox(edt_JZDJ, "01");
		this.setEditboxValue(edt_BXCS, "北戴河公园");
	}
}
