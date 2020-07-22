package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sinosoft.test.fccp.common.FccbBase;

public abstract class AbstractInsuredObjectInfoPage_07 extends RiskDetailPage {

	/**
	 * @Fields edt_SF : 省份
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringItemProvinceCode")
	WebElement edt_SF;
			
	/**
	 * @Fields edt_CS : 城市
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringItemCityCode")
	WebElement edt_CS;
	
	/**
	 * @Fields edt_QX : 区县
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringItemDistrictCode")
	WebElement edt_QX;
	
	/**
	 * @Fields edt_GCDD : 工程地点 
	 */								
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractAddress")
	WebElement edt_GCDD;
	
	/**
	 * @Fields edt_BB : 币别
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringCurrency")
	WebElement edt_BB;
	
	/**
	 * @Fields edt_GCMC : 工程名称
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractTitle")
	WebElement edt_GCMC;
	
	/**
	 * @Fields edt_YZSSJT : 业主所属集团
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractNature")
	WebElement edt_YZSSJT ;
	
	/**
	 * @Fields edt_YZ : 业主
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractNatureBranch")
	WebElement edt_YZ ; 
	
	/**
	 * @Fields edt_CBSSSJT : 承包商所属集团
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractDesc")
	WebElement edt_CBSSSJT ;
	
	
	/**
	 * @Fields edt_CBS : 承包商
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractDescBranch")
	WebElement edt_CBS ;
	
	/**
	 * @Fields edt_GCHTH : 工程合同号 
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractNo")
	WebElement edt_GCHTH ; 
	
	/**
	 * @Fields edt_GCJZ : 工程价值
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractValue")
	WebElement edt_GCJZ ; 
	
	/**
	 * @Fields edt_GCQSRQ : 工程起始日期
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractStartDate")
	WebElement edt_GCQSRQ ; 
	
	/**
	 * @Fields edt_GCZZRQ : 工程终止日期
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractEndDate")
	WebElement edt_GCZZRQ ;
	
	/**
	 * @Fields edt_GCZTS : 工程总天数
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractDays")
	WebElement edt_GCZTS; 
	/**
	 * @Fields edt_GCFW : 工程范围
	 */

	@FindBy(how = How.NAME,using = "GuItemEngineeringContractScope")
	WebElement edt_GCFW;
	
	/**
	 * @Fields edt_BZQSZRQ : 保证期起始日期
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringMaintenStartDate")
	WebElement edt_BZQQSRQ;
	/**
	 * @Fields edt_BZQZZRQ : 保证期终止日期 
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringMaintenEndDate")
	WebElement edt_BZQZZRQ;
	
	/**
	 * @Fields edt_BZQZTS : 保证期总天数
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringMaintenDays")
	WebElement edt_BZQZTS;
	
	
	public static AbstractInsuredObjectInfoPage_07 getInstance(String riskCode) {
		switch(riskCode) {
			case "0710": return new InsuredObjectInfoPage_0710();
			default: return new InsuredObjectInfoPage_0701();
		}
		
	}
	public abstract void inputInsuredObjectAction(Map<String, String> map);

	
	/**
	 *<p>inputInsuredObjectCommmon</p>
	 *<p>录入公用标的物信息</p>
	 * @param map
	 */
	protected void inputInsuredObjectCommmon(Map<String, String> map) {
		this.SetCodeEditBox(edt_SF, map.get("jgx_sf"));
		this.SetCodeEditBox(edt_CS,map.get("jgx_cs"));
		this.setEditboxValue(edt_GCDD, map.get("jgx_gcdd"));
		this.SetCodeEditBox(edt_BB, map.get("jgx_bb") );
		this.setEditboxValue(edt_GCMC,map.get("jgx_gcmc"));
		this.CodeSelect(edt_QX, map.get("jgx_qx"));
		this.SetCodeEditBox(edt_YZSSJT, map.get("jgx_yzssjt"));
		this.SetCodeEditBox(edt_YZ, map.get("jgx_yz"));
		this.SetCodeEditBox(edt_CBSSSJT, map.get("jgx_cbs_ssjt"));
		this.SetCodeEditBox(edt_CBS, map.get("jgx_cbs"));
		this.SetCodeEditBox(edt_GCHTH, map.get("jgx_gchth"));
		this.SetCodeEditBox(edt_GCJZ, map.get("jgx_gcjz"));
		this.SetDateEditBox(edt_GCQSRQ, map.get("jgx_gcqsrq"),edt_GCZTS);
		this.SetDateEditBox(edt_GCZZRQ, map.get("jgx_gczzrq"),edt_GCZTS);
		this.setEditboxValue(edt_GCFW, map.get("jgx_gcfw")); 
		this.SetDateEditBox(edt_BZQQSRQ, map.get("jgx_bzqqsrq"),edt_GCZTS);
		this.SetDateEditBox(edt_BZQZZRQ, map.get("jgx_bzqzzrq"),edt_BZQZTS);
		
	}


}