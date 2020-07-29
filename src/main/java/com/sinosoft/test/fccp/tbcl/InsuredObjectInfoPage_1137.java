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
	
	
	
	public InsuredObjectInfoPage_1137() {
		edt_BZ =super.waitAndGetElement(By.xpath("//input[@name='GuItemAcciCurrency']"), 30);
		PageFactory.initElements(driver(), this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		this.SetCodeEditBox(edt_BZ, map.get("ywx_bz"));
		this.setNumberEditBoxValue(edt_MRTBFS, map.get("ywx_mrtbfs"));
		this.setNumberEditBoxValue(edt_TBZRS, map.get("ywx_tbzrs"));
	}

}
