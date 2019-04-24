package cn.cxd.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarDemo {

	public static void main(String[] args) {

		// 获得日期相关的属性

		Calendar cal = new GregorianCalendar(1992, 12, 03, 10, 05, 33);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);// 0-11
		int day = cal.get(Calendar.DATE);
		int weekDay = cal.get(Calendar.DAY_OF_WEEK);

		System.out.println(year);// 1993
		System.out.println(month);//
		System.out.println(day);// 3
		System.out.println(weekDay);// 5

		Calendar cal2 = new GregorianCalendar();
		cal2.set(Calendar.YEAR, 2019);

		Calendar cal3 = new GregorianCalendar();
		cal3.add(Calendar.YEAR, -100);

		Date d1 = cal.getTime();
		Calendar cal4 = new GregorianCalendar();
		cal4.setTime(d1);
	}
}
