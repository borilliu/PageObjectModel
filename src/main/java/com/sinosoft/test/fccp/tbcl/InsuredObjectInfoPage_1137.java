package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 *InsuredObjectInfoPage_none.java
 *<p>处理标的信息页面</p>
 * @author liubenchao@sinsoft.com.cn
 */
public class InsuredObjectInfoPage_1137 extends AbstractInsuredObjectInfoPage_11 {
	/**
	 * @Fields edt_BZ : 币种
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciCurrency")
	WebElement edt_BZ;
	
	/**
	 * @Fields edt_MRTBFS : 每人投保份数
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciUwCount")
	WebElement edt_MRTBFS;
	
	
	/**
	 * @Fields edt_TBZRS : 投保总人数
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciQuantity")
	WebElement edt_TBZRS;
	
	
	
	/**
	 * @Fields btn_RYLB : 人员列表
	 */
	@FindBy(how = How.NAME,using = "buttonSummaryAcciListInfo")
	WebElement btn_RYLB;
	
	public InsuredObjectInfoPage_1137() {
		edt_BZ =super.waitAndGetElement(By.xpath("//input[@name='GuItemAcciCurrency']"), 30);
		PageFactory.initElements(driver(), this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		this.SetCodeEditBox(edt_BZ, map.get("ywx_bz"));
		this.setNumberEditBoxValue(edt_MRTBFS, map.get("ywx_mrtbfs"));
		this.setNumberEditBoxValue(edt_TBZRS, map.get("ywx_tbzrs"));
		if(!"".equals(map.get("bbr_mc")) && !"null".equals(map.get("bbr_mc"))) {
			this.jsClickButton(btn_RYLB);
			WebElement tbl_acciList = waitAndGetElement(By.id("summaryAcciList"), 5);
			WebElement btn_addItem = tbl_acciList.findElement(By.name("buttonAcciListAdd"));
			this.jsClickButton(btn_addItem);
			
			//被保人名称
			WebElement edt_bbrmc = tbl_acciList.findElement(By.name("GuItemAcciListClientCName"));
			this.setEditboxValue(edt_bbrmc, map.get("bbr_mc"));
			//被保人性别
			WebElement edt_bbrxb = tbl_acciList.findElement(By.name("GuItemAcciListSex"));
			this.setSelectWithStartText(edt_bbrxb, map.get("bbr_xb"));
			//证件类型
			WebElement edt_bbrzjlx = tbl_acciList.findElement(By.name("GuItemAcciListIdentifyTypeA"));
			this.setSelectWithStartText(edt_bbrzjlx, map.get("bbr_zjlx"));
			//证件号码
			WebElement edt_bbrzjhm = tbl_acciList.findElement(By.name("GuItemAcciListIdentifyNoA"));
			this.setEditboxValue(edt_bbrzjhm, map.get("bbr_zjhm"));
			//出生日期
			WebElement edt_bbrcsrq = tbl_acciList.findElement(By.name("GuItemAcciListBirthday"));
			this.SetDateEditBox(edt_bbrcsrq, map.get("bbr_csrq"));
			//职业，工种
			WebElement edt_bbrzrgz = tbl_acciList.findElement(By.name("GuItemAcciListOccupation"));
			this.setEditboxValue(edt_bbrzrgz, map.get("bbr_zygz"));
			//家庭地址
			WebElement edt_bbrjtdz = tbl_acciList.findElement(By.name("GuItemAcciListHomeAddress"));
			this.setEditboxValue(edt_bbrjtdz, map.get("bbr_jtdz"));
			
			WebElement btn_ok = tbl_acciList.findElement(By.name("closeAcciList"));
			this.jsClickButton(btn_ok);
			
		}
	}

}
