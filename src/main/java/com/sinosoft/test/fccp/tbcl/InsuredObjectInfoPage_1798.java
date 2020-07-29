package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.fccp.tbcl.common.InsuredListAdd_Page;
public class InsuredObjectInfoPage_1798 extends AbstractInsuredObjectInfoPage_17 {
	/**
	 * @Fields edt_TBRS : 投保人数 
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciQuantity")
	WebElement edt_TBRS;
	
	/**
	 * @Fields edt_JZDJ : 建筑等级
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertyConstruction")
	WebElement edt_JZDJ;

	/**
	 * @Fields edt_BXCS : 保险处所
	 */
	@FindBy(how = How.NAME,using = "GuItemPropertySituation")
	WebElement edt_BXCS;	
	
	
	/**
	 * @Fields btn_QDCX : 清单查询
	 */
	@FindBy(how = How.NAME,using = "ShowPersonListButton")
	WebElement btn_QDCX;
	
	public InsuredObjectInfoPage_1798() {
		edt_JQBM =super.waitAndGetElement(By.name("GuItemPropertyBlockCode"), 20);
		PageFactory.initElements(driver(), this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		logger.info("开始录入标的物信息！");
		super.inputInsuredObjectCommmon(map);
		this.SetCodeEditBox(edt_JZDJ, map.get("jzdj"));
		this.SetCodeEditBox(edt_TBRS, map.get("tbrs"));
		this.setEditboxValue(edt_BXCS, map.get("bxcs"));
	}
	
	public void inputInsuredDetailAction(Map<String, String> map) {
		logger.info("开始录入被保人清单信息！");
		this.jsClickButton(btn_QDCX);
		navigateToWindowByUrl("processAcciList.do", 5);
		InsuredListAdd_Page insuredAdd= new InsuredListAdd_Page();
		insuredAdd.AddInsuredAction(map);
		navigateToWindowByTitle(WINDOW_MAIN_TITLE, 5);
	}

}
