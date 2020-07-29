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
public class InsuredObjectInfoPage_1134 extends AbstractInsuredObjectInfoPage_11 {
	/**
	 * @Fields edt_BZ : 币种
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciCurrency")
	WebElement edt_BZ;
	/**
	 * @Fields edt_ZYDLDM : 职业大类代码
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciOccupationType")
	WebElement edt_ZYDLDM;
	
	/**
	 * @Fields edt_ZYGZDM : 职业工种代码
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciOccupationCode")
	WebElement edt_ZYGZDM;
	
	
	/**
	 * @Fields edt_MRTBFS : 每人投保份数
	 */
	@FindBy(how = How.NAME,using = "GuItemAcciUwCount")
	WebElement edt_MRTBFS;
	
	public InsuredObjectInfoPage_1134() {
		edt_BZ =super.waitAndGetElement(By.xpath("//input[@name='GuItemAcciCurrency']"), 20);
		PageFactory.initElements(driver(), this);
	}

	public void inputInsuredObjectAction(Map<String, String> map) {
		this.SetCodeEditBox(edt_BZ, map.get("ywx_bz"));
		this.SetCodeEditBox(edt_ZYDLDM, map.get("ywx_zydldm"));
		this.CodeSelect(edt_ZYGZDM, map.get("ywx_zygzdm"));
		this.setEditboxValue(edt_MRTBFS, map.get("ywx_mrtbfs"));
	}

}
