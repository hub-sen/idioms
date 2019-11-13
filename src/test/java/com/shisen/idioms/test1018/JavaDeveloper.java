package com.shisen.idioms.test1018;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/10/21 17:28
 * </pre>
 */
public class JavaDeveloper implements Developer {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void code() {
		System.out.println(this.name + " is coding java !");
	}

	@Override
	@Interceptor("hello")
	public void debug() {
		System.out.println(this.name + " is debugging java !");
	}

	@Test
	public void test_1() {
		JavaDeveloper ran = new JavaDeveloper();
		ran.setName("ran");

		Developer proxyInstance = (Developer) Proxy.newProxyInstance(ran.getClass().getClassLoader(), ran.getClass().getInterfaces(), (proxy, method, args) -> {
			if (method.getName().equals("code")) {
				System.out.println("准备!!!");
				return method.invoke(ran, args);
			}
			if (method.getName().equals("debug")) {
				if (ran.name.equals("ran")) {
					System.out.println("many bugs !!!");
					return method.invoke(ran, args);
				}
				System.out.println("no bug !!!");
			}
			return null;
		});

		proxyInstance.code();
		proxyInstance.debug();

	}

	@Test
	public void test_2() {
		JavaDeveloper javaDeveloper = new JavaDeveloper();
		javaDeveloper.setName("ran");
		Developer instance = (Developer)new LogHandler().newProxyInstance(javaDeveloper);
		instance.code();
	}


}
