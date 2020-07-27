package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InsuredObjectInfoPage_0710 extends AbstractInsuredObjectInfoPage_07 {

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

	/**
	 * @Fields edt_IDI_StartDate : IDI保险起始日期
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringIdiStartDate")
	WebElement edt_IDI_StartDate;
	
	
	/**
	 * @Fields edt_IDI_EndDate : IDI保险终止日期
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringIdiEndDate")
	WebElement edt_IDI_EndDate;
	
	/**
	 * @Fields edt_IDI_Days : IDI保险总天数
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringIdiDays")
	WebElement edt_IDI_Days;
	
	
	/**
	 * @Fields edt_GCSJDW : 工程设计单位
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringEngineeringDesignUnit")
	WebElement edt_GCSJDW;
	
	/**
	 * @Fields edt_GCSJDWZZ : 工程设计单位资质
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringEngineeringDesignUnitAptitude")
	WebElement edt_GCSJDWZZ;
	
	/**
	 * @Fields edt_TIS_SSJGMC : TIS实施机构名称
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringImplementingName")
	WebElement edt_TIS_SSJGMC;
	
	/**
	 * @Fields edt_TIS_SSJGZZ : TIS实施机构资质
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringImplementingAptitude")
	WebElement edt_TIS_SSJGZZ;
	
	/**
	 * @Fields slc_TBSJSZT : 投保时建设状态
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringConstructionStatusInsured")
	WebElement slc_TBSJSZT;
	
	
	public InsuredObjectInfoPage_0710() {
		edt_SF =super.waitAndGetElement(By.xpath("//input[@name='GuItemEngineeringItemProvinceCode']"), 20);
		PageFactory.initElements(driver(), this);
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
		this.SetDateEditBox(edt_IDI_StartDate, map.get("jgx_idi_qsrq"),edt_IDI_Days);
		this.SetDateEditBox(edt_IDI_EndDate, map.get("jgx_idi_zzrq"),edt_IDI_Days);
		
		this.setEditboxValue(edt_GCSJDW, map.get("jgx_gcsjdw"));
		this.setEditboxValue(edt_GCSJDWZZ, map.get("jgx_gcsjdwzz"));
		
		this.setEditboxValue(edt_TIS_SSJGMC, map.get("jgx_tis_ssjgmc"));
		this.setEditboxValue(edt_TIS_SSJGZZ, map.get("jgx_tis_ssjgzz"));
		this.setSelectWithStartText(slc_TBSJSZT, map.get("jgx_tbsjszt"));

	}
	
	
}
