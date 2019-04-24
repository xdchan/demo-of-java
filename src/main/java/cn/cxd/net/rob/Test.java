package cn.cxd.net.rob;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.cxd.tools.FileTools;

public class Test {

	public static void main(String[] args) throws Exception {

		// String info = "<span
		// class=\"big-begin\">豆豆</span>今天早晨来到店里，一脸便秘的表情。我就问他:大兄弟这是咋了，让人给煮了？<br/>豆豆说:别提了，这几天有点感冒，晚饭后基本都在家看电视，由于平时习惯了晚睡，都要看到凌晨。昨晚像往常一样躺在床上看电视。<br/>媳妇说她给我买了感冒药，然后递了一颗，说到：“老公，该吃药了。”我一口吞下后没一会就困意十足......早上醒来一看手机短信，11.11日XX银行卡消费了两万多...<br/>这臭婆娘居然学会下药了，这次是安眠药，谁知道以后会不会下别的药，我可不想做武大郎啊";

		// String inPath = "D:/detail.html";
		// BufferedReader br = new BufferedReader(new FileReader(new File(inPath)));
		// String textRegex = "</span>" + "(.+)";
		// Pattern pat = Pattern.compile(textRegex);
		// String info = null;
		// for(int i=0; i<200; i++) {
		// info = br.readLine();
		// if(null != info && info.contains("big-begin")) {
		// Matcher matcher = pat.matcher(info);
		// if(matcher.find()) {
		// for(int j=0; j<=matcher.groupCount(); j++) {
		// System.out.println(matcher.group(j));
		// }
		// }
		// }
		// }

		String strUrl = "https://www.qiushibaike.com/article/121267715";
		URL url = new URL(strUrl);
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String textRegex = "class=\"big-begin\">" + "(.+)";
		Pattern pat = Pattern.compile(textRegex);

		String line = null;
		for (int i = 0; i < 300; i++) {

			line = br.readLine();

			if (null != line && line.startsWith("<span class=\"big-begin\">")) {
				Matcher matcher = pat.matcher(line);
				if (matcher.find()) {
					System.out.println(matcher.group(1));
					// for(int j=0; j<=matcher.groupCount(); j++) {
					// System.out.println(matcher.group(j));
					// }
				}
			}
		}

		FileTools.close(br);

	}
}
