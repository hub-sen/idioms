package com.shisen.idioms.longtest;

import java.util.Objects;
import java.util.function.Function;

public class Try {

	public static <T, R> Function<T, R> of(UncheckedFunction<T, R> mapper) {
		Objects.requireNonNull(mapper);
		return t -> {
			try {
				return mapper.apply(t);
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		};
	}

	public static <T, R> Function<T, R> of(
			UncheckedFunction<T, R> mapper, R defaultR) {
		Objects.requireNonNull(mapper);
		return t -> {
			try {
				return mapper.apply(t);
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
				return defaultR;
			}
		};
	}

	@FunctionalInterface
	public static interface UncheckedFunction<T, R> {

		R apply(T t) throws Exception;
	}
}