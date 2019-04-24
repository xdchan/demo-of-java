package cn.cxd.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 抢红包算法
 * 
 * @author Tony 首先将所有金额m换算成最小单位分：如1元=100分，4.23=423分
 *         然后在区间（0，m）上得到（n-1）个随机数，即将�?有金额随机划分成了n份�?�n为红包个数�??
 */
public class RedPack {

	public static void main(String[] args) {
		int peopleCount = 10;
		int totalMoney = 100;
		getRandomMoney(peopleCount, totalMoney);
	}

	private static void getRandomMoney(int peopleCount, int totalMoney) {

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < peopleCount - 1; i++) {
			int r = (int) (Math.random() * (totalMoney - 1) + 1);
			if (list.contains(r)) {
				i--;
			} else {
				list.add(r);
			}
		}
		list.add(0);
		list.add(totalMoney);
		Collections.sort(list);
		for (int j = 0; j < peopleCount; j++) {
			int get = list.get(j + 1) - list.get(j);
			System.out.println("�?" + (j + 1) + "个人抢到:" + get);
		}
	}
}
