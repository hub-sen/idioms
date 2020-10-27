package com.shisen.idioms.test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/8/28 18:00
 * </pre>
 */
public class User<T> {
    private String name;
    private T x;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }
}
