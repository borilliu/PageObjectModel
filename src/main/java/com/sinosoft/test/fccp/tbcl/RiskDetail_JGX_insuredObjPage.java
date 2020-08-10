package com.sinosoft.test.fccp.tbcl;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.util.TestUtil;

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
		PageFactory.initElements(driver(), this);
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
		logger.info("开始录入物质损失险信息！");
		this.inputRiskCovr_WS(map);
		if(!"0710".equalsIgnoreCase(map.get("riskCode"))) {
			logger.info("开始录入三者险信息！");
			this.inputRiskCovr_SZ(map);
		}
		logger.info("开始录入附加险信息！");
		inputRidersAction(map);
		inputRidersAction(map);
		logger.info("开始录入特别约定信息！");
		inputSpecialClauseAction(map);
		takeSnapShot(getTestCaseId(map)+"_标的投保详细信息");
	}
	/**
	 *<p>saveInsredObjectPage</p>
	 *<p>保存标的物页面</p>
	 */
	public void saveInsredObjectPage(){
		this.clickButton(btn_savePage);
		pause(WAIT_SECOND);
	}
	/**
	 *<p>inputRiskCovr_WZSS</p>
	 *<p>录入为物质损失险的信息</p>
	 * @param map
	 */
	private void inputRiskCovr_WS(Map<String, String> map) {
		scrollToElement(tbl_PropertyLoss);
		
		WebElement btn_addLoss = tbl_PropertyLoss.findElement(By.name("button_ItemKind_Insert"));
		List<Map<String,Object>> riskList= getRiskMapList(map,"jgx_ws_");
		 for(int i=0;i<riskList.size();i++) {
			 if(i>0) {
				 this.jsClickButton(btn_addLoss);
			 }
			 Map<String,Object> riskMap=riskList.get(i);
			WebElement edt_XBDM = tbl_PropertyLoss.findElement(By.xpath("(//input[@name='GuItemKindItemDetailCode'])[last()]"));
			WebElement edt_JRBE = tbl_PropertyLoss.findElement(By.xpath("(//input[@name='GuItemKindCalculateInd'])[last()]"));
			WebElement edt_BXJE = tbl_PropertyLoss.findElement(By.xpath("(//input[@name='GuItemKindSumInsured'])[last()]"));
			WebElement edt_BFFL = tbl_PropertyLoss.findElement(By.xpath("(//input[@name='GuItemKindRate'])[last()]"));
			WebElement edt_DQFLBZ = tbl_PropertyLoss.findElement(By.xpath("(//input[@name='GuItemKindShortRateFlag'])[last()]"));
			WebElement edt_YSBF = tbl_PropertyLoss.findElement(By.xpath("(//input[@name='GuItemKindGrossPremium'])[last()]"));
			this.CodeSelect(edt_XBDM, (String)riskMap.get("xbdm"));
			this.CodeSelect(edt_JRBE,(String)riskMap.get("jrbe"));
			this.setNumberEditBoxValue(edt_BXJE, (String)riskMap.get("bxje"));
			this.setNumberEditBoxValue(edt_BFFL, (String)riskMap.get("bffl"));
			this.CodeSelect(edt_DQFLBZ, (String)riskMap.get("dqflbz"));
			this.setNumberEditBoxValue(edt_YSBF, (String)riskMap.get("ysbf"));
		 }	
	}
	/**
	 *<p>inputRiskCovr_SZ</p>
	 *<p>录入第三者责任险的投保信息</p>
	 * @param map
	 */
	private void inputRiskCovr_SZ(Map<String, String> map) {
		scrollToElement(tbl_ThirdParty);
		WebElement btn_addThird = tbl_ThirdParty.findElement(By.name("button_ItemKindThird_Insert"));
		List<Map<String,Object>> riskList= getRiskMapList(map,"jgx_sz_");
		 for(int i=0;i<riskList.size();i++) {
			 if(i>0) {
				 this.jsClickButton(btn_addThird);
			 }
			Map<String,Object> riskMap=riskList.get(i);
			System.out.println(TestUtil.getMapObjString(riskMap));
			WebElement edt_XBDM = tbl_ThirdParty.findElement(By.xpath("(//input[@name='ThirdGuItemKindKindCode'])[last()]"));
			this.CodeSelect(edt_XBDM, (String)riskMap.get("xbdm"));
			WebElement edt_JRBE = tbl_ThirdParty.findElement(By.xpath("(//input[@name='ThirdGuItemKindCalculateInd'])[last()]"));
			this.CodeSelect(edt_JRBE,(String)riskMap.get("jrbe"));
			WebElement edt_BXJE = tbl_ThirdParty.findElement(By.xpath("(//input[@name='ThirdGuItemKindSumInsured'])[last()]"));
			this.setNumberEditBoxValue(edt_BXJE, (String)riskMap.get("bxje"));
			WebElement edt_BFFL = tbl_ThirdParty.findElement(By.xpath("(//input[@name='ThirdGuItemKindRate'])[last()]"));
			this.setNumberEditBoxValue(edt_BFFL, (String)riskMap.get("bffl"));
			WebElement edt_DQFLBZ = tbl_ThirdParty.findElement(By.xpath("(//input[@name='ThirdGuItemKindShortRateFlag'])[last()]"));
			this.CodeSelect(edt_DQFLBZ, (String)riskMap.get("dqflbz"));
			WebElement edt_YSBF = tbl_ThirdParty.findElement(By.xpath("(//input[@name='ThirdGuItemKindGrossPremium'])[last()]"));
			this.setNumberEditBoxValue(edt_YSBF, (String)riskMap.get("ysbf"));
	
			
			
			//处理限额信息
			WebElement btn_EditLmt = tbl_ThirdParty.findElement(By.xpath("(//input[@name='button_ThirdKindLimitKind_Edit'])[last()]"));  //限额编辑窗口
			this.jsClickButton(btn_EditLmt);
			pause(WAIT_SHORTEST);
			WebElement spn_limitDtl = tbl_ThirdParty.findElement(By.xpath("(//span[@id='span_ThirdKindLimitKind_SubPage'])[last()]"));
			List<WebElement> btn_delList = spn_limitDtl.findElements(By.name("button_ThridKindLimit_Delete")); //限额编辑-删除限额项目
			logger.debug("限额个数："+btn_delList.size());
			//删除原有限额
			for(int j=0;j<btn_delList.size();j++) {
				this.jsClickButton(btn_delList.get(j));
			}
			//重新设置新的限额
			List<Map<String, String>> lmtList = (List<Map<String, String>>)riskMap.get("xeList");
			System.out.println("限额数量："+lmtList.size());
			for (Map<String,String> xeMap:lmtList) {
				System.out.println(TestUtil.getMapString(xeMap));
				pause(this.WAIT_SHORTEST);
				WebElement btn_addItem = spn_limitDtl.findElement(By.name("buttonThirdKindLimitInsert"));
				this.jsClickButton(btn_addItem);
				WebElement edt_lmtCode = spn_limitDtl.findElement(By.xpath("(//input[@name='thirdKindGuKindLimitLimitCode'])[last()]"));
				this.CodeSelect(edt_lmtCode, xeMap.get("xedm"));
				WebElement edt_lmtType = spn_limitDtl.findElement(By.xpath("(//input[@name='thirdKindGuKindLimitLimitType'])[last()]"));
				this.CodeSelect(edt_lmtType, xeMap.get("xelx"));
				WebElement edt_lmtCur = spn_limitDtl.findElement(By.xpath("(//input[@name='thirdKindGuKindLimitCurrency'])[last()]"));
				this.CodeSelect(edt_lmtCur, xeMap.get("xebz"));
				WebElement edt_lmtAmt = spn_limitDtl.findElement(By.xpath("(//input[@name='thirdKindGuKindLimitLimit'])[last()]"));
				this.setNumberEditBoxValue(edt_lmtAmt, xeMap.get("xexe"));               
				WebElement edt_lmtRmk = spn_limitDtl.findElement(By.xpath("(//textarea[@name='thirdKindGuKindLimitRemark'])[last()]"));
				this.setNumberEditBoxValue(edt_lmtRmk, xeMap.get("xermk"));
			}
			WebElement btn_closeLimit = spn_limitDtl.findElement(By.name("button_ThirdKindLimit_Close")); //限额编辑确定按钮
			this.clickButton(btn_closeLimit);
		 }
	}
	
}
