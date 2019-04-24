package cn.cxd.io;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {

	int age;
	String name;
	transient char sex;// 该属性不需要序列化

	public Student(int age, String name, char sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}
}
