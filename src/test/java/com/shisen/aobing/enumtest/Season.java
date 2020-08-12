package com.shisen.aobing.enumtest;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/15 14:53
 * </pre>
 */
public enum Season {
    SPRING(0), SUMMER(1), AUTUMN(2), WINTER(3);

    private int value;

    Season(int value) {
        this.value = value;
    }

    public static Season getNextSeason(Season nowSeason) {
        int nextSeasonValue = nowSeason.value;

        if (++nextSeasonValue == 4) {
            nextSeasonValue = 0;
        }

        return getSeasonByValue(nextSeasonValue);

    }

    public static Season getSeasonByValue(int value) {
        for (Season season : Season.values()) {
            if (season.value == value) {
                return season;
            }
        }
        return null;
    }
}
