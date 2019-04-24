package cn.cxd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo1 {

	public static void main(String[] args) throws ParseException {

		String formatType = "yyyy-MM-dd hh:mm:ss";

		long st = System.currentTimeMillis();
		String strTime = timestamp2Date(st, formatType);
		System.out.println(strTime);

		String input = "2018-11-13 08:57:55";
		long lTime = date2Timestamp(input, formatType);
		System.out.println(lTime);

		SimpleDateFormat format = new SimpleDateFormat("D");
		String str = format.format(new Date());
		System.out.println("这是今年的第" + str + "天");

	}

	public static String timestamp2Date(long timestamp, String formatType) {
		SimpleDateFormat format = new SimpleDateFormat(formatType);
		String date = format.format(timestamp);
		return date;
	}

	public static long date2Timestamp(String date, String formatType) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(formatType);
		long timestamp = format.parse(date).getTime();
		return timestamp;
	}

}
