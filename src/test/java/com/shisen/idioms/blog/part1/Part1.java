package com.shisen.idioms.blog.part1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Description  第一部分: Java中的一种更轻松的函数式编程途径
 * </pre>
 */
public class Part1 {

	private List<String> names;
	private boolean found;
	private String page;

	@Before
	public void before() {
		names = Arrays.asList("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");
		found = false;
		page = "https://hub-sen.github.io";
	}

	@After
	public void after() {
		if (found) {
			System.out.println("found Nemo");
		} else {
			System.out.println("not found Nemo");
		}
	}

	@Test
	public void findNemo_1() {
		found = false;
		for (String name : names) {
			if (name.equals("Nemo")) {
				found = true;
				break;
			}
		}

	}

	@Test
	public void findNemo_2() {
		if (names.contains("Nemo")) {
			found = true;
		}
	}

	@Test
	public void increment_1() {
		HashMap<String, Integer> pageVisits = new HashMap<>();
		incrementPageVisit_1(pageVisits, page);
		System.out.println("page visits = " + pageVisits.get(page));
	}

	@Test
	public void increment_2() {
		HashMap<String, Integer> pageVisits = new HashMap<>();
		incrementPageVisit_2(pageVisits, page);
		incrementPageVisit_2(pageVisits, page);
		System.out.println("page visits = " + pageVisits.get(page));
	}

	@Test
	public void increment_3() {
		HashMap<String, Integer> pageVisits = new HashMap<>();
		incrementPageVisit_3(pageVisits, page);
		incrementPageVisit_3(pageVisits, page);
		incrementPageVisit_3(pageVisits, page);
		System.out.println("page visits = " + pageVisits.get(page));
	}


	private void incrementPageVisit_1(Map<String, Integer> pageVisits, String page) {
		if (!pageVisits.containsKey(page)) {
			pageVisits.put(page, 0);
		}
		pageVisits.put(page, pageVisits.get(page) + 1);
	}

	private void incrementPageVisit_2(Map<String, Integer> pageVisits, String page) {
		pageVisits.merge(page, 1, (oldValue, newValue) -> oldValue + newValue);
	}

	private void incrementPageVisit_3(Map<String, Integer> pageVisits, String page) {
		pageVisits.merge(page, 1, Integer::sum);
	}

}
