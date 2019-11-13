package com.shisen.idioms.eclipseCollections.Test1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/6/24 20:23
 * </pre>
 */
@Getter
@Setter
@AllArgsConstructor
public class Food {

	private String name;

	private FoodType foodType;

	private Integer numbers;

	enum FoodType {
		FRUIT,
		DESSERT,
		VEGETABLE,
		MEAT,
	}
}

