package com.shisen.idioms.checkNodeGuid.taskType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/5 17:43
 * </pre>
 */
@Getter
@Setter
@ToString
public class ShowNodeResult {
	String taskDefCode;
	boolean showNode;
	ShowNodeResult(String taskDefCode){
		this.taskDefCode = taskDefCode;
	}
}
