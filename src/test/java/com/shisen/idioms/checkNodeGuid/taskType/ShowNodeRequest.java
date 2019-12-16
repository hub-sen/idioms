package com.shisen.idioms.checkNodeGuid.taskType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/5 17:43
 * </pre>
 */
@Getter
@Setter
@AllArgsConstructor
public class ShowNodeRequest {
	String orderNo;
	String transTypeCd;
	List<String> taskDefCodes;
	WayBill wayBill;
}
