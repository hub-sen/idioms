package com.shisen.aobing.enumtest;

import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/15 14:56
 * </pre>
 */
public class TestApp {

    @Test
    public void testSeason() {
        System.out.println("Season.SUMMER = " + Season.SUMMER);
    }


    @Test
    public void testSeason2() {
        Season season = Season.getSeasonByValue(3);
        System.out.println("season = " + season);
        Season nextSeason = Season.getNextSeason(season);
        System.out.println("nextSeason = " + nextSeason);

    }


    @Test
    public void testSingleton() {
        SingletonObject instance0 = SingletonObject.getInstance();
        SingletonObject instance1 = SingletonObject.getInstance();

        System.out.println("instance0 = " + instance0);
        System.out.println("instance1 = " + instance1);
    }



}
