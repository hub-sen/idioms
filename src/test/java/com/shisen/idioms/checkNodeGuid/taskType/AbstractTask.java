package com.shisen.idioms.checkNodeGuid.taskType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Predicate;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/5 17:54
 * </pre>
 */
@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractTask implements Task {
	private String typeOfTrans;
	private String taskDefCode;
	private String taskDefName;
	private ShowNodeResult showNodeResult;

	public boolean transTypeCdEqualsCheck(String typeOfTrans) {
		return transTypeCdCheck(typeOfTrans::equals);
	}

	public boolean transTypeCdCheck(Predicate<String> predicate) {
		return predicate.test(typeOfTrans);
	}

	public boolean taskDefCodeEqualsCheck(String taskDefCode) {
		return taskDefCodeCheck(x -> x.equals(taskDefCode));
	}

	public boolean taskDefCodeCheck(Predicate<String> predicate) {
		return predicate.test(taskDefCode);
	}
}
