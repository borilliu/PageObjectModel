package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InsuredObjectInfoPage_0105 extends AbstractInsuredObjectInfoPage_01 {
	
	/**
	 * @Fields edt_GLDH : 关联单号
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyBlockCode")
	WebElement edt_GLDH;
	
	/**
	 * @Fields edt_GLBDXH : 关联标的序号
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyBlockCode")
	WebElement edt_GLBDXH;
	
	/**
	 * @Fields edt_JD : 街道
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyBlockCode")
	WebElement edt_JD;
	/**
	 * @Fields edt_YYXZ : 营业性质
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyBlockCode")
	WebElement edt_YYXZ;
	/**
	 * @Fields edt_SYDYYE : 上年度营业额
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyBlockCode")
	WebElement edt_SYDYYE;
	/**
	 * @Fields edt_SNDMLRZE : 上年度毛利润总额
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyBlockCode")
	WebElement edt_SNDMLRZE;
	
	public InsuredObjectInfoPage_0105() {
		edt_JQBM =super.waitAndGetElement(By.name("GuItemPropertyBlockCode"), 20);
		PageFactory.initElements(driver(), this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		super.inputInsuredObjectCommmon(map);
	}
	
	
}
