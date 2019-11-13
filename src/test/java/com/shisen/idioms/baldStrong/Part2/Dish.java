package com.shisen.idioms.baldStrong.Part2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * Description
 * </pre>
 */
@Getter
@Setter
@AllArgsConstructor
public class Dish {
	private String name;
	/**
	 * 素食
	 */
	private Boolean vegetarian;
	/**
	 * 卡路里
	 */
	private int calories;
	//private Type type;

	public enum Type{

	}
}
