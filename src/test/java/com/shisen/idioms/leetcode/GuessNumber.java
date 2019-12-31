package com.shisen.idioms.leetcode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 * Description  小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 *
 * @author shishi
 * 2019/12/30 10:49
 * </pre>
 */
public class GuessNumber {

	private int[] guess;
	private int[] answer;
	private int result;

	@Before
	public void before() {
		guess = new int[]{1, 2, 3};
		answer = new int[]{2, 2, 3};
	}

	@After
	public void after() {
		System.out.println("guess: " + Arrays.toString(guess) + "\nanswer: " + Arrays.toString(answer) + "\nresult: " + result);
	}

	@Test
	public void test_1() {
		result = game(guess, answer);
	}

	public int game(int[] guess, int[] answer) {
		int temp = 0;
		for (int i = 0; i < guess.length; i++) {
			if (guess[i] == answer[i]) {
				temp++;
			}
		}
		return temp;
	}
}
