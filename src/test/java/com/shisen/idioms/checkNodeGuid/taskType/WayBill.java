package com.shisen.idioms.checkNodeGuid.taskType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/5 19:24
 * </pre>
 */
@Getter
@Setter
@AllArgsConstructor
public class WayBill {
	/**
	 * 运单出发地址数目，默认一个.
	 *
	 * @mbggenerated
	 */
	private Integer departAddrNum;

	/**
	 * 运单到达地址数目，默认一个.
	 *
	 * @mbggenerated
	 */
	private Integer arriveAddrNum;

	/**
	 * 干线合同发车类型：门门-DD，门池DP，池池PP，池门PD. Column: tbl_plan.contract_depart_cd
	 */
	private String contractDepartCd;
}
