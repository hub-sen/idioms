package com.shisen.idioms.check816;

import com.shisen.idioms.IdiomsApplicationTests;
import com.shisen.idioms.check816.checkParam.CheckParam;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/16 16:56
 * </pre>
 */
public class CheckOffice extends IdiomsApplicationTests implements ApplicationContextAware {


	private Map<String, CheckType> checkTypes;

	private Map<String, List<CheckResult>> checkResults;

	private List<CheckParam> checkParams;

	@Before
	public void before() {
		checkParams = Arrays.asList(new CheckParam(14, 261L, 510600, "KHHFYL201907182", 12, "QY", 2011, "森A11111"),
				new CheckParam(8, 261L, 510600, "KHHFYL201907182", 12, "QY", 2011, "森B2222挂"),
				new CheckParam(7, 261L, 510600, "KHHFYL201907182", 12, "QY", 2011, "森C33333"));
	}


	@After
	public void after() {
		Optional.ofNullable(checkResults).ifPresent(System.out::println);
	}

	@Test
	public void check() {

		checkResults = checkParams.stream()
				.map(this::doCheck)
				.flatMap(List::stream)
				.collect(Collectors.groupingBy(CheckResult::getName));

	}


	private List<CheckResult> doCheck(CheckParam checkParam) {

		return this.checkTypes.entrySet().stream()
				.filter(x -> (checkParam.getCheckNum() & CheckEnum.valueOf(x.getKey())
						.getNumber()) == CheckEnum.valueOf(x.getKey())
						.getNumber())
				.map(x -> x.getValue().docheck(checkParam))
				.collect(Collectors.toList());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.checkTypes = applicationContext.getBeansOfType(CheckType.class);
	}
}
