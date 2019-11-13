package com.shisen.idioms.functional;

import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * @author :		shisen
 * @date :	2019/4/3 16:10
 * </pre>
 */
public class Pipeline {
    public static List<Car> createCars() {
        return Arrays.asList(new Car("Jeep", "Wrangler", 2011),
                new Car("Jeep", "Comanche", 1990),
                new Car("Dodge", "Avenger", 2010),
                new Car("Buick", "Cascada", 2016),
                new Car("Ford", "Focus", 2012),
                new Car("Chevrolet", "Geo Metro", 1992));
    }

    /**
     * 获取2000年之后创建的车型,并按照制造年份排序
     */
    public static List<String> getModelsAfter2000UsingFor(@NotNull List<Car> cars) {
        Objects.requireNonNull(cars);
        ArrayList<Car> carsSortedByYear = new ArrayList<>();

        for (Car car : cars) {
            if (car.getYear() > 2000) {
                carsSortedByYear.add(car);
            }
        }

        Collections.sort(carsSortedByYear, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getYear() - o2.getYear();
            }
        });


        ArrayList<String> result = new ArrayList<>();

        for (Car car : carsSortedByYear) {
            result.add(car.getModel());
        }

        return result;
    }

    public static List<String> getModelsAfter2000UsingForWithStream(@NotNull List<Car> cars) {
        Assert.notNull(cars,"cars 不能为空");
        return cars.stream()
                .filter(car -> car.getYear() > 2000)
                .sorted(Comparator.comparingInt(Car::getYear))
                .map(Car::getModel)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Car> cars = createCars();
        List<String> modelsAfter2000UsingFor = getModelsAfter2000UsingFor(cars);
        System.out.println("modelsAfter2000UsingFor = " + modelsAfter2000UsingFor);

        List<String> modelsAfter2000UsingForWithStream = getModelsAfter2000UsingForWithStream(cars);
        System.out.println("modelsAfter2000UsingForWithStream = " + modelsAfter2000UsingForWithStream);
    }


}
