package cn.cxd.net.rob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import cn.cxd.tools.FileTools;

public class Test3 {

	public static void main(String[] args) throws Exception {
		String inPath = "D:/source1.html";
		File in = new File(inPath);

		BufferedReader br = new BufferedReader(new FileReader(in));
		String line = null;
		for (int i = 0; i < 2000; i++) {
			line = br.readLine();
			if (line.startsWith("<a href=\"/article")) {
				System.out.println(line);
			}
		}

		FileTools.close(br);
	}
}
