package com.shisen.idioms.blog.part9;

import java.util.function.Predicate;

/**
 * <pre>
 * Description
 * </pre>
 */
public class Util {
	public static boolean isEven(int number) {
		return 0 == number % 2;
	}

	public static Predicate<Integer> createIsOdd_1() {
		return (Integer number) -> 0 != number % 2;
	}

	public static Predicate<Integer> createIsOdd_2() {
		return number -> 0 != number % 2;
	}

	public static Predicate<Integer> isGreaterThan50() {
		return number -> number > 50;
	}




}
