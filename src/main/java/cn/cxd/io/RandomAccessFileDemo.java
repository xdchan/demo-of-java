package cn.cxd.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {

		split();

	}

	// 指定起始位置，读取剩余所有内容
	public static void fun1() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("dataset/words1.txt"), "r");
		raf.seek(2);
		byte[] bytes = new byte[1024];
		int len = 0;
		while ((-1) != (len = raf.read(bytes))) {
			System.out.println(new String(bytes, 0, len));
		}
		raf.close();
	}

	// 分块思想，指定读取某一块内容。
	public static void fun2() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("dataset/words1.txt"), "r");

		int startPos = 2;
		int actualSize = 1026;
		raf.seek(startPos);
		byte[] bytes = new byte[1024];
		int len = 0;
		while ((-1) != (len = raf.read(bytes))) {

			if (actualSize > len) {
				System.out.println(new String(bytes, 0, len));
				actualSize -= len;
			} else {
				System.out.println(new String(bytes, 0, actualSize));
				break;
			}
		}
		raf.close();
	}

	public static void split() throws IOException {

		File src = new File("D:/test.txt");
		long len = src.length();// 文件总长度
		int blockSize = 1024;// 每一块的大小
		int count = (int) Math.ceil(len * 1.0 / blockSize);// 共有多少块
		int startPos = 0;// 起始位置
		int actualSize = (int) (blockSize > len ? len : blockSize);// 实际大小

		for (int i = 0; i < count; i++) {
			startPos = i * blockSize;
			if (i == (count - 1)) {
				actualSize = (int) len;
			} else {
				actualSize = blockSize;
				len -= actualSize;
			}
			// System.out.println(i + "--->" +startPos + "--->" + actualSize);
			split1(startPos, actualSize);
		}
	}

	public static void split1(int beginPos, int actualSize) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("D:/test.txt"), "r");
		// 随机读取
		raf.seek(beginPos);
		// 读取
		// 3、操作 (分段读取)
		byte[] flush = new byte[1024]; // 缓冲容器
		int len = -1; // 接收长度
		while ((len = raf.read(flush)) != -1) {
			if (actualSize > len) { // 获取本次读取的所有内容
				System.out.println(new String(flush, 0, len));
				actualSize -= len;
			} else {
				System.out.println(new String(flush, 0, actualSize));
				break;
			}
		}

		raf.close();
	}
}
