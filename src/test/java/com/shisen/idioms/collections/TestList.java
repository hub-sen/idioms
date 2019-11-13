package com.shisen.idioms.collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

/**
 * <pre>
 * Description
 * </pre>
 */
public class TestList {

	private List<String> lists = new ArrayList<>();


	@Before
	public void before() {
		lists.add("周");
		lists.add("璨");
		lists.add("然");
		lists.add("周");
	}

	@After
	public void after() {
		Optional.ofNullable(lists).ifPresent(out::println);
	}

	@Test
	public void testRemoveIf() {
		lists.removeIf(x -> x.equals("周"));
	}

}
