package com.shisen.designpatterns.proxy;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/10/27 10:02
 * </pre>
 */
public class ServiceB implements IService{
    @Override
    public void method1() {
        System.out.println("我是 ServiceB 中的 method1 方法!");
    }

    @Override
    public void method2() {
        System.out.println("我是 ServiceB 中的 method2 方法!");
    }

    @Override
    public void method3() {
        System.out.println("我是 ServiceB 中的 method3 方法!");
    }
}
