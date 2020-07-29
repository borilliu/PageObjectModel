package com.sinosoft.test.fccp.tbcl;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.util.TestUtil;

public class RiskDetail_TypePage_1137 extends RiskDetail_TypePage {
	/*****************************************
	 * 险种信息
	 *****************************************/
	
	/**
	 * @Fields tbl_riskDynamic : 动态字段
	 */
	@FindBy(how = How.ID, using  ="riskDynamic")
	WebElement tbl_riskDynamic;
/*	*//**
	 * @Fields slc_DRBZ : 导入标志
	 *//*
	@FindBy(how = How.NAME, using  ="GuRiskDynamicUploadInd")
	WebElement slc_DRBZ;
	
	
	*//**
	 * @Fields slc_JMBZ : 记名标志
	 *//*
	@FindBy(how = How.NAME, using  ="GuRiskDynamicNominativeInd")
	WebElement slc_JMBZ;*/
	
	
	/**
	 * @Fields edt_BBXZRS : 被保险人总人数  
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAA")
	WebElement edt_BBXZRS;
	
	/**
	 * @Fields edt_SXQY : 销售区域   
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAB")
	WebElement edt_SXQY;
	
	/**
	 * @Fields edt_SXFS : 销售方式
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAC")
	WebElement edt_SXFS;
	
	/**
	 * @Fields edt_AQX : 安全性
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAD")
	WebElement edt_AQX;
	
	/**
	 * @Fields edt_GLSP : 管理水平
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAE")
	WebElement edt_GLSP;
	
	/**
	 * @Fields edt_XBNS : 续保年数
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAF")
	WebElement edt_XBNS;
	
	/**
	 * @Fields edt_SZFHJWTYXM : 政府或教委统一项目
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAG")
	WebElement edt_SZFHJWTYXM;
	
	/**
	 * @Fields edt_DDQ : 等待期
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAH")
	WebElement edt_DDQ;
	
	
	/**
	 * @Fields edt_XX : 学校
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAI")
	WebElement edt_XX;
	
	/**
	 * @Fields edt_BJ : 班级
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAJ")
	WebElement edt_BJ;
	
	public RiskDetail_TypePage_1137() {
		goToWorkArea();
		slc_DRBZ = super.waitAndGetElement(By.name("GuRiskDynamicUploadInd"), 10);
		PageFactory.initElements(driver(), this);
		logger.debug("投保处理/险种信息");
	}
	/**
	 *<p>InputRiskClassInfoAction</p>
	 *<p>录入险种信息</p>
	 */
	public void InputRiskTypeInfoAction(Map<String, String> map) {
		logger.info("开始处理风险类别信息");
		super.InputRiskTypeInfoAction(map);
//		super.setSelectWithStartText(slc_DRBZ, map.get("ywx_drbz"));
//		super.setSelectWithStartText(slc_JMBZ, map.get("ywx_jmbz"));
		super.setEditboxValue(edt_BBXZRS,map.get("ywx_bbxzrs"));
		super.setEditboxValue(edt_SXQY, map.get("ywx_xsqy"));
		super.setEditboxValue(edt_SXFS, map.get("ywx_xsfs"));
		super.setEditboxValue(edt_AQX, map.get("ywx_aqx"));
		super.setEditboxValue(edt_GLSP, map.get("ywx_glsp"));
		super.setEditboxValue(edt_XBNS, map.get("ywx_xbns"));
		super.setEditboxValue(edt_SZFHJWTYXM, map.get("ywx_szfhjwtyxm"));
		super.setEditboxValue(edt_DDQ,map.get("ywx_ddq"));
		super.setEditboxValue(edt_XX, map.get("ywx_xx"));
		super.setEditboxValue(edt_BJ, map.get("ywx_bj"));
	}	
	
	public void inputInusredInfoAction(Map<String, String> map) {
		//1134 无被保人信息，无需录入
	}

}
