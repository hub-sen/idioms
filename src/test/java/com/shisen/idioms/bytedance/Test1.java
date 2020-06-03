package com.shisen.idioms.bytedance;

import org.junit.Test;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * <pre>
 * Description   无重复字符的最长子串
 * Created at:	2019/7/4 14:51
 * </pre>
 */
public class Test1 {

	@Test
	public void lengthOfLongestSubstring() {
		String str = "abcabcbb";

		StringBuilder result = new StringBuilder();

		int length = 0;
		for (int i = 0; i < str.length(); i++) {
			if (result.indexOf("" + str.charAt(i)) >= 0) {
				length = Math.max(result.length(), length);
				result = new StringBuilder();
			}
			result.append(str.charAt(i));
		}
		System.out.println(length);
	}

	@Test
	public void longestCommonPrefix() {
		String[] strs = {"flower", "flow", "flight"};

		String firstStr = strs[0];

		for (int i = 1, end = firstStr.length(); i < end; i++) {
			String pre = firstStr.substring(0, i);
			if (!Stream.of(strs).allMatch(str -> str.contains(pre))) {
				firstStr = firstStr.substring(0, i - 1);
				break;
			}
		}

		System.out.println("firstStr = " + firstStr);

	}

	@Test
	public void checkInclusion() {
		String s1 = "ab";
		String s2 = "eidbaooo";


		List<String> permutation = permutation(s1.toCharArray(), 0, s1.length(), new ArrayList<>());


		System.out.println("permutation = " + permutation);

		boolean b = permutation.stream().anyMatch(s2::contains);
		System.out.println("b = " + b);
	}


	private List<String> permutation(char[] arr, int index, int size, @NotNull List<String> result) {
		if (index == size) {
			result.add(new String(arr));
		} else {
			for (int i = index; i < size; i++) {
				if (i != index && arr[i] == arr[index]) {
					continue;
				}
				swap(arr, i, index);
				permutation(arr, index + 1, size, result);
				swap(arr, i, index);
			}
		}
		return result;
	}

	private void swap(char[] arr, int idx1, int idx2) {
		char temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	/**
	 * num1 和 num2 的长度小于110。
	 * num1 和 num2 只包含数字0-9。
	 * num1 和 num2 均不以零开头，除非是数字 0 本身。
	 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
	 */
	@Test
	public void multiply() {
		String num1 = "99999";
		String num2 = "99999";

		String multiply = multiply(num1, num2);
		System.out.println("multiply = " + multiply);
	}

	private String multiply(String num1, String num2) {
		if (StringUtils.isEmpty(num1) || StringUtils.isEmpty(num2)) {
			return "";
		}
		int len1 = num1.length();
		int len2 = num2.length();
		int[] result = new int[len1 + len2];

		for (int j = len2 - 1; j >= 0; j--) {
			for (int i = len1 - 1; i >= 0; i--) {
				int p1 = i + j;
				int p2 = i + j + 1;
				int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + result[p2];
				result[p2] = num % 10;
				result[p1] += num / 10;
			}
		}
		StringBuilder finalResult = new StringBuilder();
		for (int num : result) {
			if (num == 0 && finalResult.length() == 0) {
				continue;
			}
			finalResult.append(num);
		}

		return finalResult.length() == 0 ? "0" : finalResult.toString();
	}
}
