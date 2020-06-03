package com.shisen.idioms.js;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <pre>
 * Description  红利分段信息
 * @author shishi
 * 2020/1/14 12:25
 * </pre>
 */
@Setter
@Getter
public class DividendMileageSegmentationDto implements Serializable {
	private static final long serialVersionUID = -8682128768055937592L;
	private Integer startIndex;
	private Integer endIndex;
	private BigDecimal cost;
}
