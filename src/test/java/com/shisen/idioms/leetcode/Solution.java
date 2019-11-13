package com.shisen.idioms.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/11/6 10:58
 * </pre>
 */
public class Solution {

	@Test
	public void test_1() {
		int[] nums = {-1, -1, -1, -1, -1, 0};
		int index = pivotIndex_2(nums);
		System.out.println("index = " + index);
	}

	private int pivotIndex_1(int[] nums) {
		for (int i = 0, length = nums.length; i < length; i++) {
			if (Arrays.stream(nums, 0, i).sum() == Arrays.stream(nums, i + 1, length).sum()) {
				return i;
			}
		}
		return -1;
	}

	private int pivotIndex_2(int[] nums) {

		int sumL = 0, sumR = 0;

		for (int num : nums) {
			sumR += num;
		}

		for (int i = 0, n = nums.length; i < n; i++) {
			if (sumL == sumR - sumL - nums[i]) {
				return i;
			}
			sumL += nums[i];
		}
		return -1;
	}
}
