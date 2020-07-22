package com.sinosoft.test.fccp.tbcl;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RiskDetail_JGX_insuredObjPage extends RiskDetail_AbstractInsuredObjPage {


	/*********************************************************
	 **********                险别信息                               *************
	 *********************************************************
	 */
	
	/**
	 * @Fields tbl_PropertyLoss : 物质损失险
	 */
	@FindBy(how = How.ID,using = "ItemKind")
	WebElement tbl_PropertyLoss;
	
	/**
	 * @Fields tbl_PropertyLoss : 物质损失险
	 */
	@FindBy(how = How.ID,using = "ItemKindThird")
	WebElement tbl_ThirdParty;
	/**
	 * @Fields btn_savePage : 保存标的信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	
	public RiskDetail_JGX_insuredObjPage() {
		goToWorkArea();
		PageFactory.initElements(driver, this);
		logger.debug("进入建工险-保险标的信息页面对象！");
	}

	/**
	 *<p>InputInsuredObjectAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		AbstractInsuredObjectInfoPage_07.getInstance( map.get("riskCode")).inputInsuredObjectAction(map);
		super.takeSnapShot(super.getTestCaseId(map)+"_标的基础信息");
		
	}
	/**
	 *<p>inputRiskCodeAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public void inputRiskCoverageAction(Map<String, String> map) {
		this.inputRiskCovr_WS(map);
		if(!"0710".equalsIgnoreCase(map.get("riskCode"))) {
			this.inputRiskCovr_SZ(map);
		}	
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
	private void inputRiskCovr_WS(Map<String, String> map) {
		this.clickElement(tbl_PropertyLoss);
		WebElement edt_XBDM = tbl_PropertyLoss.findElement(By.name("GuItemKindItemDetailCode"));
		WebElement edt_JRBE = tbl_PropertyLoss.findElement(By.name("GuItemKindCalculateInd"));
		WebElement edt_BXJE = tbl_PropertyLoss.findElement(By.name("GuItemKindSumInsured"));
		WebElement edt_BFFL = tbl_PropertyLoss.findElement(By.name("GuItemKindRate"));
		WebElement edt_DQFLBZ = tbl_PropertyLoss.findElement(By.name("GuItemKindShortRateFlag"));
		WebElement edt_YSBF = tbl_PropertyLoss.findElement(By.name("GuItemKindGrossPremium"));
		this.CodeSelect(edt_XBDM, map.get("jgx_ws_xmlbdm"));
		this.CodeSelect(edt_JRBE,map.get("jgx_ws_jrbe"));
		this.setNumberEditBoxValue(edt_BXJE, map.get("jgx_ws_bxje"));
		this.setNumberEditBoxValue(edt_BFFL, map.get("jgx_ws_fl"));
		this.CodeSelect(edt_DQFLBZ, map.get("jgx_ws_dqflbz"));
		this.setNumberEditBoxValue(edt_YSBF, map.get("jgx_ws_ysbf"));
	}
	/**
	 *<p>inputRiskCovr_SZ</p>
	 *<p>录入第三者责任险的投保信息</p>
	 * @param map
	 */
	private void inputRiskCovr_SZ(Map<String, String> map) {
		this.clickElement(tbl_ThirdParty);
		WebElement edt_XBDM = tbl_ThirdParty.findElement(By.name("ThirdGuItemKindKindCode"));
		WebElement edt_JRBE = tbl_ThirdParty.findElement(By.name("ThirdGuItemKindCalculateInd"));
		WebElement edt_BXJE = tbl_ThirdParty.findElement(By.name("ThirdGuItemKindSumInsured"));
		WebElement edt_BFFL = tbl_ThirdParty.findElement(By.name("ThirdGuItemKindRate"));
		WebElement edt_DQFLBZ = tbl_ThirdParty.findElement(By.name("ThirdGuItemKindShortRateFlag"));
		WebElement edt_YSBF = tbl_ThirdParty.findElement(By.name("ThirdGuItemKindGrossPremium"));
		this.CodeSelect(edt_XBDM, map.get("jgx_sz_xbdm"));
		this.CodeSelect(edt_JRBE,map.get("jgx_sz_jrbe"));
		this.setNumberEditBoxValue(edt_BXJE, map.get("jgx_sz_ljpcxe"));
		this.setNumberEditBoxValue(edt_BFFL, map.get("jgx_sz_fl"));
		this.CodeSelect(edt_DQFLBZ, map.get("jgx_sz_dqflbz"));
		this.setNumberEditBoxValue(edt_YSBF, map.get("jgx_sz_ysbf"));

		WebElement btn_Edit = tbl_ThirdParty.findElement(By.name("button_ThirdKindLimitKind_Edit"));  //限额编辑窗口
		this.jsClickButton(btn_Edit);
		pause(3000);
		List<WebElement> btn_delList = tbl_ThirdParty.findElements(By.name("button_ThridKindLimit_Delete")); //限额编辑-删除限额项目
		logger.debug("限额个数："+btn_delList.size());
		for(int i=0;i<btn_delList.size();i++) {
			this.jsClickButton(btn_delList.get(i));
		}
		WebElement btn_ok = tbl_ThirdParty.findElement(By.name("button_ThirdKindLimit_Close")); //限额编辑确定按钮
		this.clickButton(btn_ok);
		
	}
	
}
