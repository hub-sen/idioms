package com.shisen.idioms.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/11/6 17:54
 * </pre>
 */
public class Demo {

	@Test
	public void test_1() {

		Integer[] nums = {100,100,100,2,3,6,46};
		int i = find(nums);
		System.out.println("i = " + i);
	}

	private int find(Integer[] nums) {
		if (nums.length < 2) {
			return -1;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0, n = nums.length; i < n; i++) {
			map.put(nums[i], i);
		}

		Arrays.sort(nums, Comparator.reverseOrder());
		if (nums[0] >= (nums[1] << 1)) {
			return map.get(nums[0]);
		}

		return -1;
	}


}
