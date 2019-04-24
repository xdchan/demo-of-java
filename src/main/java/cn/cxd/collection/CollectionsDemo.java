package cn.cxd.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

	public static void main(String[] args) {

		// List<Integer> list = Arrays.asList(9,3,1,5,7);
		List<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(3);
		list.add(1);
		list.add(5);
		list.add(7);

		System.out.println("-----------");
		list.stream().forEach(obj -> System.out.print(obj + ","));

		System.out.println();
		System.out.println("-----------");
		System.out.println("排序后，降序，默认是升序。");
		Collections.sort(list, (v1, v2) -> -(v1.compareTo(v2)));
		list.stream().forEach(obj -> System.out.print(obj + ","));

		System.out.println();
		System.out.println("-----------");
		System.out.println("求极值");
		int min = Collections.min(list);
		int max = Collections.max(list);
		System.out.println("max is " + max);
		System.out.println("min is " + min);

		System.out.println();
		System.out.println("-----------");
		System.out.println("通过二分查找求索引，若不存在返回-5。");
		int index = Collections.binarySearch(list, 5);
		System.out.println(index);

		System.out.println();
		System.out.println("-----------");
		System.out.println("shuffle");// 随机排列
		Collections.shuffle(list);
		System.out.println(list);

		System.out.println();
		System.out.println("-----------");
		System.out.println("reverse");// 逆序排列
		Collections.reverse(list);
		System.out.println(list);

	}

}
