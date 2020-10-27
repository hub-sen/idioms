package com.shisen.idioms.guigu.jvm;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/8/12 14:28
 * </pre>
 */
public class ClInitTest {

    private int a = 1;

    private static int c = 3;

    public ClInitTest() {
        a = 10;
        int d = 20;
    }

    public static void main(String[] args) {
        int b = 2;
    }
}
