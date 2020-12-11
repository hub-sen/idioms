package com.shi.sen.juc;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/11 11:00
 * </pre>
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {

            int finalI = i;
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(CountryEnum.getCountryEnumByCode(finalI).getMessage() + "国被灭");
                countDownLatch.countDown();
            }, String.valueOf(finalI)).start();

        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("秦一统华夏");

    }
}

enum CountryEnum {
    /**
     * 齐
     */
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩");
    @Getter
    private Integer code;
    @Getter
    private String message;
    private static Map<Integer, CountryEnum> cacheMap;

    CountryEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CountryEnum getCountryEnumByCode(Integer code) {
        return cacheMap.get(code);
    }

    static {
        cacheMap = Arrays.stream(CountryEnum.values())
                .collect(Collectors.toMap(CountryEnum::getCode, Function.identity()));
    }
}

