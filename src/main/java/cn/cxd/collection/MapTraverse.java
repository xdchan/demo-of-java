package cn.cxd.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapTraverse {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "songjiang");
		map.put(2, "lujunyi");
		map.put(3, "wuyong");
		map.put(4, "gongshunsheng");
		map.put(5, "guangsheng");
		map.put(6, "linchong");

		traverse1(map);
		traverse2(map);
		traverse3(map);
		traverse4(map);
		traverse5(map);
		traverse6(map);
		traverse7(map);
		traverse8(map);
	}

	/**
	 * 遍历Map的方式一 通过Map.keySet遍历key和value
	 */
	private static void traverse1(Map<Integer, String> map) {
		map.keySet().forEach(key -> System.out.println(key + "--->" + map.get(key)));
	}

	/**
	 * 遍历Map第二种 通过Map.entrySet使用Iterator遍历key和value
	 */
	private static void traverse2(Map<Integer, String> map) {
		map.entrySet().iterator()
				.forEachRemaining(item -> System.out.println(item.getKey() + "--->" + item.getValue()));
	}

	/**
	 * 遍历Map第三种 通过Map.entrySet遍历key和value，在大容量时推荐使用
	 */
	private static void traverse3(Map<Integer, String> map) {
		map.entrySet().forEach(entry -> System.out.println(entry.getKey() + "--->" + entry.getValue()));
	}

	/**
	 * 遍历Map第四种 通过Map.values()遍历所有的value，但不能遍历key
	 */
	private static void traverse4(Map<Integer, String> map) {
		map.values().forEach(System.out::println);
	}

	/**
	 * 遍历Map第五种 通过k,v遍历，Java8独有的
	 */
	private static void traverse5(Map<Integer, String> map) {
		map.forEach((k, v) -> System.out.println(k + "--->" + v));
	}

	/**
	 * 适用于大规模数据
	 * 
	 * @param map
	 */
	private static void traverse6(Map<Integer, String> map) {
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
	}

	private static void traverse7(Map<Integer, String> map) {
		for (Integer key : map.keySet()) {
			System.out.println("key = " + key);
		}

		for (String value : map.values()) {
			System.out.println("value = " + value);
		}
	}

	private static void traverse8(Map<Integer, String> map) {

		Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
	}
}
