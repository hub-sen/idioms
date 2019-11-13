package com.shisen.idioms.blog.part4;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * <pre>
 * Description  第 4 部分：提倡使用有帮助的编码
 * </pre>
 */
public class Part4 {

	private List<String> names;

	@Before
	public void before() {
		names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");
	}

	@Test
	public void test_1() {

		List<String> subList = new ArrayList<>();

		for (String name : names) {
			if (name.length() == 4) {
				subList.add(name);
			}
		}

		StringBuilder namesOfLength4 = new StringBuilder();
		for (int i = 0; i < subList.size() - 1; i++) {
			namesOfLength4.append(subList.get(i)).append(",");
		}

		if (subList.size() > 1) {
			namesOfLength4.append(subList.get(subList.size() - 1));
		}

		out.println("namesOfLength4 = " + namesOfLength4);
	}

	@Test
	public void test_2() {
		String namesOfLength4 = names.stream()
				.filter(name -> name.length() == 4)
				.collect(Collectors.joining(","));
		out.println("namesOfLength4 = " + namesOfLength4);
	}

	@Test
	public void test_3() {
		out.println(names.stream()
				.filter(name -> name.startsWith("J"))
				.filter(name -> name.length() > 3)
				.map(String::toUpperCase)
				.collect(Collectors.joining(",")));
	}
}
