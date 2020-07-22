package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class InsuredObjectInfoPage_0101 extends AbstractInsuredObjectInfoPage_01 {
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
	public InsuredObjectInfoPage_0101() {
		edt_JQBM =super.waitAndGetElement(By.name("GuItemPropertyBlockCode"), 20);
		PageFactory.initElements(driver, this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		super.inputInsuredObjectCommmon(map);
		this.SetCodeEditBox(edt_JZDJ, map.get("jzdj"));
		this.SetCodeEditBox(edt_ZYXZ, map.get("zyxz"));
		this.setEditboxValue(edt_BXCS, map.get("bxcs"));
	}
	

}
