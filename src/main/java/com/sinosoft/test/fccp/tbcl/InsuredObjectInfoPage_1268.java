package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.fccp.tbcl.common.InsuredListAdd_Page;
public class InsuredObjectInfoPage_1268 extends AbstractInsuredObjectInfoPage_12 {

	
	/**
	 * @Fields edt_YYLX : 运营路线
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAA")
	WebElement edt_YYLX;
	
	/**
	 * @Fields slc_YYLX : 运营类型
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAB")
	WebElement slc_YYLX;
	
	/**
	 * @Fields edt_JYXKZ : 道路运输经营许可证 
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAC")
	WebElement edt_JYXKZ;
	
	/**
	 * @Fields edt_SSQK : 前三年损失情况
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAD")
	WebElement edt_SSQK;
	
	
	
	/**
	 * @Fields edt_CPXH : 厂牌型号
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAE")
	WebElement edt_CPXH;
	
	/**
	 * @Fields edt_CPHM : 车牌号码
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAF")
	WebElement edt_CPHM;
	
	/**
	 * @Fields edt_CKZWS : 核定乘客座位数
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAG")
	WebElement edt_CKZWS;
	
	/**
	 * @Fields edt_YYZBM : 车辆营运证编码
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAH")
	WebElement edt_YYZBM;
	
	/**
	 * @Fields edt_TBZWS : 投保座位数
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAI")
	WebElement edt_TBZWS;
	
	/**
	 * @Fields edt_XSZCZ : 行驶证车主
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAJ")
	WebElement edt_XSZCZ;
	
	/**
	 * @Fields edt_CLLX : 车辆类型 
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAK")
	WebElement edt_CLLX;
	
	/**
	 * @Fields edt_CJH : 车架号/VIN码
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAL")
	WebElement edt_CJH;
	
	/**
	 * @Fields edt_ZCRQ : 车辆注册日期
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAM")
	WebElement edt_ZCRQ;
	
	
	public InsuredObjectInfoPage_1268() {
		//edt_JQBM =super.waitAndGetElement(By.name("GuItemPropertyBlockCode"), 20);
		PageFactory.initElements(driver(), this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		super.inputInsuredObjectCommmon(map);
		this.setEditboxValue(edt_YYLX, map.get("cyr_yyLine"));
		this.setSelectWithStartText(slc_YYLX, map.get("cyr_yyType"));
		this.setEditboxValue(edt_JYXKZ, map.get("cyr_jyxkz"));
		this.setEditboxValue(edt_SSQK, map.get("cyr_ssqk"));
		this.setEditboxValue(edt_CPXH, map.get("cyr_cpxh"));
		this.setEditboxValue(edt_CPHM, map.get("cyr_cphm"));
		this.setEditboxValue(edt_CKZWS, map.get("cyr_ckzws"));
		this.setEditboxValue(edt_YYZBM, map.get("cyr_yyzbm"));
		this.setEditboxValue(edt_TBZWS, map.get("cyr_tbzws"));
		this.setEditboxValue(edt_XSZCZ, map.get("cyr_xszcz"));
		this.setEditboxValue(edt_CLLX, map.get("cyr_cllx"));
		this.setEditboxValue(edt_CJH, map.get("cyr_cjh"));
		this.SetDateEditBox(edt_ZCRQ, map.get("cyr_zcrq"),edt_CLLX);
		
		
	}

}
