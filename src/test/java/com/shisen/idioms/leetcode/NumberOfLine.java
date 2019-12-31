package com.shisen.idioms.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/27 14:20
 * </pre>
 */
public class NumberOfLine {
	private int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
	private String S = "abcdefghijklmnopqrstuvwxyz";


	@Test
	public void test_1() {
		int[] ints = numberOfLines(widths, S);
		System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
	}

	public int[] numberOfLines(int[] widths, String S) {
		int sum = 100;
		int line = 1;
		int temp;
		for (char c: S.toCharArray()){
			temp = widths[c - 'a'];
			if (sum < temp) {
				line++;
				sum = 100;
			}
			sum -= temp;
		}
		return new int[]{line, 100 - sum};
	}


}
