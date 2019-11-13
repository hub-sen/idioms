package com.shisen.idioms.check816;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/16 18:02
 * </pre>
 */
@Accessors(chain = true)
@Getter
@Setter
@Builder
@ToString
public class CheckResult {
	String name;
	String checkResult;
}
