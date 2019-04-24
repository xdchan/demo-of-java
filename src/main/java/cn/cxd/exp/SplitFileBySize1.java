package cn.cxd.exp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.Vector;

import cn.cxd.tools.FileTools;

/**
 * 方法仍然有问题
 * 
 * @author Tony
 *
 */

public class SplitFileBySize1 {

	public static void main(String[] args) throws Exception {

		String inPath = "D:/BaiduNetdiskDownload/招魂.rmvb";
		String destDir = "D:/blocks/";

		int blockLength = 128 * 1024 * 1024;
		System.out.println("开始分割文件--->" + System.currentTimeMillis());
		split(inPath, destDir, blockLength);
		System.out.println("分割完成开始合并--->" + System.currentTimeMillis());// 15183
		merge(destDir);
		System.out.println("合并完成--->" + System.currentTimeMillis());// 14681
	}

	private static void merge(String destDir) throws Exception {

		File[] files = new File(destDir).listFiles();

		OutputStream os = new FileOutputStream(new File(destDir + "海上钢琴师.rmvb"));

		Vector<InputStream> vector = new Vector<>();
		SequenceInputStream sis = null;
		for (int i = 0; i < files.length; i++) {
			vector.add(new FileInputStream(files[i]));
		}

		sis = new SequenceInputStream(vector.elements());
		byte[] bytes = new byte[1024];
		int len = -1;
		while ((-1) != (len = sis.read(bytes))) {
			os.write(bytes, 0, len);
		}

		os.flush();

		FileTools.close(sis, os);
	}

	private static void split(String inPath, String destDir, int blockLength) throws Exception {

		File inFile = new File(inPath);
		long len = inFile.length();
		int startPos = 0;
		int realSize = (int) (blockLength > len ? len : blockLength);// 判断块与文件的大小
		int count = (int) Math.ceil(len * 1.0 / blockLength);// 确定块的数量

		for (int i = 0; i < count; i++) {
			startPos = i * blockLength;
			if (i == count - 1) {
				realSize = (int) len;
			} else {
				realSize = blockLength;
				len -= realSize;
			}

			splitDetail(inFile, i, startPos, realSize);
		}

	}

	private static void splitDetail(File inFile, int i, int startPos, int realSize) throws Exception {

		File destFile = new File("D:/blocks/block-" + i);
		RandomAccessFile raf1 = new RandomAccessFile(inFile, "r");
		RandomAccessFile raf2 = new RandomAccessFile(destFile, "rw");

		raf1.seek(startPos);
		byte[] bytes = new byte[1024];
		int len = -1;
		while ((-1) != (len = raf1.read(bytes))) {
			if (realSize > len) {
				raf2.write(bytes, 0, len);
				realSize -= len;
			} else {
				raf2.write(bytes, 0, realSize);
				break;
			}
		}

		FileTools.close(raf2, raf1);
	}
}
