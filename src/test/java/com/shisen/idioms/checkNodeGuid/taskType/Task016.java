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
public class Task016 extends AbstractTask implements Task {

	private static final String typeOfTrans = "TG";
	private static final String taskDefCode = "016";
	private static final String taskDefName = "两装";
	private static final ShowNodeResult showNodeResult = new ShowNodeResult(taskDefCode);


	public Task016() {
		super(typeOfTrans, taskDefCode, taskDefName, showNodeResult);
	}

	@Override
	public ShowNodeResult showNode(ShowNodeRequest showNodeRequest) {
		List<String> taskDefCodes = showNodeRequest.getTaskDefCodes();
		WayBill wayBill = showNodeRequest.getWayBill();

		// 必须存在 `用箱计划`
		// 必须存在 `送空箱`, 或 `不送空` 或 `B-C送空`
		// 必须是多装
		// 必须没有做过两装
		if (taskDefCodes.contains("006")) {
			if (taskDefCodes.contains("001") || taskDefCodes.contains("013") || taskDefCodes.contains("014")) {
				if (wayBill.getDepartAddrNum() > 1) {
					if (!taskDefCodes.contains(taskDefCode)) {
						showNodeResult.setShowNode(true);
					}
				}
			}
		}

		return showNodeResult;
	}
}
