package com.sinosoft.test.fccp.tbcl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.sinosoft.test.util.TestUtil;

public abstract class RiskDetail_AbstractInsuredObjPage extends RiskDetailPage {

	@FindBy(how = How.ID,using = "ItemPropertyDetail")
	//@FindBy(how = How.ID,using = "ItemPropertyDetailKind")
	WebElement tbl_BDWMX;
	
	/*********************************************************
	 **********               附加险信息        	 *************
	 *********************************************************
	 */	
	/**
	 * @Fields tbl_rider : 附加险
	 */
	@FindBy(how = How.ID,using = "ItemKindSub")
	WebElement tbl_riskRsiders;

	/*********************************************************
	 **********               免赔信息        	 *************
	 *********************************************************
	 */
	
	@FindBy(how = How.ID,using = "ItemDeductible")
	//@FindBy(how = How.ID,using = "ItemPropertyDetailKind")
	WebElement tbl_MPXX;
	
	/*********************************************************
	 **********               特别条款        	 *************
	 *********************************************************
	 */
	
	@FindBy(how = How.NAME,using = "MainClausesImg")
	WebElement lnk_TBTK;	
	
	@FindBy(how = How.ID,using = "SpecialClause")
	WebElement tbl_TBTK;
	

	
	
	/**
	 * @Fields btn_savePage : 保存标的信息
	 */
	@FindBy(how = How.ID,using = "saveButton")
	WebElement btn_savePage;
	
	public static RiskDetail_AbstractInsuredObjPage getInstance(String riskClass) {
		switch (riskClass){
			case "07": 
				return new RiskDetail_JGX_insuredObjPage();
			case "11": 
				return new RiskDetail_YWX_insuredObjPage();
			case "12": 
				return new RiskDetail_ZRX_insuredObjPage();
			case "17": 
				return new RiskDetail_JCX_insuredObjPage();
			default:
				return new RiskDetail_insuredObjPage();
		}
	}
	/**
	 *<p>InputInsuredObjectAction</p>
	 *<p>录入标的物信息</p>
	 * @param map
	 */
	public  abstract void inputInsuredObjectAction(Map<String, String> map);

	/**
	 *<p>inputRiskCodeAction</p>
	 *<p>录入标的物险种信息</p>
	 * @param map
	 */
	public abstract  void inputRiskCoverageAction(Map<String, String> map);
	
	/**
	 *<p>saveInsredObjectPage</p>
	 *<p>保存标的物页面</p>
	 */
	public void saveInsredObjectPage(Map<String, String> map){
		this.clickButton(btn_savePage);
	}
	
	/**
	 *<p>inputDeductionAction</p>
	 *<p>免赔信息</p>
	 * @param map
	 */
	public void inputDeductionAction(Map<String, String> map) {
		scrollToElement(tbl_MPXX);
		this.clickElement(tbl_MPXX);
		WebElement btn_addDeduction = tbl_MPXX.findElement(By.name("buttonKindDeductibleInsert"));
		this.jsClickButton(btn_addDeduction);
		WebElement edt_MPDM= tbl_MPXX.findElement(By.name("kindGuKindDeductibleDeductibleCode"));
		this.SetCodeEditBox(edt_MPDM, map.get("mp_mpdm"));
		WebElement edt_MPBZ= tbl_MPXX.findElement(By.name("kindGuKindDeductibleRemark"));
		this.setEditboxValue(edt_MPBZ, map.get("mp_mpbz"));
	}
	
