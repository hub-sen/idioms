package com.shisen.idioms.functional;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * @author :		shisen
 * @date :	2019/4/3 10:18
 * </pre>
 */
public class FindNemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");
        imperativeFindNemo(names, "Nemo");
        declarativeFindNemo(names,"Nemo");
    }

    /**
     * 命令式的
     *
     * @param list
     */
    public static void imperativeFindNemo(List<String> list, String findName) {
        Assert.notEmpty(list, "list 不能为空");
        Assert.hasText(findName, "findName 不能为空");
        boolean found = false;
        for (String name : list) {
            if (findName.equals(name)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Found " + findName);
        } else {
            System.out.println("Not found " + findName);
        }
    }

    /**
     * 声明式的
     *
     * @param list
     * @param findName
     */
    public static void declarativeFindNemo(List<String> list, String findName) {
        Assert.notEmpty(list, "list 不能为空");
        Assert.hasText(findName, "findName 不能为空");
        if (list.contains(findName)) {
            System.out.println("Found " + findName);
        } else {
            System.out.println("Not found " + findName);
        }
    }


}
