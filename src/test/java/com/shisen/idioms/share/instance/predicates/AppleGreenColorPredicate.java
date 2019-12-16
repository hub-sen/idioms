package com.shisen.idioms.share.instance.predicates;

import com.shisen.idioms.share.instance.Apple;
import com.shisen.idioms.share.instance.ApplePredicate;

import static com.shisen.idioms.share.instance.Apple.Color.GREEN;


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
