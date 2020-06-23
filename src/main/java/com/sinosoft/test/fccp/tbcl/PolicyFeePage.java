package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PolicyFeePage extends TbclMainFramePage {
	/**
	 * @Fields edt_XSFDJ : XSF等级 
	 */
	@FindBy(how = How.NAME, using  ="GuMainXsfInd") 
	WebElement edt_XSFDJ;
	/**
	 * @Fields edt_FSH : FSH(不含增值税) 
	 */
	@FindBy(how = How.NAME, using  ="GuMainFsh") 
	WebElement edt_FSH;

	/**
	 * @Fields edt_XSFXS : XSF调整系数
	 */
	@FindBy(how = How.NAME, using  ="GuMainAdjustRate")
	WebElement edt_XSFXS;
	
	/**
	 * @Fields btn_saveFeePage : 保存保单费用信息
	 */
	@FindBy(how = How.NAME,using = "saveButton")  
	WebElement btn_saveFeePage;
	
	public PolicyFeePage() {
		System.out.println("初始化PolicyFeePage：");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("myFrame");
		PageFactory.initElements(driver, this);
	}
	
	/**
	 *<p>inputPolicyFeeAction</p>
	 *<p>录入保单费用信息</p>
	 */
	public void inputPolicyFeeAction(Map<String, String> map) {
		this.CodeSelect(edt_XSFDJ, "A");
		this.setEditboxTValue(edt_FSH, "5");
		this.setEditboxTValue(edt_XSFXS, "2");
	}
	/**
	 *<p>savePolicyFee</p>
	 *<p>保存保单费用信息</p>
	 */
	public void savePolicyFee() {
		this.clickButton(btn_saveFeePage);
	}
}
