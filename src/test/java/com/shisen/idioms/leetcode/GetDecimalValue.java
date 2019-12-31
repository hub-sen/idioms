package com.shisen.idioms.leetcode;

import java.util.Objects;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/30 13:07
 * </pre>
 */
public class GetDecimalValue {


	public int getDecimalValue(ListNode head) {
		int temp = 0;
		do {
			temp = temp >> 1;
			temp = temp | head.getVal();

		} while (Objects.nonNull(head = head.getNext()));

		return temp;
	}
}
