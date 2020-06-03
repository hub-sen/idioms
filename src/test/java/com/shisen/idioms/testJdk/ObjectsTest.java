package com.shisen.idioms.testJdk;

import lombok.val;
import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/10/22 11:44
 * </pre>
 */
public class ObjectsTest {

	List<String> lists;

	@Test
	public void test_1() {
		System.out.println("Objects.checkIndex(4,8) = " + Objects.checkIndex(4, 8));
		System.out.println("Objects.checkFromToIndex(4,10,5) = " + Objects.checkFromToIndex(4, 10, 3));
	}

	@Test
	public void test_2() {
		int a = 10;
		int b = 11;
		assert a > b : "a <= b";

	}

	@Test
	public void test_optional() {

		Optional.ofNullable(lists).orElseThrow(() -> new RuntimeException("lists is null"));
	}



	@Test
	public void testMyArray() {
		val myArrayCount = new MyArrayCount();

		Object[] elements = {1, 2, 3};

		myArrayCount.addAll(elements);

		System.out.println("myArrayCount.getCount() = " + myArrayCount.getCount());


	}



}
