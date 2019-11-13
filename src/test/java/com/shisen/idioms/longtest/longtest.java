package com.shisen.idioms.longtest;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/7/25 16:06
 * </pre>
 */
public class longtest {
	/**
	 * N 离他最近的大于等于他的一个2的幂次方数是多少
	 */
	@Test
	public void test_1() {
		System.out.println(allocateElements(30));
	}

	@Test
	public void test_2() {
		int sum = IntStream.range(0, 30)
				.map(p -> (int) Math.pow(2, p))
				.peek(System.out::println)
				.sum();
		System.out.println("sum = " + sum);
	}

	private int allocateElements(int numElements) {
		int initialCapacity = 0;
		if (numElements >= initialCapacity) {
			initialCapacity = numElements;
			initialCapacity |= (initialCapacity >>> 1);
			initialCapacity |= (initialCapacity >>> 2);
			initialCapacity |= (initialCapacity >>> 4);
			initialCapacity |= (initialCapacity >>> 8);
			initialCapacity |= (initialCapacity >>> 16);
			initialCapacity++;

			if (initialCapacity < 0) {
				initialCapacity >>>= 1;
			}
		}
		return initialCapacity;
	}


	@Test
	public void test_3() {
		List<Person> peoples = Arrays.asList(new Person().setName("施森").setAge(25),
				new Person().setName("彭烽").setAge(24));

		List<Student> students = peoples.stream()
				.map(people -> new Student().setName(people.getName()).setAge(people.getAge()))
				.collect(Collectors.toList());

		Optional.ofNullable(students).ifPresent(System.out::println);


	}


	@Accessors(chain = true)
	@Getter
	@Setter
	class Student{
		private String name;
		private int age;
	}

	@Accessors(chain = true)
	@Getter
	@Setter
	class Person{
		private String name;
		private int age;
	}


	@Test
	public void testException() {

	}
}
