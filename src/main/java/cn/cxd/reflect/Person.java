package cn.cxd.reflect;

public class Person {

	private long id;

	private String name;

	public int age;

	// 构造函数1
	public Person() {

	}

	// 构造函数2
	public Person(long id) {
		this.id = id;
	}

	// 构造函数3
	public Person(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 静态方法
	 */
	public static void update() {

	}
}
