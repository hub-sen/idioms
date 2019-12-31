package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 * Description  给你一个整数 n(1 <= n <= 10^5)，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * @author shishi
 * 2019/12/30 11:17
 * </pre>
 */
public class SubtractProductAndSum {
	private int n;
	private int result;

	@Before
	public void before() {
		n = 4421;
	}

	@After
	public void after() {
		System.out.println("result = " + result);
	}

	@Test
	public void test_1() {
		result = subtractProductAndSum(n);
	}

	public int subtractProductAndSum(int n) {
		int temp;
		int product = 1;
		int sum = 0;
		while (n != 0) {
			temp = n % 10;
			n = n / 10;
			product *= temp;
			sum += temp;
		}
		return product - sum;
	}
}
