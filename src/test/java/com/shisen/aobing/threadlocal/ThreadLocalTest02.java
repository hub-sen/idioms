package com.shisen.aobing.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/21 10:42
 * </pre>
 */
public class ThreadLocalTest02 {

    public static ExecutorService THRED_POOL = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            THRED_POOL.submit(()->{
                String date = new ThreadLocalTest02().date(finalI);
                System.out.println("date = " + date);
            });
        }
        THRED_POOL.shutdown();
    }



    private String date(int seconds){
        Date date = new Date(seconds * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);

    }
}
