package cn.cxd.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 将数据保存文件并持久化
 * 
 * @author Tony
 *
 */
public class ObjectIODemo {

	public static void main(String[] args) {
		// 写文件--->序列化
		write();
		// 读文件--->反序列化
		read();
	}

	private static void read() {

		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("dataset/obj.res")));) {
			String info = ois.readUTF();
			int age = ois.readInt();
			boolean flag = ois.readBoolean();
			char ch = ois.readChar();
			Object str = ois.readObject();
			Object date = ois.readObject();
			System.out.println(info + "," + age + "," + flag + "," + ch);

			Object student = ois.readObject();
			if (str instanceof String) {
				String obj = (String) str;
				System.out.println(obj);
			}

			if (date instanceof Date) {
				Date obj = (Date) date;
				System.out.println(obj);
			}

			if (student instanceof Student) {
				Student obj = (Student) student;
				System.out.println(obj.getAge() + "," + obj.getName() + "," + obj.getSex());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void write() {

		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dataset/obj.res"));) {
			oos.writeUTF("重庆市南岸区");
			oos.writeInt(20);
			oos.writeBoolean(false);
			oos.writeChar('c');
			oos.writeObject("重庆邮电大学");
			oos.writeObject(new Date());
			Student stu = new Student(20, "mike", 'M');
			oos.writeObject(stu);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
