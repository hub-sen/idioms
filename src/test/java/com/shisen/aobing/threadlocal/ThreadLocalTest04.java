package com.shisen.aobing.threadlocal;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/21 10:54
 * </pre>
 */
public class ThreadLocalTest04 {
    public static ExecutorService THRED_POOL = Executors.newFixedThreadPool(10);


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            THRED_POOL.submit(()->{
                String date = new ThreadLocalTest04().date(finalI);
                System.out.println("date = " + date);
            });
        }
        THRED_POOL.shutdown();
    }

    private String date(int seconds){
        Date date = new Date(seconds * 1000);
        return DateFormatUtils.dateFormatThreadLocal.get().format(date);
    }



}
