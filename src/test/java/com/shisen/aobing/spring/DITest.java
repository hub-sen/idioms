package com.shisen.aobing.spring;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/12/1 10:31
 * </pre>
 */
public class DITest {
    private static Map<String, Object> cacheMap = new HashMap<>();

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class[] classes = {A.class, B.class};


        for (Class aClass : classes) {
            getBean(aClass);
        }


        System.out.println("getBean(A.class).getB() == getBean(B.class) = " + (getBean(A.class).getB() == getBean(B.class)));
        System.out.println("getBean(B.class).getA() == getBean(A.class) = " + (getBean(B.class).getA() == getBean(A.class)));

    }


    private static <T> T getBean(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String className = clazz.getSimpleName().toLowerCase();

        if (cacheMap.containsKey(className)) {
            return (T) cacheMap.get(className);
        }

        Object object = clazz.getDeclaredConstructor().newInstance();

        cacheMap.put(className, object);

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            Class<?> fieldType = field.getType();
            String fieldTypeName = fieldType.getSimpleName().toLowerCase();

            field.set(object, cacheMap.containsValue(fieldTypeName) ? cacheMap.get(fieldTypeName) : getBean(fieldType));
        }


        return (T) object;
    }
}
