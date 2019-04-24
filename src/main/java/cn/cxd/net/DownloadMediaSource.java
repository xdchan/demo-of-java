package cn.cxd.net;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadMediaSource {

	public static void main(String[] args) {

		String url = "https://www.baidu.com/img/bd_logo1.png";

		// String url =
		// "http://mvideo.spriteapp.cn/video/2018/0402/5ac225b674cd2_wpcco.mp4";
		byte[] btImg = getImageFromNetByUrl(url);
		if (null != btImg && btImg.length > 0) {
			System.out.println("读取到：" + btImg.length + " 字节");
			String fileName = "5ac225b674cd2_wpcco.mp4";
			writeImageToDisk(btImg, fileName);
		} else {
			System.out.println("没有从该连接获得内容");
		}
	}

	private static void writeImageToDisk(byte[] img, String fileName) {

		try {
			File file = new File("E:\\" + fileName);
			FileOutputStream fops = new FileOutputStream(file);
			fops.write(img);
			fops.flush();
			fops.close();
			System.out.println("图片已经写入到C盘");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static byte[] getImageFromNetByUrl(String strUrl) {

		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			InputStream inStream = conn.getInputStream();// 通过输入流获取图片数据
			byte[] btImg = readInputStream(inStream);// 得到图片的二进制数据
			return btImg;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		if (inStream != null) {
			inStream.close();
		}
		return outStream.toByteArray();
	}
}
