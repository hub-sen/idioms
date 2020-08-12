package com.shisen.aobing.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/21 10:47
 * </pre>
 */
public class ThreadLocalTest03 {
    public static ExecutorService THRED_POOL = Executors.newFixedThreadPool(10);

    static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            THRED_POOL.submit(()->{
                String date = new ThreadLocalTest03().date_2(finalI);
                System.out.println("date = " + date);
            });
        }
        THRED_POOL.shutdown();
    }



    private String date_1(int seconds){
        Date date = new Date(seconds * 1000);
        return SIMPLE_DATE_FORMAT.format(date);
    }

    private String date_2(int seconds) {
        Date date = new Date(seconds * 1000);

        String format;
        synchronized (ThreadLocalTest03.class){
            format = SIMPLE_DATE_FORMAT.format(date);
        }

        return format;
    }
}
