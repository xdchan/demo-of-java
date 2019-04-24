package cn.cxd.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import net.sf.json.JSONObject;

public class TelLocation {

	public static void main(String[] args) throws Exception {

		String str = calcMobileCity("17723150146");
		System.out.println(str);
	}

	public static String calcMobileCity(String mobileNumber) throws Exception {

		String urlString = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + mobileNumber;
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		InputStream in = null;
		URL url = new URL(urlString);
		String location = null;
		String line = null;
		try {
			in = url.openStream();
			br = new BufferedReader(new InputStreamReader(in, "gb2312"));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			String objectStr = sb.toString().split("\\=")[1];
			JSONObject jsonObject2 = JSONObject.fromObject(objectStr);
			location = jsonObject2.getString("carrier");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
			if (in != null) {
				in.close();
			}
		}

		return location;
	}

}
