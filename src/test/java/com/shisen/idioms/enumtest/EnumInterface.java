package com.shisen.idioms.enumtest;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/7 17:39
 * </pre>
 */
public interface EnumInterface<T, V> {
	T getCode();

	V getMessage();
}
