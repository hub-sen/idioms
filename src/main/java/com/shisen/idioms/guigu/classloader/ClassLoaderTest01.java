package com.shisen.idioms.guigu.classloader;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/8/12 13:57
 * </pre>
 */
public class ClassLoaderTest01 {

    private static int num = 1;

    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("systemClassLoader = " + systemClassLoader);
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println("parent = " + parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println("parent1 = " + parent1);

        ClassLoader classLoader = ClassLoaderTest01.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println("classLoader1 = " + classLoader1);
    }
}
