package com.shisen.designpatterns.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/10/27 10:05
 * </pre>
 */
public class ProxyTest {
    @Test
    public void test1() {
        ServiceA serviceA = new ServiceA();
        ServiceB serviceB = new ServiceB();
        serviceA.method1();
        serviceA.method2();
        serviceA.method3();
        serviceB.method1();
        serviceB.method2();
        serviceB.method3();
    }

    @Test
    public void test2() {
        ServiceProxy serviceProxyA = new ServiceProxy(new ServiceA());
        ServiceProxy serviceProxyB = new ServiceProxy(new ServiceB());

        serviceProxyA.method1();
        serviceProxyA.method2();
        serviceProxyA.method3();
        serviceProxyB.method1();
        serviceProxyB.method2();
        serviceProxyB.method3();

    }

    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1, 获取接口类对应的代理类
        Class<IService> proxyClass = (Class<IService>) Proxy.getProxyClass(IService.class.getClassLoader(), IService.class);
        // 2, 创建代理类的处理器
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是 InvocationHandler, 被调用的方法是: " + method.getName());
                return null;
            }
        };
        // 3, 创建代理类实例
        IService proxyService = proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);

        // 4, 调用代理类方法
        proxyService.method1();
        proxyService.method2();
        proxyService.method3();

    }

    @Test
    public void test4() {
        // 1, 创建代理类处理器
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            System.out.println("我是 InvocationHandler, 被调用的方法是: " + method.getName());
            return null;
        };

        // 1, 直接创建代理类实例
        IService proxyInstance = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class}, invocationHandler);
        proxyInstance.method1();
        proxyInstance.method2();
        proxyInstance.method3();

    }

    @Test
    public void test5() {
        IService serviceA = CostTimeInvocationHandler.creatProxy(new ServiceA(), IService.class);
        IService serviceB = CostTimeInvocationHandler.creatProxy(new ServiceB(), IService.class);

        serviceA.method1();
        serviceA.method2();
        serviceA.method3();
        serviceB.method1();
        serviceB.method2();
        serviceB.method3();

    }

    @Test
    public void test6() {
        IUserService userService = CostTimeInvocationHandler.creatProxy(new UserService(), IUserService.class);
        userService.insert("施森");
    }

    @Test
    public void test7() {
        IUserService userService = (IUserService)new LogInvocationHandler().newProxyInstance(new UserService());
        userService.insert("施森");

    }
}
