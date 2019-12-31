package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 * Description  给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * @author shishi
 * 2019/12/30 11:25
 * </pre>
 */
public class DefangIPaddr {
	private String address;
	private String result;

	@Before
	public void before() {
		address = "114.114.114.114";
	}

	@After
	public void after() {
		System.out.println("result = " + result);
	}

	@Test
	public void test_1() {
		result = defangIPaddr(address);
	}


	public String defangIPaddr(String address) {
		StringBuilder stringBuffer = new StringBuilder();
		for (char c : address.toCharArray()) {
			if ('.' == c) {
				stringBuffer.append("[.]");
			} else {
				stringBuffer.append(c);
			}
		}
		return stringBuffer.toString();
	}
}
