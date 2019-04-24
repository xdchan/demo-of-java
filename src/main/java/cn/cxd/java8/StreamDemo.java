package cn.cxd.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		List<Student> stu = Arrays.asList(new Student("001", "apple", 23), new Student("002", "bank", 21),
				new Student("003", "car", 18), new Student("004", "dog", 20), new Student("005", "ear", 19),
				new Student("006", "file", 26), new Student("002", "bank", 21), new Student("003", "car", 18));

		// filter(stu);
		// limit(stu);
		// skip(stu);
		// distinct(stu);
		// map(stu);
		// sorted(stu);
		// flatMap(stu);

	}

	/*
	 * 筛选和切片 接收Lambda，从流中排除某些元素。 此处过滤出年龄>20的学生
	 */
	public static void filter(List<Student> stu) {

		// 1.创建stu.stream()
		// 2.流的中间操作
		Stream<Student> stream = stu.stream().filter(student -> {
			return student.getAge() > 20;
		});
		// 3.流终止
		stream.forEach(System.out::println);
		stream.close();
	}

	/*
	 * 截断流，使其元素不超过给定数量
	 */
	public static void limit(List<Student> stu) {

		stu.stream().limit(5).forEach(System.out::println);
	}

	/*
	 * skip(long n)：跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit（n）互补。
	 */
	public static void skip(List<Student> stu) {
		stu.stream().skip(5).forEach(System.out::println);
	}

	/*
	 * 筛选，通过流所生成元素的hashCode()和equals()去除重复的元素
	 */
	public static void distinct(List<Student> stu) {
		@SuppressWarnings("unused")
		List<Student> collect = stu.stream().distinct().collect(Collectors.toList());

		stu.stream().map(e -> e.getName()).distinct().forEach(System.out::println);
	}

	// map
	/*
	 * 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
	 */
	public static void map(List<Student> stu) {
		stu.stream().map(e -> e.getName()).forEach(System.out::println);
	}

	/*
	 * 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
	 */
	public static void sorted(List<Student> stu) {
		stu.stream().sorted((x, y) -> {
			if (x.getAge() == y.getAge()) {
				return x.getName().compareTo(y.getName());
			} else {
				return Integer.compare(x.getAge(), y.getAge());
			}
		}).forEach(System.out::println);
	}

	public static void flatMap(List<Student> stu) {
	}
}
