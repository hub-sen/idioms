package com.shisen.idioms.format;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/6/20 18:19
 * </pre>
 */
public class StringFormat {
    @Test
    public void test_1() {
        LocalDateTime now = LocalDateTime.now();


        System.out.println("now.toLocalDate() = " + now.toLocalDate());
        System.out.println("now.toLocalTime() = " + now.toLocalTime());

        String dataStr = String.format("%tY-%tm-%td %tH:%tM:%tS", now, now, now, now, now, now);
        System.out.println("now = " + now);
        System.out.println("dataStr = " + dataStr);


        String format = String.format("第一名:%d分,第二名:%d分,第三名:%d分", 11, 12, 13);

        System.out.println(format);
    }

    @Test
    public void test_2() {

        Date date1 = new Date(2019, 6, 30, 18, 0, 0);
        Date date2 = new Date(2019, 6, 30, 18, 1, 59);

        double minute = (date2.getTime() - date1.getTime()) / 60000.0;

        double v1 = minute / 60;


        double ceil = Math.ceil(v1 * 10) / 10;
        System.out.println("minute = " + minute);

        System.out.println("小时 = " + v1);
        System.out.println("格式化后 = " + ceil);

    }

    @Test
    public void test_3() {
        System.out.println("12000-11700 = " + (12000 - 11700));
    }


    @Test
    public void test_4() {
        List<jiagequjian> jiagequjians = Arrays.asList(new jiagequjian(1, 0, 0, 30000),
                new jiagequjian(3, 100, 200, 50000),
                new jiagequjian(26, 350, 450, 120000),
                new jiagequjian(37, 450, 650, 42000),
                new jiagequjian(43, 700, 950, 421000));

        int jage = 1;

        jiagequjians.stream()
                .filter(e -> jage > e.getMinPrice())
                .filter(e -> jage < e.getMaxPrice())
                .max(Comparator.comparing(jiagequjian::getMinPrice))
                .ifPresentOrElse(
                        e -> System.out.println(jage + " => 取 [" + e.getMinPrice() + "," + e.getMaxPrice() + "]  押金 => " + e
                                .getAmount()),
                        () -> System.out.println(jage + " => 未查询到价格区间, 取默认值")
                );

    }


}

@Getter
@Setter
@AllArgsConstructor
class jiagequjian {
    private int id;
    private int minPrice;
    private int maxPrice;
    private int amount;
}
