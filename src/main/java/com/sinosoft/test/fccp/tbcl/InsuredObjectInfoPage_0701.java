package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InsuredObjectInfoPage_0701 extends AbstractInsuredObjectInfoPage_07 {

	/**
	 * @Fields edt_GCLX : 工程类型_一级
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractType1")
	WebElement edt_GCLX_1;
	
	
	/**
	 * @Fields edt_GCLX_2 : 工程类型_二级
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractType2")
	WebElement edt_GCLX_2 ;
	
	/**
	 * @Fields edt_GCLX_3: 工程类型_三级
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractType3")
	WebElement edt_GCLX_3;
	
	
	/**
	 * @Fields edt_GCLX_4 : 工程类型_四级
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractType4")
	WebElement edt_GCLX_4 ;
	
	/**
	 * @Fields edt_GCLX_5 : 工程类型_五级
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractType5")
	WebElement edt_GCLX_5 ;
	
	
	/**
	 * @Fields edt_GCLX_6 : 工程类型_六级
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractType6")
	WebElement edt_GCLX_6 ;
	
	
	public InsuredObjectInfoPage_0701() {
		edt_SF =super.waitAndGetElement(By.xpath("//input[@name='GuItemEngineeringItemProvinceCode']"), 20);
		PageFactory.initElements(driver, this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		super.inputInsuredObjectCommmon(map);
		this.CodeSelect(edt_GCLX_1, map.get("jgx_gclx_1"));
		this.CodeSelect(edt_GCLX_2, map.get("jgx_gclx_2"));
		this.CodeSelect(edt_GCLX_3, map.get("jgx_gclx_3"));
		this.CodeSelect(edt_GCLX_4, map.get("jgx_gclx_4"));
		this.CodeSelect(edt_GCLX_5, map.get("jgx_gclx_5"));
		this.CodeSelect(edt_GCLX_6, map.get("jgx_gclx_6"));

	}
	
	
}
