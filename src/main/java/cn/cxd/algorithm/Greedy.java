package cn.cxd.algorithm;

/**
 * 贪心算法
 * @author Tony
 *
 */
public class Greedy {

	public static void main(String[] args) {
		int[] values = { 1, 2, 5, 10, 20, 50, 100 };
		int[] counts = { 3, 1, 2, 1, 1, 3, 5 };
		int allMoney = 442;
		int[] res = getRes(allMoney, values, counts);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	private static int[] getRes(int allMoney, int[] values, int[] counts) {

		int res[] = new int[values.length];
		for (int i = values.length - 1; i >= 0; i--) {
			int c = Math.min(allMoney / values[i], counts[i]);
			allMoney -= (c * values[i]);
			res[i] = c;
		}
		return res;
	}
}
