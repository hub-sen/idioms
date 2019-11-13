package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/11/8 13:37
 * </pre>
 */
public class MyTest {

	private String args;

	private List<String> result;

	@Before
	public void before() {
		args = "我喜欢你";
	}

	@After
	public void after() {
		MyOptional.ofNullable(result).ifPresent(System.out::println, () -> System.out.println("result is null"));
	}


	@Test
	public void test_1() {


	}
}
