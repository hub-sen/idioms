package com.shisen.idioms.leetcode.audition;

import org.junit.Test;

/**
 * <pre>
 * Description  字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑
 * @author shishi
 * 2020/9/2 14:59
 * </pre>
 */
public class Test05 {


    @Test
    public void app() {
        String s1 = "pale", s2 = "pale";

        boolean b = oneEditAway(s1, s2);
        System.out.println("b = " + b);
    }

    public boolean oneEditAway(String first, String second) {

        int length1 = first.length();
        int length2 = second.length();

        if (Math.abs(length1 - length2) > 1) {
            return false;
        }

        if (length2 > length1) {
            return oneEditAway(second, first);
        }

        for (int i = 0; i < length2; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(i + 1).equals(second.substring(length1 == length2 ? i + 1 : i));
            }
        }
        return true;
    }
}
