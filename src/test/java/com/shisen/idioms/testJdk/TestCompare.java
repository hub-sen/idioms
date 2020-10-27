package com.shisen.idioms.testJdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/10/12 19:38
 * </pre>
 */
@Slf4j
public class TestCompare {

    private List<Person> personList = new ArrayList<>();

    private final static String name = "us";

    @Before
    public void before() {
        Person person1 = new Person("us",26);
        Person person2 = new Person("us",27);
        Person person3 = new Person("zbcjrj",24);
        Person person4 = new Person("zbcjrj",28);
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
    }

    @Test
    public void test_1() {
        List<Person> collect = personList.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .peek(x -> log.info(x.getName() + ", 年龄" + x.getAge()))
                .collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    public void timeDifference(Date beforeTime, Date afterTime) {
        String pattern = "#.#";
        DecimalFormat df = new DecimalFormat(pattern);
        double pow = Math.pow(10, 6);
        String format = df.format((afterTime.getTime() - beforeTime.getTime()) * 0.277777778 / pow);
        System.out.println( "0".equals(format) ? "0.1" : format);
    }

    @Test
    public void timediff() {
        Date date = new Date(2020, 10, 19, 20, 8, 52);
        Date date1 = new Date(2020, 10, 20, 14, 0, 0);
        timeDifference(date,date1);
    }


}
