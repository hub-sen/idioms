package com.shisen.idioms.checkNodeGuid.taskType;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/5 17:44
 * </pre>
 */
@Service
public class Task006 extends AbstractTask {

	private static final String typeOfTrans = "TG";
	private static final String taskDefCode = "006";
	private static final String taskDefName = "用厢计划";
	private static final ShowNodeResult showNodeResult = new ShowNodeResult(taskDefCode);

	public Task006() {
		super(typeOfTrans, taskDefCode, taskDefName, showNodeResult);
	}

	@Override
	public ShowNodeResult showNode(ShowNodeRequest showNodeRequest) {

		boolean b = transTypeCdEqualsCheck(showNodeRequest.getTransTypeCd());


		System.out.println("b = " + b);


		List<String> taskDefCodes = showNodeRequest.getTaskDefCodes();
		WayBill wayBill = showNodeRequest.getWayBill();

		// 没有用箱计划, 就必须做用箱计划
		if (!taskDefCodes.contains(taskDefCode)) {
			showNodeResult.setShowNode(true);
		}

		return showNodeResult;
	}
}
