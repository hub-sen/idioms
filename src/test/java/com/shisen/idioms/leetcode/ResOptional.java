package com.shisen.idioms.leetcode;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * <pre>
 * Description 扩展java.util.Optional
 * @author shishi
 * 2019/12/2 15:48
 * </pre>
 */
public class ResOptional<T> {

	private static final ResOptional<?> EMPTY = new ResOptional<>();

	private T value;

	private ResOptional() {
		this.value = null;
	}

	private ResOptional(T value) {
		this.value = Objects.requireNonNull(value);
	}

	public static <T> ResOptional<T> empty() {
		@SuppressWarnings("unchecked")
		ResOptional<T> t = (ResOptional<T>) EMPTY;
		return t;
	}

	public static <T> ResOptional<T> of(T value) {
		return new ResOptional<>(value);
	}

	public static <T> ResOptional<T> ofNullable(T value) {
		return value == null ? empty() : of(value);
	}

	public Optional<T> toOptional() {
		return Optional.ofNullable(value);
	}

	public void ifPresent(Consumer<? super T> action) {
		if (value != null) {
			action.accept(value);
		}
	}

	public T ifPresentGet(Consumer<? super T> action) {
		if (value != null) {
			action.accept(value);
		}
		return value;
	}

	public void ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction) {
		if (value != null) {
			action.accept(value);
		} else {
			emptyAction.run();
		}
	}

	public T ifPresentOrElseGet(Consumer<? super T> action, Supplier<? extends T> supplier) {
		if (value != null) {
			action.accept(value);
		} else {
			value = supplier.get();
		}
		return value;
	}

	public T get() {
		if (value == null) {
			throw new NoSuchElementException("No value present");
		}
		return value;
	}

	public boolean isPresent() {
		return value != null;
	}

	public boolean isEmpty() {
		return value == null;
	}

	public ResOptional<T> filter(Predicate<? super T> predicate) {
		Objects.requireNonNull(predicate);
		if (!isPresent()) {
			return this;
		} else {
			return predicate.test(value) ? this : empty();
		}
	}

	public <U> ResOptional<U> map(Function<? super T, ? extends U> mapper) {
		Objects.requireNonNull(mapper);
		if (!isPresent()) {
			return empty();
		} else {
			return ResOptional.ofNullable(mapper.apply(value));
		}
	}

	public <U> ResOptional<U> flatMap(Function<? super T, ? extends ResOptional<? extends U>> mapper) {
		Objects.requireNonNull(mapper);
		if (!isPresent()) {
			return empty();
		} else {
			@SuppressWarnings("unchecked")
			ResOptional<U> r = (ResOptional<U>) mapper.apply(value);
			return Objects.requireNonNull(r);
		}
	}

	public ResOptional<T> or(Supplier<? extends ResOptional<? extends T>> supplier) {
		Objects.requireNonNull(supplier);
		if (isPresent()) {
			return this;
		} else {
			@SuppressWarnings("unchecked")
			ResOptional<T> r = (ResOptional<T>) supplier.get();
			return Objects.requireNonNull(r);
		}
	}

	public Stream<T> stream() {
		if (!isPresent()) {
			return Stream.empty();
		} else {
			return Stream.of(value);
		}
	}

	public T orElse(T other) {
		return value != null ? value : other;
	}

	public T orElseGet(Supplier<? extends T> supplier) {
		return value != null ? value : supplier.get();
	}

	public T orElseThrow() {
		if (value == null) {
			throw new NoSuchElementException("No value present");
		}
		return value;
	}

	public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
		if (value != null) {
			return value;
		} else {
			throw exceptionSupplier.get();
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResOptional)) {
			return false;
		}

		ResOptional<?> other = (ResOptional<?>) obj;
		return Objects.equals(value, other.value);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(value);
	}

	@Override
	public String toString() {
		return value != null
				? String.format("ResOptional[%s]", value)
				: "ResOptional.empty";
	}
}
