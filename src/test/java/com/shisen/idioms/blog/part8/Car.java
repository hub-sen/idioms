package com.shisen.idioms.blog.part8;

import java.util.Comparator;

import static java.util.Comparator.comparing;

/**
 * <pre>
 * Description
 * </pre>
 */
public class Car {
	public String getRegistration() {
		return null;
	}

	public static Comparator<Car> createComparator_1() {
		return comparing((Car car) -> car.getRegistration());
	}

	public static Comparator<Car> createComparator_2() {
		return comparing(car -> car.getRegistration());
	}

	public static Comparator<Car> createComparator_3() {
		return comparing((Car car)->car.getRegistration()).reversed();
	}

	/*public static Comparator<Car> createComparator_4() {
		return comparing(car -> car.getRegistration()).reversed();
	}*/

	public static Comparator<Car> createComparator_5() {
		return comparing(Car::getRegistration).reversed();
	}


}
