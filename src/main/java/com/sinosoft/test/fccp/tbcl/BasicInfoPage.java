package com.sinosoft.test.fccp.tbcl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sinosoft.test.fccp.common.FccbBase;
import com.sinosoft.test.util.TestUtil;

/**
 *com.sinosoft.test.fccp.tbcl.BasicInfoPage.java
 *<p>承保子系统/投保管理/投保处理：基本信息</p>
 * @author liubenchao@sinsoft.com.cn
 */
public class BasicInfoPage extends TbclMainFramePage{
	/************************************************
	 * 销售信息
	 ************************************************/		
	/**
	 * @Fields slc_FBBS : 分保标识
	 */
	@FindBy(how = How.NAME,using = "GuMainBusinessType")
	WebElement slc_FBBS;

	/**
	 * @Fields edt_GDBS : 股东标识
	 */
	@FindBy(how = How.NAME,using = "GuMainShareHolderFlag")
	WebElement edt_GDBS;

	/**
	 * @Fields edt_YWGS :  业务归属
	 */
	@FindBy(how = How.NAME,using = "GuMainCompanyCode")
	WebElement edt_YWGS;
	

	/**
	 * @Fields edt_QDLX : 渠道类型
	 */
	@FindBy(how = How.NAME,using = "GuMainChannelDetailCode")
	WebElement edt_QDLX;	
	
	/**
	 * @Fields edt_XSTD : 销售团队
	 */
	@FindBy(how = How.NAME,using = "GuMainSalesTeamCode")
	WebElement edt_XSTD;	
	
	
	/**
	 * @Fields edt_YWY : 业务员
	 */
	@FindBy(how = How.NAME,using = "GuMainSalesmanCode")
	WebElement edt_YWY;	
	

	/**
	 * @Fields edt_YWLY : 业务来源
	 */
	@FindBy(how = How.NAME,using = "GuMainBusinessSource")
	WebElement edt_YWLY;	
	
	/**
	 * @Fields slc_CXYWBS : 创新业务标识
	 */
	@FindBy(how = How.NAME,using = "GuMainSurveyInd")
	WebElement slc_CXYWBS;	
	
	/**
	 * @Fields edt_DLJG : 代理机构 
	 */
	@FindBy(how = How.XPATH,using = "//tr[@id='WDF_agreementInfo']/td/input[@name='GuMainIntermediaryCode']")
	WebElement edt_DLJG;	
	
	/**
	 * @Fields edt_XSXY :销售协议
	 */
	@FindBy(how = How.XPATH,using = "//tr[@id='WDF_agreementInfo']/td/input[@name='GuMainAgreementNo']")
	WebElement edt_XSXY;	
	
	/************************************************
	 * 保单信息
	 ************************************************/	
	
	//保单信息
	/**
	 * @Fields slc_CDJG : 出单机构
	 */
	@FindBy(how = How.NAME,using = "GuMainIssueCompany")
	WebElement edt_CDJG;
	
	/**
	 * @Fields slc_HTZYJJFS : 合同争议解决方式
	 */
	@FindBy(how = How.NAME,using = "GuMainArgueSolution")
	@CacheLookup
	WebElement slc_HTZYJJFS;

	/**
	 * @Fields slc_JNWBZ : 境内外标志
	 */
	@FindBy(how = How.NAME, using  ="GuMainDomesticInd")
	WebElement slc_JNWBZ;
	
	
	/**
	 * @Fields edt_JW_Country : 国家 - 境外保单需要填写
	 */
	@FindBy(how = How.NAME, using  ="GuMainCountryCode")
	WebElement edt_JW_Country;
	
	/**
	 * @Fields edt_JW_ADDR : 境外地址 - 境外保单需要填写
	 */
	@FindBy(how = How.NAME, using  ="GuMainAddressCName")
	WebElement edt_JW_ADDR;
	
	/**
	 * @Fields edt_SNBZ : 涉农标志
	 */
	@FindBy(how = How.NAME, using  ="GuMainAgricultureFlag")
	WebElement edt_SNBZ;
	
	/**
	 * @Fields slc_sfTKBD : 是否统括保单
	 */
	@FindBy(how = How.NAME, using  ="GuMainComInsureInd")
	WebElement slc_sfTKBD;
	
