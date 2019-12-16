package com.shisen.idioms.baldStrong.Part1.predicates;

import com.shisen.idioms.baldStrong.Part1.Apple;
import com.shisen.idioms.baldStrong.Part1.ApplePredicate;

import static com.shisen.idioms.baldStrong.Part1.Apple.Color.GREEN;

/**
 * <pre>
 * Description
 * </pre>
 */
public class AppleGreenColorPredicate<T extends Apple> implements ApplePredicate<T> {
	@Override
	public boolean test(T t) {
		return GREEN.equals(t.getColor());
	}
}