	/**
	 *<p>inputSpecialClauseAction</p>
	 *<p>特别条款</p>
	 * @param map
	 */
	public void inputSpecialClauseAction(Map<String, String> map) {
        //runJS("arguments[0].scrollIntoView();",lnk_TBTK);
		scrollToElement(lnk_TBTK);
        this.jsClickButton(lnk_TBTK);
		pause(WAIT_SHORTER);
		//this.clickElement(tbl_TBTK);
		WebElement btn_addClause = tbl_TBTK.findElement(By.name("buttonMyClausesAdd"));
		this.jsClickButton(btn_addClause);
		WebElement edt_TKDM= tbl_TBTK.findElement(By.name("GuRiskSpecialClausesClauseCode"));
		this.CodeSelect(edt_TKDM, map.get("tk_tkdm"));
		//打开条款明细页面
		pause(WAIT_SECOND);
		WebElement btn_openClause = tbl_TBTK.findElement(By.name("OpenClausesClauses"));
		this.jsClickButton(btn_openClause);
		pause(WAIT_SECOND);
		//条款信息页面
		WebElement spn_clauseDetail = tbl_TBTK.findElement(By.id("span_MainClauses_Context"));
		WebElement txt_Clause = spn_clauseDetail.findElement(By.name("GuRiskSpecialClausesClauseContext"));
		this.setEditboxValue(txt_Clause, map.get("tk_tkxx"));
		WebElement btn_close = spn_clauseDetail.findElement(By.name("CloseClausesClauses"));
		this.jsClickButton(btn_close);
	}
	/**
	 *<p>inputRidersAction</p>
	 *<p>录入附加险</p>
	 */
	public void inputRidersAction(Map<String, String> map) {
		super.scrollToElement(tbl_riskRsiders);
		List<Map<String,String>> RiderList = this.getRiderMap(map);
	    for (Map<String,String> riderMap:RiderList) {
	    	System.out.println(TestUtil.getMapString(riderMap));
            WebElement btn_addRider = tbl_riskRsiders.findElement(By.name("button_ItemKindSub_Insert"));
    		this.jsClickButton(btn_addRider);
    		WebElement edt_riderCode = tbl_riskRsiders.findElement(By.xpath("(//input[@name='SubGuItemKindKindCode'])[last()]"));
    		this.CodeSelect(edt_riderCode,riderMap.get("xbdm"));
    		WebElement edt_Jrbe = tbl_riskRsiders.findElement(By.xpath("(//input[@name='SubGuItemKindCalculateInd'])[last()]"));
    		this.CodeSelect(edt_Jrbe,riderMap.get("jrbe"));
    		WebElement edt_bxje = tbl_riskRsiders.findElement(By.xpath("(//input[@name='SubGuItemKindSumInsured'])[last()]"));
    		this.setNumberEditBoxValue(edt_bxje, riderMap.get("bxje"));
    		WebElement edt_bxfl = tbl_riskRsiders.findElement(By.xpath("(//input[@name='SubGuItemKindRate'])[last()]"));
    		this.setNumberEditBoxValue(edt_bxfl, riderMap.get("bxfl"));
    		WebElement edt_dqflbz = tbl_riskRsiders.findElement(By.xpath("(//input[@name='SubGuItemKindShortRateFlag'])[last()]"));
    		this.setNumberEditBoxValue(edt_dqflbz, riderMap.get("dqflbz"));
    		WebElement edt_ysbf = tbl_riskRsiders.findElement(By.xpath("(//input[@name='SubGuItemKindGrossPremium'])[last()]"));
    		this.setNumberEditBoxValue(edt_ysbf, riderMap.get("ysbf"));
        }
	}
	/**
	 *<p>inputLimtAmountAction</p>
	 *<p>录入限额信息</p>
	 * @param tbl_riskCoverage
	 * @param lmtList
	 */
	public void inputLimtAmountAction(WebElement tbl_riskCoverage,Map<String,Object> riskMap) {
		List<Map<String, String>> lmtList = (List<Map<String, String>>)riskMap.get("xeList");
		System.out.println("限额数量："+lmtList.size());
		if(lmtList.size()<=0) return;
		WebElement btn_addLimit = tbl_riskCoverage.findElement(By.xpath("(//input[@name='button_KindLimitKind_Edit'])[last()]"));
		this.jsClickButton(btn_addLimit);
		WebElement spn_limitDtl = tbl_riskCoverage.findElement(By.xpath("(//span[@id='span_KindLimitKind_SubPage'])[last()]"));
		WebElement btn_addItem = spn_limitDtl.findElement(By.name("kindGuKindLimit_buttonKindLimitInsert"));
		for (Map<String,String> xeMap:lmtList) {
			System.out.println(TestUtil.getMapString(xeMap));
			pause(this.WAIT_SHORTEST);
			this.jsClickButton(btn_addItem);
			WebElement edt_lmtCode = spn_limitDtl.findElement(By.xpath("(//input[@name='kindGuKindLimitLimitCode'])[last()]"));
			this.CodeSelect(edt_lmtCode, xeMap.get("xedm"));
			WebElement edt_lmtType = spn_limitDtl.findElement(By.xpath("(//input[@name='kindGuKindLimitLimitType'])[last()]"));
			this.CodeSelect(edt_lmtType, xeMap.get("xelx"));
			WebElement edt_lmtCur = spn_limitDtl.findElement(By.xpath("(//input[@name='kindGuKindLimitCurrency'])[last()]"));
			this.CodeSelect(edt_lmtCur, xeMap.get("xebz"));
			WebElement edt_lmtAmt = spn_limitDtl.findElement(By.xpath("(//input[@name='kindGuKindLimitLimit'])[last()]"));
			this.setNumberEditBoxValue(edt_lmtAmt, xeMap.get("xexe"));               
			WebElement edt_lmtRmk = spn_limitDtl.findElement(By.xpath("(//textarea[@name='kindGuKindLimitRemark'])[last()]"));
			this.setNumberEditBoxValue(edt_lmtRmk, xeMap.get("xermk"));
		}
		WebElement btn_closeLimit = spn_limitDtl.findElement(By.name("kindGuKindLimit_button_KindLimit_Close"));
		this.jsClickButton(btn_closeLimit);
	}
	
