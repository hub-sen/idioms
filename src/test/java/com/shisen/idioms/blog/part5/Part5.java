package com.shisen.idioms.blog.part5;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * <pre>
 * Description  第 5 部分：传递表达式（pass-through lambdas）的替代方案
 * </pre>
 */
public class Part5 {
	private List<Integer> numbers;

	@Before
	public void before() {
		numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}

	@Test
	public void test_1() {
		numbers.stream()
				.filter(e -> e % 2 == 0)
				.forEach(e -> out.println(e));
	}

	@Test
	public void test_2() {
		numbers.stream()
				.filter(e -> e % 2 == 0)
				.forEach(out::println);
	}

	@Test
	public void test_3() {
		out.println(numbers.stream()
				.reduce(0, Integer::sum));
	}

	@Test
	public void test_4() {
		out.println(numbers.stream()
				.map(Object::toString)
				.reduce("", String::concat));
	}
}
