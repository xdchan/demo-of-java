package cn.cxd.net.tcp.cs;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 创建客户端 1、使用Socket创建客户端+服务器的地址和端口 2、IO流的操作 3、释放资源
 * 
 * @author Tony
 *
 */
public class Client {

	public static void main(String[] args) throws Exception {

		System.out.println("-----client-----");
		Socket client = new Socket("localhost", 9999);
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String msg = "hello, I am client";
		dos.writeUTF(msg);
		dos.close();
		client.close();
	}

}
