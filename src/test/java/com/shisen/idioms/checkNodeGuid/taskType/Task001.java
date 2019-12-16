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
public class Task001 extends AbstractTask{

	private static final String typeOfTrans = "TG";
	private static final String taskDefCode = "001";
	private static final String taskDefName = "送空箱";
	private static final ShowNodeResult showNodeResult = new ShowNodeResult(taskDefCode);


	Task001() {
		super(typeOfTrans, taskDefCode, taskDefName, showNodeResult);
	}

	@Override
	public ShowNodeResult showNode(ShowNodeRequest showNodeRequest) {
		//
		return null;
	}
}
