package com.shisen.idioms.leetcode.audition;

import org.junit.Test;

/**
 * <pre>
 * Description  实现一个算法，确定一个字符串 s 的所有字符是否全都不同
 * @author shishi
 * 2020/8/31 19:12
 * </pre>
 */
public class Test01 {


    @Test
    public void app() {
        String str = "abc";
        boolean isUnique = isUnique(str);
        System.out.println(str + ": " + isUnique);
    }

    private boolean isUnique(String astr) {

        int index = 0;
        int length = astr.length();
        while (index < length) {
            if (astr.indexOf(astr.charAt(index++), index) > -1) {
                return false;
            }
        }

        return true;
    }
}
