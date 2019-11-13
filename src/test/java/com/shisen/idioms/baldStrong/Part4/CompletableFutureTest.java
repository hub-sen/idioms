package com.shisen.idioms.baldStrong.Part4;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <pre>
 * Description
 * </pre>
 */
public class CompletableFutureTest {
	@Test
	public void test1() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<Double> future = executorService.submit(new Callable<Double>() {
			@Override
			public Double call() throws Exception {
				return longComputation();
			}
		});

		try {
			Double result = future.get(1, TimeUnit.SECONDS);
			System.out.println("result = " + result);
		} catch (InterruptedException e) {
			// 当前线程在等待过程中被中端
			e.printStackTrace();
		} catch (ExecutionException e) {
			// 计算抛出一个异常
			e.printStackTrace();
		} catch (TimeoutException e) {
			// 在Future对象完成之前已过期
			e.printStackTrace();
		}


	}


	@Test
	public void test2() {

		Shop shop = new Shop("Best Shop");

		long start = System.nanoTime();

		double price = shop.getPrice("macbook pro");
		System.out.printf(shop.getName() + "price is %.2f%n", price);
		long invocationTime = (System.nanoTime()-start)/1_000_000;
		System.out.println("同步方法调用花费: ---"+invocationTime+"---msecs");
		doSomethingElse();
		long retrievalTime = (System.nanoTime()-start)/1_000_000;
		System.out.println("同步方法返回价格所需事件: ---"+retrievalTime+"---msecs");

	}

	@Test
	public void test3() {

		Shop shop = new Shop("Best Shop");

		long start = System.nanoTime();

		Future<Double> futurePrice = shop.getPriceAsync("macbook pro");
		long invocationTime = (System.nanoTime()-start)/1_000_000;
		System.out.println("异步方法调用花费: ---"+invocationTime+"---msecs");

		doSomethingElse();

		try {
			Double price = futurePrice.get();
			System.out.printf(shop.getName() + "price is %.2f%n", price);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		long retrievalTime = (System.nanoTime()-start)/1_000_000;
		System.out.println("同步方法返回价格所需事件: ---"+retrievalTime+"---msecs");

	}


	private static void doSomethingElse() {
		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Double longComputation() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Math.random();
	}
}
