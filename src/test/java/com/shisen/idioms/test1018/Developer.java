package com.shisen.idioms.test1018;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/10/21 17:27
 * </pre>
 */
public interface Developer {
	void code();

	@Interceptor("hello")
	void debug();
}
