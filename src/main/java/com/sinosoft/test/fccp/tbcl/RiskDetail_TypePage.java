package com.sinosoft.test.fccp.tbcl;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.util.TestUtil;

public class RiskDetail_TypePage extends RiskDetailPage {
	/*****************************************
	 * 险种信息
	 *****************************************/
	/**
	 * @Fields btn_DRTBRXX : 带入投保人信息
	 */
	@FindBy(how = How.ID, using  ="buttonRelatedRisk")
	WebElement btn_DRTBRXX;
	/**
	 * @Fields btn_saveButton : 保存按钮
	 */
	@FindBy(how = How.ID, using  ="saveButton")
	WebElement btn_saveButton;	
	/**
	 * @Fields edt_XZSYFW : 险种适用范围
	 */
	@FindBy(how = How.NAME,using = "GuRiskRiskApplyType")
	WebElement slc_XZSYFW;
	
	/**
	 * @Fields edt_QBRQ : 起保日期
	 */
	@FindBy(how = How.NAME,using = "GuRiskStartDate")
	WebElement edt_QBRQ;
	
	/**
	 * @Fields edt_ZBRQ : 终保日期
	 */
	@FindBy(how = How.NAME,using = "GuRiskEndDate")
	WebElement edt_ZBRQ;

	/**
	 * @Fields edt_TotalDays : 保险期限
	 */
	@FindBy(how = How.NAME,using = "GuRiskTotalDays")
	WebElement edt_BXQX;
	/**
	 * @Fields edt_LGBBZ : 联共保标志
	 */
	@FindBy(how = How.NAME,using = "GuRiskCoinsInd")
	WebElement slc_LGBBZ;
	
	/**
	 * @Fields edt_YYZDBZ : 营业中断险标志
	 */
	@FindBy(how = How.NAME,using = "GuRiskBusinessFlag")
	WebElement slc_YYZDBZ;
	
	/**
	 * @Fields edt_SFGXDM : 司法管辖代码
	 */
	@FindBy(how = How.NAME,using = "GuRiskJudicalCode")
	WebElement slc_SFGXDM;
	
	/**
	 * @Fields edt_CBDQ : 承保地区
	 */
	@FindBy(how = How.NAME,using = "GuRiskGeographicalArea")
	WebElement edt_CBDQ;
	
	
	
	
	/**
	 * @Fields edt_HYDL : 被保人信息
	 */
	@FindBy(how = How.ID,using = "InsuredRelatedParty")
	WebElement tbl_InsuredInfo;
	
	
	/**
	 * @Fields edt_CBDQ : 增值服务类型
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='InsuredRelatedParty']/tbody/tr[@id='InsuredGuRelatedPartyCorInsuredType']/td/select[@name='InsuredGuRelatedPartyStarLevel']")
	WebElement slc_ZZFWLX;
	/**
	 * @Fields edt_HYDL : 行业大类
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='InsuredRelatedParty']/tbody/tr[@id='InsuredGuRelatedPartyVocation']/td/input[@name='InsuredGuRelatedPartyIndustryMainCode']")
	WebElement edt_HYDL;
	
	/**
	 * @Fields edt_HYXL : 行业小类
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='InsuredRelatedParty']/tbody/tr[@id='InsuredGuRelatedPartyVocation']/td/input[@name='InsuredGuRelatedPartyIndustryKindCode']")
	WebElement edt_HYXL;
	
	
	public RiskDetail_TypePage() {
		goToWorkArea();
		slc_XZSYFW = super.waitAndGetElement(By.name("GuRiskRiskApplyType"), 10);
		PageFactory.initElements(driver, this);
		logger.debug("投保处理/险种信息");
	}
	public void InputRiskTypeInfoAction(String xzsyfw,String tqmc,String qbrq,String zbrq,String lgbbz,String yyzdbz,String sfgxdm,String cbdq) {
		super.setSelectWithStartText(slc_XZSYFW, xzsyfw);
		super.SetDateEditBox(edt_QBRQ, qbrq,edt_BXQX);
		//super.clickElement(edt_BXQX);
		super.SetDateEditBox(edt_ZBRQ, zbrq,edt_BXQX);
		//super.clickElement(edt_BXQX);
		super.setSelectWithStartText(slc_LGBBZ, lgbbz);
		super.setSelectWithStartText(slc_YYZDBZ, yyzdbz);
		super.setSelectWithStartText(slc_SFGXDM, sfgxdm);
		super.CodeSelect(edt_CBDQ, cbdq);
	}
	/**
	 *<p>InputRiskClassInfoAction</p>
	 *<p>录入险种信息</p>
	 */
	public void InputRiskTypeInfoAction(Map<String, String> map) {
		logger.info("开始处理风险类别信息");
		this.InputRiskTypeInfoAction(map.get("xzsyfw"),map.get("tqmc"),map.get("qbrq"),map.get("zbrq"),map.get("lgbbz"),map.get("yyzdbz"),map.get("sfgxdm"),map.get("cbdq"));
	}	
	/**
	 *<p>inputInusredInfoAction</p>
	 *<p>description</p>
	 * @param hydl 行业大类
	 * @param hyxl 行业小类
	 */
	private void inputInusredInfoAction(String zzfwlx,String hydl,String hyxl) {
		//slc_ZZFWLX = tbl_InsuredInfo.findElement(By.name("InsuredGuRelatedPartyStarLevel"));
		//edt_HYDL = tbl_InsuredInfo.findElement(By.name("InsuredGuRelatedPartyIndustryMainCode"));
		//edt_HYXL = tbl_InsuredInfo.findElement(By.name("InsuredGuRelatedPartyIndustryKindCode"));
		super.setSelectWithStartText(slc_ZZFWLX, zzfwlx);
		super.CodeSelect(edt_HYDL, hydl);
		super.SetCodeEditBox(edt_HYXL, hyxl);
	}
	
	/**
	 *<p>inputInusredInfoAction</p>
	 *<p>录入被保人信息</p>
	 * @param map
	 */
	public void inputInusredInfoAction(Map<String, String> map) {
		this.inputInusredInfoAction(map.get("zzfwlx"),map.get("hydl"),map.get("hyxl"));
	}
	/**
	 *<p>saveRiskDetailTypePage</p>
	 *<p>保存险种信息</p>
	 * @return
	 */
	public RiskDetail_insuredObjPage saveRiskDetailTypePage() {
		logger.info("保存险种基本信息");
		super.jsClickButton(btn_saveButton);
		return new RiskDetail_insuredObjPage();
	}
}
