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
	 * @Fields slc_SFHBLD : 是否合并录单
	 */
	@FindBy(how = How.NAME,using = "GuRiskCombineInd")
	WebElement slc_SFHBLD;
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
	 * @Fields slc_DRBZ : 导入标志
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicUploadInd")
	WebElement slc_DRBZ;             
	
	
	/**
	 * @Fields slc_JMBZ : 记名标志
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicNominativeInd")
	WebElement slc_JMBZ;			
	
	/********************************
	 ************被保险人信息********
	 ********************************/
	
	
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
	
	public static RiskDetail_TypePage getInstance(String riskCode) {
		logger.debug("风险类型代码："+riskCode);
		switch(riskCode) {
			case "1134": return new RiskDetail_TypePage_1134();
			case "1137": return new RiskDetail_TypePage_1137();
			default: return new RiskDetail_TypePage();
		}
	}
	
	public RiskDetail_TypePage() {
		goToWorkArea();
		slc_XZSYFW = super.waitAndGetElement(By.name("GuRiskRiskApplyType"), 10);
		PageFactory.initElements(driver(), this);
		logger.debug("投保处理/险种信息");
	}
	/**
	 *<p>InputRiskClassInfoAction</p>
	 *<p>录入险种信息</p>
	 */
	public void InputRiskTypeInfoAction(Map<String, String> map) {
		logger.info("开始处理风险类别信息");
		setSelectWithStartText(slc_XZSYFW, map.get("xzsyfw"));
		SetDateEditBox(edt_QBRQ, map.get("qbrq"),edt_BXQX);
		//super.clickElement(edt_BXQX);
		SetDateEditBox(edt_ZBRQ, map.get("zbrq"),edt_BXQX);
		//super.clickElement(edt_BXQX);
		setSelectWithStartText(slc_LGBBZ, map.get("lgbbz"));
		if(map.get("yyzdbz")!=null) {
			setSelectWithStartText(slc_YYZDBZ, map.get("yyzdbz"));
		}
		setSelectWithStartText(slc_SFHBLD, map.get("sfhbld"));
		setSelectWithStartText(slc_SFGXDM, map.get("sfgxdm"));
		CodeSelect(edt_CBDQ, map.get("cbdq"));
		setSelectWithStartText(slc_DRBZ, map.get("drbz"));
		setSelectWithStartText(slc_JMBZ, map.get("jmbz"));
	}	
	/**
	 *<p>inputInusredInfoAction</p>
	 *<p>description</p>
	 * @param hydl 行业大类
	 * @param hyxl 行业小类
	 */
	private void inputInusredInfoAction(String zzfwlx,String hydl,String hyxl) {
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
	public RiskDetail_AbstractInsuredObjPage saveRiskDetailTypePage(Map<String, String> map) {
		logger.info("保存险种基本信息");
		TestUtil.takeScreenshot(getTestCaseId(map)+"投保单险种信息页面");
		super.jsClickButton(btn_saveButton);
		pause(WAIT_LONGGEST);
		if(waitPageIsReady()) {
			logger.info("页面加载完毕");
		}else {
			logger.info("页面未加载超时！");
		}
		return RiskDetail_AbstractInsuredObjPage.getInstance(map.get("riskClass"));
	}
}
