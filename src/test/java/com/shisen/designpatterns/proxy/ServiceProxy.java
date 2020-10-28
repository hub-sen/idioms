package com.shisen.designpatterns.proxy;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/10/27 10:06
 * </pre>
 */
public class ServiceProxy implements IService{
    private IService target;

    public ServiceProxy(IService target) {
        this.target = target;
    }

    @Override
    public void method1() {
        long start = System.nanoTime();
        target.method1();
        long end = System.nanoTime();
        System.out.println(this.target.getClass() + ".method1() 耗时(纳秒):" + (end - start));
    }

    @Override
    public void method2() {
        long start = System.nanoTime();
        target.method2();
        long end = System.nanoTime();
        System.out.println(this.target.getClass() + ".method2() 耗时(纳秒):" + (end - start));
    }

    @Override
    public void method3() {
        long start = System.nanoTime();
        target.method3();
        long end = System.nanoTime();
        System.out.println(this.target.getClass() + ".method3() 耗时(纳秒):" + (end - start));
    }
}
