package com.shisen.idioms.test1018;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * <pre>
 * Description  菜单 VO 类
 * @author shishi
 * 2019/10/18 19:30
 * </pre>
 */

@Setter
@Getter
@ToString
public class MenuVO {
	/**
	 * 菜单标识
	 */
	private Long id;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 菜单链接
	 */
	private String url;
	/**
	 * 子菜单列表
	 */
	private List<MenuVO> childList;
}
