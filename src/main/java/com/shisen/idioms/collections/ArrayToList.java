package com.shisen.idioms.collections;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Author:		shisen
 * Created at:	2019/4/4 15:37
 * </pre>
 */
public class ArrayToList {
    public static void main(String[] args) {
        System.out.println("args = " + args);
        List<String> list = Arrays.asList(args);
        System.out.println("list = " + list);
        List<String> hello = Arrays.asList("hello");
    }
}
