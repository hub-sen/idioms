package com.shisen.idioms.blog.part9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static com.shisen.idioms.blog.part9.Util.*;

/**
 * <pre>
 * Description  第 9 部分：级联 lambda 表达式
 * </pre>
 */
public class Part9_1 {


	List<Integer> valus;

	Object result;

	@Before
	public void before() {
		valus = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	}

	@After
	public void after() {
		System.out.println("result = " + result);
	}

	@Test
	public void test_1() {
		result = totalSelectedValus(valus, x -> x > 5);
	}

	@Test
	public void test_2(){
		result = totalSelectedValus(valus, Util::isEven);
	}

	@Test
	public void test_3(){
		Predicate<Integer> isOdd = createIsOdd_2();
		result = isOdd.test(4);
	}


	private static int totalSelectedValus(List<Integer> valus, Predicate<Integer> predicate) {
		return valus.stream()
				.filter(predicate)
				.reduce(0, Integer::sum);
	}


}
