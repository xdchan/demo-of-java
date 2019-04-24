package cn.cxd.io;

import java.io.UnsupportedEncodingException;

public class EncodeTest {

	public static void main(String[] args) throws UnsupportedEncodingException {

		String msg = "重庆邮电大学yddx";

		// 设置编码
		byte[] b1 = msg.getBytes();// 默认为工程的编码，本工程编码是utf-8
		System.out.println(b1.length);// 输出为22，因此在utf-8中，汉字为3个字节，英文字母为一个字节。

		byte[] b2 = msg.getBytes("GBK");
		System.out.println(b2.length);// 输出为16，因此在GBK中，汉字为2个字节，英文字母为一个字节。

		// 乱码问题：1、字节数不够。2、字符集不统一

		String str = new String(b1, 0, b1.length, "utf8");
		System.out.println(str);// 输出--->重庆邮电大学yddx--->正常

		String str2 = new String(b2, 0, b2.length, "utf8");
		System.out.println(str2);// 输出--->�����ʵ��ѧyddx--->乱码

		String str3 = new String(b1, 0, b1.length - 5, "utf8");
		System.out.println(str3);// 输出--->重庆邮电大�--->乱码
	}

}
