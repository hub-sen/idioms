package com.shisen.idioms.testJdk;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/28 16:35
 * </pre>
 */
public class MyArray {
    private List<Object> a = new ArrayList<>();


    public void add(Object element) {
        a.add(element);
    }

    public void addAll(Object[] elements) {
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
    }


    // 5-29 19:24:52  8-31 01:24:52

    @Test
    public void date() {
        LocalDateTime from = LocalDateTime.of(2020, 5, 29, 19, 24, 52);
        LocalDateTime to = LocalDateTime.of(2020, 8, 31, 01, 24, 52);

        int i = from.compareTo(to);


        int fromSecond = from.getSecond();

        int toSecond = to.getSecond();

        int beteewn = toSecond - fromSecond;

        long betSeconds = TimeUnit.SECONDS.toSeconds(beteewn);
        long betMinutes = TimeUnit.SECONDS.toMinutes(beteewn);
        long betHours = TimeUnit.SECONDS.toHours(beteewn);
        long betDays = TimeUnit.SECONDS.toDays(beteewn);

        System.out.println("天 = " + betDays);
        System.out.println("时 = " + betHours);
        System.out.println("分 = " + betMinutes);
        System.out.println("秒 = " + betSeconds);


        BigDecimal divide = BigDecimal.valueOf(940832999)
                .divide(BigDecimal.valueOf(1000))
                .setScale(2, RoundingMode.HALF_UP)
                .stripTrailingZeros();
        System.out.println("divide = " + divide);

        System.out.println("valueOf = " + BigDecimal.valueOf(0).stripTrailingZeros());


    }


}
