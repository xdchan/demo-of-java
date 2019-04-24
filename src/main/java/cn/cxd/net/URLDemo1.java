package cn.cxd.net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo1 {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://www.baidu.com/");

		System.out.println("协议：" + url.getProtocol());
		System.out.println("域名ip：" + url.getHost());
		System.out.println("主机：" + url.getFile());
		System.out.println("端口：" + url.getPort());
	}
}
