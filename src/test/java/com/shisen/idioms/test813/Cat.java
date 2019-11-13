package com.shisen.idioms.test813;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/13 9:55
 * </pre>
 */
@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Cat {
	private int age;
	private int height;
}
