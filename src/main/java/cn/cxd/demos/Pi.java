package cn.cxd.demos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pi {

	public static void main(String[] args) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long sTime = System.currentTimeMillis();
		Date startTime = new Date(sTime);
		String st = format.format(startTime);

		// String st1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new
		// Date(System.currentTimeMillis()));

		long n = 2000000000L;
		double pi = 0D;
		int oper = 1;

		for (int i = 1; i <= n; i += 2) {
			if (oper % 2 == 1) {
				pi += (double) 1 / i;
				++oper;
			} else {
				pi += ((double) 1 / i * (-1));
				--oper;
			}
			// System.out.println(i);
		}

		System.out.println("Pi is roughly " + pi * 4);
		Long eTime = System.currentTimeMillis();
		Date endTime = new Date(eTime);
		String et = format.format(endTime);
		System.out.println("This job start  at " + st);
		System.out.println("This job finish at " + et);
		System.out.println("This job costs " + (eTime - sTime) / 1000 + " seconds.");
	}
}