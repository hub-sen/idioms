package com.shisen.idioms.functional;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * @author :		shisen
 * Created at:	2019/4/3 11:02
 * </pre>
 */
public class UseMap {
    public static void main(String[] args) {
        Map<String, Integer> pageVisits = new HashMap<>();
        String page = "https://agiledeveloper.com";
        imperativeIncrementPageVisit(pageVisits,page);
        imperativeIncrementPageVisit(pageVisits,page);
        System.out.println(pageVisits.get(page));

        functionalIncrementPageVisit(pageVisits,page);
        functionalIncrementPageVisit(pageVisits,page);
        System.out.println(pageVisits.get(page));

    }

    /**
     * 命令式的
     *
     * @param pageVisits
     * @param page
     */
    public static void imperativeIncrementPageVisit(Map<String, Integer> pageVisits, String page) {
        Assert.notNull(pageVisits,"pageVisits 不能为空");
        Assert.hasText(page,"page 不能为空");

        if (!pageVisits.containsKey(page)) {
            pageVisits.put(page, 0);
        }
        pageVisits.put(page, pageVisits.get(page) + 1);
    }

    public static void functionalIncrementPageVisit(Map<String, Integer> pageVisits, String page) {
        Assert.notNull(pageVisits,"pageVisits 不能为空");
        Assert.hasText(page,"page 不能为空");

        pageVisits.merge(page, 1, Integer::sum);
    }
}
