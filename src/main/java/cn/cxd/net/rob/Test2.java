package cn.cxd.net.rob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.cxd.tools.FileTools;

public class Test2 {

	public static void main(String[] args) throws Exception {

		String inPath = "D:/source1.html";
		File in = new File(inPath);

		BufferedReader br = new BufferedReader(new FileReader(in));

		String urlRegex = "/article/\\d+";
		Pattern pattern = Pattern.compile(urlRegex);

		// Matcher matcher = pattern.matcher(line);
		Map<String, Integer> map = new HashMap<>();
		String line = null;
		for (int i = 0; i < 2000; i++) {
			line = br.readLine();

			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				String key = matcher.group(0);
				if (map.containsKey(key)) {
					int counter = map.get(key);
					map.put(key, ++counter);
				} else {
					map.put(key, 1);
				}
			}
		}
		FileTools.close(br);

		map.forEach((k, v) -> {
			System.out.println(k + "--->" + v);
		});
	}
}
