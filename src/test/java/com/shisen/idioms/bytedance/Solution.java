package com.shisen.idioms.bytedance;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

	@Test
	public void test_1() {
		int[] a = {6, 0, 0, 1, 2, 3, 4, 5, 2, 6};
		int[] ints = twoSum(a, 6);
		System.out.println("ints = " + Arrays.toString(ints));

	}

	private int[] twoSum(int[] nums, int target) {
		int[] indexs = new int[2];

		// 建立k-v ，一一对应的哈希表
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hash.containsKey(nums[i])) {
				indexs[0] = hash.get(nums[i]);
				indexs[1] = i;
				return indexs;
			}
			// 将数据存入 key为补数 ，value为下标
			hash.put(target - nums[i], i);
		}
		return indexs;
	}
}