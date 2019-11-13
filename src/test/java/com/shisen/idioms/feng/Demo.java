package com.shisen.idioms.feng;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/11/11 14:56
 * </pre>
 */
public class Demo {

	private List<Student> list_1;
	private List<Student> list_2;

	private List<Student> result;

	@Before
	public void before() {
		list_1 = Arrays.asList(new Student(1, "施森"), new Student(2, "彭烽"), new Student(3, "彭烽2"));
		list_2 = Arrays.asList(new Student(1, "施森"), new Student(2, "彭烽"));
		list_1 = new ArrayList<>();
		list_1.add(new Student(1, "施森"));
		list_1.add(new Student(2, "彭烽"));
		list_1.add(new Student(3, "彭烽2"));
	}

	@After
	public void after() {
		Optional.ofNullable(result).ifPresent(System.out::println);
		System.out.println("list_1 = " + list_1);
	}

	@Test
	public void demo_1() {
		List<Integer> nos = list_2.parallelStream().map(Student::getNo).collect(Collectors.toList());
		list_1.removeIf(x -> nos.contains(x.getNo()));
		//result = list_1.stream().filter(x -> list_2.stream().anyMatch(y -> y.getNo() != x.getNo())).collect(Collectors.toList());
	}


}
