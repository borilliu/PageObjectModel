package com.sinosoft.test.fccp.tbcl;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.util.TestUtil;

/**
 *com.sinosoft.test.fccp.tbcl.RiskDetail_UnionPage.java
 *<p>联共保信息页面</p>
 * @author liubenchao@sinsoft.com.cn
 */
public class RiskDetail_CoInsuredPage extends RiskDetailPage {
	
	
	@FindBy(how = How.ID,using ="Coinsurance" )
	WebElement tbl_coInsured;
	
	@FindBy(how = How.XPATH,using = "//table[@id='Coinsurance']/tbody/tr[last()]/td/span[@id='span_ConinsuranceDetailInfo_SubPage']")
	WebElement spn_lastSpan; 
	/**
	 * @Fields btn_CoDetail : 按钮-联共保详情
	 */
	@FindBy(how = How.XPATH,using = "//table[@id='Coinsurance']/tbody/tr[last()]/td/p/input[@name='buttonCoinsuranceDetailInfo']")
	WebElement btn_CoDetail; 
	
	/**
	 * @Fields btn_Add : 按钮-增加联共保
	 */
	@FindBy(how = How.NAME,using = "buttonProductCoinsuranceAdd")
	WebElement btn_Add; 
	
	
	/**
	 * @Fields btn_saveCoInsurance : 保存共保信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_saveCoInsurance; 
	
	public RiskDetail_CoInsuredPage() {
		goToWorkArea();
		PageFactory.initElements(driver, this);
	}
	
	public void inputCoInsuranceInfoAction(Map<String, String> map) {
		this.jsClickButton(btn_CoDetail);
		WebElement edt_mainPrct= spn_lastSpan.findElement(By.name("GuCoinsuranceCoinsRate"));
		WebElement edt_mainPrmm= spn_lastSpan.findElement(By.name("GuCoinsuranceCoinsPremium"));
		this.setEditboxValue(edt_mainPrct, map.get("lgb_main_pcrt"));
		this.clickElement(edt_mainPrmm);
		WebElement btn_confirm =spn_lastSpan.findElement(By.name("button_CoinsuranceDetailInfo_Close"));
		this.clickButton(btn_confirm);
		logger.debug("处理完主保方信息");
		//处理共保的信息,增加共保方信息
		this.clickButton(btn_Add);
		logger.debug("开始处理共保方信息");
		//处理共保方详细信息
		this.clickButton(btn_CoDetail);
		logger.debug("打开了共保方的页面");
		WebElement edt_codeL1=spn_lastSpan.findElement(By.name("GuCoinsuranceCoinsCode"));
		this.SetCodeEditBox(edt_codeL1, map.get("lgb_co_level1"));
		WebElement edt_codeL2=spn_lastSpan.findElement(By.name("GuCoinsuranceCoinsCodeTwo"));
		this.SetCodeEditBox(edt_codeL2, map.get("lgb_co_level2"));
		WebElement edt_codeL3=spn_lastSpan.findElement(By.name("GuCoinsuranceCoinsCodeThree"));
		this.setEditboxValue(edt_codeL3,map.get("lgb_co_level3"));
		WebElement edt_sharePct=spn_lastSpan.findElement(By.name("GuCoinsuranceCoinsRate"));
		this.setEditboxValue(edt_sharePct,map.get("lgb_co_prct"));
		List <WebElement> rdo_prmSourceInd=spn_lastSpan.findElements(By.name("CoinsPremiumAcceptInd02"));
		this.SetRadioValue(rdo_prmSourceInd,map.get("lgb_co_gbbfsqxs"));
		WebElement btn_confirm2 =spn_lastSpan.findElement(By.name("button_CoinsuranceDetailInfo_Close"));
		this.jsClickButton(btn_confirm2);
	}
	public void processCoInsured(Map<String, String> map) {
		if(!"0".equals(map.get("lgbbz"))) { //联共保标志
			inputCoInsuranceInfoAction(map);
			saveCoInsuredPage();
		}
		TestUtil.takeScreenshot(getTestCaseId(map)+"联共保信息页面");
	}
	/**
	 *<p>saveCoInsuredPage</p>
	 *<p>保存共保信息</p>
	 */
	public void saveCoInsuredPage() {
		this.jsClickButton(btn_saveCoInsurance);
	}

}
