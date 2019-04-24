package cn.cxd.str;

public class StringTest {

	public static void main(String[] args) {

		long st1 = System.currentTimeMillis();
		long sm1 = Runtime.getRuntime().freeMemory();
		@SuppressWarnings("unused")
		String str1 = "";
		for (int i = 0; i < 10000; i++) {
			str1 += i;
		}
		long et1 = System.currentTimeMillis();
		long em1 = Runtime.getRuntime().freeMemory();
		System.out.println("String共耗时" + (et1 - st1) + "毫秒");// 240
		System.out.println("String共耗内存" + (em1 - sm1));// 10898496

		long st2 = System.currentTimeMillis();
		long sm2 = Runtime.getRuntime().freeMemory();
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < 10000; i++) {
			sb1.append(i);
		}
		long et2 = System.currentTimeMillis();
		long em2 = Runtime.getRuntime().freeMemory();
		System.out.println("StringBuffer共耗时" + (et2 - st2) + "毫秒");// 2
		System.out.println("StringBuffer共耗内存" + (em2 - sm2));// 0

		long st3 = System.currentTimeMillis();
		long sm3 = Runtime.getRuntime().freeMemory();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			sb2.append(i);
		}
		long et3 = System.currentTimeMillis();
		long em3 = Runtime.getRuntime().freeMemory();
		System.out.println("StringBuilder共耗时" + (et3 - st3) + "毫秒");// 1
		System.out.println("StringBuilder共耗内存" + (em3 - sm3));// 0

	}

}
