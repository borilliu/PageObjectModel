package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RiskDetail_insuredObjPage extends RiskDetail_AbstractInsuredObjPage {
	/**
	 * @Fields edt_BDW : 标的物
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyDetailItemDetailCode")
	WebElement edt_BDW;             
	
	/**
	 * @Fields edt_BDWMX : 标的物明细名称
	 */							
	@FindBy(how = How.NAME,using = "GuItemPropertyDetailItemDetailList")
	WebElement edt_BDWMX;

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
	//@FindBy(how = How.NAME,using = "GuItemKindKindCode")
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
	
	/***************************************************
	 *   营业中断险
	 * *************************************************/
	
	
	/**
	 * @Fields tbl_YYZDX : 营业中断险
	 */
	@FindBy(how = How.ID,using = "ItemPropertyItem1105")
	WebElement tbl_YYZDX;

	

	
	@FindBy(how = How.ID,using = "ItemPropertyDetail0105")
	WebElement tbl_YYZDX_DETAIL;
	
	/**
	 * @Fields edt_BXJE : 最大赔偿期
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamic0105FieldBG")
	WebElement edt_ZDPCG;
	
	
	
	/**
	 * @Fields edt_SNDMLRZE : 上年度毛利润总额
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamic0105FieldBF")
	WebElement edt_SNDMLRZE;
	
	
	/**
	 * @Fields edt_SNDYYE : 上年度营业额
	 */
	@FindBy(how = How.NAME,using = "GuItemDynamic0105FieldBE")
	WebElement edt_SNDYYE;
	
	
	
	/**
	 * @Fields edt_YYZD_BDW : 营业中断险-标的物
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='ItemPropertyDetail0105']/tbody/tr/td/input[@name='GuItemPropertyDetail0105ItemDetailCode']")
	WebElement edt_YYZD_BDW;
	
	/**
	 * @Fields edt_YYZD_BDW : 营业中断险-标的物明细
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='ItemPropertyDetail0105']/tbody/tr/td/input[@name='GuItemPropertyDetail0105ItemDetailList']")
	WebElement edt_YYZD_BDWMX;
	
	
	
	/**
	 * @Fields tbl_YYZDX : 营业中断险
	 */
	@FindBy(how = How.ID,using = "ItemPropertyDetailKind0105")
	WebElement tbl_YYZDX_LIST;

	/**
	 * @Fields btn_savePage : 保存标的信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	
	public RiskDetail_insuredObjPage() {
		goToWorkArea();
		tbl_BDWMX =super.waitAndGetElement(By.id("ItemPropertyDetail"), 20);
		PageFactory.initElements(driver(), this);
		logger.debug("进入保险标的信息页面对象！");
	}
	
	/**
	 *<p>InputInsuredObjectAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		AbstractInsuredObjectInfoPage_01.getInstance( map.get("riskCode")).inputInsuredObjectAction(map);
		super.takeSnapShot(super.getTestCaseId(map)+"_标的基础信息");
		//this.inputInsuredObjectAction(map.get("jqbm"),map.get("bbdm"),map.get("sf"),map.get("cs"),map.get("qx"),map.get("yb"),map.get("jzdj"),map.get("bxcs"));
	}
	/**
	 *<p>inputRiskCodeAction</p>
	 *<p>录入标的物险种信息</p>
	 * @param map
	 */
	public void inputRiskCoverageAction(Map<String, String> map) {
		logger.debug("开始录入险种明细信息");
		if("0123".equals(map.get("riskCode"))) {
			inputRiskCode0123Action(map);
		}else {
			this.inputRiskCodeAction(map);
		}
		logger.debug("开始录入营业中断险！");
		if("1".equals(map.get("yyzdbz"))) {
			this.inputBizInterruptionAction(map);
		}
		super.takeSnapShot(super.getTestCaseId(map)+"_标的投保详细信息");
	}
	/**
	 *<p>inputBizInterruptionAction</p>
	 *<p>录入营业中断信息</p>
	 * @param map
	 */
	public void inputBizInterruptionAction(Map<String, String> map) {
		this.clickElement(tbl_YYZDX);
		this.setEditboxValue(edt_ZDPCG, map.get("yyzd_zdpcg"));
		this.SetCodeEditBox(edt_SNDMLRZE, map.get("yyzd_sndmlrze"));
		this.SetCodeEditBox(edt_SNDYYE, map.get("yyzd_sndyye"));
		
		edt_YYZD_BDW = tbl_YYZDX_DETAIL.findElement(By.name("GuItemPropertyDetail0105ItemDetailCode"));
		edt_YYZD_BDWMX = tbl_YYZDX_DETAIL.findElement(By.name("GuItemPropertyDetail0105ItemDetailList"));
		this.CodeSelect(edt_YYZD_BDW, map.get("yyzd_bdw"));
		this.setEditboxValue(edt_YYZD_BDWMX, map.get("yyzd_bdwmx"));
		this.clickElement(tbl_YYZDX_DETAIL);
		WebElement edt_YYZD_XBDM = tbl_YYZDX_DETAIL.findElement(By.name("GuItemKind0105KindCode"));
		WebElement edt_YYZD_JRBE = tbl_YYZDX_DETAIL.findElement(By.name("GuItemKind0105CalculateInd"));
		WebElement slc_YYZD_JZFS = tbl_YYZDX_DETAIL.findElement(By.name("GuItemKind0105ValueType"));
		WebElement edt_YYZD_BXJE = tbl_YYZDX_DETAIL.findElement(By.name("GuItemKind0105SumInsured"));
		WebElement edt_YYZD_BFFL = tbl_YYZDX_DETAIL.findElement(By.name("GuItemKind0105Rate"));
		WebElement edt_YYZD_DQFLVZ = tbl_YYZDX_DETAIL.findElement(By.name("GuItemKind0105ShortRateFlag"));
		WebElement edt_YYZD_YSBF = tbl_YYZDX_DETAIL.findElement(By.name("GuItemKind0105GrossPremium"));
		

		this.CodeSelect(edt_YYZD_XBDM,map.get("yyzd_xbdm"));
		this.CodeSelect(edt_YYZD_JRBE,map.get("yyzd_jrbe"));
		this.setSelectWithStartText(slc_YYZD_JZFS, map.get("yyzd_jzfs"));
		this.setEditboxValue(edt_YYZD_BXJE, map.get("yyzd_bxje"));
		this.setEditboxTValue(edt_YYZD_BFFL,  map.get("yyzd_bffl"));
		this.CodeSelect(edt_YYZD_DQFLVZ, map.get("yyzd_dqflbz"));
		this.setEditboxTValue(edt_YYZD_YSBF, map.get("yyzd_ysbf"));
	}
	/**
	 *<p>InputInsuredObjectAction</p>
	 *<p>录入标的物信息</p>
	 * @param jqbm 街区编码
	 * @param bbdm 币别代码/名称
	 * @param sf 省份
	 * @param cs 城市
	 * @param qx 区县
	 * @param yb 邮编
	 * @param jzdj 建筑等级
	 * @param bxcs 保险处所
	 */
/*	private void inputInsuredObjectAction(String jqbm,String bbdm,String sf,String cs,String qx,String yb,String jzdj,String bxcs) {
		this.setEditboxTValue(edt_JQBM, jqbm);
		this.CodeSelect(edt_BBDM, bbdm);
		this.SetCodeEditBox(edt_SF, sf);
		this.SetCodeEditBox(edt_CS, cs);
		this.CodeSelect(edt_QX, qx);
		this.setEditboxValue(edt_YB, yb);
		this.SetCodeEditBox(edt_JZDJ, jzdj);
		this.setEditboxValue(edt_BXCS, bxcs);
	}*/
	private void inputRiskCode0123Action(Map<String, String> map) {
		this.clickElement(tbl_BDWMX);
		edt_XBDM = tbl_BDWMX.findElement(By.name("GuItemKindItemDetailCode"));
		this.CodeSelect(edt_XBDM, map.get("xbdm"));
		edt_JRBE = tbl_BDWMX.findElement(By.name("GuItemKindCalculateInd"));
		this.CodeSelect(edt_JRBE,map.get("jrbe"));
		edt_BXJE = tbl_BDWMX.findElement(By.name("GuItemKindSumInsured"));
		this.setEditboxValue(edt_BXJE, map.get("bxje"));
		edt_BFFL = tbl_BDWMX.findElement(By.name("GuItemKindRate"));
		this.setEditboxTValue(edt_BFFL, map.get("bffl"));
		edt_DQFLBZ = tbl_BDWMX.findElement(By.name("GuItemKindShortRateFlag"));
		this.CodeSelect(edt_DQFLBZ, map.get("dqflbz"));
		edt_YSBF = tbl_BDWMX.findElement(By.name("GuItemKindGrossPremium"));
		this.setEditboxTValue(edt_YSBF, map.get("ysbf"));
	}
	private void inputRiskCodeAction(Map<String, String> map) {
		String bdw=map.get("bdw");
		String bdwmx = map.get("bdwmx");
		String xbdm = map.get("xbdm");
		String jrbe = map.get("jrbe");
		String jzfs= map.get("jzfs");
		String bxje = map.get("bxje");
		String bffl = map.get("bffl");
		String dqflbz = map.get("dqflbz");
		String ysbf =map.get("ysbf");
		this.clickElement(tbl_BDWMX);
		if(!"".equals(bdw)) {
			edt_BDW = tbl_BDWMX.findElement(By.name("GuItemPropertyDetailItemDetailCode"));
			edt_BDWMX = tbl_BDWMX.findElement(By.name("GuItemPropertyDetailItemDetailList"));
			this.CodeSelect(edt_BDW, bdw);
			this.setEditboxValue(edt_BDWMX, bdwmx);
		}
		edt_XBDM = tbl_BDWMX.findElement(By.name("GuItemKindKindCode"));
		this.CodeSelect(edt_XBDM, xbdm);
		edt_JRBE = tbl_BDWMX.findElement(By.name("GuItemKindCalculateInd"));
		this.CodeSelect(edt_JRBE,jrbe);
		slc_JZFS = tbl_BDWMX.findElement(By.name("GuItemKindValueType"));
		this.setSelectWithStartText(slc_JZFS, jzfs);
		edt_BXJE = tbl_BDWMX.findElement(By.name("GuItemKindSumInsured"));
		this.setEditboxValue(edt_BXJE, bxje);
		
		//edt_BFFL = tbl_BDWMX.findElement(By.name("GuItemKindRate"));
		this.setEditboxTValue(edt_BFFL, bffl);
		//edt_DQFLBZ = tbl_BDWMX.findElement(By.name("GuItemKindShortRateFlag"));
		this.CodeSelect(edt_DQFLBZ, dqflbz);
		//edt_YSBF = tbl_BDWMX.findElement(By.name("GuItemKindGrossPremium"));
		this.setEditboxTValue(edt_YSBF, ysbf);
	}
	

	/**
	 *<p>saveInsredObjectPage</p>
	 *<p>保存标的物页面</p>
	 */
	public void saveInsredObjectPage(){
		this.jsClickButton(btn_savePage);
		pause(1000);
	}
	
}
