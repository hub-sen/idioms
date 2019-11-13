package com.shisen.idioms.check816.packageRequest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/29 15:30
 * </pre>
 */
@Setter
@Getter
@Builder
public class Task {
	private Truck tk;
	private Trailer tr;
	private Driver td;
	private Integer routeId;
	private Date startTime;
	private Date endTime;
	private Integer departCt;
}
