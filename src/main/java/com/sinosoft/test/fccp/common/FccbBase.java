package com.sinosoft.test.fccp.common;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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
		if("".equals(code)) return;
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
		if("".equals(code)) return;
		logger.debug("SetCodeEditBox:开始设置:"+ codeEditBox.toString()+" & Code=" +code);
		setEditboxValue(codeEditBox,code);
		pause(500);
		try {
			WebElement folText=codeEditBox.findElement(By.xpath("../input[last()]"));
			folText.click();
			pause(500);
			logger.debug("SetCodeEditBox:找到了Code对应的文本显示框:"+folText.getAttribute("name"));
		}catch(NoSuchElementException nse) {
			//logger.error("使用SetCodeEditBox必须要指定一个鼠标点击位置BlankWidget",nse);
			logger.error("SetCodeEditBox:虚拟点击错误！",nse);
		}
		logger.debug("SetCodeEditBox:设置完毕"+ codeEditBox.toString()+",设置值 Code=" +code);
	}
	/**
	 *<p>goToWorkArea</p>
	 *<p>将浏览器工作区域切换到用户录入区域</p>
	 */
	public void goToWorkArea() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainFrame");
		driver.switchTo().frame("myFrame");
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
}
