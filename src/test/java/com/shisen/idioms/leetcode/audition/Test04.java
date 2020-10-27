package com.shisen.idioms.leetcode.audition;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * Description  给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一
 * @author shishi
 * 2020/9/1 18:02
 * </pre>
 */
public class Test04 {

    @Test
    public void app() {
        String str1 = "tactcoa";
        boolean canPermutePalindrome = canPermutePalindrome2(str1);
        System.out.println(canPermutePalindrome);
    }

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0, length = s.length(); i < length; i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        int nums = 0;
        for (Integer value : map.values()) {
            if ((value & 1) == 1) {
                nums++;
            }
        }

        return nums <= 1;
    }

    public boolean canPermutePalindrome2(String s) {
        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!chars.add(c)) {
                chars.remove(c);
            }
        }
        return chars.size() <= 1;
    }

}
