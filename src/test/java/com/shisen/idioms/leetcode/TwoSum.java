package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

/**
 * <pre>
 * Description  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @author shishi
 * 2020/1/18 11:30
 * </pre>
 */
public class TwoSum {

	private int nums[] = {2, 7, 11, 15};
	private int target = 9;
	private int result[];

	@After
	public void after() {
		Optional.ofNullable(result).ifPresent(temp-> System.out.println(Arrays.toString(temp)));
	}

	@Test
	public void test_1() {
		result = twoSum(nums, target);
	}

	private int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> tempMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (tempMap.containsKey(complement)) {
				return new int[]{i, tempMap.get(complement)};
			}
			tempMap.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution");
	}
}
