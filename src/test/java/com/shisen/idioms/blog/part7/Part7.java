package com.shisen.idioms.blog.part7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Comparator.comparing;

/**
 * <pre>
 * Description  第 7 部分：函数接口
 * </pre>
 */
public class Part7 {

	private Thread thread;

	private List<Device> devices;

	private List<OrderItem> items;

	@Before
	public void before() {
		devices = Arrays.asList(new Device(true, "0"),
				new Device(false, "1"),
				new Device(true, "2"),
				new Device(false, "3"),
				new Device(true, "4"),
				new Device(false, "5"),
				new Device(true, "6"));

		items = Arrays.asList(new OrderItem(1, 11),
				new OrderItem(2, 22),
				new OrderItem(3, 33),
				new OrderItem(4, 44),
				new OrderItem(5, 55));
	}

	@After
	public void after() {
		Optional.ofNullable(thread).ifPresent(this::threadStart);
	}

	@Test
	public void test_1() {
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				out.println("In another thread");
			}
		});
	}

	@Test
	public void test_2() {
		thread = new Thread(() -> out.println("In another thread"));
	}

	@Test
	public void test_3() {
		borrowDevice((device) -> out.println("using" + device.getName()));
	}

	@Test
	public void test_4() {
		transformAndPrint(new Transformer<Stream<OrderItem>>() {
			@Override
			public Stream<OrderItem> transform(Stream<OrderItem> input) {
				return input.sorted(new Comparator<OrderItem>() {
					@Override
					public int compare(OrderItem o1, OrderItem o2) {
						return o2.getPrice() - o1.getPrice();
					}
				});
			}
		});
	}


	@Test
	public void test_5() {
		transformAndPrint(input -> input.sorted(comparing(OrderItem::getPrice).reversed()));
	}


	private void threadStart(Thread thread) {
		thread.start();
		out.println("In main thread");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void borrowDevice(Consumer<Device> consumer) {
		Device device = getFromAvailable();
		device.checkOut();
		try {
			consumer.accept(device);
		} finally {
			device.checkIn();
		}

	}

	private Device getFromAvailable() {
		return devices.stream()
				.filter(Device::getAvailable)
				.findFirst()
				.orElse(new Device(false, ""));
	}


	private void transformAndPrint(Transformer<Stream<OrderItem>> transformOrderItems) {
		transformOrderItems.transform(items.stream())
				.forEach(out::println);
	}
}
