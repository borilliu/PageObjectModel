package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.fccp.tbcl.common.InsuredListAdd_Page;
public class InsuredObjectInfoPage_1254 extends AbstractInsuredObjectInfoPage_12 {
	
	/**
	 * @Fields slc_TBLX : 投保类型
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAC")
	WebElement slc_WXHW_TBLX;
	
	/**
	 * @Fields edt_WXHWWPMC : 危险货物物品名称
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAD")
	WebElement edt_WXHW_WPMC;
	
	
	/**
	 * @Fields edt_WXHW_YSDQFW : 危险货物运输地区范围
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAE")
	WebElement edt_WXHW_YSFW;
	
	/**
	 * @Fields edt_WXHW_YSCSL : 危险货物运输车数量 
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAF")
	WebElement edt_WXHW_YSCS;
	
	/**
	 * @Fields edt_WXHW_QDYS : 危险货物运输车辆清单页数
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAG")
	WebElement edt_WXHW_QDYS;
	
	/**
	 * @Fields edt_WXHW_CPHM : 危险货物运输车牌照号
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAH")
	WebElement edt_WXHW_CPHM;
	
	/**
	 * @Fields edt_WXHW_CPXH : 厂牌型号
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAI")
	WebElement edt_WXHW_CPXH;
	
	/**
	 * @Fields edt_WXHW_FDJH : 发动机号
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAJ")
	WebElement edt_WXHW_FDJH;
	
	/**
	 * @Fields edt_WXHW_CJH : 车架号
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAK")
	WebElement edt_WXHW_CJHM;
	
	/**
	 * @Fields 初次登记日期 
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAL")
	WebElement edt_WXHW_CCDJRQ;
	
	/**
	 * @Fields edt_WXHW_QTXX : 其它信息
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAM")
	WebElement edt_WXHW_QTXX;
	
	/**
	 * @Fields edt_WXHW_YYCS : 营业场所
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAN")
	WebElement edt_WXHW_YYCS;
	
	/**
	 * @Fields edt_WXHW_YYXZ : 营业性质
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAO")
	WebElement edt_WXHW_YYXZ;
	
	/**
	 * @Fields edt_WXHW_ZRFW : 责任范围
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAP")
	WebElement edt_WXHW_ZRFW;
	
	/**
	 * @Fields edt_WXHW_NYSL : 预计年运输量
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAQ")
	WebElement edt_WXHW_NYSL;
	
	/**
	 * @Fields edt_WXHW_YFSR : 预计年运费毛收入 
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAR")
	WebElement edt_WXHW_YFSR;
	
	/**
	 * @Fields edt_WXHW_YSCX : 危险货物运输车型
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamicFieldAS")
	WebElement edt_WXHW_YSCX;
	
	public InsuredObjectInfoPage_1254() {
		//edt_JQBM =super.waitAndGetElement(By.name("GuItemPropertyBlockCode"), 20);
		PageFactory.initElements(driver(), this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		super.inputInsuredObjectCommmon(map);
		this.setSelectWithStartText(slc_WXHW_TBLX, map.get("wh_tblx"));
		this.setEditboxValue(edt_WXHW_WPMC, map.get("wh_wpmc"));
		this.setEditboxValue(edt_WXHW_YSFW, map.get("wh_ysfw"));
		this.setEditboxValue(edt_WXHW_YSCS, map.get("wh_yscs"));
		this.setEditboxValue(edt_WXHW_QDYS, map.get("wh_qdys"));
		this.setEditboxValue(edt_WXHW_CPHM, map.get("wh_cphm"));
		this.setEditboxValue(edt_WXHW_CPXH, map.get("wh_cpxh"));
		this.setEditboxValue(edt_WXHW_FDJH, map.get("wh_fdjh"));
		this.setEditboxValue(edt_WXHW_CJHM, map.get("wh_cjhm"));
		this.SetDateEditBox(edt_WXHW_CCDJRQ, map.get("wh_ccdjrq"),edt_WXHW_QTXX);
		this.setEditboxValue(edt_WXHW_QTXX, map.get("wh_qtxx"));
		this.setEditboxValue(edt_WXHW_YYCS, map.get("wh_yycs"));
		this.setEditboxValue(edt_WXHW_YYXZ, map.get("wh_yyxz"));
		this.setEditboxValue(edt_WXHW_ZRFW, map.get("wh_zrfw"));
		this.setEditboxValue(edt_WXHW_NYSL, map.get("wh_nysl"));
		this.setEditboxValue(edt_WXHW_YFSR, map.get("wh_yfsr"));
		this.setEditboxValue(edt_WXHW_YSCX, map.get("wh_yscx"));
	}

}
