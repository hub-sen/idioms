package com.shisen.idioms.test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/8/5 10:40
 * </pre>
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);
    }
}
