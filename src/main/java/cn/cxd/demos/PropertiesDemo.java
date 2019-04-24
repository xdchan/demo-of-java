package cn.cxd.demos;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws Exception {

		Properties pro = new Properties();

		FileInputStream fis = new FileInputStream("demo.properties");
		pro.load(fis);

		String name = pro.getProperty("name");
		int age = Integer.parseInt(pro.getProperty("age"));
		String id = pro.getProperty("id");

		System.out.println(name + "," + age + "," + id);
	}
}