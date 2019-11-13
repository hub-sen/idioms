package com.shisen.idioms.check816.packageRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/28 15:15
 * </pre>
 */
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResCheckRequest implements Serializable {
	private static final long serialVersionUID = -3327917216546200911L;
	/**
	 * 是否故障
	 */
	private static final Integer CHECK_FAULT = 1;
	/**
	 * 合同有效
	 */
	private static final Integer CHECK_CONTRACT = 1 << 1;
	/**
	 * 合同线路
	 */
	private static final Integer CHECK_ROUTE = 1 << 2;
	/**
	 * 城市
	 */
	private static final Integer CHECK_CITY = 1 << 3;
	/**
	 * 车头和司机供应商是否一致
	 */
	private static final Integer CHECK_VENDOR = 1 << 4;
	/**
	 * 发布时间是否在合同有效期内
	 */
	private static final Integer CHECK_CONTRACT_TIME = 1 << 5;


	/**
	 * 校验的类型, 必传
	 */
	private Integer checkNum;

	/**
	 * 线路id, 用于校验线路是否和合同上线路一致
	 */
	private Long routeId;

	/**
	 * 始发城市, 用于校验资源是否在当前城市
	 */
	private Integer departCt;

	/**
	 * 资源Id
	 */
	private Integer resId;

	/**
	 * 资源名称
	 */
	private String resName;

	/**
	 * 司机列表
	 */
	private List<String> drivers;

	/**
	 * 计划开始的最小时间, 计划时间是否在合同有效期内
	 */
	private Date minStartTime;

	/**
	 * 计划结束的最大时间, 计划时间是否在合同有效期内
	 */
	private Date maxEndTime;

	public Integer getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(Integer checkNum) {
		this.checkNum = checkNum;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Integer getDepartCt() {
		return departCt;
	}

	public void setDepartCt(Integer departCt) {
		this.departCt = departCt;
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public List<String> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<String> drivers) {
		this.drivers = drivers;
	}

	public Date getMinStartTime() {
		return minStartTime;
	}

	public void setMinStartTime(Date minStartTime) {
		this.minStartTime = minStartTime;
	}

	public Date getMaxEndTime() {
		return maxEndTime;
	}

	public void setMaxEndTime(Date maxEndTime) {
		this.maxEndTime = maxEndTime;
	}
}
