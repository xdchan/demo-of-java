package cn.cxd.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {

	public static void main(String[] args) throws UnknownHostException {
		// 获取本机的一些信息
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());

		// 根据域名获得netAddress对象
		addr = InetAddress.getByName("www.qq.com");
		System.out.println(addr.getHostAddress());// 获取腾讯的ip地址
		System.out.println(addr.getHostName());

		// netstat -ano | findstr "3306"
	}
}
