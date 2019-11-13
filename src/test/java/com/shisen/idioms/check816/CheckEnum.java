package com.shisen.idioms.check816;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/19 20:13
 * </pre>
 */
@Getter
@AllArgsConstructor
public enum CheckEnum {
	checkCity("checkCity", 1),
	checkContract("checkContract", 1 << 1),
	checkRoute("checkRoute", 1 << 2),
	checkShift("checkShift", 1 << 3);

	private String code;
	private Integer number;

}
