package com.sinosoft.test.fccp.tbcl;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

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
public class RiskDetailPage extends TbclMainFramePage {

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
	 *<p>跳转到 投保处理/险种信息/险种信息页面</p>
	 * @param map
	 * @return
	 */
	public RiskDetail_TypePage goToRiskTypePage(Map<String, String> map) {
		goToRiskDetailTable("险种信息");
		return new RiskDetail_TypePage();
	}
	
	/**
	 *<p>goToRiskTermsPage</p>
	 *<p>跳转到 投保处理/险种信息/保险条款标签页面</p>
	 * @param map
	 * @return
	 */
	public RiskDetail_TermsPage goToRiskTermsPage(Map<String, String> map) {
		goToRiskDetailTable("条款信息");
		return new RiskDetail_TermsPage();
	}
	/**
	 *<p>goToInsuredObjectPage</p>
	 *<p>跳转到 投保处理/险种信息/标的信息标签页面</p>
	 * @return
	 */
	public RiskDetail_insuredObjPage goToInsuredObjectPage(Map<String, String> map) {
		goToRiskDetailTable("标的信息"); 
		return new RiskDetail_insuredObjPage();

	}
	public RiskDetail_UnionPage goToUnionPage(Map<String, String> map) {
		goToRiskDetailTable("联共保信息");
		return new RiskDetail_UnionPage();
	}
	private void goToRiskDetailTable(String TabName) {
		System.out.println("准备进入标签页:"+TabName);
		goToRiskFrame();
		tab_SubRiskDetail = waitAndGetElement(By.xpath("//td[text()='"+TabName+"']"), 5);
		this.clickButton(tab_SubRiskDetail);
		goToWorkArea();
	}
	public String saveProposalNumbes(Map<String, String> map) {
		super.goToWorkArea();
		tbl_RiskItems =super.waitAndGetElement(By.id("RiskItem"), 10);
		List<WebElement> numLst =tbl_RiskItems.findElements(By.name("summarySubBusinessNo"));
		StringBuffer numSB=new StringBuffer();
		for(int i=0;i<numLst.size();i++) {
			String num=numLst.get(i).getAttribute("value");
			logger.info("投保单号："+num);
			if(i==0) {
				numSB.append(num);
			}else {
				numSB.append(",").append(num);
			}
		}
		 map.put("proposalNumber", numSB.toString());
	     goToWorkArea();
		return numSB.toString();
/*		List<WebElement> trs =tbl_RiskItems.findElements(By.tagName("tr"));
		int table_rows = trs.size();
		List<WebElement> tds = trs.get(0).findElements(By.tagName("td"));
		int table_cols= tds.size();
		logger.info("表格一共有："+table_rows+"行，"+table_cols+"列");
		for(int i=0;i<=trs.size();i++) {
			WebElement  tr =trs.get(i);
			for(int j=0;j<=tds.size();j++) {
				List<WebElement> trtds =tr.findElements(By.tagName("td"));
				String cellValue;
				if(i==0) {
					cellValue= trtds.get(j).getText();
				}else {
					try {
						cellValue =trtds.get(j).findElement(By.xpath("./input[last()]")).getAttribute("value");
					}catch (NoSuchElementException nse) {
						cellValue="";
						nse.printStackTrace();
					}
				}
	
				logger.info("Row:"+i+"Col:"+j+"is:"+cellValue);
			}
		}*/
	}
}
