package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RiskDetail_JGX_insuredObjPage extends RiskDetail_AbstractInsuredObjPage {

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
	 * @Fields edt_GCLX : 工程类型_一级
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractType1")
	WebElement edt_GCLX_1;
	
	
	/**
	 * @Fields edt_GCLX_2 : 工程类型_二级
	 */
	@FindBy(how = How.NAME,using = "GuItemEngineeringContractType2")
	WebElement edt_GCLX_2 ;
	
	/*********************************************************
	 **********                险别信息                               *************
	 *********************************************************
	 */
	
	@FindBy(how = How.ID,using = "ItemPropertyDetail")
	//@FindBy(how = How.ID,using = "ItemPropertyDetailKind")
	WebElement tbl_BDWMX;
	
	/**
	 * @Fields edt_XBDM : 险别代码/名称
	 */
	@FindBy(how = How.NAME,using = "GuItemKindKindCode")
	WebElement edt_XBDM;
	
	
	/**
	 * @Fields edt_JRBE : 计入保额(标记)
	 */
	@FindBy(how = How.NAME,using = "GuItemKindCalculateInd")
	WebElement edt_JRBE;
	
	
	/**
	 * @Fields slc_JZFS : 价值方式 
	 */
	@FindBy(how = How.NAME,using = "GuItemKindValueType")
	WebElement slc_JZFS;
	
	
	/**
	 * @Fields edt_BXJE : 保险金额
	 */
	@FindBy(how = How.NAME,using = "GuItemKindSumInsured")
	WebElement edt_BXJE;
	
	
	
	/**
	 * @Fields edt_BFFL : 保费费率
	 */
	//@FindBy(how = How.NAME,using = "GuItemKindRate")
	@FindBy(how = How.XPATH,using = "//table[@id='ItemPropertyDetailKind']/tbody/tr/td/input[@name='GuItemKindRate']")
	WebElement edt_BFFL;
	
	
	
	/**
	 * @Fields edt_DQFLBZ : 短期费率标志
	 */
	//@FindBy(how = How.NAME,using = "GuItemKindShortRateFlag")
	@FindBy(how = How.XPATH,using = "//table[@id='ItemPropertyDetailKind']/tbody/tr/td/input[@name='GuItemKindShortRateFlag']")
	WebElement edt_DQFLBZ;
	
	
	/**
	 * @Fields edt_YSBF : 应收保费
	 */
	//@FindBy(how = How.NAME,using = "GuItemKindGrossPremium")
	@FindBy(how = How.XPATH,using = "//table[@id='ItemPropertyDetailKind']/tbody/tr/td/input[@name='GuItemKindGrossPremium']")
	WebElement edt_YSBF;
	
	
	
	
	/**
	 * @Fields btn_savePage : 保存标的信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	
	public RiskDetail_JGX_insuredObjPage() {
		goToWorkArea();
		edt_SF =super.waitAndGetElement(By.xpath("//input[@name='GuItemEngineeringItemProvinceCode']"), 20);
		PageFactory.initElements(driver, this);
		logger.debug("进入建工险-保险标的信息页面对象！");
	}

	/**
	 *<p>InputInsuredObjectAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
	}
	public void inputRiskCodeAction(String bdw,String bdwmx,String xbdm,String jrbe,String jzfs,String bxje,String bffl,String dqflbz,String ysbf) {
		this.clickElement(tbl_BDWMX);

	}
	/**
	 *<p>inputRiskCodeAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public void inputRiskCoverageAction(Map<String, String> map) {
		this.inputRiskCodeAction(map.get("bdw"),map.get("bdwmx"),map.get("xbdm"),map.get("jrbe"),map.get("jzfs"),map.get("bxje"),map.get("bffl"),map.get("dqflbz"),map.get("ysbf"));
	}
	/**
	 *<p>saveInsredObjectPage</p>
	 *<p>保存标的物页面</p>
	 */
	public void saveInsredObjectPage(){
		this.clickButton(btn_savePage);
	}
	
}
