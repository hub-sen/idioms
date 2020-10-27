package com.shisen.idioms.testJdk;

import java.util.ArrayList;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/10/22 10:30
 * </pre>
 */
public class TestContains {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("12");
        boolean contains = strings.contains("12");
        System.out.println("contains = " + contains);
    }
}
