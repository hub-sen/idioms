package com.shisen.idioms.baldStrong.Part5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <pre>
 * Description
 * </pre>
 */
public class exam {

	private List<Integer> nums;
	private int target;
	private List<Integer> result;
	private List<Result> resultList;

	private long startTime;
	private long endTime;

	@Before
	public void before() {
		nums = Arrays.asList(4, 4, 2, 5, 1, 7);
		target = 8;
		result = new ArrayList<>();
		resultList = new ArrayList<>();
	}

	@After
	public void after() {
		if (CollectionUtils.isEmpty(result)) {
			//System.out.println("未找到!!");
		} else {
			System.out.println("result = " + result);
			result.forEach(index -> System.out.println(nums.get(index)));
		}

		resultList.forEach(System.out::println);

		System.out.println("总用时: " + (endTime - startTime));

	}


	@Test
	public void test1() {
		for (int i = 0, left; i < nums.size(); i++) {
			if ((left = nums.get(i)) > target) continue;
			for (int j = i + 1; j < nums.size(); j++)
				if (left + nums.get(j) == target) {
					result.add(i);
					result.add(j);
					return;
				}
		}
	}


	@Test
	public void test2() {
		startTime = System.nanoTime();
		for (int i = 0, left; i < nums.size(); i++) {
			if ((left = nums.get(i)) > target) continue;
			for (int j = i + 1; j < nums.size(); j++)
				if (left + nums.get(j) == target) resultList.add(new Result(i, j, left, nums.get(j)));
		}
		endTime = System.nanoTime();
	}


	@Test
	public void test3() {
		startTime = System.nanoTime();
		IntStream.range(0, nums.size())
				.parallel()
				.filter(left -> nums.get(left) < target)
				.forEach(left -> IntStream.range(left + 1, nums.size())
						.parallel()
						.filter(right -> nums.get(left) + nums.get(right) == target)
						.forEach(right -> resultList.add(new Result(left, right, nums.get(left), nums.get(right)))));
		endTime = System.nanoTime();
	}


	// 时间复杂度：O(n)
	// 空间复杂度：O(n)
	@Test
	public void test4() {
		startTime = System.nanoTime();
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) > target) {
				continue;
			}
			Integer complement = target - nums.get(i);
			if (map.containsKey(complement)) {
				System.out.println(map.get(complement) + "----" + i);
				break;
			}

			map.put(nums.get(i), i);

		}
		endTime = System.nanoTime();

	}


	@Getter
	@Setter
	@AllArgsConstructor
	@ToString
	private class Result {
		private Integer leftIndex;
		private Integer rightIndex;
		private Integer leftValue;
		private Integer rightValue;
	}

}
