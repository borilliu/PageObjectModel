package com.sinosoft.test.fccp.tbcl;

import org.openqa.selenium.support.PageFactory;

/**
 *com.sinosoft.test.fccp.tbcl.RiskDetail_UnionPage.java
 *<p>联共保信息页面</p>
 * @author liubenchao@sinsoft.com.cn
 */
public class RiskDetail_UnionPage extends RiskDetailPage {

	public RiskDetail_UnionPage() {
		goToWorkArea();
		PageFactory.initElements(driver, this);
	}

}