	/**
	 *<p>inputDeductionAction</p>
	 *<p>录入免赔信息</p>
	 * @param tbl_riskCoverage
	 * @param deductList
	 */
	public void inputDeductionAction(WebElement tbl_riskCoverage,Map<String,Object> riskMap) {
		List<Map<String, String>> deductList = (List<Map<String, String>>)riskMap.get("mpList");
		if(deductList.size()<=0) return;
		WebElement btn_addDeduction = tbl_riskCoverage.findElement(By.xpath("(//input[@name='button_KindDeductibleKind_Edit'])[last()]"));
		this.jsClickButton(btn_addDeduction);
		WebElement spn_deductDtl = tbl_riskCoverage.findElement(By.xpath("(//span[@id='span_KindDeductibleKind_SubPage'])[last()]"));
		WebElement btn_addDeduct = spn_deductDtl.findElement(By.name("kindGuKindDeductible_buttonKindDeductibleInsert"));
		for (Map<String,String> deductMap:deductList) {
			System.out.println(TestUtil.getMapString(deductMap));
			this.jsClickButton(btn_addDeduct);
			//免赔代码
			WebElement edt_DeductCode = spn_deductDtl.findElement(By.xpath("(//input[@name='kindGuKindDeductibleDeductibleCode'])[last()]"));
			this.CodeSelect(edt_DeductCode, deductMap.get("mpdm"));
			//免赔数值
			WebElement edt_deductAmt = spn_deductDtl.findElement(By.xpath("(//input[@name='kindGuKindDeductibleDeductible'])[last()]"));
			this.setNumberEditBoxValue(edt_deductAmt, deductMap.get("mpsz"));
			//免赔率
			WebElement edt_deductRate = spn_deductDtl.findElement(By.xpath("(//input[@name='kindGuKindDeductibleDeductibleRate'])[last()]"));
			this.setNumberEditBoxValue(edt_deductRate, deductMap.get("mpfl"));
			//免赔备注
			WebElement edt_deductRmk = spn_deductDtl.findElement(By.xpath("(//textarea[@name='kindGuKindDeductibleRemark'])[last()]"));
			this.setEditboxValue(edt_deductRmk, deductMap.get("mpbz"));
		}
		//关闭免赔页面
		WebElement btn_closeDeduct = spn_deductDtl.findElement(By.name("kindGuKindDeductible_button_KindDeductible_Close"));
		this.jsClickButton(btn_closeDeduct);
	}
	
