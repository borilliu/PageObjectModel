package com.sinosoft.test.fccp.tbcl;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.util.TestUtil;

public class RiskDetail_ZRX_insuredObjPage extends RiskDetail_AbstractInsuredObjPage {

	/*********************************************************
	 **********                险别信息          *************
	 *********************************************************
	 */
	
	@FindBy(how = How.ID,using = "ItemKind")
	WebElement tbl_riskCoverage;
	
	/**
	 * @Fields btn_savePage : 保存标的信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	
	public RiskDetail_ZRX_insuredObjPage() {
		goToWorkArea();
		btn_savePage =super.waitAndGetElement(By.id("saveButton"), 20);
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
		AbstractInsuredObjectInfoPage_12.getInstance( map.get("riskCode")).inputInsuredObjectAction(map);
		super.takeSnapShot(super.getTestCaseId(map)+"_标的基础信息");
	}
	/**
	 *<p>inputRiskCodeAction</p>
	 *<p>录入标的物险种信息</p>
	 * @param map
	 */
	public void inputRiskCoverageAction(Map<String, String> map) {
		logger.debug("开始录入险种明细信息");
		this.inputRiskCodeAction(map);
		logger.debug("开始录入附加险种明细信息");
		super.inputRidersAction(map);
		logger.debug("开始录入特殊条款信息");
		super.inputSpecialClauseAction(map);
		super.takeSnapShot(super.getTestCaseId(map)+"_标的投保详细信息");
	}
	
	private void inputRiskCodeAction(Map<String, String> map) {
		
		this.scrollToElement(tbl_riskCoverage);
		List<Map<String,Object>> riskList= getRiskMapList(map,"zrx_");
		 for (Map<String,Object> riskMap:riskList) {
			WebElement btn_addRisk = tbl_riskCoverage.findElement(By.name("button_ItemKindSub_Insert"));
			this.jsClickButton(btn_addRisk);
			//主险
			WebElement edt_XBDM = tbl_riskCoverage.findElement(By.xpath("(//input[@name='GuItemKindKindCode'])[last()]"));
			this.CodeSelect(edt_XBDM, (String)riskMap.get("xbdm"));
			WebElement edt_JRBE = tbl_riskCoverage.findElement(By.xpath("(//input[@name='GuItemKindCalculateInd'])[last()]"));
			this.CodeSelect(edt_JRBE,(String)riskMap.get("jrbe"));
			WebElement edt_BXJE;
			if ("1268".equals(map.get("riskCode"))) {
				 edt_BXJE = tbl_riskCoverage.findElement(By.xpath("(//input[@name='GuItemKindSumInsured'])[last()]"));
			}else {
				 edt_BXJE = tbl_riskCoverage.findElement(By.xpath("(//input[@name='GuItemKindSumValue'])[last()]"));
			}
			this.setEditboxValue(edt_BXJE, (String)riskMap.get("bxje"));
			WebElement edt_BFFL = tbl_riskCoverage.findElement(By.xpath("(//input[@name='GuItemKindRate'])[last()]"));
			this.setEditboxTValue(edt_BFFL, (String)riskMap.get("bffl"));
			WebElement edt_DQFLBZ = tbl_riskCoverage.findElement(By.xpath("(//input[@name='GuItemKindShortRateFlag'])[last()]"));
			this.CodeSelect(edt_DQFLBZ, (String)riskMap.get("dqflbz"));
			
			WebElement edt_JBBF = tbl_riskCoverage.findElement(By.xpath("(//input[@name='GuItemKindBasePremium'])[last()]"));
			this.setNumberEditBoxValue(edt_JBBF, (String)riskMap.get("jbbf"));
			
			WebElement edt_YSBF = tbl_riskCoverage.findElement(By.xpath("(//input[@name='GuItemKindGrossPremium'])[last()]"));
			this.setNumberEditBoxValue(edt_YSBF, (String)riskMap.get("ysbf"));
			
			//限额调整
			super.inputLimtAmountAction(tbl_riskCoverage,riskMap);
			//险种免赔信息
			super.inputDeductionAction(tbl_riskCoverage,riskMap);
	}
		
	}
	
	/**
	 *<p>saveInsredObjectPage</p>
	 *<p>保存标的物页面</p>
	 */
	public void saveInsredObjectPage(Map<String, String> map){
		this.jsClickButton(btn_savePage);
		pause(WAIT_LONGGEST);
	}
	
}
