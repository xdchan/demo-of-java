package cn.cxd.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo1 {

	public static void main(String[] args) throws Exception {

		String inPath = "D:/cqupt.txt";
		RandomAccessFile raf1 = new RandomAccessFile(inPath, "rw");

		FileChannel inChannel = raf1.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);

		@SuppressWarnings("unused")
		int len = 0;
		while (-1 != (len = inChannel.read(buf))) {
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.println((char) buf.get());
			}
			buf.clear();
			// len = inChannel.read(buf);
		}

		raf1.close();
	}
}
