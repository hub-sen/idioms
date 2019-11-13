package com.shisen.idioms.blog.part9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.shisen.idioms.blog.part9.Util.isGreaterThan50;
import static java.util.stream.Collectors.toList;

/**
 * <pre>
 * Description  创建可重用的函数
 * </pre>
 */
public class Part9_2 {

	private List<Integer> number1;
	private List<Integer> number2;

	private List<Integer> result_1;
	private List<Integer> result_2;

	@SuppressWarnings("all")
	private Function<Integer, Predicate<Integer>> isGreaterThan = (Integer pivot) -> {
		Predicate<Integer> isGreaterThanpivot = (Integer candidate) -> {
			return candidate > pivot;
		};
		return isGreaterThanpivot;
	};



	private Function<Integer, Predicate<Integer>> isGreaterThan2 = pivot -> number -> number > pivot;

	private static Predicate<Integer> isGreaterThan(final int pivot) {
		return number -> number > pivot;
	}

	@Before
	public void before() {
		number1 = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
		number2 = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
	}

	@After
	public void after() {

		Optional.ofNullable(result_1).ifPresent(result -> System.out.println("result_1 = " + result));
		Optional.ofNullable(result_2).ifPresent(result -> System.out.println("result_2 = " + result));
	}

	@Test
	public void test_1() {
		result_1 = number1.stream()
				.filter(number -> number > 50)
				.collect(toList());

		result_2 = number2.stream()
				.filter(number -> number > 50)
				.map(number -> number * 2)
				.collect(toList());
	}

	@Test
	public void test_2() {
		result_1 = number1.stream()
				.filter(isGreaterThan50())
				.collect(toList());

		result_2 = number2.stream()
				.filter(isGreaterThan50())
				.map(number -> number * 2)
				.collect(toList());

	}

	@Test
	public void test_3() {
		result_1 = number1.stream()
				.filter(number -> number > 25)
				.collect(toList());
	}

	@Test
	public void test_4() {
		result_1 = number1.stream()
				.filter(number -> number > 50)
				.collect(toList());
	}

	@Test
	public void test_5() {
		result_1 = number1.stream()
				.filter(number -> number > 75)
				.collect(toList());
	}

	@Test
	public void test_6() {
		result_1 = number1.stream()
				.filter(isGreaterThan.apply(25))
				.collect(toList());
	}

	@Test
	public void test_7() {
		result_1 = number1.stream()
				.filter(isGreaterThan(25))
				.collect(toList());
	}

	@Test
	public void test_8() {
		result_1 = number1.stream()
				.filter(isGreaterThan(50))
				.collect(toList());
	}

	@Test
	public void test_9() {
		result_1 = number1.stream()
				.filter(isGreaterThan2.apply(25))
				.collect(toList());
	}


}
