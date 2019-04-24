package cn.cxd.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayIOStreamDemo {

	public static void main(String[] args) {

		input();
		output();
	}

	private static void input() {

		byte[] bytes = "If you miss the train I am on,".getBytes();
		try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes)) {
			byte[] buffer = new byte[10];
			int len = 0;
			while ((-1) != (len = bis.read(buffer))) {
				String str = new String(buffer, 0, len);
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void output() {

		String info = "You will know that I am gone.";
		byte[] dst = null;
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
			byte[] bytes = info.getBytes();
			bos.write(bytes, 0, bytes.length);
			bos.flush();
			dst = bos.toByteArray();
			System.out.println(new String(dst, 0, dst.length));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
