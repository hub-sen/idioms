package com.shisen.idioms.leetcode.audition;

import org.junit.Test;

/**
 * <pre>
 * Description  字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）
 * @author shishi
 * 2020/9/2 15:19
 * </pre>
 */
public class Test06 {


    @Test
    public void app() {
        String str = "aabcccccaaad";

        String s = compressString(str);
        System.out.println("s = " + s);

    }

    public String compressString(String S) {

        if (S == null || S.length() <= 2) {
            return S;
        }

        StringBuilder stringBuilder = new StringBuilder().append(S.charAt(0));

        int tempNum = 1;
        int length = S.length();
        for (int i = 1; i < length; i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                stringBuilder.append(tempNum).append(S.charAt(i));
                tempNum = 1;
            } else {
                tempNum++;
            }
        }

        return stringBuilder.append(tempNum).length() > length ? S : stringBuilder.toString();
    }
}
