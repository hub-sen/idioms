package com.shisen.idioms.hutool;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/4/7 14:16
 * </pre>
 */
public class DateUtilsTest {
    @Test
    public void one() {
        Date date = new Date();
        System.out.println("date = " + date);
        DateTime dateTime = DateUtil.beginOfMonth(date);
        System.out.println("dateTime = " + dateTime);
    }


    @Test
    public void two() {
        Date date = new Date();
        System.out.println("date = " + date);
        Date truncate = DateUtils.truncate(date, Calendar.MONTH);
        System.out.println("truncate = " + truncate);
        System.out.println(String.format("%tF %tT", truncate, truncate));

        System.out.println("date = " + date);
        Date ceiling = DateUtil.truncate(date, DateField.MONTH);
        System.out.println(String.format("%tF %tT", ceiling, ceiling));

        Date date1 = DateUtils.setHours(date, 23);
        Date date2 = DateUtils.setMinutes(date1, 59);
        Date date3 = DateUtils.setSeconds(date2, 59);
        System.out.println("date3 = " + date3);
    }

    @Test
    public void three() {
        TCCost tcCost1 = new TCCost("1", BigDecimal.valueOf(12));
        TCCost tcCost2 = new TCCost("1", null);
        TCCost tcCost3 = new TCCost("2", BigDecimal.valueOf(465));
        TCCost tcCost4 = new TCCost("2", BigDecimal.valueOf(4654));
        ArrayList<TCCost> tcCosts = new ArrayList<>();
        tcCosts.add(tcCost1);
        tcCosts.add(tcCost2);
        tcCosts.add(tcCost3);
        tcCosts.add(tcCost4);
        List<TCCost> collect = tcCosts.stream()
                .filter(tcCost -> Objects.nonNull(tcCost.getPlateNo()) && Objects.nonNull(tcCost.getCost()))
                .collect(Collectors.groupingBy(TCCost::getPlateNo, Collectors.reducing(BigDecimal.ZERO, TCCost::getCost, BigDecimal::add)))
                .entrySet()
                .stream()
                .map(entry -> new TCCost(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        System.out.println("collect = " + collect);

    }
}
