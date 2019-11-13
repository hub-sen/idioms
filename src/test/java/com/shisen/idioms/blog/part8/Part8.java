package com.shisen.idioms.blog.part8;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * <pre>
 * Description  第 8 部分：Java 知道您的类型
 * </pre>
 */
public class Part8 {

	@Test
	public void test_1() {
		IntStream.rangeClosed(1, 5)
				.forEach((int number) -> System.out.println("number = " + number));
	}

	@Test
	public void test_2() {
		IntStream.rangeClosed(1, 5)
				.forEach((number) -> System.out.println("number = " + number));
	}

	@Test
	public void test_3() {
		IntStream.rangeClosed(1, 5)
				.forEach(number -> System.out.println("number = " + number));
	}


}
