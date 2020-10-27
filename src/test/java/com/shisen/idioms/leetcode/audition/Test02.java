package com.shisen.idioms.leetcode.audition;

import org.junit.Test;

import java.util.HashMap;

/**
 * <pre>
 * Description  给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串
 * @author shishi
 * 2020/8/31 19:22
 * </pre>
 */
public class Test02 {


    @Test
    public void app() {
        String str1 = "abcbb";
        String str2 = "bcacc";
        boolean checkPermutation = checkPermutation(str1, str2);
        System.out.println(checkPermutation);
    }

    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0, length = s1.length(); i < length; i++) {

            map.merge(s1.charAt(i), 1, Integer::sum);
            map.merge(s2.charAt(i), -1, Integer::sum);
        }

        for (Integer value : map.values()) {
            if (!value.equals(0)) {
                return false;
            }
        }

        return true;
    }
}
