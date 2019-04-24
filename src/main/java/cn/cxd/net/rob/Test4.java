package cn.cxd.net.rob;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {

	public static void main(String[] args) {

		String input = "<a href=\"/article/121268836\" target=\"_blank\" class=\"contentHerf\" onclick=\"_hmt.push(['_trackEvent','web-list-content','chick'])\">";
		String urlRegex = "/article/(\\d+)(\\s+)(target=)";

		Pattern pattern = Pattern.compile(urlRegex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			for (int i = 0; i <= matcher.groupCount(); i++) {
				System.out.println(matcher.group(i));
			}
		}
	}
}
