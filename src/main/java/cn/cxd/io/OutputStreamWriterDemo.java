package cn.cxd.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/**
 * 转换流，将字节转为字符。
 * 
 * @author Tony
 *
 */
public class OutputStreamWriterDemo {

	public static void main(String[] args) {

		rwInConsole();
		downloadNetSource();

	}

	private static void rwInConsole() {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			String msg = "";
			while (!"exit".equals(msg)) {
				msg = br.readLine();
				bw.write(msg);
				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 操作网络流，下载百度首页源代码，并指定字符集，不然会出现乱码。
	// new URL("https://www.baidu.com").openStream();--->打开网络流，返回的是字节流。
	private static void downloadNetSource() {

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new URL("https://www.baidu.com").openStream(), "UTF-8"));
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("dataset/baidu.txt"), "utf-8"));) {
			String info = null;
			while (null != (info = br.readLine())) {
				bw.write(info);
				bw.newLine();
			}
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