	/**
	 * @Fields slc_sfDZBD : 是否电子保单
	 */
	@FindBy(how = How.NAME, using  ="GuMainPolicyStyle")
	WebElement slc_sfDZBD;
	
	/**
	 * @Fields slc_sfXB : 是否续保
	 */
	@FindBy(how = How.NAME, using  ="RenewalOfInsuranceSelect")
	WebElement slc_sfXB;
	
	/**
	 * @Fields edt_FXQKYJYTZ : 反洗钱可疑交易特征
	 */
	@FindBy(how = How.NAME, using  ="GuMainMoneySuspiciousInd")
	WebElement edt_FXQKYJYTZ;
	
	/**
	 * @Fields slc_sfYDYW : 是否异地业务
	 */
	@FindBy(how = How.NAME, using  ="GuMainIsDifferentPlace")
	WebElement slc_sfYDYW;
	
	/**
	 * @Fields slc_sfSN : 是否涉农
	 */
	@FindBy(how = How.NAME, using  ="GuMainIsFarming")
	WebElement slc_sfSN;
	
	/**
	 * @Fields edt_XBBDH : 续保保单号
	 */
	@FindBy(how = How.NAME, using  ="GuMainRenewalNo")
	WebElement edt_XBBDH;
	
	
	/************************************************
	 * 投保人信息
	 ************************************************/		

	/**
	 * @Fields slc_TBR_LX : 投保人类型
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyInsuredType")
	WebElement slc_TBR_LX;
	/**
	 * @Fields slc_TBR_VIP : VIP客户分类
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyVipInd")
	WebElement slc_TBR_VIP;
	/**
	 * @Fields edt_TBR_DM : 投保人代码
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyInsuredCode")
	WebElement edt_TBR_DM;
	/**
	 * @Fields btn_TBR_CX : 【按钮】投保人查询
	 */
	@FindBy(how = How.NAME, using  ="buttonAppliGuRelatedPartyClient")
	WebElement btn_TBR_CX;
	/**
	 * @Fields edt_TBR_MC : 投保人名称
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyInsuredName")
	WebElement edt_TBR_MC;
	/**
	 * @Fields slc_TBR_ZJLX : 证件类型
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyIdentifyType")
	WebElement slc_TBR_ZJLX;
	/**
	 * @Fields edt_TBR_ZJHM : 证件号码 
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyIdentifyNumber")
	WebElement edt_TBR_ZJHM;
		
	/**
	 * @Fields edt_TBR_CSRQ : 出生日期
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyBirthDate")
	WebElement edt_TBR_CSRQ;
	
	/**
	 * @Fields edt_TBR_SJ : 投保人手机号
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyMobilePhone")
	WebElement edt_TBR_SJ;
	/**
	 * @Fields edt_TBR_LXDZ : 联系地址
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyInsuredAddress")
	WebElement edt_TBR_LXDZ;
	
	
	/**
	 * @Fields edt_TBR_YX : 投保人邮箱-个人客户
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyRemark")
	WebElement edt_TBR_YX;
	/**
	 * @Fields edt_TBR_DWDH_QH : 单位电话-区号
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyOfficePhoneAreaCode")
	WebElement edt_TBR_DWDH_QH;
	
	/**
	 * @Fields edt_TBR_DWDH_HM : 单位电话-号码
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyOfficePhoneNumber")
	WebElement edt_TBR_DWDH_HM;
	
	/**
	 * @Fields edt_TBR_DWDH_FJ : 单位电话-分机号
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyOfficePhoneExt")
	WebElement edt_TBR_DWDH_FJ;
	
	/**
	 * @Fields btn_TBR_KHSB : 【按钮】客户识别
	 */
	@FindBy(how = How.NAME, using  ="buttonInsuredGuAppliPartyCustomerIdentify")
	WebElement btn_TBR_KHSB;
	/**
	 * @Fields btn_TBR_BCKH : 【按钮】保存客户
	 */
	@FindBy(how = How.NAME, using  ="buttonSaveCustomer")
	WebElement btn_TBR_BCKH;
	
	
	
	
	
