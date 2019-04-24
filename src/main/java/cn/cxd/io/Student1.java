package cn.cxd.io;

import java.io.Serializable;

public class Student1 implements Serializable {

	private static final long serialVersionUID = 1L;
	int id;
	String name;
	char gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}

	public Student1(int id, String name, char gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public Student1() {
		super();
	}

	public void show() {

		String info = "Student [id=" + id + ", name=" + name + ", gender=" + gender + "]";
		System.out.println(info);
	}

}
