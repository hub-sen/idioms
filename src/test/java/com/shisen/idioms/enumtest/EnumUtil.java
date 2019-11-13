package com.shisen.idioms.enumtest;

import java.util.HashMap;
import java.util.Map;

public class EnumUtil {

	private static Map<String, EnumInterface[]> enumConstantDirectory = new HashMap<>();

	/**
	 * 通过Code获取Message
	 *
	 * @param enumClass
	 * @param code
	 * @param <T>
	 * @param <V>
	 * @param <E>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, V, E extends EnumInterface<T, V>> V getEnumMsgByCode(Class<E> enumClass, T code) {

		enumConstantDirectory.putIfAbsent(enumClass.getSimpleName(), enumClass.getEnumConstants());

		for (E each : (E[]) enumConstantDirectory.get(enumClass.getSimpleName())) {
			if (each.getCode().equals(code)) {
				return each.getMessage();
			}
		}

		throw new IllegalArgumentException(enumClass.getSimpleName() + " has no this code of " + code);
	}

	/**
	 * 通过Code获取Message
	 *
	 * @param enumClass
	 * @param msg
	 * @param <T>
	 * @param <V>
	 * @param <E>
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, V, E extends EnumInterface<T, V>> T getEnumCodeByMsg(Class<E> enumClass, V msg) {

		enumConstantDirectory.putIfAbsent(enumClass.getSimpleName(), enumClass.getEnumConstants());

		for (E each : (E[]) enumConstantDirectory.get(enumClass.getSimpleName())) {
			if (each.getMessage().equals(msg)) {
				return each.getCode();
			}
		}

		throw new IllegalArgumentException(enumClass.getSimpleName() + " has no this message of " + msg);
	}

}