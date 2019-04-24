package cn.cxd.net.rob;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

import cn.cxd.tools.FileTools;

public class GetUrlToFile {

	public static void main(String[] args) throws Exception {

		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D:/source1.html")));
		URL url = new URL("https://www.qiushibaike.com/text/page/1/");
		// HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// conn.setRequestMethod("GET");
		// conn.setRequestProperty("user-agent",
		// "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like
		// Gecko) Chrome/70.0.3538.77 Safari/537.36");
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(conn.getInputStream(), "UTF-8"));

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

		String line = null;
		for (int i = 0; i < 3000; i++) {
			line = br.readLine();
			if (null != line) {
				bw.write(line);
				bw.newLine();
			} else {
				bw.write(" ");
				bw.newLine();
			}
		}
		bw.flush();
		FileTools.close(bw, br);
	}

}
