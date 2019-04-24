package cn.cxd.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class VisualCalendar {

	public static void main(String[] args) throws Exception {

		String input = "2018-11-14";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(input);
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		System.out.println("日\t一\t二\t三\t四\t五\t六");

		int day = c.get(Calendar.DAY_OF_MONTH);
		int maxDay = c.getActualMaximum(Calendar.DATE);

		c.set(Calendar.DAY_OF_MONTH, 1);

		for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK) - 1; i++) {
			System.out.print("\t");
		}

		for (int i = 1; i <= maxDay; i++) {

			if (day == c.get(Calendar.DAY_OF_MONTH)) {
				System.out.print(c.get(Calendar.DAY_OF_MONTH) + "*\t");
			} else {
				System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
			}

			if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				System.out.println();
			}
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}
