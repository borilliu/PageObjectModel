package com.sinosoft.test.fccp.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sinosoft.test.base.TestBase;

/**
 * @author liubenchao@sinsoft.com.cn
 *
 */
public abstract class FccbBase extends TestBase {
	/**
	 * @Fields WINDOW_MAIN_TITLE : 业务系统窗口标题
	 */
	static String WINDOW_MAIN_TITLE = "黄河财险业务系统";
	/**
	 * @Fields WINDOW_CODESELECT_TITLE : Code选择窗口标题
	 */
	static String WINDOW_CODESELECT_TITLE ="Code Select";
	
	public FccbBase() {
		PageFactory.initElements(driver, this);
	}
	/**
	 *<p>CodeSelect</p>
	 *<p>双击Code选择框，在弹出的窗口选中相关Code.该方法较慢，尽量使用SetCodeSelect方法</p>
	 * @param codeEditBox
	 * @param code
	 */
	public void CodeSelect(WebElement codeEditBox,String code) {
		if(null == code || "".equals(code)) return;
		if(code.equals(codeEditBox.getAttribute("value"))) return;
		logger.debug("CodeSelect:开始设置"+ codeEditBox.toString()+" & Code=" +code);
		super.actionDoubleClick(codeEditBox);
		super.navigateToWindowByTitle(WINDOW_CODESELECT_TITLE, 5);
		CodeSelectPage CSP =new CodeSelectPage();
		CSP.selectByCodes(code);
		super.navigateToWindowByTitle(WINDOW_MAIN_TITLE, 5);
		goToWorkArea();
		logger.debug("CodeSelect:设置完毕"+ codeEditBox.toString()+" & Code=" +code);
	}
	
	/**
	 *<p>SetCodeSelect</p>
	 *<p>设置Code选择输入框的值，通过点击触发ajax事件</p>
	 * @param codeEditBox
	 * @param code
	 */
	public void SetCodeEditBox(WebElement codeEditBox,String code) {
		if(null == code || "".equals(code)) return;
		if(code.equals(codeEditBox.getAttribute("value").trim())) {
			return;
		}
		logger.debug("SetCodeEditBox:开始设置:"+ codeEditBox.toString()+" & Code=" +code);
		setEditboxValue(codeEditBox,code);
		pause(WAIT_SHORTEST);
		try {
			WebElement folText;
			folText=codeEditBox.findElement(By.xpath("../input[last()]"));
			if(folText.isEnabled()&&folText.isDisplayed()) {
				logger.info("SetCodeEditBox:找到了Code对应的文本显示框并点击触发显示:"+folText.getAttribute("name"));
			}else {
				//再次查找
				folText=codeEditBox.findElement(By.xpath("../input[last-1()]"));
				if(folText.isEnabled()&&folText.isDisplayed()) {
					logger.info("SetCodeEditBox:重新找到了Code对应的文本显示框并点击触发显示:"+folText.getAttribute("name"));
				}	
			}
			if(folText!=null) {	
				folText.click();
				pause(WAIT_SHORTER);
			}
		}catch(Exception e) {
			//logger.error("使用SetCodeEditBox必须要指定一个鼠标点击位置BlankWidget",nse);
			logger.error("SetCodeEditBox:虚拟点击错误！",e);
		}
		logger.debug("SetCodeEditBox:设置完毕"+ codeEditBox.toString()+",设置值 Code=" +code);
	}
	/**
	 *<p>setSelectWithStartText</p>
	 *<p>根据起始字符选择列表项</p>
	 * @param slcELe
	 * @param startText
	 */
	public void setSelectWithStartText(WebElement slcELe,String startText) {
		logger.info("setSelectWithStartText:"+ slcELe.toString()+"->"+ startText);
		if("".equals(startText)) {
			return;
		}
		Select select = new Select(slcELe);
		try {
			WebElement slctedOption = select.getFirstSelectedOption();
			if(null != slctedOption && slctedOption.getText().startsWith(startText)) {
				logger.info(slcELe.toString()+"使用了默认选中的选项："+slctedOption.getText());
				return;
			}
		}catch(Exception e) {
		}	
		List<WebElement> Options = select.getOptions();
		boolean found = false;
	    for (WebElement selectedOption : Options) {
	        String txt = selectedOption.getText();
	        if (null !=txt && txt.startsWith(startText)){
	        	logger.info("找到匹配【"+ startText+"】的选项："+ txt);
	        	select.selectByVisibleText(txt);
	        	found =true;
	        	break;
	        }
	    }
	    if(!found) {
	    	logger.error("没有找到以【"+startText+"】为起始的选项！" );
	    }
	}	
	/**
	 *<p>SetDateEditBox</p>
	 *<p>设置日期框的值</p>
	 * @param dateEditBox
	 * @param date
	 */
	public void SetDateEditBox(WebElement dateEditBox,String date) {
		if("".equals(date)) return;
		String val = dateEditBox.getAttribute("value");
		if(this.fmtDateString(date).equals(val)) {
			logger.debug("设置的日期值"+date+"和系统值"+val+"一致,不再设置！");
			return;
		}else {
			logger.debug("设置日期值 由"+val+" 设置为"+ fmtDateString(date));
		}
		logger.debug("SetDateEditBox:开始设置:"+ dateEditBox.toString()+" & date=" +date);
		setEditboxValue(dateEditBox,date);
	}
	/**
	 *<p>goToWorkArea</p>
	 *<p>将浏览器工作区域切换到用户录入区域</p>
	 */
	public void goToWorkArea() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("myFrame");
		System.out.println("进入了MyFrame");
	}
	public void goToMainArea() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame"); 
	}
	/**
	 *<p>goToMenuArea</p>
	 *<p>将浏览器工作区域切换到带单工作区域</p>
	 */
	public void goToMenuArea() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("leftFrame");
	}
	/**
	 *<p>openMenu</p>
	 *<p>打开菜单</p>
	 * @param menuString 使用“#”分割的菜单项目，如 传入"承保子系统#投保管理#投保处理" 将依次打开"承保子系统"->"投保管理" ->"投保处理"
	 */
	public void openMenu(String menuString) {
		this.goToMenuArea();
		String[] menus = menuString.split("#");
		for(int i=0;i<menus.length;i++) {
			WebElement menu = waitAndGetElement(By.linkText(menus[i]), 1);
			runJS("arguments[0].click();", menu);
			pause(200);
		}
	}		
	public String fmtDateString(String dateString) {
		String dateStringFmt= dateString.replaceAll("\\/|-", "");
		try {
			Date date = new SimpleDateFormat("yyyyMMdd").parse(dateStringFmt);
			return new SimpleDateFormat(prop.getProperty("system.app.dateformat", "yyyyMMdd")).format(date);
		}catch(Exception e) {
			return dateStringFmt;
		}
		
	}

}
