package cn.cxd.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {

	public static void main(String[] args) {

		String reg = "\\d{4,10}";
		String tar = "1971707473";

		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(tar);

		boolean out = m.matches();
		System.out.println(out);

	}
}
