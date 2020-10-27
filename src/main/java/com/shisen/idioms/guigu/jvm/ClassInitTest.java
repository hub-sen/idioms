package com.shisen.idioms.guigu.jvm;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/8/12 14:18
 * </pre>
 */
public class ClassInitTest {
    private static int num = 1;

    static {
        num = 2;
        number = 20;
        System.out.println("num = " + num);
        // System.out.println("number = " + number); // 错误的前项引用
    }

    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.number);
    }
}
