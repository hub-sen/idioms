package com.shisen.idioms.eclipseCollections.Test2;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/6/25 9:53
 * </pre>
 */
public class Test2 {


	List<Person> people;
	ImmutableList<Person> immutablepeople;

	@Before
	public void before() {
		people = List.of(new Person("Alice", 19),
				new Person("Bob", 52), new Person("Carol", 35));
		immutablepeople = Lists.immutable.of(new Person("Alice", 19),
				new Person("Bob", 52), new Person("Carol", 35));
	}

	@Test
	public void test1() {
		List<String> collect = people.stream()
				.filter(person -> person.getAge() > 25)
				.map(Person::getName)
				.collect(toList());

		System.out.println("collect = " + collect);
	}

	@Test
	public void test2() {
		ImmutableList<String> collect = immutablepeople.select(person -> person.getAge() > 25)
				.collect(Person::getName);
		System.out.println("collect = " + collect);
	}
}
