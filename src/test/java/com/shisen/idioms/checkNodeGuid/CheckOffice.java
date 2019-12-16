package com.shisen.idioms.checkNodeGuid;

import com.shisen.idioms.IdiomsApplicationTests;
import com.shisen.idioms.checkNodeGuid.taskType.ShowNodeRequest;
import com.shisen.idioms.checkNodeGuid.taskType.ShowNodeResult;
import com.shisen.idioms.checkNodeGuid.taskType.Task;
import com.shisen.idioms.checkNodeGuid.taskType.WayBill;
import com.shisen.idioms.leetcode.ResOptional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/16 16:56
 * </pre>
 */
public class CheckOffice extends IdiomsApplicationTests implements ApplicationContextAware {


	private Map<String, Task> taskTypes;

	private List<ShowNodeResult> checkResults;

	private ShowNodeRequest checkParams;

	private WayBill wayBill;

	@Before
	public void before() {
		wayBill = new WayBill(2, 1, "PP");
		checkParams = new ShowNodeRequest("K12345678", "TG", new ArrayList<>(), wayBill);
	}


	@After
	public void after() {
		Optional.ofNullable(checkResults).ifPresent(System.out::println);
	}

	@Test
	public void Test() {
		Predicate<String>[] predicate = null;
		@SuppressWarnings("unchecked")
		Stream<Predicate<String>> stream = (Stream<Predicate<String>>) (null == predicate ? Stream.empty() : Stream.of(predicate));
		Predicate<String> stringPredicate = stream.reduce(Predicate::or).orElse(x -> true);

		//	List<Task> collect = this.taskTypes.values().stream().filter(stringPredicate).collect(Collectors.toList());
	}


	@Test
	public void Test2() {
	    String str1 = "12,施森";
		List<String> list = Arrays.asList("璨然", "111");
		String s1 = ResOptional.ofNullable(str1).ifPresentOrElseGet(s -> s = String.join(",", list), () -> String.join(",", list));

		System.out.println("s1 = " + s1);
	}

	@Test
	public void doCheck() {
		ShowNodeRequest showNodeRequest = checkParams;
		// 查询已制定完成的任务
		List<String> allEffectiveTask = Arrays.asList("006", "001");

		List<String> taskDefCodes = checkParams.getTaskDefCodes();

		taskDefCodes.addAll(allEffectiveTask);
		checkParams.setTaskDefCodes(taskDefCodes);

		checkResults = this.taskTypes.values().stream()
				.map(task -> task.showNode(showNodeRequest))
				.filter(Objects::nonNull)
				.filter(ShowNodeResult::getShowNode)
				.collect(Collectors.toList());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.taskTypes = applicationContext.getBeansOfType(Task.class);
	}
}
