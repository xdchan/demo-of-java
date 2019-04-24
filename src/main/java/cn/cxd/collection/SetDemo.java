package cn.cxd.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {

		int[] array1 = { 11, 22, 33, 44, 55, 66, 55, 44, 33, 22 };
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < array1.length; i++) {
			set.add(array1[i]);
		}

		Iterator<Integer> it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
