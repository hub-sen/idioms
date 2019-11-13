package com.shisen.idioms.baldStrong.Part4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * </pre>
 */
public class CompletableFutureTest2 {
	List<Shop> shops;

	long start;

	List<String> result;

	@Before
	public void before() {
		start = System.nanoTime();
		shops = Arrays.asList(new Shop("淘宝"),
				new Shop("天猫"),
				new Shop("京东"),
				new Shop("亚马逊"),
				new Shop("实体店")
		);
	}

	@After
	public void after() {
		Optional.ofNullable(result).ifPresent(result -> {
			System.out.println("result = " + result);
			System.out.println("Done in " + (System.nanoTime() - start) / 1_000_000 + "ms");
		});
	}

	@Test
	public void test1() {
		result = findPrice("mac bookPro");
	}

	@Test
	public void test2() {
		result = findPrice2("mac bookPro");
	}

	@Test
	public void test3() {
		result = findPrice3("mac bookPro");
	}

	/**
	 * 顺序查询所有商店的方式实现
	 *
	 * @param product
	 * @return
	 */
	public List<String> findPrice(String product) {
		return shops.stream()
				.map(shop ->
						String.format("%s price is %.2f RMB", shop.getName(), shop.getPrice(product))
				).collect(Collectors.toList());
	}

	/**
	 * 使用并行流查询所有商店的方式实现
	 *
	 * @param product
	 * @return
	 */
	public List<String> findPrice2(String product) {
		return shops.stream().parallel()
				.map(shop ->
						String.format("%s price is %.2f RMB", shop.getName(), shop.getPrice(product))
				).collect(Collectors.toList());
	}

	/**
	 * 使用CompletableFuture异步实现
	 *
	 * @param product
	 * @return
	 */
	public List<String> findPrice3(String product) {
		List<CompletableFuture<String>> futures = shops.stream()
				.map(shop -> CompletableFuture.supplyAsync(
						() -> String.format("%s price is %.2f RMB", shop.getName(), shop.getPrice(product))
				))
				.collect(Collectors.toList());
		return futures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList());
	}

}