package com.shisen.idioms.baldStrong.Part1.predicates;

import com.shisen.idioms.baldStrong.Part1.Apple;
import com.shisen.idioms.baldStrong.Part1.ApplePredicate;

/**
 * <pre>
 * Description
 * </pre>
 */
public class AppleHeavyWeightPredicate<T extends Apple> implements ApplePredicate<T> {
	@Override
	public boolean test(T t) {
		return t.getWeight() > 75;
	}
}
