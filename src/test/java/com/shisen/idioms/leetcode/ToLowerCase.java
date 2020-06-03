package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/1/15 15:56
 * </pre>
 */
public class ToLowerCase {
	private String str;
	private String result;

	@Before
	public void before() {
		str = "helloWORLD";
	}

	@After
	public void after() {
		Optional.ofNullable(result).ifPresent(System.out::println);
	}

	@Test
	public void test_1() {
		result = toLowerCase(str);
	}

	public String toLowerCase(String str) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0, length = str.length(); i < length; i++) {
			stringBuilder.append((char) (str.charAt(i) ^ 32));
		}

		return stringBuilder.toString();
	}
}
