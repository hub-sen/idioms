package com.shisen.idioms.baldStrong.Part3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

/**
 * <pre>
 * Description
 * </pre>
 */
public class App {
	List<Dish> menu;

	List<String> lowCaloricDishesName;


	Optional<Dish> MaxDish = Optional.empty();
	Optional<Dish> MinDish = Optional.empty();

	@Before
	public void before() {
		menu = Arrays.asList(new Dish("红烧肉", false, 600),
				new Dish("蒜泥白肉", false, 500),
				new Dish("狮子头", false, 400),
				new Dish("拍黄瓜", true, 300),
				new Dish("凉皮", true, 200),
				new Dish("地三鲜", true, 100));
	}

	@After
	public void after() {
		MaxDish.ifPresent(dish-> System.out.println("MaxDish = " + dish));
		MinDish.ifPresent(dish-> System.out.println("MinDish = " + dish));
	}

	/**
	 * 使用Collectors
	 */
	@Test
	public void test1() {
		MaxDish = menu.stream()
				.collect(maxBy(Comparator.comparing(Dish::getCalories)));
		MinDish = menu.stream()
				.collect(minBy(Comparator.comparing(Dish::getCalories)));

	}

	/**
	 * 使用Stream
	 */
	@Test
	public void test2() {
		MaxDish = menu.stream().max(Comparator.comparing(Dish::getCalories));
		MinDish = menu.stream().min(Comparator.comparing(Dish::getCalories));
	}

	@Test
	public void test3() {
		int sum = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println("sum = " + sum);
	}

	@Test
	public void test4() {
		Integer collect = menu.stream()
				.collect(summingInt(Dish::getCalories));
		System.out.println("collect = " + collect);

	}

	@Test
	public void test5() {
		Integer reduce = menu.stream()
				.map(Dish::getCalories)
				.reduce(0, Integer::sum);
		System.out.println("reduce = " + reduce);

	}

	@Test
	public void test6() {
		IntSummaryStatistics collect = menu.stream()
				.collect(summarizingInt(Dish::getCalories));
		System.out.println("collect = " + collect);

		System.out.println("collect.getCount() = " + collect.getCount());
		System.out.println("collect.getCount() = " + collect.getCount());
		System.out.println("collect.getAverage() = " + collect.getAverage());
		System.out.println("collect.getMax() = " + collect.getMax());
		System.out.println("collect.getMin() = " + collect.getMin());

	}


	@Test
	public void test7() {
		String collect = menu.stream()
				.map(Dish::getName)
				.collect(joining(","));
		System.out.println("collect = " + collect);

	}

	@Test
	public void test8() {
		Map<Boolean, List<Dish>> collect = menu.stream()
				.collect(groupingBy(Dish::getVegetarian));

		System.out.println("collect.get(true) = " + collect.get(true));
		System.out.println("collect.get(false) = " + collect.get(false));

	}


	@Test
	public void test9() {
		Map<Boolean, IntSummaryStatistics> collect = menu.stream()
				//.map(Dish::getVegetarian)
				.collect(groupingBy(Dish::getVegetarian, summarizingInt(Dish::getCalories)));
		System.out.println("collect = " + collect);
	}


}