	/**
	 *<p>getRiderMap</p>
	 *<p>附加险数据整理</p>
	 * @param dataMap
	 * @return
	 */
	public List<Map<String,String>> getRiderMap(Map<String, String> dataMap) {
		List<Map<String,String>> riderList= new java.util.ArrayList<Map<String,String>>();
		for(int i=1;i<=5;i++) {
			String xbdm = dataMap.get("fjx_xbdm"+i);
			if(xbdm!=null && !"".equals(xbdm)) {
				HashMap<String, String> riderMap= new HashMap<String, String>();
				riderMap.put("xbdm",dataMap.get("fjx_xbdm"+i));
				riderMap.put("jrbe",dataMap.get("fjx_jrbe"+i));
				riderMap.put("bxje",dataMap.get("fjx_bxje"+i));
				riderMap.put("bxfl",dataMap.get("fjx_bxfl"+i));
				riderMap.put("dqflbz",dataMap.get("fjx_dqflbz"+i));
				riderMap.put("ysbf",dataMap.get("fjx_ysbf"+i));
				riderList.add(riderMap);
			}
		}
		return riderList;
	}
	/**
	 *<p>getRiskMapList</p>
	 *<p>从数据文件中获取险种信息</p>
	 * @param dataMap
	 * @param prefix
	 * @return
	 */
	public List<Map<String,Object>> getRiskMapList(Map<String, String> dataMap,String prefix) {
		List<Map<String,Object>> riskList= new ArrayList<Map<String,Object>>();
		for(int i=1;i<=5;i++) {
			String xbdm = dataMap.get(prefix+"xbdm"+i);
			if(xbdm!=null && !"".equals(xbdm)) {
				HashMap<String, Object> riskMap= new HashMap<String, Object>();
				riskMap.put("bdw",dataMap.get(prefix+"bdw"+i));
				riskMap.put("bdmx",dataMap.get(prefix+"bdmx"+i));
				riskMap.put("xbdm",dataMap.get(prefix+"xbdm"+i));
				riskMap.put("xbdm",dataMap.get(prefix+"xbdm"+i));
				riskMap.put("jrbe",dataMap.get(prefix+"jrbe"+i));
				riskMap.put("jzfs",dataMap.get(prefix+"jzfs"+i));
				riskMap.put("bxje",dataMap.get(prefix+"bxje"+i));
				riskMap.put("bffl",dataMap.get(prefix+"bffl"+i));
				riskMap.put("dqflbz",dataMap.get(prefix+"dqflbz"+i));
				riskMap.put("jbbf",dataMap.get(prefix+"jbbf"+i));
				riskMap.put("ysbf",dataMap.get(prefix+"ysbf"+i));
	
				//处理免赔信息
				String xzmp_prefix = prefix+"xzmp"+i+"_";
				List<Map<String,String>> mpList= new ArrayList<Map<String,String>>();
				for(int j=1;j<=5;j++) {
					//System.out.println(xzmp_prefix+"dm"+j);
					String mpdm = dataMap.get(xzmp_prefix+"dm"+j);
					if(mpdm!=null && !"".equals(mpdm.trim())) {
						HashMap<String, String> mpMap= new HashMap<String, String>();
						mpMap.put("mpdm", dataMap.get(xzmp_prefix+"dm"+j));
						mpMap.put("mpsz", dataMap.get(xzmp_prefix+"sz"+j));
						mpMap.put("mpfl", dataMap.get(xzmp_prefix+"fl"+j));
						mpMap.put("mpbz", dataMap.get(xzmp_prefix+"bz"+j));
						mpList.add(mpMap);
					}
				}
				riskMap.put("mpList", mpList);//险种免赔

				//处理限额信息
				String xzxe_prefix = prefix+"xzxe"+i+"_";
				List<Map<String,String>> xeList= new ArrayList<Map<String,String>>();
				for(int k=1;k<=5;k++) {
					String mpdmKey = xzxe_prefix+"dm"+k;
					String mpdm = dataMap.get(mpdmKey);
					//System.out.println(mpdmKey +" = " +mpdm);
					if(mpdm!=null && !"".equals(mpdm.trim())) {
						HashMap<String, String> xeMap= new HashMap<String, String>();
						xeMap.put("xedm", dataMap.get(xzxe_prefix+"dm"+k));
						xeMap.put("xelx", dataMap.get(xzxe_prefix+"lx"+k));
						xeMap.put("xebz", dataMap.get(xzxe_prefix+"bz"+k));
						xeMap.put("xexe", dataMap.get(xzxe_prefix+"xe"+k));
						xeMap.put("xermk", dataMap.get(xzxe_prefix+"rmk"+k));
						xeList.add(xeMap);
					}
				}
				riskMap.put("xeList", xeList);//险种限额
	
				riskList.add(riskMap);
				
			}
		}
		return riskList;
	}
}