	/************************************************
	 * 联系人信息
	 ************************************************/	
	
	/**
	 * @Fields rdo_related : 联系人
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyContactName")
	WebElement edt_LXR_XM;
	
	/**
	 * @Fields slc_LXR_XB : 联系人性别 
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyContactSex")
	WebElement slc_LXR_XB;
	
	/**
	 * @Fields edt_LXR_BM : 联系人部门
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyContactDepartment")
	WebElement edt_LXR_BM;
	
	/**
	 * @Fields slc_LXR_SJ : 联系人手机 - 单位客户
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyContactMobile")
	WebElement edt_LXR_SJ;
	
	/**  AppliGuRelatedPartyContactPosition
	 * @Fields edt_LXR_YX : 联系人邮箱
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyRemark")
	WebElement edt_LXR_YX;
	
	
	/**  
	 * @Fields edt_LXR_ZW : 联系人职务
	 */
	@FindBy(how = How.NAME, using  ="AppliGuRelatedPartyContactPosition")
	WebElement edt_LXR_ZW;
	
	
	

	/**
	 * @Fields btn_saveBasicPage : 保存 - 保存投保处理基本信息
	 */
	@FindBy(how = How.ID, using  ="saveButton")
	WebElement btn_SAVE_BASIC_PAGE;
	
	
	//Initializing the Page Objects:
	public BasicInfoPage(){
		goToWorkArea();
		PageFactory.initElements(driver(), this);
		logger.debug("投保处理/基本信息");
//		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10) ,this);

	}
	
	
	//Actions:

	/**
	 *<p>inputSalesInfoAction</p>
	 *<p>销售信息</p>
	 * @param fbbs 分保标识
	 * @param ywgs 业务归属
	 * @param qdlx 渠道类型
	 * @param xstd 销售团队
	 * @param ywy 业务员
	 * @param ywly 业务来源 
	 * @param dljg 代理机构 
	 * @param xsxy 销售协议 
	 * @param cxywbs 创新业务标识
	 */
	public void inputSalesInfoAction(String fbbs, String ywgs,String qdlx,String gdbs,String xstd,String ywy,String ywly,String dljg,String xsxy, String cxywbs){
		slc_FBBS = this.waitAndGetElement(By.name("GuMainBusinessType"), 20);
		super.setSelectWithStartText(slc_FBBS, fbbs);
		super.SetCodeEditBox(edt_YWGS, ywgs);
		super.SetCodeEditBox(edt_QDLX, qdlx);
		super.CodeSelect(edt_GDBS, gdbs);
		super.CodeSelect(edt_XSTD, xstd);
		super.CodeSelect(edt_YWY, ywy);
		super.CodeSelect(edt_YWLY, ywly);
		super.setSelectWithStartText(slc_CXYWBS, cxywbs);
		super.CodeSelect(edt_DLJG, dljg);
		super.CodeSelect(edt_XSXY, xsxy);

	}
	/**
	 *<p>inputSalesInfoAction</p>
	 *<p>录入销售信息</p>
	 * @param map
	 */
	public void inputSalesInfoAction(Map<String, String> map) {
		this.inputSalesInfoAction(map.get("fbbs"), map.get("ywgs"), map.get("qdlx"), map.get("gdbs"),map.get("xstd"), map.get("ywy"), map.get("ywly"),map.get("dljg"),map.get("xsxy"), map.get("cxywbs"));
	}
	
