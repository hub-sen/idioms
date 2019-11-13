package com.shisen.idioms.test1018;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * <pre>
 * Description
 * @author shishi
 * 2019/10/21 17:58
 * </pre>
 */
public class LogHandler implements InvocationHandler {

	private Object targetObject;

	public Object newProxyInstance(Object object) {
		this.targetObject = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("前置... ...");

		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof Interceptor) {
				Interceptor annotation1 = (Interceptor) annotation;
				System.out.println("annotation1.value() = " + annotation1.value());
			}
			System.out.println("annotation = " + annotation.annotationType());
		}

		System.out.println("annotations = " + annotations);
		Interceptor annotation = method.getAnnotation(Interceptor.class);
		System.out.println("annotation = " + annotation);
		if (Objects.nonNull(method.getAnnotation(Interceptor.class))) {
			System.out.println("有注解, 要执行");
		}

		Object invoke = method.invoke(targetObject, args);
		System.out.println("后置... ...");
		return invoke;
	}
}
