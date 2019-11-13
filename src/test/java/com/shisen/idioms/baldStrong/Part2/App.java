package com.shisen.idioms.baldStrong.Part2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description  函数式数据处理--流
 * </pre>
 */
public class App {
	List<Dish> menu;

	List<String> lowCaloricDishesName;

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
		Optional.ofNullable(lowCaloricDishesName)
				.ifPresent(lowCaloricDishesName -> System.out.println("lowCaloricDishesName = " + lowCaloricDishesName));
	}

	/**
	 * 查找出热量低于400的食物,并按照卡路里进行排序输出菜名
	 */
	@Test
	public void test1() {
		ArrayList<Dish> lowCaloricDishes = new ArrayList<>();
		// 选出低热量的食物
		for (Dish dish : menu) {
			if (dish.getCalories() < 400) {
				lowCaloricDishes.add(dish);
			}
		}

		// 按照卡路里进行排序
		lowCaloricDishes.sort(Comparator.comparing(Dish::getCalories));

		// 输出菜名
		lowCaloricDishesName = new ArrayList<>();

		for (Dish lowCaloricDish : lowCaloricDishes) {
			lowCaloricDishesName.add(lowCaloricDish.getName());
		}

	}

	@Test
	public void test2() {
		lowCaloricDishesName = menu.stream()
				.filter(dish -> dish.getCalories() < 400)
				.sorted(Comparator.comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(Collectors.toList());

	}



}
