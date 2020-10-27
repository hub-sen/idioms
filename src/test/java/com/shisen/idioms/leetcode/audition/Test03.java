package com.shisen.idioms.leetcode.audition;

import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/9/1 17:35
 * </pre>
 */
public class Test03 {
    @Test
    public void app() {
        String str1 = "a bcbb";
        String checkPermutation = replaceSpaces(str1, str1.length());
        System.out.println(checkPermutation);
    }

    public String replaceSpaces(String S, int length) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
