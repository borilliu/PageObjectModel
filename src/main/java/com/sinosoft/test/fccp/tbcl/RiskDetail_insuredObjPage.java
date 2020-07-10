package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RiskDetail_insuredObjPage extends RiskDetailPage {

	/**
	 * @Fields edt_JQBM : 街区编码
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyBlockCode")
	WebElement edt_JQBM;
	
	/**
	 * @Fields edt_BBDM : 币别代码/名称
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyCurrency")
	WebElement edt_BBDM;
	
	/**
	 * @Fields edt_SF : 省份
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyItemProvinceCode")
	WebElement edt_SF;

	
	/**
	 * @Fields edt_CS : 城市
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyItemCityCode")
	WebElement edt_CS;
	
	/**
	 * @Fields edt_QX : 区县
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyItemDistrictCode")
	WebElement edt_QX;
	
	/**
	 * @Fields edt_YB : 邮编
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyItemPostalCode")
	WebElement edt_YB;
	
	/**
	 * @Fields edt_JZDJ : 建筑等级
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyConstruction")
	WebElement edt_JZDJ;
	
	/**
	 * @Fields edt_ZYXZ : 占用性质 
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyOccupation")
	WebElement edt_ZYXZ;
	
	/**
	 * @Fields edt_BXCS : 保险处所
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertySituation")
	WebElement edt_BXCS;
		
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
	@FindBy(how = How.NAME,using = "GuItemKindKindCode")
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
	
	
	
	
	/**
	 * @Fields btn_savePage : 保存标的信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	
	public RiskDetail_insuredObjPage() {
		goToWorkArea();
		edt_JQBM =super.waitAndGetElement(By.name("GuItemPropertyBlockCode"), 20);
		PageFactory.initElements(driver, this);
		logger.debug("进入保险标的信息页面对象！");
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
	private void inputInsuredObjectAction(String jqbm,String bbdm,String sf,String cs,String qx,String yb,String jzdj,String bxcs) {
		this.setEditboxTValue(edt_JQBM, jqbm);
		this.CodeSelect(edt_BBDM, bbdm);
		this.SetCodeEditBox(edt_SF, sf);
		this.SetCodeEditBox(edt_CS, cs);
		this.CodeSelect(edt_QX, qx);
		this.setEditboxValue(edt_YB, yb);
		this.SetCodeEditBox(edt_JZDJ, jzdj);
		this.setEditboxValue(edt_BXCS, bxcs);
	}
	/**
	 *<p>InputInsuredObjectAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		this.inputInsuredObjectAction(map.get("jqbm"),map.get("bbdm"),map.get("sf"),map.get("cs"),map.get("qx"),map.get("yb"),map.get("jzdj"),map.get("bxcs"));
	}
	public void inputRiskCodeAction(String bdw,String bdwmx,String xbdm,String jrbe,String jzfs,String bxje,String bffl,String dqflbz,String ysbf) {
		this.clickElement(tbl_BDWMX);
		edt_BDW = tbl_BDWMX.findElement(By.name("GuItemPropertyDetailItemDetailCode"));
		edt_BDWMX = tbl_BDWMX.findElement(By.name("GuItemPropertyDetailItemDetailList"));
		this.CodeSelect(edt_BDW, bdw);
		this.setEditboxValue(edt_BDWMX, bdwmx);
		
		
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
	 *<p>inputRiskCodeAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public void inputRiskCodeAction(Map<String, String> map) {
		this.inputRiskCodeAction(map.get("bdw"),map.get("bdwmx"),map.get("xbdm"),map.get("jrbe"),map.get("jzfs"),map.get("bxje"),map.get("bffl"),map.get("dqflbz"),map.get("ysbf"));
	}
	/**
	 *<p>saveInsredObjectPage</p>
	 *<p>保存标的物页面</p>
	 */
	public void saveInsredObjectPage(){
		this.clickButton(btn_savePage);
	}
	
}
