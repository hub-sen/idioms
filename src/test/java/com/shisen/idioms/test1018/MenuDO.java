package com.shisen.idioms.test1018;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <pre>
 * Description  菜单 DO 类
 * @author shishi
 * 2019/10/18 19:29
 * </pre>
 */
@Setter
@Getter
@ToString
public class MenuDO {
	/**
	 * 菜单标识
	 */
	private Long id;
	/**
	 * 菜单父标识
	 */
	private Long parentId;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 菜单链接
	 */
	private String url;
}
