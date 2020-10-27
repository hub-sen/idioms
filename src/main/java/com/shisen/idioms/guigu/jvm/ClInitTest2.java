package com.shisen.idioms.guigu.jvm;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/8/12 14:39
 * </pre>
 */
public class ClInitTest2 {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        }, "线程1").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        }, "线程2").start();


    }


}

class DeadThread {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            while (true) {

            }
        }
    }
}
