package cn.cxd.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		list.set(3, 200);
		list.add(2, 100);
		list.sort(Comparator.naturalOrder()); // 升序
		// list.sort(Comparator.reverseOrder()); //降序

		// System.out.println(list);
		//
		// System.out.println("list.indexOf(100):"+list.indexOf(100));
		// System.out.println("list.lastIndexOf(100):"+list.lastIndexOf(100));
		// System.out.println("list.lastElement():"+list.lastIndexOf(2));
		// System.out.println("size:"+list.size());
		// System.out.println("list 2 to 4:"+list.subList(1, 4));
		list.forEach(obj -> System.out.print(obj + ","));
	}
}
