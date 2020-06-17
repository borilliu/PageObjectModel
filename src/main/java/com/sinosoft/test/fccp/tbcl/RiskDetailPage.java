package com.sinosoft.test.fccp.tbcl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.fccp.common.FccbBase;

/**
 *com.sinosoft.test.fccp.tbcl.RiskDetailPage.java
 *<p>description</p>
 * @author liubenchao@sinsoft.com.cn
 */
public class RiskDetailPage extends FccbBase {

	/**
	 * @Fields tbl_RiskItems : 险种信息表 RiskItem
	 */
	@FindBy(how = How.ID, using  ="RiskItem")
	WebElement tbl_RiskItems;
	
	/*****************************************
	 * Tab 标签元素
	 *****************************************/
	/**
	 * @Fields tab_XZXX : 险种信息
	 */
	@FindBy(how = How.XPATH, using  ="//td[text()='险种信息']")
	WebElement tab_XZXX;
	/**
	 * @Fields tab_BDXX : 标的信息
	 */
	@FindBy(how = How.XPATH, using  ="//td[text()='标的信息']")
	WebElement tab_BDXX;
	/**
	 * @Fields tab_TKXX : 条款信息
	 */
	@FindBy(how = How.XPATH, using  ="//td[text()='条款信息']")
	WebElement tab_TKXX;
	/**
	 * @Fields tab_LGBXX : 联共保信息
	 */
	@FindBy(how = How.XPATH, using  ="//td[text()='联共保信息']")
	WebElement tab_LGBXX;
	
	/*****************************************
	 * 险种信息
	 *****************************************/
	/**
	 * @Fields btn_DRTBRXX : 带入投保人信息
	 */
	@FindBy(how = How.ID, using  ="buttonRelatedRisk")
	WebElement btn_DRTBRXX;
	
	/**
	 * @Fields edt_XZSYFW : 险种适用范围
	 */
	@FindBy(how = How.NAME,using = "GuRiskRiskApplyType")
	WebElement edt_XZSYFW;
	
	/**
	 * @Fields edt_QBRQ : 起保日期
	 */
	@FindBy(how = How.NAME,using = "GuRiskStartDate")
	WebElement edt_QBRQ;
	
	/**
	 * @Fields edt_ZBRQ : 终保日期
	 */
	@FindBy(how = How.NAME,using = "GuRiskEndDate")
	WebElement edt_ZBRQ;
	
	/**
	 * @Fields edt_LGBBZ : 联共保标志
	 */
	@FindBy(how = How.NAME,using = "GuRiskCoinsInd")
	WebElement edt_LGBBZ;
	
	/**
	 * @Fields edt_YYZDBZ : 营业中断险标志
	 */
	@FindBy(how = How.NAME,using = "GuRiskBusinessFlag")
	WebElement edt_YYZDBZ;
	
	/**
	 * @Fields edt_SFGXDM : 司法管辖代码
	 */
	@FindBy(how = How.NAME,using = "GuRiskJudicalCode")
	WebElement edt_SFGXDM;
	
	/**
	 * @Fields edt_CBDQ : 承保地区
	 */
	@FindBy(how = How.NAME,using = "GuRiskGeographicalArea")
	WebElement edt_CBDQ;
	public RiskDetailPage(){
		super();
		goToWorkArea();
	}
	
	public void goToWorkArea() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("myFrame");
		driver.switchTo().frame("RiskFrame");
		driver.switchTo().frame("myFrame");
	}
}
