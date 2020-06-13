package com.sinosoft.test.fccp.tbcl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sinosoft.test.base.TestBase;

public class BasicInfoPage extends TestBase{
	/************************************************
	 * 销售信息
	 ************************************************/		
	/**
	 * @Fields slc_FBBS : 分保标识
	 */
	@FindBy(how = How.NAME,using = "GuMainBusinessType")
	WebElement slc_FBBS;

	/**
	 * @Fields edt_GDBS : 股东标识
	 */
	@FindBy(how = How.NAME,using = "GuMainShareHolderFlag")
	WebElement edt_GDBS;

	/**
	 * @Fields edt_YWGS :  业务归属
	 */
	@FindBy(how = How.NAME,using = "GuMainCompanyCode")
	WebElement edt_YWGS;
	

	/**
	 * @Fields edt_QDLX : 渠道类型
	 */
	@FindBy(how = How.NAME,using = "GuMainChannelDetailCode")
	WebElement edt_QDLX;	
	
	/**
	 * @Fields edt_XSTD : 销售团队
	 */
	@FindBy(how = How.NAME,using = "GuMainSalesTeamCode")
	WebElement edt_XSTD;	
	
	
	/**
	 * @Fields edt_YWY : 业务员
	 */
	@FindBy(how = How.NAME,using = "GuMainSalesmanCode")
	WebElement edt_YWY;	
	

	/**
	 * @Fields edt_YWLY : 业务来源
	 */
	@FindBy(how = How.NAME,using = "GuMainBusinessSource")
	WebElement edt_YWLY;	
	
	/**
	 * @Fields slc_CXYWBS : 创新业务标识
	 */
	@FindBy(how = How.NAME,using = "GuMainSurveyInd")
	WebElement slc_CXYWBS;	
	
	/************************************************
	 * 保单信息
	 ************************************************/	
	
	//保单信息
	@FindBy(how = How.NAME,using = "XXXXXXXXX")
	WebElement edt_riskCode;
	
	@FindBy(how = How.NAME,using = "XXXXXXXXX")
	@CacheLookup
	WebElement btn_nextStep;
	// 01**
	@FindBy(how = How.NAME, using  ="XXXXXXXXX")
	List<WebElement> rdo_renewal;
	
	/************************************************
	 * 投保人信息
	 ************************************************/		

	@FindBy(how = How.NAME, using  ="XXXXXXXXX")
	WebElement rdo_prePayFee;
	//0601
	@FindBy(how = How.NAME, using  ="XXXXXXXXX")
	WebElement rdo_carrayOver;
	
	/************************************************
	 * 联系人信息
	 ************************************************/	
	
	@FindBy(how = How.NAME, using  ="XXXXXXXXX")
	WebElement rdo_related;
	
	@FindBy(how = How.NAME, using  ="XXXXXXXXX")
	WebElement ed_relatedPolicy;
	
	//Initializing the Page Objects:
	public BasicInfoPage(){
		PageFactory.initElements(driver, this);
//		btn_nextStep = super.waitAndGetElement(By.name("buttonNextStep"), 2);
//		if (btn_nextStep == null){
//		    throw new IllegalStateException("The Page is not loaded correctly: "+ driver.getCurrentUrl());
//		}
//		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10) ,this);
	}
	//Actions:

	public void inputSalesInfoAction(String fbbs, String ywgs,String qdlx,String xstd,String ywy,String ywly,String cxywbs){
		slc_FBBS = this.waitAndGetElement(By.name("GuMainBusinessType"), 20);
		this.setSelectText(slc_FBBS, fbbs);
		this.setEditboxTValue(edt_YWGS, ywgs);
		this.setEditboxTValue(edt_QDLX, qdlx);
		this.setEditboxTValue(edt_XSTD, xstd);
		
//		this.edt_YWGS.sendKeys(ywgs,Keys.TAB);
//		this.edt_QDLX.sendKeys(qdlx,Keys.TAB);
//		this.edt_XSTD.sendKeys(xstd,Keys.TAB);

		
		//runJS("arguments[0].dblclick();", edt_XSTD);
//		this.edt_YWY.sendKeys(ywy,Keys.TAB);
//		this.edt_YWLY.sendKeys(ywly,Keys.TAB);
//		this.setSelectText(slc_CXYWBS, cxywbs);
	}
}
