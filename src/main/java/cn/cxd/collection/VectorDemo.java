package cn.cxd.collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {

		Vector<Integer> vec = new Vector<Integer>();
		vec.add(1);
		vec.add(2);
		vec.add(3);
		vec.add(4);
		vec.add(5);

		for (Integer e : vec) {
			System.out.print(e + ",");
		}

		vec.set(0, 100);
		vec.add(2, 300);

		System.out.println();
		Iterator<Integer> it = vec.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ",");
		}

		System.out.println();

		System.out.println("vec:" + vec);
		System.out.println("vec.indexOf(100):" + vec.indexOf(100));
		System.out.println("vec.lastIndexOf(100):" + vec.lastIndexOf(100));
		System.out.println("vec.firstElement():" + vec.firstElement());
		System.out.println("vec.elementAt(2):" + vec.elementAt(2));
		System.out.println("vec.lastElement():" + vec.lastElement());
		System.out.println("size:" + vec.size());
		System.out.println("capacity:" + vec.capacity());
		System.out.println("vec 2 to 4:" + vec.subList(1, 4));
	}
}
