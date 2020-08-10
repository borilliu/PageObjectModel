package com.sinosoft.test.fccp.tbcl;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RiskDetail_JCX_insuredObjPage extends RiskDetail_AbstractInsuredObjPage {
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
	 **********                险别信息        	 *************
	 *********************************************************
	 */
	
	@FindBy(how = How.ID,using = "ItemPropertyDetail")
	//@FindBy(how = How.ID,using = "ItemPropertyDetailKind")
	WebElement tbl_BDWMX;
	
/*	*//**
	 * @Fields edt_XBDM : 险别代码/名称
	 *//*
	//@FindBy(how = How.NAME,using = "GuItemKindKindCode")
	WebElement edt_XBDM;
	
	
	*//**
	 * @Fields edt_JRBE : 计入保额(标记)
	 *//*
	@FindBy(how = How.NAME,using = "GuItemKindCalculateInd")
	WebElement edt_JRBE;
	
	
	*//**
	 * @Fields slc_JZFS : 价值方式 
	 *//*
	@FindBy(how = How.NAME,using = "GuItemKindValueType")
	WebElement slc_JZFS;
	
	
	*//**
	 * @Fields edt_BXJE : 保险金额
	 *//*
	@FindBy(how = How.NAME,using = "GuItemKindSumInsured")
	WebElement edt_BXJE;
	
	
	
	*//**
	 * @Fields edt_BFFL : 保费费率
	 *//*
	//@FindBy(how = How.NAME,using = "GuItemKindRate")
	@FindBy(how = How.XPATH,using = "//table[@id='ItemPropertyDetailKind']/tbody/tr/td/input[@name='GuItemKindRate']")
	WebElement edt_BFFL;
	
	
	
	*//**
	 * @Fields edt_DQFLBZ : 短期费率标志
	 *//*
	//@FindBy(how = How.NAME,using = "GuItemKindShortRateFlag")
	@FindBy(how = How.XPATH,using = "//table[@id='ItemPropertyDetailKind']/tbody/tr/td/input[@name='GuItemKindShortRateFlag']")
	WebElement edt_DQFLBZ;
	
	
	*//**
	 * @Fields edt_YSBF : 应收保费
	 *//*
	//@FindBy(how = How.NAME,using = "GuItemKindGrossPremium")
	@FindBy(how = How.XPATH,using = "//table[@id='ItemPropertyDetailKind']/tbody/tr/td/input[@name='GuItemKindGrossPremium']")
	WebElement edt_YSBF;*/
	

	/**
	 * @Fields btn_savePage : 保存标的信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	
	public RiskDetail_JCX_insuredObjPage() {
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
		AbstractInsuredObjectInfoPage_17.getInstance( map.get("riskCode")).inputInsuredObjectAction(map);
		super.takeSnapShot(super.getTestCaseId(map)+"_标的基础信息");
	}
	/**
	 *<p>inputRiskCodeAction</p>
	 *<p>录入标的物险种信息</p>
	 * @param map
	 */
	public void inputRiskCoverageAction(Map<String, String> map) {
		logger.debug("开始录入免赔信息");
		inputDeductionAction(map);
		logger.debug("开始录入条款信息");
		inputSpecialClauseAction(map);
		logger.debug("开始录入险种明细信息");
		inputRiskCodeAction(map);
		super.takeSnapShot(getTestCaseId(map)+"_标的投保详细信息");
	}
	
	private void inputRiskCodeAction(Map<String, String> map) {
		scrollToElement(tbl_BDWMX);
		WebElement btn_addBDW = tbl_BDWMX.findElement(By.name("button_ItemDetail_Insert"));
		List<Map<String,Object>> riskList= getRiskMapList(map,"jcx_");
		 for(int i=0;i<riskList.size();i++) {
			 if(i>0) {
				 this.jsClickButton(btn_addBDW);
			 }
			Map<String,Object> riskMap=riskList.get(i);
			WebElement edt_BDW = tbl_BDWMX.findElement(By.xpath("(//input[@name='GuItemPropertyDetailItemDetailCode'])[last()]"));
			CodeSelect(edt_BDW, (String)riskMap.get("bdw"));
			WebElement edt_BDWMX = tbl_BDWMX.findElement(By.xpath("(//textarea[@name='GuItemPropertyDetailItemDetailList'])[last()]"));
			setEditboxValue(edt_BDWMX, (String)riskMap.get("bdmx"));
			WebElement edt_XBDM = tbl_BDWMX.findElement(By.xpath("(//input[@name='GuItemKindKindCode'])[last()]"));
			this.CodeSelect(edt_XBDM, (String)riskMap.get("xbdm"));
			WebElement edt_JRBE = tbl_BDWMX.findElement(By.xpath("(//input[@name='GuItemKindCalculateInd'])[last()]"));
			this.CodeSelect(edt_JRBE,(String)riskMap.get("jrbe"));
			WebElement edt_BXJE = tbl_BDWMX.findElement(By.xpath("(//input[@name='GuItemKindUnitInsured'])[last()]"));
			this.setEditboxValue(edt_BXJE, (String)riskMap.get("bxje"));
			
			WebElement edt_BFFL = tbl_BDWMX.findElement(By.xpath("(//input[@name='GuItemKindRate'])[last()]"));
			this.setEditboxTValue(edt_BFFL, (String)riskMap.get("bffl"));
			WebElement edt_DQFLBZ = tbl_BDWMX.findElement(By.xpath("(//input[@name='GuItemKindShortRateFlag'])[last()]"));
			this.CodeSelect(edt_DQFLBZ, (String)riskMap.get("dqflbz"));
			WebElement edt_YSBF = tbl_BDWMX.findElement(By.xpath("(//input[@name='GuItemKindGrossPremium'])[last()]"));
			this.setEditboxTValue(edt_YSBF, (String)riskMap.get("ysbf"));
		}
	}
	/**
	 *<p>saveInsredObjectPage</p>
	 *<p>保存标的物页面</p>
	 */
	public void saveInsredObjectPage(Map<String, String> map){
		this.jsClickButton(btn_savePage);
		pause(10000);
		AbstractInsuredObjectInfoPage_17.getInstance( map.get("riskCode")).inputInsuredDetailAction(map);
	}
	
}
