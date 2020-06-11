package com.sinosoft.test.fccp.tbcl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.crm.qa.base.TestBase;

public class RiskSelectPage extends TestBase{
	
	//common widgets
	@FindBy(how = How.NAME,using = "planrisk")
	WebElement rdo_planrisk;
	
	@FindBy(how = How.NAME,using = "riskClassTemp")
	WebElement edt_riskClass;
	
	@FindBy(how = How.NAME,using = "riskCode")
	WebElement edt_riskCode;
	
	@FindBy(how = How.NAME,using = "buttonNextStep")
	@CacheLookup
	WebElement btn_nextStep;
	// 01**
	@FindBy(how = How.NAME, using  ="renewInd")
	List<WebElement> rdo_renewal;
	
	//0601
	@FindBy(how = How.NAME, using  ="prePayFeeFlag")
	WebElement rdo_prePayFee;
	//0601
	@FindBy(how = How.NAME, using  ="carryOverInd")
	WebElement rdo_carrayOver;
	
	//0613/0636
	@FindBy(how = How.NAME, using  ="relatedInd")
	WebElement rdo_related;
	
	@FindBy(how = How.NAME, using  ="relatePolicyN")
	WebElement ed_relatedPolicy;
	
	//Initializing the Page Objects:
	public RiskSelectPage(){
		PageFactory.initElements(driver, this);
//		btn_nextStep = super.waitAndGetElement(By.name("buttonNextStep"), 2);
//		if (btn_nextStep == null){
//		    throw new IllegalStateException("The Page is not loaded correctly: "+ driver.getCurrentUrl());
//		}
//		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 1) ,this);
	}
	//Actions:

	public void doSelectAction(String riskClass, String riskCode,String renewalInd){
		edt_riskClass.sendKeys(riskClass + Keys.TAB);
		edt_riskCode.sendKeys(riskCode + Keys.TAB);
		SetRadioValue(rdo_renewal,renewalInd);
		runJS("arguments[0].click();", btn_nextStep);
	}
	
	private void SetRadioValue(List<WebElement> radioList,String value) {
		 for(WebElement radio:radioList) {
			 	String tmpVal = radio.getAttribute("value");
			 	if(value.equals(tmpVal)){
			 		if(!radio.isSelected()) {
			 			//radio.click();
			 			runJS("arguments[0].click();", radio);
			 		}
			 		break;
			 	}
	        }
		
	}
	
}
