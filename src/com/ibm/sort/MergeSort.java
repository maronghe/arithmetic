package com.ibm.sort;

/**
 * MergeSort
 * @author Logan
 *
 */
public class MergeSort{
	
	/**
	 * merge sort arithmetic
	 * @param srcArray
	 * @return sorted array
	 */
	public static void mergeSort(int[] srcArray) {
		// 避免重复创建临时数组
		int[] tempArr = new int[srcArray.length];
		mergeSort(srcArray, 0, srcArray.length - 1, tempArr);
	}
	/**
	 * 
	 * @param srcArray
	 * @param start
	 * @param end
	 * @param tempArr
	 */
	private static void mergeSort(int[] srcArray, int start, int end, int[] tempArr) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(srcArray, start, mid, tempArr); // 左侧归并排序
			mergeSort(srcArray, mid + 1, end, tempArr);// 右侧归并排序
			merge(srcArray, start, mid, end, tempArr); // 合并当前的有序序列
		}
	}

	/**
	 *  合并当前有序序列
	 * @param srcArray
	 * @param start
	 * @param mid
	 * @param end
	 * @param tempArr
	 */
	private static void merge(int[] srcArray, int start, int mid, int end, int[] tempArr) {
		// 左序列指针
		int left = start;
		// 右序列指针
		int right = mid + 1;
		// 临时指针
		int temp = 0;
		// 当左指针小于右指针，逐一比较
		while(left <= mid && right <= end) {
			// 当左侧数据小于右侧数据
			if(srcArray[left] <= srcArray[right]) {
				tempArr[temp ++] = srcArray[left ++];
			}else {
				tempArr[temp ++] = srcArray[right ++];
			}
		}
		// 将剩余的左数组放入临时数组中
		while(left <= mid) {
			tempArr[temp ++] = srcArray[left ++];
		}
		// 将剩余的右数组放入临时数组中
		while(right <= end) {
			tempArr[temp ++] = srcArray[right ++];
		}
		temp = 0;
		// 将临时数组数据转移到原数组中
		while(start <= end) {
			srcArray[start ++] = tempArr[temp ++];
		}
		
	}
}