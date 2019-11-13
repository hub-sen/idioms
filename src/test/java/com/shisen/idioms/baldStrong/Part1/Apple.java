package com.shisen.idioms.baldStrong.Part1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <pre>
 * Description
 * </pre>
 */
@Getter
@Setter
@AllArgsConstructor()
@ToString
public class Apple {
	private Color color;

	private int weight;

	@AllArgsConstructor
	@Getter
	@ToString
	public enum Color {
		RED("红色"),
		WRITE("白色"),
		BLACK("黑色"),
		GREEN("绿色"),
		BLUE("蓝色"),
		PURPLE("紫色");

		private String name;

	}

}
