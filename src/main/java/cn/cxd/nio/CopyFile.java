package cn.cxd.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import cn.cxd.tools.FileTools;

public class CopyFile {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		System.out.println(System.currentTimeMillis());

		String inPath = "D:/BaiduNetdiskDownload/海上钢琴师.rmvb";
		String outPath = "D:/blocks/海上钢琴师.rmvb";
		File srcFile = new File(inPath);
		File dstFile = new File(outPath);

		FileChannel srcFileChannel = new FileInputStream(srcFile).getChannel();
		FileChannel destFileChannel = new FileOutputStream(dstFile).getChannel();
		srcFileChannel.transferTo(0, srcFile.length(), destFileChannel);

		System.out.println(System.currentTimeMillis());

		FileTools.close(destFileChannel, srcFileChannel);
	}
}
