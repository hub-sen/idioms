package com.shisen.idioms.check816.checkParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/23 16:32
 * </pre>
 */
@Accessors(chain = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
public class CheckParam {

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
	 * 资源绑定的合同No, 用于校验合同是否生效
	 */
	private String contractNo;

	/**
	 * 资源所在班组
	 */
	private Integer shiftNo;

	/**
	 * 资源类型
	 */
	private String resTypeCd;

	/**
	 * 资源Id
	 */
	private Integer resId;

	/**
	 * 资源名称
	 */
	private String resName;

}
