package com.sinosoft.test.fccp.tbcl;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.util.TestUtil;

public class RiskDetail_TypePage_1134 extends RiskDetail_TypePage {
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
	 * @Fields edt_ZDJSCLCPH : 指定驾驶车辆车牌号
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAA")
	WebElement edt_ZDJSCLCPH;
	
	/**
	 * @Fields edt_XSZCZ : 行驶证车主
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAC")
	WebElement edt_XSZCZ;

	/**
	 * @Fields edt_CPH : 车牌号 
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAD")
	WebElement edt_CPH;
	
	/**
	 * @Fields edt_CJH : 车架号
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAE")
	WebElement edt_CJH;
	
	/**
	 * @Fields edt_HPDS : 号牌底色
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAF")
	WebElement edt_HPDS;
	
	/**
	 * @Fields edt_FDJH : 发动机号
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAG")
	WebElement edt_FDJH;
	
	/**
	 * @Fields edt_SYXZ : 使用性质
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAH")
	WebElement edt_SYXZ;
	
	/**
	 * @Fields edt_SYXZ_txt : 使用性质-描述
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAN")
	WebElement edt_SYXZ_txt;

	/**
	 * @Fields edt_CPXH : 厂牌型号
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAI")
	WebElement edt_CPXH;
	
	/**
	 * @Fields edt_HDZZL : 核定载质量
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAJ")
	WebElement edt_HDZZL;
	
	/**
	 * @Fields edt_HDZKRS : 核定载客人数
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAK")
	WebElement edt_HDZKRS;
	
	/**
	 * @Fields edt_QTSM : 其他说明
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAL")
	WebElement edt_QTSM;
	
	/**
	 * @Fields edt_ZDJSCLLX : 指定驾驶车辆类型
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAU")
	WebElement edt_ZDJSCLLX;
	
	/**
	 * @Fields edt_ZDJSCLLX_L2 : 指定驾驶车辆类型-二级代码
	 */
	@FindBy(how = How.NAME, using  ="GuRiskDynamicFieldAV")
	WebElement edt_ZDJSCLLX_L2;
	
	public RiskDetail_TypePage_1134() {
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
		super.setEditboxValue(edt_ZDJSCLCPH,map.get("ywx_zdjsclcph"));
		super.setEditboxValue(edt_XSZCZ, map.get("ywx_xszcz"));
		super.setEditboxValue(edt_CPH, map.get("ywx_cph"));
		super.setEditboxValue(edt_CJH, map.get("ywx_cjh"));
		super.setEditboxValue(edt_HPDS, map.get("ywx_hpds"));
		super.setEditboxValue(edt_FDJH, map.get("ywx_fdjh"));
		super.SetCodeEditBox(edt_SYXZ, map.get("ywx_syxz"));
		super.setEditboxValue(edt_SYXZ_txt, map.get("ywx_syxz_2"));
		super.setEditboxValue(edt_CPXH,map.get("ywx_cpxh"));
		super.setEditboxValue(edt_HDZZL, map.get("ywx_hdzzl"));
		super.setEditboxValue(edt_HDZKRS, map.get("ywx_hdzkrs"));
		super.setEditboxValue(edt_QTSM, map.get("ywx_qtsm"));
		super.CodeSelect(edt_ZDJSCLLX,map.get("ywx_zdjscllx"));
		super.CodeSelect(edt_ZDJSCLLX_L2,map.get("ywx_zdjscllx2"));
	}	
	
	public void inputInusredInfoAction(Map<String, String> map) {
		//1134 无被保人信息，无需录入
	}

}
