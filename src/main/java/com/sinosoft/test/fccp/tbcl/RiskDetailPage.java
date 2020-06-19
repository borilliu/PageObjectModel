package com.sinosoft.test.fccp.tbcl;

import java.util.Map;

import org.openqa.selenium.By;
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
	 * Tab 标签元素 动态获取
	 *****************************************/
	WebElement tab_SubRiskDetail;
	
	
	public RiskDetailPage(){
		//super();
		//goToWorkArea();
	}
	
	public void goToWorkArea() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("myFrame");
		driver.switchTo().frame("RiskFrame");
		driver.switchTo().frame("myFrame");
	}
	public void goToRiskFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("myFrame");
		driver.switchTo().frame("RiskFrame");
	}
	/**
	 *<p>goToRiskTypePage</p>
	 *<p>跳转到投保处理/险种信息/险种信息页面</p>
	 * @param map
	 * @return
	 */
	public RiskDetail_TypePage goToRiskTypePage(Map<String, String> map) {
		goToRiskDetailTable("险种信息");
		return new RiskDetail_TypePage();
	}
	public RiskDetail_insuredObjPage goToInsuredObjectPage() {
		goToRiskDetailTable("标的信息"); 
		return new RiskDetail_insuredObjPage();
//		goToRiskDetailTable("条款信息");
//		goToRiskDetailTable("联共保信息");
//		goToRiskDetailTable("险种信息");
	}
	public void goToRiskDetailTable(String TabName) {
		System.out.println("准备进入标签页:"+TabName);
		goToRiskFrame();
		tab_SubRiskDetail = waitAndGetElement(By.xpath("//td[text()='"+TabName+"']"), 5);
		this.clickButton(tab_SubRiskDetail);
		goToWorkArea();
	}
}
