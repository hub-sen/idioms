package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/1/9 14:12
 * </pre>
 */
public class BalancedStringSplit {
	private String str;

	private int result;

	@Before
	public void before() {
		str = "RLLRRRLLLR";
	}

	@After
	public void after() {
		System.out.println("result = " + result);
	}

	@Test
	public void test_1() {
		result = balancedStringSplit(str);
	}

	public int balancedStringSplit(String s) {
		int temp = 0;
		for (int i = 0, length = s.length(); i < length; i++) {
			if (s.startsWith("LR", i) || s.startsWith("RL", i)) {
				temp++;
				i++;
			}

		}
		return temp;
	}


}
