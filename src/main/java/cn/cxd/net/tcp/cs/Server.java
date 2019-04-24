package cn.cxd.net.tcp.cs;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务器 1、指定端口，使用ServerSocket创建服务器 2、阻塞式等待连接accept 3、IO流相关操作 4、释放资源
 * 
 * @author Tony
 *
 */
public class Server {

	public static void main(String[] args) throws Exception {

		System.out.println("-----server-----");
		@SuppressWarnings("resource")
		ServerSocket server = new ServerSocket(9999);
		Socket client = server.accept();
		System.out.println("一个客户端连接上了");

		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		System.out.println("收到的消息为：" + msg);
		dis.close();
		client.close();
		// server.close();
	}

}
