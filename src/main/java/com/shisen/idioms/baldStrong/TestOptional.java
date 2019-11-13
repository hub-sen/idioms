package com.shisen.idioms.baldStrong;

import java.util.Date;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/5/29 18:26
 * </pre>
 */
public class TestOptional {
 /*   public static void main(String[] args) {
        Java8Map java8Map1 = new Java8Map();
        Java8Map java8Map2 = new Java8Map();
        Java8Map java8Map3 = new Java8Map();
        ArrayList<Java8Map> java8Maps1 = new ArrayList<>();
        java8Maps1.add(java8Map1);
        java8Maps1.add(java8Map2);
        java8Maps1.add(java8Map3);

        List<Java8Map> java8Maps2 = new ArrayList<>();
        java8Maps2.add(java8Map1);
        java8Maps2.add(java8Map2);
        java8Maps2.add(java8Map3);
        List<Java8Map> result = new ArrayList<>();
        Optional.ofNullable(java8Maps1).ifPresent(result::addAll);
        Optional.ofNullable(java8Maps2).ifPresent(result::addAll);
        System.out.println("result = " + result);
    }
*/

	public static void main(String[] args) {
		Date endDate = new Date(2019,6,17,23,59,0);
		Date nowDate = new Date(2018,6,18,0,0,0);

		String datePoor = getDatePoor(endDate, nowDate);
		System.out.println("datePoor = " + datePoor);
	}



	public static String getDatePoor(Date endDate, Date nowDate) {
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		long ns = 1000;
		// 获得两个时间的毫秒时间差异
		long diff = endDate.getTime() - nowDate.getTime();
		// 计算差多少天
		long day = diff / nd;
		// 计算差多少小时
		long hour = diff % nd / nh;
		// 计算差多少分钟
		long min = diff % nd % nh / nm;
		// 计算差多少秒//输出结果
		long sec = diff % nd % nh % nm / ns;

		if (sec > 0) {
			min++;
		}
		return recursive(day, hour, min);
	}

	private static String recursive(long day, long hour, long min) {
		if (day >= 365) {
			return "一年以上";
		}
		if (min < 60 && hour < 24) {
			if (day == 0) {
				if (hour == 0) {
					if (min == 0) {
						return "1分钟";
					} else {
						return min + "分钟";
					}
				} else {
					return hour + "小时" + min + "分钟";
				}
			} else {
				if (hour == 0) {
					if (min == 0) {
						return day + "天0小时";
					} else {
						return day + "天" + (hour + 1) + "小时";
					}
				} else {
					if (min == 0) {
						return day + "天" + hour + "小时";
					} else {
						if (hour == 23) {
							//day != 0 && hour != 0 && min != 0
							return (day + 1) + "天0小时";
						} else {
							return day + "天" + (hour + 1) + "小时";
						}
					}
				}
			}
		}

		if (min >= 60) {
			hour++;
			min = 0;
		}
		if (hour >= 24) {
			day++;
			hour = 0;
		}
		return recursive(day, hour, min);
	}

}
