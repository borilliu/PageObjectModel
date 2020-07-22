package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InsuredObjectInfoPage_0107 extends AbstractInsuredObjectInfoPage_01 {
	/**
	 * @Fields edt_JD : 街道
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAA']")
	WebElement edt_JD;
	/**
	 * @Fields edt_YYXZ : 营业性质
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAB']")
	//@FindBy(how = How.XPATH,using = "GuItemDynamicFieldAB")
	WebElement edt_YYXZ;
	/**
	 * @Fields edt_SFHYF : 是否含运费
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAF']")
	//@FindBy(how = How.NAME,using = "GuItemDynamicFieldAF")
	WebElement edt_SFHYF;
	/**
	 * @Fields edt_FXLX :风险类型 
	 */
	//@FindBy(how = How.NAME,using = "GuItemDynamicFieldBX")
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldBX']")
	WebElement edt_FXLX; 	
	
	/**
	 * @Fields edt_BXCS : 保险处所
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertySituation")
	WebElement edt_BXCS;	
	
	public InsuredObjectInfoPage_0107() {
		edt_JQBM =super.waitAndGetElement(By.name("GuItemPropertyBlockCode"), 20);
		PageFactory.initElements(driver, this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		super.inputInsuredObjectCommmon(map);
		
		this.setEditboxValue(edt_BXCS,map.get("bxcs"));
		this.setEditboxValue(edt_JD,map.get("bdw_jd"));
		this.SetCodeEditBox(edt_YYXZ, map.get("bdw_yyxz"));
		this.SetCodeEditBox(edt_SFHYF, map.get("bdw_sfhyf"));
		this.SetCodeEditBox(edt_FXLX,map.get("bdw_fxlx"));

	}
	
	
}
