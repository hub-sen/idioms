package com.shisen.idioms.guigu.jvm;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/8/12 14:28
 * </pre>
 */
public class ClInitTest1 {

    static class Father{
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Son extends Father{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println("Son.B = " + Son.B);
    }
}
