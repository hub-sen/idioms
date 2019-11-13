package com.shisen.idioms.functional;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * @author :		shisen
 * @date :	2019/4/3 16:12
 * </pre>
 */
public class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}
