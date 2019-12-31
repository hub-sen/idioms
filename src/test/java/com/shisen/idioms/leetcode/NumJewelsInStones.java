package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 * Description  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * @author shishi
 * 2019/12/30 11:03
 * </pre>
 */
public class NumJewelsInStones {
	private String J;
	private String S;
	private int result;

	@Before
	public void before() {
		J = "z";
		S = "ZZ";
	}

	@After
	public void after() {
		System.out.println("J = " + J);
		System.out.println("S = " + S);
		System.out.println("result = " + result);
	}

	@Test
	public void test_1() {
		result = numJewelsInStones(J, S);
	}

	public int numJewelsInStones(String J, String S) {
		int temp = 0;
		for (char c : S.toCharArray()) {
			if (J.indexOf(c) != -1) {
				temp++;
			}
		}
		return temp;
	}

}
