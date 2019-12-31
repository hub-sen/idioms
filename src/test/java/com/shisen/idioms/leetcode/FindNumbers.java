package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/27 15:20
 * </pre>
 */
public class FindNumbers {

	private int nums[] = {12, 345, 2, 6, 7896};

	private int result;

	@After
	public void after() {
		System.out.println("result = " + result);
	}

	@Test
	public void test_1() {
		result = findNumbers_2(nums);
	}

	public int findNumbers_2(int[] nums) {
		int ans = 0;
		for (int num : nums) {
			if ((int) (Math.log10(num) + 1) % 2 == 0) {
				++ans;
			}
		}
		return ans;
	}
}
