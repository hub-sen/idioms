package com.shisen.idioms.leetcode;

import lombok.Getter;
import lombok.Setter;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/12/30 13:06
 * </pre>
 */
@Getter
@Setter
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}

}
