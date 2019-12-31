package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Test;

/**
 * <pre>
 * Description  平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
 *
 * 你可以按照下面的规则在平面上移动：
 *
 * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 * @author shishi
 * 2019/12/30 11:42
 * </pre>
 */
public class MinTimeToVisitAllPoints {

	private int[][] points = {{3, 2}, {-2, 2}};

	private int result;

	@After
	public void after() {
		System.out.println("result = " + result);
	}

	@Test
	public void test_1() {
		result = minTimeToVisitAllPoints(points);
	}

	public int minTimeToVisitAllPoints(int[][] points) {
		int temp = 0;
		for (int i = 0; i < points.length - 1; i++) {
			temp += Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
		}
		return temp;
	}
}
