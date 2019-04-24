package cn.cxd.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class MergeFileByNio {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		long st = System.currentTimeMillis();
		File[] files = new File("D:/exp/dataset/").listFiles();
		FileChannel dstFile = new FileOutputStream(new File("D:/exp/all.txt")).getChannel();
		FileChannel inFileChannel = null;
		for (File file : files) {
			inFileChannel = new FileInputStream(file).getChannel();
			inFileChannel.transferTo(0, inFileChannel.size(), dstFile);
			inFileChannel.close();
		}
		dstFile.close();
		long et = System.currentTimeMillis();
		System.out.println((et - st) / 1000);
	}
}
