package cn.cxd.tools;

import java.io.Closeable;
import java.io.IOException;

public class FileTools {

	public static void close(Closeable... close) {

		for (Closeable io : close) {
			if (null != io) {
				try {
					io.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
