package com.shisen.idioms.enumtest;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/8/7 16:30
 * </pre>
 */
@Getter
@AllArgsConstructor
public enum TestEnum implements EnumInterface<String, String> {
	/**
	 * 签约合同
	 */
	QY("QY", "签约合同"),
	/**
	 * 外雇合同(企业)
	 */
	B("B", "外雇合同"),
	/**
	 * 外雇合同(个人)
	 */
	C("C", "外雇合同"),
	/**
	 * 短驳合同
	 */
	DQY("DQY", "短驳合同");

	private String code;

	private String message;

}
