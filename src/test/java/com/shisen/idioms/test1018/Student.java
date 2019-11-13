package com.shisen.idioms.test1018;

import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * Description  学生类
 * @author shishi
 * 2019/10/21 11:34
 * </pre>
 */
@Setter
@Getter
public class Student extends Person {
	private String studentNo;
	private String className;

	@Override
	public String toString() {
		return "Student{" +
				"studentNo='" + studentNo + '\'' +
				", className='" + className + '\'' +
				"} " + super.toString();
	}
}
