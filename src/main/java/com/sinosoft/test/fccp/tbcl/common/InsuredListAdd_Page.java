package com.sinosoft.test.fccp.tbcl.common;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sinosoft.test.fccp.common.FccbBase;

public class InsuredListAdd_Page extends FccbBase {
	
	
	/**
	 * @Fields btn_QDCX : 清单查询
	 */
	@FindBy(how = How.NAME,using = "buttonInsert")
	WebElement btn_addInsured;
	
	@FindBy(how = How.XPATH,using = "//tr[@id='saveBackTr']/td/input[@type='button']")
	WebElement btn_saveInusred;
	
	@FindBy(how = How.NAME,using = "GuItemAcciListDisplayNo")
	WebElement edt_QDXH;
	/**
	 * @Fields btn_BBRXM : 被保险人名称
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciListClientCName")
	WebElement edt_BBRMC;
	
	/**
	 * @Fields slc_ZJLX : 证件类型
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciListIdentifyTypeA")
	WebElement slc_ZJLX;
	
	/**
	 * @Fields edt_ZJHM : 证件号码
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciListIdentifyNoA")
	WebElement edt_ZJHM;
	
	/**
	 * @Fields edt_BXBDDZ : 保险标的地址
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciListItemAddress")
	WebElement edt_BXBDDZ;
	
	/**
	 * @Fields edt_LXFS : 联系方式
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciListHomeTel")
	WebElement edt_LXFS;
	
	/**
	 * @Fields edt_KHYH : 开户银行
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciListBankName")
	WebElement edt_KHYH;
	
	/**
	 * @Fields edt_YHZH : 银行账号
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciListBankAccountNo")
	WebElement edt_YHZH;
	
	/**
	 * @Fields edt_BBRQZ : 被保险人签字
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciListSignature")
	WebElement edt_BBRQZ;
	
	
	public InsuredListAdd_Page() {
		PageFactory.initElements(driver(), this);
	}
	
	/**
	 *<p>AddInsuredAction</p>
	 *<p>增加被保人</p>
	 * @param map
	 */
	public void AddInsuredAction(Map<String, String> map) {
		this.jsClickButton(btn_addInsured);
		pause(WAIT_SHORTER);
		driver().switchTo().defaultContent();
		driver().switchTo().frame("QueryResultFrame"); 
		this.setEditboxValue(edt_QDXH, map.get("qd_xh"));
		this.setEditboxValue(edt_BBRMC, map.get("qd_bbrmc"));
		this.setSelectWithStartText(slc_ZJLX, map.get("qd_zjlx"));
		this.setEditboxValue(edt_ZJHM, map.get("qd_zjhm"));
		this.setEditboxValue(edt_BXBDDZ, map.get("qd_bddz"));
		this.setEditboxValue(edt_ZJHM, map.get("qd_zjhm"));
		this.setEditboxValue(edt_BXBDDZ, map.get("qd_bddz"));
		this.setEditboxValue(edt_LXFS, map.get("qd_lxfs"));
		this.setEditboxValue(edt_KHYH, map.get("qd_khyh"));
		this.setEditboxValue(edt_YHZH, map.get("qd_yhzh"));
		this.setEditboxValue(edt_BBRQZ, map.get("qd_bbrqz"));
		pause(WAIT_SHORTER);
		this.jsClickButton(btn_saveInusred);
		pause(WAIT_SECOND);
		driver().close();
	}

}
