package com.shisen.aobing.jvm;

import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/7/21 18:17
 * </pre>
 */
public class Test01 {
    public static void main(String[] args) {
        Shisen shisen = new Shisen();
        shisen.start();
        for (; ; ) {
            synchronized (shisen) {
                if (shisen.isFlag()) {
                    System.out.println("有点东西");
                }
            }
        }
    }


    @Test
    public void test_01() {
        Shisen shisen = new Shisen();
        shisen.start();
        for (; ; ) {
            if (shisen.isFlag()) {
                System.out.println("有点东西");
            }
        }
    }


}

class Shisen extends Thread {

    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.flag = true;
        System.out.println("flag = " + flag);
    }
}
