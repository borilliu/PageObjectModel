package com.sinosoft.test.fccp.tbcl;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
		System.out.println(driver().getPageSource());
		AbstractInsuredObjectInfoPage_11.getInstance( map.get("riskCode")).inputInsuredObjectAction(map);
		super.takeSnapShot(super.getTestCaseId(map)+"_标的基础信息");
	}
	/**
	 *<p>inputRiskCodeAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public void inputRiskCoverageAction(Map<String, String> map) {
		this.inputRiskCovr(map);
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
	 *<p>inputRiskCovr_WZSS</p>
	 *<p>录入为物质损失险的信息</p>
	 * @param map
	 */
	private void inputRiskCovr(Map<String, String> map) {
		this.clickElement(tbl_AcciKind);	
		WebElement btn_addItem = tbl_AcciKind.findElement(By.name("button_ItemKind_Insert"));
		this.jsClickButton(btn_addItem);
		WebElement edt_XBDM = tbl_AcciKind.findElement(By.name("GuItemKindKindName"));
		WebElement edt_JRBE = tbl_AcciKind.findElement(By.name("GuItemKindCalculateInd"));
		WebElement edt_BXJE = tbl_AcciKind.findElement(By.name("GuItemKindUnitInsured"));
		WebElement edt_BFFL = tbl_AcciKind.findElement(By.name("GuItemKindRate"));
		WebElement edt_DQFLBZ = tbl_AcciKind.findElement(By.name("GuItemKindShortRateFlag"));
		WebElement edt_YSBF = tbl_AcciKind.findElement(By.name("GuItemKindGrossPremium"));
		this.CodeSelect(edt_XBDM, map.get("ywx_xbdm"));
		this.CodeSelect(edt_JRBE,map.get("ywx_jrbe"));
		this.setEditboxValue(edt_BXJE, map.get("ywx_bxje"));
		this.setNumberEditBoxValue(edt_BFFL, map.get("ywx_bffl"));
		this.CodeSelect(edt_DQFLBZ,map.get("ywx_dqflbz"));
		this.setNumberEditBoxValue(edt_YSBF,map.get("ywx_ysbf"));
	}
}
