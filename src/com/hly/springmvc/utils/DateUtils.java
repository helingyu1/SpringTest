package com.hly.springmvc.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static Timestamp dateToTimestamp(Date date){
		String str = dateToString(date);
		return stringtoTimeStamp(str);
	}
	public static String dateToString(Date date){
		String ret = "";
		//DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		ret = sdf.format(date);
		return ret;
	}
	public static Timestamp stringtoTimeStamp(String date){
		return new Timestamp(System.currentTimeMillis()).valueOf(date);
	}
	public static void main(String[] args){
//		System.out.println(dateToString(new Date()));
		//System.out.println(stringtoTimeStamp("2016-04-22 14:33:29"));
		System.out.println(dateToString(new Date()));
	}
}
