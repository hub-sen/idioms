package com.shisen.idioms.test903;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/9/3 13:26
 * </pre>
 */
@Accessors(chain = true)
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Student {
	private String name;
	private LocalDate birthday;
	private String birthdayStr;
}
