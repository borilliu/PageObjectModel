package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.util.TestUtil;

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
	 * @Fields edt_TIS : TIS(不含增值税)
	 */
	@FindBy(how = How.NAME, using  ="GuMainTIS")
	WebElement edt_TIS;
	
	
	
	/**
	 * @Fields tbl_XSFY : 销售费用
	 */
	@FindBy(how = How.ID, using  ="SalesFee")
	WebElement tbl_XSFY;
	/**
	 * @Fields btn_saveFeePage : 保存保单费用信息
	 */
	@FindBy(how = How.ID,using = "saveButton")  
	WebElement btn_saveFeePage;
	
	public PolicyFeePage() {
		logger.debug("初始化PolicyFeePage：");
		driver().switchTo().defaultContent();
		driver().switchTo().frame("mainFrame");
		driver().switchTo().frame("myFrame");
		PageFactory.initElements(driver(), this);
	}
	
	/**
	 *<p>inputPolicyFeeAction</p>
	 *<p>录入保单费用信息</p>
	 */
	public void inputPolicyFeeAction(Map<String, String> map) {
		edt_XSFDJ = super.waitAndGetElement(By.name("GuMainXsfInd"), 10);
		//this.CodeSelect(edt_XSFDJ, map.get("xsfdj"));
		this.setEditboxValue(edt_FSH, map.get("fsh"));
		this.setEditboxValue(edt_XSFXS, map.get("xsfxs"));
		this.setEditboxValue(edt_TIS, map.get("tis"));
		this.CodeSelect(edt_XSFDJ, map.get("xsfdj"));
		if(!"".equals(map.get("xsfy_bl"))) {
			WebElement edt_fybl = tbl_XSFY.findElement(By.name("GuSalesFeeFeePercent"));
			this.setNumberEditBoxValue(edt_fybl, map.get("xsfy_bl"));
		}	
	
	}
	/**
	 *<p>savePolicyFee</p>
	 *<p>保存保单费用信息</p>
	 */
	public void savePolicyFee() {
		this.jsClickButton(btn_saveFeePage);
		pause(WAIT_SECOND);
	}
	public void processPolicyFeeAction(Map<String, String> map) {
		this.inputPolicyFeeAction(map);
		TestUtil.takeScreenshot(getTestCaseId(map)+"保单费用信息页面");
		this.savePolicyFee();
	}
}
