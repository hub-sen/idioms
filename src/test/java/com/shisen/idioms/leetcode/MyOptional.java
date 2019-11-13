package com.shisen.idioms.leetcode;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/11/8 11:43
 * </pre>
 */
public class MyOptional<T> {

	private static final MyOptional<?> EMPTY = new MyOptional<>();

	private T value;

	private MyOptional() {
		this.value = null;
	}

	private MyOptional(T value) {
		this.value = Objects.requireNonNull(value);
	}

	public static <T> MyOptional<T> empty() {
		@SuppressWarnings("unchecked")
		MyOptional<T> t = (MyOptional<T>) EMPTY;
		return t;
	}

	public static <T> MyOptional<T> of(T value) {
		return new MyOptional<>(value);
	}

	public static <T> MyOptional<T> ofNullable(T value) {
		return value == null ? empty() : of(value);
	}

	public void ifPresent(Consumer<? super T> consumer) {
		if (value != null) {
			consumer.accept(value);
		}
	}

	public void ifPresent(Consumer<? super T> consumer, Runnable emptyAction) {
		if (null != value) {
			consumer.accept(value);
		} else {
			emptyAction.run();
		}
	}
}
