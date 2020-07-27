package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InsuredObjectInfoPage_0122 extends AbstractInsuredObjectInfoPage_01 {

	/**
	 * @Fields edt_SBMC : 设备名称
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAP']")
	WebElement edt_SBMC;
	/**
	 * @Fields edt_CJH : 车架号
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAB']")
	WebElement edt_CJH;
	/**
	 * @Fields edt_FDJH : 发动机号
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAC']")
	WebElement edt_FDJH;
	/**
	 * @Fields edt_CCDJRQ :初次登记日期
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@fieldShowDesc='初次登记日期']")
	WebElement edt_CCDJRQ; 
	
	/**
	 * @Fields edt_CLLX : 车辆类型
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAE']")
	WebElement edt_CLLX; 
	
	/**
	 * @Fields edt_CPCX : 厂牌车型
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAF']")
	WebElement edt_CPCX; 
	
	/**
	 * @Fields edt_SCCJ : 生产厂家
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAG']")
	WebElement edt_SCCJ; 
	
	/**
	 * @Fields edt_GZJZ : 购置价值
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAK']")
	WebElement edt_GZJZ; 
	
	/**
	 * @Fields edt_SGZYQY : 施工作业区域
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAM']")
	WebElement edt_SGZYQY; 

	
	/**
	 * @Fields edt_ZYLX : 作业类型
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='itemDynamic']/tbody/tr/td/input[@name='GuItemDynamicFieldAO']")
	WebElement slc_ZYLX; 
	
	

	
	public InsuredObjectInfoPage_0122() {
		edt_JQBM =super.waitAndGetElement(By.name("GuItemPropertyBlockCode"), 20);
		PageFactory.initElements(driver(), this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		super.inputInsuredObjectCommmon(map);
		this.setEditboxValue(edt_SBMC, map.get("bdw_sbmc"));
		this.setEditboxValue(edt_CJH, map.get("bdw_cjh"));
		this.setEditboxValue(edt_FDJH, map.get("bdw_fdjh"));
		this.SetDateEditBox(edt_CCDJRQ, map.get("bdw_cjdjrq"), edt_CLLX);
		this.setEditboxValue(edt_CLLX, map.get("bdw_cllx"));
		this.setEditboxValue(edt_CPCX, map.get("bdw_cpcx"));
		this.setEditboxValue(edt_SCCJ, map.get("bdw_sccj"));
		this.setEditboxValue(edt_GZJZ, map.get("bdw_gzjz"));
		this.setEditboxValue(edt_SGZYQY, map.get("bdw_sgzyqy"));
		this.setSelectText(slc_ZYLX,  map.get("bdw_zylx"));
	}
	
	
}
