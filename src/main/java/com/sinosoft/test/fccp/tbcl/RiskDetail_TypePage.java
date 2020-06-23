package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
	public RiskDetail_TypePage() {
		goToWorkArea();
		PageFactory.initElements(driver, this);
	}
	public void InputRiskTypeInfoAction(String xzsyfw,String tqmc,String qbrq,String zbrq,String lgbbz,String yyzdbz,String sfgxdm,String cbdq) {
		super.setSelectWithStartText(slc_XZSYFW, xzsyfw);
		super.SetDateEditBox(edt_QBRQ, qbrq);
		super.clickElement(edt_BXQX);
		super.SetDateEditBox(edt_ZBRQ, zbrq);
		super.clickElement(edt_BXQX);
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
