package com.shisen.idioms.blog.part3;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.lang.System.out;

/**
 * <pre>
 * Description  第 3 部分：传统 for 循环的函数式替代方案
 * </pre>
 */
public class part3 {

	private ExecutorService executorService;

	@Before
	public void before() {
		executorService = Executors.newFixedThreadPool(10);
	}

	@Test
	public void test_1() {
		for (int i = 0; i < 4; i++) {
			out.println("i = " + i);
		}
	}

	@Test
	public void test_2() {
		IntStream.range(0, 4)
				.forEach(i -> out.println("i = " + i));
	}

	@Test
	public void test_3() {
		for (int i = 0; i < 4; i++) {
			int temp = i;
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					// local variables referenced from an inner class must be final or effectively final
					//System.out.println("Running task " + i);
					out.println("Running task " + temp);
				}
			});
		}
	}

	@Test
	public void test_4() {
		IntStream.range(0, 4)
				.forEach(i -> executorService.submit(new Runnable() {
					@Override
					public void run() {
						out.println("Running task " + i);
					}
				}));
	}

	@Test
	public void test_5() {
		IntStream.range(0, 4).
				forEach(i ->
						executorService.submit(() ->
								out.println("Running task " + i)
						)
				);
	}

	@Test
	public void test_6() {
		IntStream.rangeClosed(0, 4).forEach(out::println);
	}

	@Test
	public void test_7() {
		int total = 0;
		for (int i = 0; i <= 100; i += 3) {
			total += i;
		}
		out.println("total = " + total);
	}

	@Test
	public void test_8() {
		int total = IntStream.iterate(0, e -> e + 3)
				.limit(34).sum();
		out.println("total = " + total);
	}

	/**
	 * JDK 9+
	 */
	@Test
	public void test_9() {
		int total = IntStream.iterate(0, e -> e + 3)
				.takeWhile(i -> i <= 100) // available in java 9 or later
				.sum();
		out.println("total = " + total);
	}


}