	/**
	 *<p>inputPolicyInofAction</p>
	 *<p>输入保单信息</p>
	 * @param cdjg 出单机构
	 * @param htzyjjfs 合同争议解决方式
	 * @param jnwbz 境内外标志
	 * @param jw_country 境外国家
	 * @param jw_Addr 境外地址
	 * @param snbz 涉农标志
	 * @param sftkbd 是否统括保单
	 * @param sfdzbd 是否电子保单
	 * @param sfxb 是否续保
	 * @param fxqkyjytz 反洗钱可疑交易特征
	 * @param sfydyw 是否异地业务
	 * @param sfsn 是否涉农
	 * @param xbbdh 续保保单号
	 */
	public void inputPolicyInfoAction(String cdjg,String htzyjjfs,String jnwbz,String jw_country,String jw_Addr,String snbz,String sftkbd,String sfdzbd,String sfxb,String fxqkyjytz,String sfydyw,String sfsn,String xbbdh) {
		super.CodeSelect(edt_CDJG, cdjg);
		super.setSelectWithStartText(slc_HTZYJJFS,htzyjjfs);
		super.setSelectWithStartText(slc_JNWBZ, jnwbz);
		if ("1".equals(jnwbz)) {
			super.SetCodeEditBox(edt_JW_Country, jw_country);
			super.setEditboxValue(edt_JW_ADDR, jw_Addr);
		}
		super.SetCodeEditBox(edt_SNBZ, snbz);
		super.setSelectWithStartText(slc_sfTKBD, sftkbd);
		super.setSelectWithStartText(slc_sfDZBD, sfdzbd);
		super.setSelectWithStartText(slc_sfXB, sfxb);
		super.CodeSelect(edt_FXQKYJYTZ, fxqkyjytz);
		super.setSelectWithStartText(slc_sfYDYW, sfydyw);
		super.setSelectWithStartText(slc_sfSN, sfsn);
		super.setEditboxValue(edt_XBBDH, xbbdh);		
	}
	/**
	 *<p>inputPolicyInfoAction</p>
	 *<p>录入保单信息</p>
	 * @param map
	 */
	public void inputPolicyInfoAction(Map<String, String> map) {
		this.inputPolicyInfoAction(map.get("cdjg"),map.get("htzyjjfs"),map.get("jnwbz"),
								   map.get("jw_country"),map.get("jw_Addr"),map.get("snbz"),
								   map.get("sftkbd"),map.get("sfdzbd"),map.get("sfxb"),
								   map.get("fxqkyjytz"),map.get("sfydyw"),map.get("sfsn"),
								   map.get("xbbdh")
								  );
	}
	/**
	 *<p>inputOwnerInfoAction</p>
	 *<p>输入投保人信息</p>
	 * @param tbr_lx 投保人类型
	 * @param tbr_mc 投保人名称 
	 * @param tbr_vip VIP客户分类
	 * @param tbr_dm 投保人代码
	 * @param tbr_zjlx 证件类型 
	 * @param tbr_zjhm 证件号码
	 * @param tbr_csrq 出生日期
	 * @param tbr_lxdz 联系地址 
	 * @param tbr_dwdh 单位电话
	 * @param lxr_xm 联系人姓名
	 * @param lxr_xb 联系人性别 
	 * @param lxr_zw 联系人职务
	 * @param lxr_sj 联系人手机
	 * @param lxr_yx 联系人邮箱
	 */
	public void inputOwnerInfoAction(String tbr_lx,String tbr_mc,String tbr_vip,String tbr_dm,String tbr_zjlx,String tbr_zjhm,String tbr_csrq,String tbr_sj,String tbr_lxdz,String tbr_dwdh,String tbr_yx,String lxr_xm,String lxr_xb,String lxr_zw,String lxr_sj,String lxr_yx) {
		super.setSelectWithStartText(slc_TBR_LX, tbr_lx);
		if(!"".equals(tbr_dm)) {   //如果投保人代码不为空则直接从系统中获取投保人信息
			super.setEditboxTValue(edt_TBR_DM, tbr_dm);
		}else {
			super.setSelectWithStartText(slc_TBR_VIP, tbr_vip);
			super.setEditboxValue(edt_TBR_MC, tbr_mc);
			super.setSelectWithStartText(slc_TBR_ZJLX, tbr_zjlx);
			super.setEditboxValue(edt_TBR_ZJHM, tbr_zjhm);
			super.setEditboxValue(edt_TBR_LXDZ, tbr_lxdz);
			if("1".equals(tbr_lx)) { //个人客户
				super.setEditboxTValue(edt_TBR_CSRQ,tbr_csrq);
				super.setEditboxTValue(edt_TBR_SJ,tbr_sj);
			}else if("2".equals(tbr_lx)) {//团体客户
				if(!"".equals(tbr_dwdh)) {
					String[] telArr= {"","",""};
					String[] tmpArr=tbr_dwdh.split("-");
					for(int i=0; i<tmpArr.length || i<3; i++) {
						telArr[i]=tmpArr[i];
					}
					super.setEditboxValue(edt_TBR_DWDH_QH, telArr[0]);
					super.setEditboxValue(edt_TBR_DWDH_HM, telArr[1]);
					super.setEditboxValue(edt_TBR_DWDH_FJ, telArr[2]);
				}
				super.setEditboxValue(edt_LXR_XM, lxr_xm);
				super.setSelectWithStartText(slc_LXR_XB, lxr_xb);
				super.setEditboxValue(edt_LXR_ZW, lxr_zw);
				super.setEditboxValue(edt_LXR_SJ, lxr_sj);
				super.setEditboxValue(edt_LXR_YX, lxr_yx);
			}
			this.btn_TBR_KHSB.click();//识别客户
			waitAndAcceptAlert("客户不存在，请创建客户.",3);
			
		}
	if("1".equals(tbr_lx)) {
		this.SetCodeEditBox(edt_TBR_YX,tbr_yx);
	}
	}
	/**
	 *<p>inputOwnerInfoAction</p>
	 *<p>录入投保人信息</p>
	 * @param map
	 */
	public void inputOwnerInfoAction(Map<String, String> map) {
		this.inputOwnerInfoAction(map.get("tbr_lx"),map.get("tbr_mc"),map.get("tbr_vip"),
								  map.get("tbr_dm"),map.get("tbr_zjlx"),map.get("tbr_zjhm"),
								  map.get("tbr_csrq"),map.get("tbr_sj"),map.get("tbr_lxdz"),map.get("tbr_dwdh"),map.get("tbr_yx"),
								  map.get("lxr_xm"),map.get("lxr_xb"),map.get("lxr_zw"),
								  map.get("lxr_sj"),map.get("lxr_yx")
								);
	
	}
	/**
	 *<p>inputContactInfoAction</p>
	 *<p>输入联系人信息</p>
	 * @param lxr_xm 联系人 
	 * @param lxr_xb 联系人性别 
	 * @param lxr_bm 联系人部门
	 * @param lxr_sj 联系人手机
	 * @param lxr_yx 联系人E-mail 
	 * @param lxr_zw 联系人职务
	 */
	public void inputContactInfoAction(String lxr_xm,String lxr_xb,String lxr_bm,String lxr_sj,String lxr_yx,String lxr_zw) {
		super.setEditboxValue(edt_LXR_XM, lxr_xm);
		super.setSelectWithStartText(slc_LXR_XB, lxr_xb);
		super.setEditboxValue(edt_LXR_BM, lxr_bm);
		super.setEditboxValue(edt_LXR_SJ, lxr_sj);
		super.setEditboxValue(edt_LXR_YX, lxr_yx);
		super.setEditboxValue(edt_LXR_ZW, lxr_zw);
	}
	
