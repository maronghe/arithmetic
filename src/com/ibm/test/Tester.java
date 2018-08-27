package com.ibm.test;

import java.util.Arrays;

import com.ibm.utils.SortUtils;

/**
 * Test class
 * @author Logan
 *
 */
public class Tester {
	public static void main(String[] args) {
		// 测试数据
		int[] arr = {1,2,22,4,5,2,4,2,3,51,-2,34,-12,-12};
		SortUtils.mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
