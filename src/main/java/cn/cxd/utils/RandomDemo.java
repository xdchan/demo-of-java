package cn.cxd.utils;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {

		Random rand = new Random();
		// 随机生成[0,1)之间的double类型的数据
		System.out.println(rand.nextDouble());
		// 随机生成一个int范围内的整数
		System.out.println(rand.nextInt());
		// 随机生成[0,10)之间的int类型的数据
		System.out.println(rand.nextInt(10));
		// 随机生成[0,1)之间的float类型的数据
		System.out.println(rand.nextFloat());
		// 随机生成true或者false
		System.out.println(rand.nextBoolean());
		// 随机生成[20,30)直接的int类型的数据
		System.out.println(rand.nextInt(10) + 10);
	}
}
