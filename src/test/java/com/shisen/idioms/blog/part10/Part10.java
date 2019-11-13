package com.shisen.idioms.blog.part10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

/**
 * <pre>
 * Description  第 10 部分：使用闭包捕获状态
 * </pre>
 */
public class Part10 {
	private List<Integer> number;

	private List<Integer> result;

	@Before
	public void before() {
		number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}

	@After
	public void after() {
		Optional.ofNullable(result)
				.ifPresent(out::println);
	}

	@Test
	public void test_1() {
		result = number.stream()
				.filter(e -> 0 == e % 2)
				.map(e -> e * 2)
				.collect(toList());
	}


	@Test
	public void test_2() {
		int factor = 3;
		result = number.stream()
				.filter(e -> 0 == e % 2)
				.map(e -> e * factor)
				.collect(toList());
	}

}
