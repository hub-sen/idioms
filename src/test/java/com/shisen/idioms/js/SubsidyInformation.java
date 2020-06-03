package com.shisen.idioms.js;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <pre>
 * Description  短驳合同的补贴信息, 包含各种补贴信息
 * @author shishi
 * 2020/1/2 17:30
 * </pre>
 */
@Getter
@Setter
public class SubsidyInformation implements Serializable {
	private static final long serialVersionUID = 2836864046415997113L;
	/**
	 * 任务补贴.
	 */
	private BigDecimal taskSubsidy;

	/**
	 * 兜底任务数.
	 */
	private int pocketTaskNum;

	/**
	 * 超任务数补贴.
	 */
	private BigDecimal subTaskSubsidy;

	/**
	 * 兜底里程.
	 */
	private double pocketMileage;

	/**
	 * 抽红利里程.
	 */
	private double dividendMileage;

	/**
	 * 抽红利里程分段.
	 */
	private List<DividendMileageSegmentationDto> dividendMileageSegmentation;

}
