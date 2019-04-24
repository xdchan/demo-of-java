package cn.cxd.exp;

public class BigNumberAdd {

	public static void main(String[] args) {

		String str1 = "123456789123456789123456789";
		String str2 = "123456789123456789123456789";

		String res = null;

		if (str2.length() >= str2.length()) {
			res = add(str1, str2);
		} else {
			res = add(str2, str1);
		}

		System.out.println(res);

	}

	private static String add(String str1, String str2) {

		String res = null;

		int sub = str1.length() - str2.length();
		String str1Tmp = reverseString(str1);
		String str2Tmp = reverseString(str2);
		for (int i = 0; i < sub; i++) {
			str2Tmp += "0";
		}

		res = strAdd(str1Tmp + "0", str2Tmp + "0");

		return res;
	}

	private static String strAdd(String str1, String str2) {

		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		StringBuilder tmp = new StringBuilder();

		int quo = 0;

		for (int i = 0; i < ch1.length; i++) {

			int v1 = Integer.parseInt(ch1[i] + "");
			int v2 = Integer.parseInt(ch2[i] + "");

			int value = v1 + v2;

			int mod = (value + quo) % 10;
			tmp.append(mod);
			quo = (value + 1) / 10;

		}

		String res = tmp.toString();
		if (res.endsWith("0")) {
			res = res.substring(0, res.length() - 1);
		}
		return reverseString(res);
	}

	private static String reverseString(String str) {

		StringBuilder sb = new StringBuilder();

		char[] ch = str.toCharArray();

		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(ch[i]);
		}

		return sb.toString();
	}

}
