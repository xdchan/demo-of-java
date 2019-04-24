package cn.cxd.reg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class WebSpiderDemo1 {

	public static void main(String[] args) {

		String url = "https://www.163.com/";
		String charset = "gbk";
		String content = getContentByUrl(url, charset);
		System.out.println(content);
	}

	private static String getContentByUrl(String strUrl, String charset) {

		StringBuilder sb = new StringBuilder();
		try {

			URL url = new URL(strUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(charset)));

			String line = null;

			while ((null) != br.readLine()) {
				sb.append(line);
			}

			if (null != br) {
				br.close();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}
}
