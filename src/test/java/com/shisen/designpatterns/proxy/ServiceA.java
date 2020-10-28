package com.shisen.designpatterns.proxy;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/10/27 10:01
 * </pre>
 */
public class ServiceA implements IService {
    @Override
    public void method1() {
        System.out.println("我是 ServiceA 中的 method1 方法!");
    }

    @Override
    public void method2() {
        System.out.println("我是 ServiceA 中的 method2 方法!");
    }

    @Override
    public void method3() {
        System.out.println("我是 ServiceA 中的 method3 方法!");
    }
}
