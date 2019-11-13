package com.shisen.idioms.baldStrong.Part4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * <pre>
 * Description
 * </pre>
 */
@Getter
@Setter
@AllArgsConstructor
public class Shop {
	private String name;


	private double calculatePrice(String product) {
		delay();
		return 10 * product.charAt(0);
	}

	private void delay() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 阻塞式
	 * @param product
	 * @return
	 */
	public double getPrice(String product) {
		return calculatePrice(product);
	}


	/**
	 * 非阻塞式
	 * @param product
	 * @return
	 */
	public Future<Double> getPriceAsync(String product) {
		CompletableFuture<Double> future = new CompletableFuture<>();
		new Thread(()->{
			double price = calculatePrice(product);
			future.complete(price);
		}).start();
		return future;
	}


	/**
	 * 使用静态工厂supplyAsync异步获取价格
	 * @param product
	 * @return
	 */
	public Future<Double> getPriceSupplyAsync(String product) {
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
	}
}
