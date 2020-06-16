package com.sinosoft.test.fccp.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.sinosoft.test.base.TestBase;

public class CodeSelectPage extends TestBase {

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
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	/**
	 * 进入菜单 - 投保处理
	 */
	public void testWidgets(){
		super.highlight(btn_confirm);
		super.pause(2000);
		super.highlight(slc_codeList);
		super.pause(2000);
		super.highlight(edt_findCode);
		super.pause(2000);
		super.highlight(edt_findName);
		super.pause(2000);
		super.highlight(btn_query);
		super.pause(2000);
	}
	public void selectByCodes(String code) {
		this.setEditboxValue(edt_findCode, code);
		this.clickButton(btn_query);
		this.setSelectWithStartText(slc_codeList, code);
		this.jsClickButton(btn_confirm);
	}
	
}
