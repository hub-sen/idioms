package com.shisen.idioms.leetcode;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/***
 * 发车状态修改
 *
 * <pre>
 * Description
 * Copyright:	Copyright (c)2014
 * Company:		上海天地汇
 * Author:		wangkun
 * Version:		1.0
 * Created at:	2017-2-8 下午3:38:06
 * </pre>
 */
public class DepartOrderStateUpdateDto {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long departId = null;

	private String departNo = null;

	@NotBlank
	private String sourceProdCd;
	/**
	 * L:已装车 D:在途中 ARV:已到达 UL:已接车
	 */
	@NotBlank
	private String stateCd = null;

	@Size(max = 256, message = "允许最大字符串长度为256")
	private String comments;

	/**
	 * 操作类型：0正常，1异常<br/>
	 * 不填默认正常
	 *
	 */
	private Byte stateType = 0;
	/**
	 * 经度
	 */
	private BigDecimal longitude = null;
	/**
	 * 纬度
	 */
	private BigDecimal latitude = null;

	/**
	 * 对外描述
	 */
	private String exterDesc;
	/**
	 * 对内描述
	 */
	private String innerDesc;
	/**
	 * 城市代码
	 */
	private Integer cityCt;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 地址
	 */
	private String address;

	/**
	 * 异常类型：TJ堵车异常，OTHER其它异常；操作类型为异常时，异常类型必填
	 */
	private String abnormalType;
	/**
	 * 异常子类类型
	 */
	private String abnormalItemType;

	/**
	 * 异常开始时间 操作类型为异常时，异常开始时间必填
	 */
	private Date startTime;

	/**
	 * 异常结束时间 操作类型为异常时，异常结束时间必填
	 */
	private Date endTime;

	/**
	 * 默认非客户处发货
	 */
	private Boolean customerDelivery = false;

	/**
	 * 默认非送货完成
	 */
	private Boolean deliverEnded = false;

	/**
	 * 位置id
	 */
	private Long locationId;

	/**
	 * 堵车异常状态：TJSTART-堵车开始;TJEND-堵车结束
	 */
	private String trafficJamState;

	/**
	 * 新车头牌号
	 */
	private String newTruckPlateNo;

	/**
	 * 新挂箱牌号
	 */
	private String newTrailerPlateNo;

	/**
	 * 允许提交结算(1-允许，0-不允许)
	 */
	@Max(value = 1, message = "值只能是0或1")
	@Min(value = 0, message = "值只能是0或1")
	private Byte finFlag = null;

	public Long getDepartId() {
		return departId;
	}

	public void setDepartId(Long departId) {
		this.departId = departId;
	}

	public String getDepartNo() {
		return departNo;
	}

	public void setDepartNo(String departNo) {
		this.departNo = departNo;
	}

	public String getSourceProdCd() {
		return sourceProdCd;
	}

	public void setSourceProdCd(String sourceProdCd) {
		this.sourceProdCd = sourceProdCd;
	}

	public String getStateCd() {
		return stateCd;
	}

	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Byte getStateType() {
		return stateType;
	}

	public void setStateType(Byte stateType) {
		this.stateType = stateType;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public String getExterDesc() {
		return exterDesc;
	}

	public void setExterDesc(String exterDesc) {
		this.exterDesc = exterDesc;
	}

	public String getInnerDesc() {
		return innerDesc;
	}

	public void setInnerDesc(String innerDesc) {
		this.innerDesc = innerDesc;
	}

	public Integer getCityCt() {
		return cityCt;
	}

	public void setCityCt(Integer cityCt) {
		this.cityCt = cityCt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAbnormalType() {
		return abnormalType;
	}

	public void setAbnormalType(String abnormalType) {
		this.abnormalType = abnormalType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Boolean getCustomerDelivery() {
		return customerDelivery;
	}

	public void setCustomerDelivery(Boolean customerDelivery) {
		this.customerDelivery = customerDelivery;
	}

	public Boolean getDeliverEnded() {
		return deliverEnded;
	}

	public void setDeliverEnded(Boolean deliverEnded) {
		this.deliverEnded = deliverEnded;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getTrafficJamState() {
		return trafficJamState;
	}

	public void setTrafficJamState(String trafficJamState) {
		this.trafficJamState = trafficJamState;
	}

	public String getNewTruckPlateNo() {
		return newTruckPlateNo;
	}

	public void setNewTruckPlateNo(String newTruckPlateNo) {
		this.newTruckPlateNo = newTruckPlateNo;
	}

	public String getNewTrailerPlateNo() {
		return newTrailerPlateNo;
	}

	public void setNewTrailerPlateNo(String newTrailerPlateNo) {
		this.newTrailerPlateNo = newTrailerPlateNo;
	}

	public String getAbnormalItemType() {
		return abnormalItemType;
	}

	public void setAbnormalItemType(String abnormalItemType) {
		this.abnormalItemType = abnormalItemType;
	}

	public Byte getFinFlag() {
		return finFlag;
	}

	public void setFinFlag(Byte finFlag) {
		this.finFlag = finFlag;
	}

}
