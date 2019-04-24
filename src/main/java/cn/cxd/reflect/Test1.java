package cn.cxd.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		Class<?> class1 = null;

		try {
			class1 = Class.forName("cn.cxd.reflect.Person");
			// System.out.println(class1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// getObject();
		// getObjectMethod(class1);
		// getFileds(class1);
		// getConstructor(class1);
		demo();
	}

	public static void demo() {

		try {
			Class<?> clazz = Class.forName("cn.cxd.reflect.Person");

			// 通过反射API调用构造方法，构造对象
			Person p1 = (Person) clazz.newInstance();
			System.out.println(p1);// 调用了Person的无参数构造方法

			Constructor<?> person = clazz.getDeclaredConstructor(long.class, String.class);
			Person p2 = (Person) person.newInstance(101L, "mike");
			System.out.println(p2.getName());

			// 通过反射API调用普通方法
			Person p3 = (Person) clazz.newInstance();
			Method method1 = clazz.getDeclaredMethod("setName", String.class);
			method1.invoke(p3, "james");
			System.out.println(p3.getName());

			// 通过反射API操作属性
			Person p4 = (Person) clazz.newInstance();
			Field id = clazz.getDeclaredField("id");
			id.setAccessible(true);
			id.set(p4, 12345);
			System.out.println(p4.getId());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public static void getConstructor(Class<?> class1) {

		Constructor[] cons = class1.getDeclaredConstructors();// 获取全部构造器
		for (Constructor con : cons) {
			System.out.println(con);
		}

		Constructor c;
		try {
			c = class1.getConstructor(long.class, String.class);
			System.out.println(c);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}

	public static void getObject() {

		// 第一种方法 Class.forName
		try {
			Class<?> class1 = Class.forName("cn.cxd.reflect.Person");
			System.out.println(class1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 第二种方法
		Class<?> class2 = Person.class;
		System.out.println(class2);

		// 第三种方法
		Person person = new Person();
		Class<?> class3 = person.getClass();

		System.out.println(class2);
		System.out.println(class3);
	}

	public static void getObjectMethod(Class<?> clazz) {

		Method[] methods = clazz.getDeclaredMethods();

		for (Method method : methods) {
			System.out.println(method);
		}

	}

	public static void getFileds(Class<?> clazz) {

		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			System.out.println(field);
		}
	}
}
