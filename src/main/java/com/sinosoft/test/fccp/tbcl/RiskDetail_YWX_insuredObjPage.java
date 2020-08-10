package com.sinosoft.test.fccp.tbcl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.util.TestUtil;

public class RiskDetail_YWX_insuredObjPage extends RiskDetail_AbstractInsuredObjPage {
	/**
	 * @Fields tbl_AcciKind : 保障详情
	 */
	@FindBy(how = How.ID,using = "ItemAcciKind")
	WebElement tbl_AcciKind;

	/**
	 * @Fields btn_savePage : 保存标的信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	
	public RiskDetail_YWX_insuredObjPage() {
		goToWorkArea();
		PageFactory.initElements(driver(), this);
		logger.debug("进入意外险-保险标的信息页面对象！");
	}

	/**
	 *<p>InputInsuredObjectAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始意外险基础信息！");
		//System.out.println(driver().getPageSource());
		AbstractInsuredObjectInfoPage_11.getInstance( map.get("riskCode")).inputInsuredObjectAction(map);
		super.takeSnapShot(super.getTestCaseId(map)+"_标的基础信息");
	}
	/**
	 *<p>inputRiskCodeAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public void inputRiskCoverageAction(Map<String, String> map) {
		logger.debug("开始录入保障明细信息");
		this.inputRiskCovr(map);
		logger.debug("开始录入特殊条款信息");
		super.inputSpecialClauseAction(map);
		super.takeSnapShot(super.getTestCaseId(map)+"_标的投保详细信息");
	}
	/**
	 *<p>saveInsredObjectPage</p>
	 *<p>保存标的物页面</p>
	 */
	public void saveInsredObjectPage(){
		this.clickButton(btn_savePage);
		pause(1000);
	}

	/**
	 *<p>inputRiskCovr</p>
	 *<p>录入主险信息</p>
	 * @param map
	 */
	private void inputRiskCovr(Map<String, String> map) {
		this.scrollToElement(tbl_AcciKind);	
		List<Map<String,Object>> riskList= getRiskMapList(map,"ywx_");
		 for (Map<String,Object> riskMap:riskList) {
		    	pause(WAIT_SHORTEST);
		    	System.out.println(TestUtil.getMapObjString(riskMap));
				WebElement btn_addItem = tbl_AcciKind.findElement(By.name("button_ItemKind_Insert"));
				this.jsClickButton(btn_addItem);
				WebElement edt_XBDM = tbl_AcciKind.findElement(By.xpath("(//input[@name='GuItemKindKindName'])[last()]"));
				WebElement edt_JRBE = tbl_AcciKind.findElement(By.xpath("(//input[@name='GuItemKindCalculateInd'])[last()]"));
				WebElement edt_BXJE = tbl_AcciKind.findElement(By.xpath("(//input[@name='GuItemKindUnitInsured'])[last()]"));
				WebElement edt_BFFL = tbl_AcciKind.findElement(By.xpath("(//input[@name='GuItemKindRate'])[last()]"));
				WebElement edt_DQFLBZ = tbl_AcciKind.findElement(By.xpath("(//input[@name='GuItemKindShortRateFlag'])[last()]"));
				WebElement edt_YSBF = tbl_AcciKind.findElement(By.xpath("(//input[@name='GuItemKindGrossPremium'])[last()]"));
				this.CodeSelect(edt_XBDM, (String)riskMap.get("xbdm"));
				this.CodeSelect(edt_JRBE,(String)riskMap.get("jrbe"));
				this.setEditboxValue(edt_BXJE, (String)riskMap.get("bxje"));
				this.setNumberEditBoxValue(edt_BFFL, (String)riskMap.get("bffl"));
				this.CodeSelect(edt_DQFLBZ,(String)riskMap.get("dqflbz"));
				this.setNumberEditBoxValue(edt_YSBF,(String)riskMap.get("ysbf"));
				//限额调整
				super.inputLimtAmountAction(tbl_AcciKind,riskMap);
				//险种免赔信息
				super.inputDeductionAction(tbl_AcciKind,riskMap);
		 }		
	}
	
}
