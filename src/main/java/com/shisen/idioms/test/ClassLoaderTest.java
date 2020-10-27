package com.shisen.idioms.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/8/5 10:40
 * </pre>
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println("classLoader = " + classLoader);


        Method[] methods = ClassLoaderTest.class.getMethods();

        Method myTest = methods[1];

        Type[] genericParameterTypes = null;
        for (Method method : methods) {


            if (method.getName().equals("myTest")) {
                Parameter[] parameters = myTest.getParameters();


                ObjectMapper objectMapper = new ObjectMapper();

                for (Parameter parameter : parameters) {
                    ParameterizedType parameterizedType = (ParameterizedType)parameter.getParameterizedType();

                    Type rawType = parameterizedType.getRawType();

                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (Type actualTypeArgument : actualTypeArguments) {

                        Class<?> aClass = Class.forName(actualTypeArgument.getTypeName());
                        System.out.println("aClass = " + aClass);
                    }
                }

                genericParameterTypes = myTest.getGenericParameterTypes();

            }
        }

        System.out.println("genericParameterTypes = " + genericParameterTypes);


    }


    public void myTest(User<String> user) {


        String name = user.getName();

        String x = user.getX();

        System.out.println("x = " + x);


    }


}
