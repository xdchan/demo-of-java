package cn.cxd.compos.days_count;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class DaysCompute {

	public boolean checkInputDate(String startDate, String endDate) {

		String[] startDateFields = startDate.split("-");
		String[] endDateFields = endDate.split("-");

		if (Integer.valueOf(startDateFields[0]) > Integer.valueOf(endDateFields[0])) {
			return false;
		}

		if (right(startDateFields) && right(endDateFields)) {
			return true;
		}

		return false;
	}

	private boolean right(String[] startDateFields) {

		int year = 0;
		int month = 0;
		int day = 0;
		try {
			year = Integer.parseInt(startDateFields[0]);
			month = Integer.parseInt(startDateFields[1]);
			day = Integer.parseInt(startDateFields[2]);
		} catch (Exception e) {
			return false;
		}

		List<Integer> bigMonthList = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
		List<Integer> smallMonthList = Arrays.asList(4, 6, 9, 11);

		if (month == 2) {
			if (leapYear(year)) {// 闰年2月
				if (day > 0 && day < 30) {
					return true;
				}
			} else {// 平年二月
				if (day > 0 && day < 29) {
					return true;
				}
			}
		}

		if (bigMonthList.contains(month)) {// 大月
			if (day > 0 && day < 32) {
				return true;
			}
		} else if (smallMonthList.contains(month)) {// 小月
			if (day > 0 && day < 31) {
				return true;
			}
		} else {// 非法
			return false;
		}

		return false;
	}

	private boolean leapYear(int year) {
		if (year % 4 == 0) {
			return true;
		}
		return false;
	}

	public long compute(String startDate, String endDate) {

		if (!checkInputDate(startDate, endDate)) {
			return -1L;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			long startDay = format.parse(startDate).getTime();
			long endDay = format.parse(endDate).getTime();
			return (endDay - startDay) / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
			return -1L;
		}

	}
}
