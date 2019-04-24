package cn.cxd.reflect;

import java.lang.reflect.Field;

public class Test2 {

	public static void main(String[] args) {

		test1(Person.class);
	}

	private static void test1(Class<?> clazz) {

		Field[] fields = clazz.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			String type = fields[i].getType().getName();
			String valueName = fields[i].getName();
			System.out.println(type + "-----" + valueName);
		}
	}
}
