package cn.cxd.demos;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Demo {

	public static void main(String args[]) {

		String md5User = DigestUtils.md5Hex("123456");
		System.out.println(md5User);

		// String path = "D:/BaiduNetdiskDownload/海上钢琴师.rmvb";
		// String path = "D:/blocks/海上钢琴师.rmvb";

		// String path = "D:/BaiduNetdiskDownload/phone.txt";
		// String path = "D:/blocks/海上钢琴师.rmvb";

		// 0fe80597afbf86d496fe753671a06619
		// 263aa277b2d05a799621a8c11e0ca0b8

		// try {
		// String res = DigestUtils.md5Hex(new FileInputStream(path));
		// System.out.println(res);
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

	}
}