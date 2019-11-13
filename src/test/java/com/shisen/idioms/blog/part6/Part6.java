package com.shisen.idioms.blog.part6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.out;


/**
 * <pre>
 * Description  第 6 部分：为什么完美的 lambda 表达式只有一行
 * </pre>
 */
public class Part6 {

	private List<Integer> vals;

	private int result;

	@Before
	public void before() {
		vals = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}

	@After
	public void after() {
		out.println("result = " + result);
	}

	@Test
	public void test_1() {
		result = 0;
		for (Integer v : vals) {
			if (v > 3 && 0 == v % 2) {
				result = v * 2;
				break;
			}
		}
	}

	@Test
	public void test_2() {
		result = vals.stream()
				.filter(v -> v > 3)
				.filter(v -> 0 == v % 2)
				.map(v -> v * 2)
				.findFirst()
				.orElse(0);
	}

	@Test
	public void test_3() {
		result = vals.stream()
				.mapToInt(v -> {
					var sum = 0;
					for (int i = 1; i <= v; i++) {
						if (0 == v % i) {
							sum += i;
						}

					}
					return sum;
				}).sum();
	}

	@Test
	public void test_4() {
		result = vals.stream()
				.mapToInt(e -> sumOfFactors(e))
				.sum();
	}

	@Test
	public void test_5() {
		result = vals.stream()
				.mapToInt(this::sumOfFactors)
				.sum();
	}

	private int sumOfFactors(int e) {
		return IntStream.rangeClosed(1, e)
				.filter(i -> 0 == e % i)
				.sum();
	}
}
