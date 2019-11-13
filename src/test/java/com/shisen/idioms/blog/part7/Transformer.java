package com.shisen.idioms.blog.part7;

/**
 * <pre>
 * Description
 * </pre>
 */
@FunctionalInterface
public interface Transformer<T> {
	T transform(T input);
}
