package com.shisen.idioms.baldStrong.Part1.predicates;

import com.shisen.idioms.baldStrong.Part1.Apple;
import com.shisen.idioms.baldStrong.Part1.ApplePredicate;

import static com.shisen.idioms.baldStrong.Part1.Apple.Color.GREEN;

/**
 * <pre>
 * Description
 * </pre>
 */
public class AppleGreenColorPredicate implements ApplePredicate {
	@Override
	public boolean test(Apple apple) {
		return GREEN.equals(apple.getColor());
	}
}
