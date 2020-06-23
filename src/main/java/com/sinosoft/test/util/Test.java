package com.sinosoft.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws ParseException {
		System.out.println("测试数据");
		String dateString="2008/08-08";
		String split= dateString.replaceAll("\\/|-", "");
			System.out.println(split);
		String dateFormat = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date =sdf.parse(split);
		SimpleDateFormat outDate = new SimpleDateFormat("yyyy-MM-dd");
		String out=outDate.format(date);
		System.out.println(out);

	}

}
