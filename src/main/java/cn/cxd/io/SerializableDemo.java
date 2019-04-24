package cn.cxd.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author cxd
 *
 */
public class SerializableDemo {

	public static void main(String[] args) {

		List<Student1> list = new ArrayList<Student1>();
		Student1 st1 = new Student1(0001, "songjiang", '男');
		Student1 st2 = new Student1(0002, "muyecha", '女');
		Student1 st3 = new Student1(0003, "linchong", '男');

		list.add(st1);
		list.add(st2);
		list.add(st3);
		readObject();
		writeObject(list);

	}

	private static void writeObject(List<Student1> list) {
		File file = new File("student.dat");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 序列化集合输出流，OutputStream+FileOutputStream
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			System.out.println("序列化成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	private static void readObject() {
		File file = new File("student.dat");
		// 反序列化集合输出流，ObjectInputStream+FileInputStream
		ObjectInputStream ois = null;
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			@SuppressWarnings("unchecked")
			List<Student1> list = (List<Student1>) ois.readObject();
			list.forEach(obj -> System.out.println(obj));
		} catch (Exception e) {
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
