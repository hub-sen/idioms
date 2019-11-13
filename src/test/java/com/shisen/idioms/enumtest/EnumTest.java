package com.shisen.idioms.enumtest;

import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/7 17:22
 * </pre>
 */
public class EnumTest {

	@Test
	public void test_1() {
		System.out.println(EnumUtil.getEnumMsgByCode(TestEnum.class, "QY"));
	}

	@Test
	public void test_2() {
		System.out.println(EnumUtil.getEnumCodeByMsg(TestEnum.class, "签约合同"));
	}
}
