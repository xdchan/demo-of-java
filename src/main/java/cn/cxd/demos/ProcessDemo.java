package cn.cxd.demos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author cxd
 *
 */
public class ProcessDemo {

	public static void main(String[] args) throws Exception {

		BufferedReader br = null;
		Process pro = null;
		try {
			// pro = Runtime.getRuntime().exec("TASKLIST /NH /FO CSV /FI \"PID EQ \"");
			pro = Runtime.getRuntime().exec("cmd /c tasklist");
			br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			String line = null;

			System.out.println("All process");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("exeception ");
		}

		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unused")
	private static void killProcessByPid(String pid) throws Exception {

		Runtime.getRuntime().exec("taskkill /F /PID " + pid);
	}
}