package cn.cxd.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 数据流： 1、写出后读取 2、读取顺序与写入顺序保持一致
 * 
 * @author Tony
 *
 */
public class DataIOStreamDemo {

	public static void main(String[] args) throws IOException {

		// 写出
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bao));

		// 操作基本数据类型
		dos.writeUTF("重庆邮电大学");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('b');
		dos.flush();
		// 读取
		byte[] bytes = bao.toByteArray();
		System.out.println(bytes.length);// 27
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(bytes)));
		String info = dis.readUTF();
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char ch = dis.readChar();
		System.out.println(info + "," + age + "," + flag + "," + ch);
	}

}
