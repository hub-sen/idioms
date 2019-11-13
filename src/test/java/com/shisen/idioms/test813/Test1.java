package com.shisen.idioms.test813;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/13 9:54
 * </pre>
 */
public class Test1 {

	private List<Cat> cats;

	@Before
	public void before() {
		cats = Arrays.asList(new Cat(3, 2),
				new Cat(4, 3),
				new Cat(3, 6),
				new Cat(2, 4));
	}

	@After
	public void after() {
		Optional.ofNullable(cats).ifPresent(System.out::println);
	}

	@Test
	public void test_1() {
		cats.sort(Comparator.comparing(Cat::getAge).thenComparing(Cat::getHeight, Comparator.reverseOrder()));
	}

	@Test
	public void test_2() {

		LocalTime of = LocalTime.of(1, 1, 1);

		int i = of.toSecondOfDay();

		System.out.println("i = " + i);

	}


	@Test
	public void test_3() {

		Map<Integer, List<Integer>> collect = cats.stream()
				.collect(Collectors.groupingBy(Cat::getAge, Collectors.mapping(Cat::getHeight, Collectors.toList())));

		System.out.println("collect = " + collect);

	}

	@Test
	public void test_4() {
		Date date = new Date();

		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		instance.add(Calendar.SECOND,1);

		Date time = instance.getTime();


		String s = timeDifference(date, time);
		System.out.println("s = " + s);


	}

	private String timeDifference(Date beforeTime, Date afterTime) {
		String pattern = "#.#";
		DecimalFormat df = new DecimalFormat(pattern);
		double pow = Math.pow(10, 6);
		String format = df.format((afterTime.getTime() - beforeTime.getTime()) * 0.277777778 / pow);
		return format.equals("0") ? "0.1" : format;
	}


}
