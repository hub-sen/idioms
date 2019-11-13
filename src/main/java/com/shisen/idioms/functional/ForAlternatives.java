package com.shisen.idioms.functional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Author:		shisen
 * Created at:	2019/4/4 16:25
 * </pre>
 */
public class ForAlternatives {
    public static void main(String[] args) {
   /*     for (int i = 1; i < 4; i++) {
            System.out.println("i = " + i);
        }

        System.out.println(" ===================== ");

        IntStream.range(1, 4)
                .forEach(i -> System.out.println("i = " + i));


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i < 10; i++) {
            int temp = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
//                    System.out.println("Running task " + i);
                    System.out.println("Running task " + temp);
                }
            });
            //System.out.println("(temp + 1) = " + (temp ++));
        }
        // executorService.shutdown();

        System.out.println(" =================== ");
        IntStream.range(1,10).forEach(i -> {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running task with range " + i);
                }
            });
           // System.out.println("i+1 = " + (i++));
        });
//        executorService.shutdown();


        System.out.println(" ++++++++++++++++++++++ ");

        IntStream.range(1,10)
                .forEach(i->executorService.submit(()->System.out.println("Running task with lambda " + i)));

        executorService.shutdown();

        System.out.println("------------------------");*/

//        IntStream.rangeClosed(1,10).forEach(System.out::println);


        int total = 0;
        for (int i = 1; i <= 100; i += 3) {
            total += i;
        }

        System.out.println("total = " + total);

        total = 0;

        total = IntStream.iterate(1, e -> e + 3).limit(34).sum();
        System.out.println("total = " + total);

//available in Java 9
/*        IntStream.iterate(1, e ‑ > e + 3)
                  .takeWhile(i ‑ > i <= 100)
                  .sum()*/



    }
}