	/**
	 *<p>saveCustomerAction</p>
	 *<p>保存客户信息，并返回客户的代码</p>
	 * @return
	 */
	private String saveCustomerAction() {
		btn_TBR_BCKH.click();
		List<String> ttlLst=new ArrayList<String>();
		ttlLst.add("客户信息被修改，是否同时保存客户.");
		ttlLst.add("客户已经保存，或不需要保存.");
		ttlLst.add("保存客户成功.");
		String altTitle =catchUnexpectedAlert(5);
		if(!"".equals(altTitle)) {
			logger.info("在保存客户时捕获了一个弹窗："+altTitle);
			waitAndAcceptAlert(altTitle,1);
		}
		Assert.assertTrue(ttlLst.contains(altTitle));
		return edt_TBR_DM.getText();
	}
	/**
	 *<p>saveBasicInfoAction</p>
	 *<p>保存投保处理保单基本信息</p>
	 */
	public RiskDetail_TypePage saveBasicInfoAction(Map<String, String> map) {
		TestUtil.takeScreenshot(getTestCaseId(map)+"投保单基本信息页面");
		if("".equals(map.get("tbr_dm"))) {
			saveCustomerAction();
		}
		btn_SAVE_BASIC_PAGE.click();
		//return new RiskDetail_TypePage();
		return RiskDetail_TypePage.getInstance(map.get("riskCode"));
	}
}
