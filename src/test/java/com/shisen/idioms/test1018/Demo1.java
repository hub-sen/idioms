package com.shisen.idioms.test1018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * <pre>
 * Description  给定一个字符串 (不一定全为字母)，请返回第一个重复出现的字符。
 * @author shishi
 * 2019/10/18 17:39
 * </pre>
 */
public class Demo1 {

	private String str;

	private Character character;

	private static  ThreadLocal<MenuDO> LOCAL_THREAD = new ThreadLocal<>();

	@Before
	public void before() {
		str = "qwertnsadan";
	}

	@After
	public void after() {
		Optional.ofNullable(character).ifPresent(System.out::println);
	}

	@Test
	public void test1() {
		character = findFirstRepeatedChar_1(str);
	}

	@Test
	public void test2() {
		character = findFirstRepeatedChar_2(str);
	}

	private Character findFirstRepeatedChar_1(String str) {
		if (Objects.isNull(str) || str.isEmpty()) {
			return null;
		}

		char[] chars = str.toCharArray();

		HashSet<Character> set = new HashSet<>(chars.length);
		for (char c : chars) {
			if (set.contains(c)) {
				return c;
			}
			set.add(c);
		}

		return null;
	}

	private Character findFirstRepeatedChar_2(String str) {
		if (Objects.isNull(str) || str.isEmpty()) {
			return null;
		}

		char[] chars = str.toCharArray();
		HashSet<Object> set = new HashSet<>(chars.length);
		for (char c : chars) {
			if (!set.add(c)) {
				return c;
			}
		}

		return null;
	}

	private Character findFirstRepeatedChar_3(String str) {
		if (Objects.isNull(str) || str.isEmpty()) {
			return null;
		}
		// TODO

		return null;
	}

	@Test
	public void test3() {
	    //给定菜单记录列表，每条菜单记录中包含父菜单标识（根菜单的父菜单标识为 null ），构建出整个菜单树。

	}

	/** 构建菜单树函数 */
	public static List<MenuVO> buildMenuTree(List<MenuDO> menuList) {
		// 检查列表为空
		if (CollectionUtils.isEmpty(menuList)) {
			return Collections.emptyList();
		}

		// 依次处理菜单
		int menuSize = menuList.size();
		List<MenuVO> rootList = new ArrayList<>(menuSize);
		Map<Long, MenuVO> menuMap = new HashMap<>(menuSize);
		for (MenuDO menuDO : menuList) {
			// 赋值菜单对象
			Long menuId = menuDO.getId();
			MenuVO menu = menuMap.get(menuId);
			if (Objects.isNull(menu)) {
				menu = new MenuVO();
				menu.setChildList(new ArrayList<>());
				menuMap.put(menuId, menu);
			}
			menu.setId(menuDO.getId());
			menu.setName(menuDO.getName());
			menu.setUrl(menuDO.getUrl());

			// 根据父标识处理
			Long parentId = menuDO.getParentId();
			if (Objects.nonNull(parentId)) {
				// 构建父菜单对象
				MenuVO parentMenu = menuMap.get(parentId);
				if (Objects.isNull(parentMenu)) {
					parentMenu = new MenuVO();
					parentMenu.setId(parentId);
					parentMenu.setChildList(new ArrayList<>());
					menuMap.put(parentId, parentMenu);
				}

				// 添加子菜单对象
				parentMenu.getChildList().add(menu);
			} else {
				// 添加根菜单对象
				rootList.add(menu);
			}
		}

		// 返回根菜单列表
		return rootList;
	}


}
