package com.shisen.idioms.collections;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * <pre>
 * Description
 * </pre>
 */
public class TestList {
    List<Demo> first = new ArrayList<>();

    @Before
    public void before() {
        Demo demo1 = new Demo();
        demo1.setPlateNo("4");
        Demo demo2 = new Demo();
        demo2.setPlateNo("4");
        Demo demo3 = new Demo();
        demo3.setPlateNo("3");
        Demo demo4 = new Demo();
        demo4.setPlateNo("4");
        Demo demo5 = new Demo();
        demo5.setPlateNo("4");

        first.add(demo1);
        first.add(demo2);
        first.add(demo3);
        first.add(demo4);
        first.add(demo5);


    }

    @Test
    public void test_2() {
        BigDecimal bigDecimal = BigDecimal.valueOf(0.0004);
        System.out.println("bigDecimal = " + bigDecimal);

    }

    @Test
    public void test_1() {
        List<Demo> demos = excelCheck(first, (one, two) -> one.getPlateNo().equals(two.getPlateNo()));
    }

    private <T extends ImportDto> List<T> excelCheck(List<T> importDto, BiPredicate<T, T> predicate) {

        for (int i = 0; i < importDto.size(); i++) {
            T one = importDto.get(i);
            if (!one.getResult()) {
                continue;
            }
            for (int j = i + 1; j < importDto.size(); j++) {
                T two = importDto.get(j);
                if (predicate.test(one, two)) {
                    one.setResult(false);
                    two.setResult(false);
                }
            }
        }

        return importDto;
    }


    @Test
    public void arraysTest() {
        Sub[] subs = {new Sub(), new Sub()};
        System.out.println("subs.getClass() = " + subs.getClass());

        Base[] bases = subs;
        System.out.println("bases.getClass() = " + bases.getClass());

        bases[0] = new Base();
    }


    @Test
    public void arrayListTest1() {
        ArrayList<String> list = new ArrayList();
        list.add("123");
        list.add("234");
        Object[] objects = list.toArray();
        System.out.println("objects.getClass() = " + objects.getClass());
        objects[0] = 1234;
    }

    @Test
    public void arrayListTest2() {
        List<String> list = Arrays.asList("abc");
        Object[] objects = list.toArray();
        System.out.println("objects.getClass() = " + objects.getClass());
        objects[0] = 1234;
    }

    @Test
    public void arrayListTest3() {
        ArrayList<String> list = new ArrayList();
        list.add("123");
        list.add("234");
    }


    @Test
    public void batch() {
        ArrayList<Integer> all = new ArrayList<>();
        all.add(0);
        all.add(1);
        all.add(2);
        all.add(3);
        all.add(4);
        all.add(5);
        all.add(6);
        all.add(7);
        all.add(8);
        all.add(9);
        all.add(10);
        all.add(11);


        int groupSize = 10;

        List<Integer> subList = null;
        for (int i = 0,groupNo = all.size() / groupSize; i < groupNo; i++) {
            subList = all.subList(0, groupSize);
            System.out.println("subList = " + subList);
            all.subList(0, groupSize).clear();
        }
        if (all.size() > 0) {
            System.out.println("all = " + all);
        }


    }


}
