package com.shisen.idioms.test1018;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/10/21 16:48
 * </pre>
 */
public class TheadId {
	// Atomic integer containing the next thread ID to be assigned
	private static final AtomicInteger nextId = new AtomicInteger(0);

	// Thread local variable containing each thread's ID
	private static final ThreadLocal<Integer> threadId =
			new ThreadLocal<Integer>() {
				@Override protected Integer initialValue() {
					return nextId.getAndIncrement();
				}
			};

	// Returns the current thread's unique ID, assigning it if necessary
	public static int get() {
		return threadId.get();
	}
}
