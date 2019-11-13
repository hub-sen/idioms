package com.shisen.idioms.baldStrong.Part1.predicates;

import com.shisen.idioms.baldStrong.Part1.Apple;
import com.shisen.idioms.baldStrong.Part1.ApplePredicate;

/**
 * <pre>
 * Description
 * </pre>
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 75;
	}
}
