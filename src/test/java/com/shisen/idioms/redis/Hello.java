package com.shisen.idioms.redis;

import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/11/12 17:46
 * </pre>
 */
public class Hello {
    @Test
    public void testHello() {
        String str = "hello";

        for (int i = 0, length = str.length(); i < length; i++) {
            char c = str.charAt(i);
            String s = "0"+Integer.toBinaryString(c);
            System.out.println(c + " \t " + s);
        }
    }
}
