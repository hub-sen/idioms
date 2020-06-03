package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Before;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/1/9 13:46
 * </pre>
 */
public class DeleteNode {

	private ListNode listNode;

	@Before
	public void before() {
		listNode = new ListNode(4);
	}

	@After
	public void after() {
		while (null != listNode) {
			System.out.println("listNode.getVal() = " + listNode.getVal());
			listNode = listNode.getNext();
		}
	}



	public void deleteNode(ListNode node) {
		node.setNext(node.next.next);
	}
}
