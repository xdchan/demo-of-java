package cn.cxd.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {

		Queue<String> queue = new LinkedList<String>();
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		queue.offer("d");
		queue.offer("e");

		for (String e : queue) {
			System.out.print(e + ",");
		}
		System.out.println();
		// 返回队列中第一个元素并删除
		System.out.println("poll-->" + queue.poll());
		for (String e : queue) {
			System.out.print(e + ",");
		}

		// 当队列为空时 element() 抛出异常；peek() 不会奔溃，只会返回 null。

		System.out.println();
		// 返回队列中的第一个元素
		System.out.println("element-->" + queue.element());
		for (String e : queue) {
			System.out.print(e + ",");
		}

		System.out.println();
		// 返回队列中的第一个元素
		System.out.println("peek-->" + queue.peek());
		for (String e : queue) {
			System.out.print(e + ",");
		}
	}
}
