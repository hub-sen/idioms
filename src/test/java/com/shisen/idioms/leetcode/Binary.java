package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/27 11:11
 * </pre>
 */
public class Binary {

	private String a;

	private String b;

	private String result;

	@Before
	public void before() {
		a = "1010111111111111111111111111111111111111";
		b = "1011111111111111111111111111111111111111";
	}

	@After
	public void after() {
		System.out.println(result);
	}

	@Test
	public void test_1() {
		 result = addBinary(a, b);
		//result = add(a, b);
	}

	private String addBinary(String a, String b) {
		//判断二进制数长度,以较长数为基础,将较短数逐位加到较长数上
		var aLength = a.length();
		var bLength = b.length();

		char[] str;//较长数
		int length;//较长数长度
		char[] addStr;//较短数
		int addLength;//较短数长度

		if (aLength > bLength) {
			length = aLength;
			str = a.toCharArray();
			addLength = bLength;
			addStr = b.toCharArray();
		} else {
			length = bLength;
			str = b.toCharArray();
			addLength = aLength;
			addStr = a.toCharArray();
		}

		// 将较短数逐位加到较长数上
		for (int i = addLength - 1; i >= 0; i--) {
			if (addStr[i] == '0') {
				continue;
			}
			for (int j = length - addLength + i; j >= 0; j--) {
				if (str[j] != '1') {
					str[j] = '1';
					break;
				}
				str[j] = '0';
				if (j == 0) {
					// 到达首位,还需要进位,数组首位压入一个1
					char[] chars = new char[length + 1];
					System.arraycopy(str, 0, chars, 1, length);
					chars[j] = '1';
					str = chars;
					length++;
				}
			}
		}

		return new String(str);
	}


	private String add(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;

		// 保存结果的可变的字符序列对象
		StringBuilder res = new StringBuilder();
		// 当前和
		int curSum;
		int carry = 0;
		while (i >= 0 || j >= 0) {
			// 当前和至少是那个进位
			curSum = carry;
			if (i >= 0) {
				curSum += a.charAt(i) - '0';
				i--;
			}
			if (j >= 0) {
				curSum += b.charAt(j) - '0';
				j--;
			}

			// 判断是否需要进位，即确定 carry 的值
			if (curSum > 1) {
				curSum -= 2;
				carry = 1;
			} else {
				carry = 0;
			}

			// 只写结果的值，进位作为下一轮的初始值
			res.insert(0, curSum);
		}

		// 这里不要忘记如果全部加完以后还要进位，要把最高位加上 1
		if (carry == 1) {
			res.insert(0, 1);
		}
		return res.toString();
	}
}
