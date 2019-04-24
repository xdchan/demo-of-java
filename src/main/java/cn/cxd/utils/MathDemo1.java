package cn.cxd.utils;

public class MathDemo1 {

	public static void main(String[] args) {

		// 取整相关操作
		System.out.println(Math.ceil(3.2));// 向上取整，其结果为4.0，类型为double。
		System.out.println(Math.floor(3.2));// 向下取整，其结果为3.0，类型为double。
		System.out.println(Math.round(3.2));// 四舍五入，其结果为3，类型为long。
		System.out.println(Math.round(3.8));// 四舍五入，其结果为4，类型为long。

		// 绝对值、开方、a的b次幂等
		System.out.println(Math.abs(-48));// 取绝对值，其结果为48。
		System.out.println(Math.sqrt(64));// 开方，其结果为8.0，类型为double。
		System.out.println(Math.pow(5, 2));// 求5的2次方（5^2），其结果为25.0，类型为double。
		System.out.println(Math.pow(2, 5));// 求2的5次方（2^5），其结果为32.0，类型为double。

		// 一些常量
		System.out.println(Math.PI);// pi的值，其结果为3.141592653589793，类型为double。
		System.out.println(Math.E);// E的值，其结果为2.718281828459045，类型为double。
		// 随机数
		System.out.println(Math.random());// 随机取[0,1)区间的一个数，类型为double。
	}
}
