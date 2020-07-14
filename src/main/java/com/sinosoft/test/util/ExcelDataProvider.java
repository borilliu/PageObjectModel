package com.sinosoft.test.util;

import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sinosoft.test.base.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
public class ExcelDataProvider extends TestBase implements Iterator<Object[]>  {
		private  String testCaseName;
		private XSSFSheet xssfSheet;
	    /**
	     * @Fields colCount : 列的数量
	     */
		private int colCount = 0;
	    /**
	     * @Fields rowCount : 数据行的数量（不含标题）
	     */
		private int rowCount = 0; 
	    /**
	     * @Fields currentRowNum : 当前处理的行号
	     */
		private int currentRowNum = 2; 

		/**
		 * @Fields colNameArray : 存放列名的数组，第一列存ROW_ID
		 */
		private String[] colNameArray = null;
		/**
		 * @Fields intputStream : TODO
		 */
		private FileInputStream intputStream;
	    /*
	    * 构造方法
	    * */
	    public ExcelDataProvider(String testCaseName) throws FileNotFoundException {
	    	this.testCaseName=testCaseName;
	        intputStream = new FileInputStream(getFullFileName(testCaseName));
	        try {
	            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(intputStream);
	            xssfSheet = xssfWorkbook.getSheetAt(0);
	           // XSSFRow xssfRow = xssfSheet.getRow(0); 第一行是大标题，不使用
	            XSSFRow xssfRow = xssfSheet.getRow(1);
	            colCount = xssfRow.getPhysicalNumberOfCells();
	            int rows = xssfSheet.getLastRowNum();
	            
	            //行首增加一列用来存储行号:ROW_ID
	            //colNameArray = new String[colCount];
	            colNameArray = new String[colCount+1]; 
	            colNameArray[0] = "ROW_ID";
	            //获取所有的列名
	            for (int i = 0; i < colCount; i++) {
	                colNameArray[i+1] = xssfSheet.getRow(1).getCell(i).toString();
	            }
	            //获取有多少行数据，Excel有两列表头，从第三行开始计数。
	            for (int r = 2; r <= rows; r++) {
	                try {
	                    String v = xssfSheet.getRow(r).getCell(0).toString();
	                    if (null == v || "".equals(v)) {
	                        break;
	                    }
	                } catch (NullPointerException e) {
	                    break;
	                }
	                this.rowCount++;
	            }
	        } catch (IOException e) {
	            e.printStackTrace(); 
	        }
	        logger.info("当前文件里面一共有数据："+rowCount);
	    }
	 

	    /* 判断是否存在待处理数据
	     * @see java.util.Iterator#hasNext()
	     */
	    @Override
	    public boolean hasNext() {
	        //行数大于0  并且 当前的行数小于等于 最大行
	        if (rowCount > 0 && currentRowNum <= rowCount+1 ){
	        	String ind= xssfSheet.getRow(this.currentRowNum).getCell(0).toString();
	        	System.out.println("字段标识："+ind);
	        	if("Y".equalsIgnoreCase(ind)) {
	        		return true;
	        	}else {
	        		return false;
	        	}
	        }
	        else {
	            try {
	                intputStream.close();
	            } catch (IOException e) {
	                e.printStackTrace(); 
	            }
	            return false;
	        }
	    }
	 
	    /* (non-Javadoc)
	     * @see java.util.Iterator#next()
	     */
	    @Override
	    public Object[] next() {
	        Object[] object = new Object[1];
	        Map<String, String> map = new LinkedHashMap<String, String>();
	        XSSFRow xssfRow = xssfSheet.getRow(this.currentRowNum);
	        for (int c = 0; c < colNameArray.length; c++) {
	        	if (c == 0) {
	        		map.put(colNameArray[0], Integer.toString(xssfRow.getRowNum()));
	        		continue;
	        	}
	            String cellValue = "";
	            try {
	            	xssfRow.getCell(c-1).setCellType(XSSFCell.CELL_TYPE_STRING);
	                cellValue = xssfRow.getCell(c-1).toString();
	            } catch (Exception e) {
	            	cellValue = "";
	            }
	            map.put(colNameArray[c], cellValue);
	        }
	        map.put("testCaseName", this.testCaseName);
	        object[0] = map;
	        this.currentRowNum++;
	        return object; 
	    }
	 
	    /**
	     * 删除
	     */
	    @Override
	    public void remove() {
	       
	    }
	 
	    /**
	     *<p>getFullFileName</p>
	     *<p>获取测试数据文件的绝对路径</p>
	     * @param filePrefix 文件名前缀：TestClass中的测试方法名。
	     * @return
	     */
	    public static String getFullFileName(String filePrefix) {
	        String dir = System.getProperty("user.dir");
	        String dataFolder=prop.getProperty("system.testdata.folder");
	        String path = dir +File.separator + dataFolder +File.separator+filePrefix+"_data.xlsx";
	        return path;
	    }
	    
	    public static void  updateExcelCellValues(String testCaseName,String rowID, Map<String,String> valueMap ) {
	    	try {
		    	String filePath=getFullFileName(testCaseName);
		    	FileInputStream intputStream = new FileInputStream(filePath);
	            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(intputStream);
	            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
	            XSSFRow xssfRow = xssfSheet.getRow(1);
	            int colCount = xssfRow.getPhysicalNumberOfCells();
	           
	            HashMap<String,Integer> colMap= new HashMap<String,Integer>();
	            //获取所有的列名
	            for (int i = 0; i < colCount; i++) {
	            	String colName=String.valueOf(xssfSheet.getRow(1).getCell(i));
	                  	colMap.put(colName, i);
	            }
	            XSSFRow row =xssfSheet.getRow(Integer.parseInt(rowID));
	            for (Map.Entry<String, String> entry : valueMap.entrySet()) {
	            		String colTitle= entry.getKey();
	                 	XSSFCell cell = row.getCell(colMap.get(colTitle));
	              		cell.setCellValue(entry.getValue());
	            }
	            FileOutputStream fileOut = new FileOutputStream(filePath);
	            xssfWorkbook.write(fileOut);
	            fileOut.flush();
	            fileOut.close();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		
	    	}
	    }
}
