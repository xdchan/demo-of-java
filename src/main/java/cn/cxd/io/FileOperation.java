package cn.cxd.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;

public class FileOperation {

	public static void main(String[] args) {

		// String txtInPath = "D:/dev/test/gx.txt";
		// String binInPath = "D:/dev/test/China.jpg";
		//
		// String txtOutPath = "D:/dev/test/gx-bak.txt";
		// String binOutPath = "D:/dev/test/China-bak.jpg";

		/**
		 * copyFile1和copyFile1使用字符流进行操作
		 */
		// copyFile1(txtInPath, txtOutPath);
		// copyFile2(txtInPath, txtOutPath);
		// copyFile3(txtInPath, txtOutPath);
		// copyFile4(binInPath, binOutPath);
		// copyFile5(binInPath, binOutPath);

		// moveFile1(binInPath, binOutPath);
		// moveFile2(binInPath, binOutPath);
	}

	/**
	 * 使用Java提供的renameTo(destFile)函数进行操作，但这个函数容易抽风，不稳定，慎用。
	 * 
	 * @param binInPath
	 * @param binOutPath
	 */
	public static void moveFile2(String binInPath, String binOutPath) {

		File inFile = new File(binInPath);
		inFile.renameTo(new File(binOutPath));
	}

	/**
	 * 使用apache common io进行移动操作。
	 * 
	 * @param binInPath
	 * @param binOutPath
	 */
	public static void moveFile1(String binInPath, String binOutPath) {

		try {
			FileUtils.moveFile(new File(binInPath), new File(binOutPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用apache common io进行复制操作。
	 * 
	 * @param binInPath
	 * @param binOutPath
	 */
	public static void copyFile5(String binInPath, String binOutPath) {

		try {
			FileUtils.copyFile(new File(binInPath), new File(binOutPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用BufferedInputStream和BufferedOutputStream进行操作，即缓存的字节流。
	 * 
	 * @param binInPath
	 * @param binOutPath
	 */
	public static void copyFile4(String binInPath, String binOutPath) {

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(binInPath)));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(binOutPath)))) {
			byte[] bytes = new byte[1024];
			int len = 0;
			while ((-1) != (len = bis.read(bytes))) {
				bos.write(bytes, 0, len);
			}
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用FileInputStream和FileOutputStream进行操作，即使用字节流进行操作。
	 * 
	 * @param txtInPath
	 * @param txtOutPath
	 */
	public static void copyFile3(String inPath, String outPath) {

		try (InputStream in = new FileInputStream(new File(inPath));
				OutputStream out = new FileOutputStream(new File(outPath))) {
			byte[] bytes = new byte[1024];
			int len = 0;
			while ((-1) != (len = in.read(bytes))) {
				out.write(bytes, 0, len);
			}
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用BufferedReader和BufferedWriter完成复制功能，即使用带缓存的字符流操作，可以提高效率。
	 * 
	 * @param txtInPath
	 * @param txtOutPath
	 */
	public static void copyFile2(String txtInPath, String txtOutPath) {

		try (BufferedReader br = new BufferedReader(new FileReader(new File(txtInPath)));
				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(txtOutPath)))) {
			String line = "";
			while (null != (line = br.readLine())) {
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 使用FileReader和FileWriter完成复制功能，即使用字符操作。
	 * 
	 * @param txtInPath
	 * @param txtOutPath
	 */
	public static void copyFile1(String txtInPath, String txtOutPath) {

		try (FileReader fr = new FileReader(new File(txtInPath));
				FileWriter fw = new FileWriter(new File(txtOutPath))) {
			char[] ch = new char[10];
			int len = 0;
			while ((-1) != (len = fr.read(ch))) {
				fw.write(ch, 0, len);
			}
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
