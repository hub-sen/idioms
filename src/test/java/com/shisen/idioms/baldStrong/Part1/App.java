package com.shisen.idioms.baldStrong.Part1;

import com.shisen.idioms.baldStrong.Part1.predicates.AppleGreenColorPredicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.shisen.idioms.baldStrong.Part1.Apple.Color.BLACK;
import static com.shisen.idioms.baldStrong.Part1.Apple.Color.BLUE;
import static com.shisen.idioms.baldStrong.Part1.Apple.Color.GREEN;
import static com.shisen.idioms.baldStrong.Part1.Apple.Color.PURPLE;
import static com.shisen.idioms.baldStrong.Part1.Apple.Color.RED;
import static com.shisen.idioms.baldStrong.Part1.Apple.Color.WRITE;

/**
 * <pre>
 * Description  通过行为参数化传递代码
 * </pre>
 */
public class App {

	List<Apple> inventory;

	List<Apple> result;

	@Before
	public void before() {
		inventory = List.of(new Apple(RED, 25),
				new Apple(WRITE, 50),
				new Apple(BLACK, 75),
				new Apple(GREEN, 100),
				new Apple(BLUE, 125),
				new Apple(PURPLE, 150));

		result = new ArrayList<>();
	}

	@After
	public void after() {
		Optional.ofNullable(result).ifPresent(result -> System.out.println("result = " + result));
	}

	/**
	 * 筛选绿苹果
	 */
	@Test
	public void test1() {
		result = filterGreenApples(inventory);
	}

	@Test
	public void test2() {
		result = filterApplesByColor(inventory, RED);
	}

	@Test
	public void test3() {
		result = filterApplesByPredicate(inventory, new AppleGreenColorPredicate<>());
	}

	@Test
	public void test4() {
		result = filterApplesByPredicate(inventory, apple -> BLACK.equals(apple.getColor()));
	}


	private <T extends Apple> List<T> filterApplesByPredicate(List<T> inventory, ApplePredicate<T> applePredicate) {
		ArrayList<T> apples = new ArrayList<>();
		for (T apple : inventory) {
			if (applePredicate.test(apple)) {
				apples.add(apple);
			}
		}
		return apples;
	}

	/**
	 * 根据颜色筛选苹果
	 *
	 * @param inventory
	 * @param color
	 * @return
	 */
	private List<Apple> filterApplesByColor(List<Apple> inventory, Apple.Color color) {
		ArrayList<Apple> apples = new ArrayList<>();
		for (Apple apple : inventory) {
			if (color.equals(apple.getColor())) {
				apples.add(apple);
			}
		}
		return apples;
	}

	/**
	 * 筛选绿色苹果
	 *
	 * @param inventory
	 * @return
	 */
	private List<Apple> filterGreenApples(List<Apple> inventory) {
		ArrayList<Apple> apples = new ArrayList<>();

		for (Apple apple : inventory) {
			if (GREEN.equals(apple.getColor())) {
				apples.add(apple);
			}
		}
		return apples;
	}

	/**
	 * 筛选红色苹果
	 *
	 * @param inventory
	 * @return
	 */
	private List<Apple> filterRedApples(List<Apple> inventory) {
		ArrayList<Apple> apples = new ArrayList<>();

		for (Apple apple : inventory) {
			if (RED.equals(apple.getColor())) {
				apples.add(apple);
			}
		}
		return apples;
	}


}
