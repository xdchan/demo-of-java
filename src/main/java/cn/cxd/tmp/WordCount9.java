package cn.cxd.tmp;

public class WordCount9 {

	public static void main(String[] args) {

		int n = 1000000000;
		int counter = 0;
		for (int i = 0; i <= n; i++) {
			String tmp = i + "";
			char[] ch = tmp.toCharArray();
			for (int j = 0; j < ch.length; j++) {
				// char c = tmp.charAt(j);
				char c = ch[j];
				if (c == '9') {
					++counter;
				}
			}
		}
		System.out.println(counter);
	}
}
