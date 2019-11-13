package com.shisen.idioms.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/6/12 20:08
 * </pre>
 */
@Accessors(chain = true)
@Getter
@Setter
public class Lombok {

	private String name;

	private int age;

	private int isLove;

	private Boolean isHero;

	public static void main(String[] args) {
		Lombok lombok = new Lombok();
		lombok.setName("施森").setAge(18).setIsHero(true);
	}
}
