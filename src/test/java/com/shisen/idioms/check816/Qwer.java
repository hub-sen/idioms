package com.shisen.idioms.check816;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/11/23 14:35
 * </pre>
 */
public class Qwer {

	private List<String> lists;

	private String result;

	@Before
	public void before() {
		lists = Optional.ofNullable(lists).orElse(new ArrayList<>());
		lists.add("施森");
		lists.add("施施");
		lists.add("森森");
	}

	@After
	public void after() {
		Optional.ofNullable(result).ifPresentOrElse(System.out::println, () -> System.out.println("结果为空"));
	}


	@Test
	public void demo1() {
		result = lists.stream().collect(Collectors.joining(","));
	}
}
