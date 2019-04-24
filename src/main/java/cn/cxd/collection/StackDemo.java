package cn.cxd.collection;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println(stack.peek());

		for (Integer e : stack) {
			System.out.print(e + ",");
		}
		System.out.println();
		stack.pop();
		for (Integer e : stack) {
			System.out.print(e + ",");
		}
	}

}
