package com.shisen.aobing.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/21 10:38
 * </pre>
 */
public class ThreadLocalTest01 {


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String date = new ThreadLocalTest01().date(10);
                System.out.println("date = " + date);
            }
        }).start();

        new Thread(() -> {
            String date = new ThreadLocalTest01().date(1000);
            System.out.println("date = " + date);
        }).start();

    }


    private String date(int seconds){
        Date date = new Date(seconds * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);

    }
}
