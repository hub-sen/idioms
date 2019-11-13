package com.shisen.idioms.check816.packageRequest;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description  任务封装
 * @author shishi
 * 2019/8/29 15:35
 * </pre>
 */
public class App {

	private List<Task> tasks;

	@Before
	public void before() {

		tasks = Arrays.asList(Task.builder()
						.tk(Truck.builder().name("森A11111").build())
						.tr(Trailer.builder().name("桂AAAAA挂").build())
						.td(Driver.builder().name("施森").build())
						.startTime(new Date())
						.endTime(new Date())
						.build(),
				Task.builder()
						.tk(Truck.builder().name("森A22222").build())
						.tr(Trailer.builder().name("桂AAAAA挂").build())
						.td(Driver.builder().name("桂小健").build())
						.startTime(new Date())
						.endTime(new Date())
						.build(),
				Task.builder()
						.tk(Truck.builder().name("森A11111").build())
						.tr(Trailer.builder().name("桂AAAAA挂").build())
						.td(Driver.builder().name("汤龙").build())
						.startTime(new Date())
						.endTime(new Date())
						.build(),
				Task.builder()
						.tk(Truck.builder().name("森A11111").build())
						.tr(Trailer.builder().name("桂AAAAA挂").build())
						.td(Driver.builder().name("汤龙").build())
						.startTime(new Date())
						.endTime(new Date())
						.build());
	}

	private List<ResCheckRequest> getResult() {


		// 获取所有车头 和 对应的司机集合

		Map<String, List<Task>> tk = tasks.stream()
				.collect(Collectors.groupingBy(task -> task.getTk().getName()));

		List<ResCheckRequest> resTk = tk.entrySet().stream().map(x -> {
			String key = x.getKey();
			List<Task> value = x.getValue();
			ResCheckRequest resCheckRequest = new ResCheckRequest();

			resCheckRequest.setResName(key);
			resCheckRequest.setMinStartTime(value.stream().map(Task::getStartTime).min(Date::compareTo).get());
			resCheckRequest.setMaxEndTime(value.stream().map(Task::getEndTime).max(Date::compareTo).get());

			resCheckRequest.setDrivers(value.stream()
					.map(task -> task.getTd().getName())
					.distinct()
					.collect(Collectors.toList()));

			return resCheckRequest;
		}).collect(Collectors.toList());

		// 获取所有的车厢
		Map<String, List<Task>> tr = tasks.stream().collect(Collectors.groupingBy(task -> task.getTr().getName()));

		List<ResCheckRequest> resTr = tr.entrySet().stream().map(x -> {
			String key = x.getKey();
			ResCheckRequest resCheckRequest = new ResCheckRequest();
			resCheckRequest.setResName(key);
			resCheckRequest.setMinStartTime(x.getValue().stream().map(Task::getStartTime).min(Date::compareTo).get());
			resCheckRequest.setMaxEndTime(x.getValue().stream().map(Task::getEndTime).max(Date::compareTo).get());
			return resCheckRequest;
		}).collect(Collectors.toList());

		// 获取所有的司机

		Map<String, List<Task>> td = tasks.stream().collect(Collectors.groupingBy(task -> task.getTd().getName()));
		List<ResCheckRequest> resTd = td.entrySet().stream().map(x -> {
			String key = x.getKey();
			List<Task> value = x.getValue();
			ResCheckRequest resCheckRequest = new ResCheckRequest();
			resCheckRequest.setResName(key);
			resCheckRequest.setDepartCt(value.get(0).getDepartCt());
			return resCheckRequest;
		}).collect(Collectors.toList());

		resTk.addAll(resTr);
		//	resTk.addAll(resTd);
		return resTk;

	}

	@Test
	public void test_1() {
		long l = System.currentTimeMillis();
		System.out.println("l = " + l);
		List<ResCheckRequest> result = getResult();
		System.out.println("result = " + result);

	}


	/**
	 * 是否故障
	 */
	public static final Integer CHECK_FAULT = 1;
	/**
	 * 合同有效
	 */
	public static final Integer CHECK_CONTRACT = 1 << 1;
	/**
	 * 合同线路
	 */
	public static final Integer CHECK_ROUTE = 1 << 2;
	/**
	 * 城市
	 */
	public static final Integer CHECK_CITY = 1 << 3;
	/**
	 * 车头和司机供应商是否一致
	 */
	public static final Integer CHECK_VENDOR = 1 << 4;
	/**
	 * 发布时间是否在合同有效期内
	 */
	public static final Integer CHECK_CONTRACT_TIME = 1 << 5;

	@Test
	public void test_2() {
		int i = CHECK_CONTRACT | CHECK_FAULT | CHECK_ROUTE | CHECK_CITY | CHECK_VENDOR | CHECK_CONTRACT_TIME;
		System.out.println("i = " + i);
	}

	@Test
	public void test_3() {


		System.out.println("(81 & 10) = " + (81 & 10));
		System.out.println("(81 / 10) = " + (81 / 10));

	}

	@Test
	public void test_4() {

		// 预到达校验通过, 就不需要校验车平台, 否则需要校验车平台

		// 通过
		int SGPass = CHECK_CITY;

		// 通过
		//SGPass = 0;

		int i = SGPass | CHECK_FAULT | CHECK_CONTRACT;


		System.out.println("i = " + i);


	}


	//
}
