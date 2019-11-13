package com.shisen.idioms.eclipseCollections.Test1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/6/24 20:27
 * </pre>
 */

@Getter
@Setter
@AllArgsConstructor
public class Animal {

	private String name;

	private AnimalType animalType;

	private List<Food> favoriteFood;


	enum AnimalType {
		ZEBRA,
		TIGER,
		GIRAFFE,
	}
}

