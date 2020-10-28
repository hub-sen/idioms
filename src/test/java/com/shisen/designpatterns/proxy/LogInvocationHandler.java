package com.shisen.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/10/27 11:41
 * </pre>
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object target;

    public Object newProxyInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();

        Object invoke = method.invoke(this.target, args);

        long end = System.nanoTime();

        System.out.println(this.target.getClass() + "." + method.getName() + "() 方法耗时(纳秒): " + (end - start));

        return invoke;
    }
}
