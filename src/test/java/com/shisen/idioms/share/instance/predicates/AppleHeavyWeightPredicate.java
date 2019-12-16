package com.shisen.idioms.share.instance.predicates;

import com.shisen.idioms.share.instance.Apple;
import com.shisen.idioms.share.instance.ApplePredicate;

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
