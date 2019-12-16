package com.shisen.idioms.checkNodeGuid.taskType;

import org.springframework.stereotype.Service;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/5 17:44
 * </pre>
 */
@Service
public class Task014 extends AbstractTask {

	private static final String typeOfTrans = "TG";
	private static final String taskDefCode = "014";
	private static final String taskDefName = "不送空";
	private static final ShowNodeResult showNodeResult = new ShowNodeResult(taskDefCode);


	public Task014() {
		super(typeOfTrans, taskDefCode, taskDefName, showNodeResult);
	}

	@Override
	public ShowNodeResult showNode(ShowNodeRequest showNodeRequest) {
		return null;
	}
}
