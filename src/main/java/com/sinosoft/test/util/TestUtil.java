package com.sinosoft.test.util;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.sinosoft.test.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long SCRIPT_TIMEOUT =3;
	public static long IMPLICIT_WAIT = 2;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\liu-b\\git\\PageObjectModel"
			+ "\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				 sheet.getRow(i + 1).getCell(k).setCellType(HSSFCell.CELL_TYPE_STRING);
				 data[i][k] = sheet.getRow(i + 1).getCell(k).getStringCellValue();
				//data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/test/" + System.currentTimeMillis() + ".png"));
	}
	/**
	 *<p>takeScreenshot</p>
	 *<p>description</p>
	 * @param fileName
	 * @return
	 */
	public static String takeScreenshot(String fileName)  {
		try {
			logger.debug("截屏文件名字是："+fileName);
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File file =new File(getFileFullName(fileName)+".png");
			FileUtils.copyFile(scrFile, file);
			Reporter.log("截屏："+file.getAbsolutePath(),false);
			return file.getAbsolutePath();
		}catch(Exception e) {
			logger.error("浏览截屏失败：", e);
			return "";
		}	
	}
	/**
	 *<p>takeDesktopScreenShot</p>
	 *<p>桌面截屏，在浏览器截屏不工作时使用</p>
	 * @param fileName
	 * @return
	 */
	public static String takeDesktopScreenShot(String fileName) {
		try {
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage screenshot = (new Robot())
					.createScreenCapture(new Rectangle(0, 0, (int) d.getWidth(), (int) d.getHeight()));
			File file =new File(getFileFullName(fileName)+".png");
			ImageIO.write(screenshot, "png", file);
			Reporter.log("截屏："+file.getAbsolutePath(),false);
			return file.getAbsolutePath();
		} catch (Exception e) {
			logger.error("桌面截屏失败：", e);
			return "";
		}
	}
	public static String getMapString(Map<String, String> map) {
		StringBuffer sb= new StringBuffer();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey().toString() + "=" + entry.getValue().toString());
			sb.append("\r\n");
		}
		return sb.toString();
	};
	public static String getFileDateStr() {
		return new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
	}
	public static String getFileFullName(String fileName) {
		String userDir = System.getProperty("user.dir");
		String Folder=prop.getProperty("system.screenshot.folder", "screenshots");
		return userDir+File.separator+Folder+File.separator+fileName+"_" +getFileDateStr();
		
	}
	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) driver;
		// Check for jQuery on the page, add it if need be
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(5000);

		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");
//'"+color+"'"
		if (messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '"+message+"' });");
		}else if(messageType.equals("info")){
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		}else if(messageType.equals("warning")){
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		}else
			System.out.println("no error message");
		// jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		Thread.sleep(5000);
	}

}
