package com.shisen.idioms.blog.part2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description  第 2 部分：函数组合与集合管道模式
 * </pre>
 */
public class Part2 {

	private List<Car> cars;
	private List<String> models;


	@Before
	public void before() {
		cars = Arrays.asList(
				new Car("Jeep", "Wrangler", 2011),
				new Car("Jeep", "Comanche", 1990),
				new Car("Dodge", "Avenger", 2010),
				new Car("Buick", "Cascada", 2016),
				new Car("Ford", "Focus", 2012),
				new Car("Chevrolet", "Geo Metro", 1992)
		);
	}

	@After
	public void after() {
		System.out.println("models = " + models);
	}

	@Test
	public void getModelsAfter2000UsingFor() {
		ArrayList<Car> carsSortsByYear = new ArrayList<>();
		for (Car car : cars) {
			if (car.getYear() > 2000) {
				carsSortsByYear.add(car);
			}
		}

		Collections.sort(carsSortsByYear,new Comparator<Car>() {
			@Override
			public int compare(Car car1, Car car2) {
				return new Integer(car1.getYear()).compareTo(car2.getYear());
			}
		});

		ArrayList<String> models = new ArrayList<>();
		for (Car car : carsSortsByYear) {
			models.add(car.getModel());
		}

		this.models = models;

	}

	@Test
	public void getModelsAfter2000UsingPipeline() {
		models = cars.stream()
				.filter(car -> car.getYear() > 2000)
				.sorted(Comparator.comparing(Car::getYear))
				.map(Car::getModel)
				.collect(Collectors.toList());
	}
}
