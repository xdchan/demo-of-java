package cn.cxd.algorithm;
/**
 * 二分查找算法的两种实现方式
 * @author Tony
 *
 */
public class BinarySearch {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
		int target = 8;
		int index = getLocation(arr, target);
		System.out.println("位置： " + (index + 1));
	}

	private static int getLocation(int[] arr, int target) {

		int index = binarySearch(arr, target, 0, arr.length - 1);

		return index;
	}

	// 使用递归实现
	public static int binarySearch(int[] arr, int target, int low, int high) {

		int mid = (low + high) / 2;
		if (arr[mid] == target) {
			return mid;
		} else if (arr[mid] > target) {
			return binarySearch(arr, target, low, mid);
		} else {
			return binarySearch(arr, target, mid, high);
		}
	}

	// 使用while循环实现
	public static int binarySearch1(int[] arr, int target, int low, int high) {

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] > target) {
				high = mid - 1;
			} else if (arr[mid] < target) {
				low = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;

	}

}
