package com.shisen.idioms.leetcode;


import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/19 15:39
 * </pre>
 */
public class Add {

	int[] args = {9, 9, 9};


	@Test
	public void tets_1() {

		int[] integers = plusOne(args);
		System.out.println("integers = " + Arrays.toString(integers));

	}


	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i]++;
				break;
			}
		}
		if (digits[0] == 0) {
			digits = new int[digits.length + 1];
			digits[0] = 1;
		}
		return digits;
	}


}
