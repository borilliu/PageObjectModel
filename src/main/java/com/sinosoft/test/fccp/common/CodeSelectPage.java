package com.sinosoft.test.fccp.common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class CodeSelectPage extends FccbBase {

	@FindBy(how = How.NAME,using = "SelectIt")
	@CacheLookup
	WebElement btn_confirm;
	
	@FindBy(how = How.NAME,using = "codeselect")
	@CacheLookup
	WebElement slc_codeList;
	
	@FindBy(how = How.NAME,using = "fieldValue")
	@CacheLookup
	WebElement edt_findCode;
	
	@FindBy(how = How.NAME,using = "fieldNameValue")
	@CacheLookup
	WebElement edt_findName;
	
	@FindBy(how = How.XPATH,using = "//input[@value='查询(Q)']")
	@CacheLookup
	WebElement btn_query;
	
	// Initializing the Page Objects:
	static String pageTitle = "Code Select";
	
	
	public CodeSelectPage() {
		//PageFactory.initElements(driver(), this);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver(), 10) ,this);
		logger.debug("基础码表选择！");
	}
	
	
	//Actions
	public void selectByCodes(String code) {
		this.setEditboxValue(edt_findCode, code);
		this.clickButton(btn_query);
		//this.setSelectWithStartText(slc_codeList, code);
		setFuzzySelect(slc_codeList, code);
		this.jsClickButton(btn_confirm);
	}
	
}
