package com.shisen.idioms.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/4/4 15:52
 * </pre>
 */
public class Person implements Iterable<Person> {
    private String firstName;
    private String lastName;
    private int age;
    private List<Person> children = new ArrayList<>();


    public Person(String firstName, String lastName, int age, Person... kids) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        for (Person child : kids) {
            children.add(child);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public Iterator<Person> iterator() {
        return children.iterator();
    }


    public static void main(String[] args) {
        Person ted = new Person("Ted", "Neward", 39,
                new Person("Michael", "Neward", 16),
                new Person("Matthew", "Neward", 10));
        for (Person kid : ted) {
            System.out.println("kid = " + kid);
        }
    }
}
