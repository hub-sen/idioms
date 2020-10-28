package com.shisen.designpatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/10/27 10:38
 * </pre>
 */
public class CostTimeInvocationHandler implements InvocationHandler {

    private Object target;

    public CostTimeInvocationHandler(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.nanoTime();

        Object invoke = method.invoke(this.target, args);

        long end = System.nanoTime();

        System.out.println(this.target.getClass() + "." + method.getName() + "() 方法耗时(纳秒): " + (end - start));

        return invoke;
    }

    public static <T> T creatProxy(Object target, Class<T> targetInterface) {
        if (!targetInterface.isInterface()) {
            throw new IllegalStateException("targetInterface 必须是接口类型");
        } else if (!targetInterface.isAssignableFrom(target.getClass())) {
            throw new IllegalStateException("target 必须是 targetInterface 的实现类");
        }
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{targetInterface}, new CostTimeInvocationHandler(target));
    }


}
