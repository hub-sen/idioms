package com.shisen.guava;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Ordering;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/9/7 17:09
 * </pre>
 */
public class OrderingTest {

    private String name;
    private int age;

    @Test
    public void test01() {

        ImmutableList<Foo> immutableList = ImmutableList.of(new Foo("b"), new Foo("c"), new Foo("a"));

        List<Foo> fooLists = new ArrayList<>();
        fooLists.add(new Foo("b"));
        fooLists.add(new Foo("c"));
        fooLists.add(new Foo("a"));
        fooLists.add(new Foo());


        Ordering<Foo> fooOrdering = Ordering.natural().nullsFirst().onResultOf(new Function<Foo, String>() {
            @Override
            public @Nullable String apply(@Nullable Foo input) {
                return input.sortedBy;
            }
        });

        Ordering<Foo> fooOrdering2 = Ordering.natural().nullsLast().onResultOf(Foo::getSortedBy).reverse();


        List<Foo> foos = fooOrdering.sortedCopy(immutableList);
        List<Foo> foos1 = fooOrdering2.sortedCopy(fooLists);

        System.out.println("foos = " + foos);


    }

    @Test
    public void test02() {
        ImmutableSet<String> digits = ImmutableSet.of(
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine");

        List<String> strings = Arrays.asList(
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine");

        ImmutableListMultimap<Integer, String> index = Multimaps.index(strings, String::length);

        System.out.println("index = " + index);

    }

}

@Data
class Foo {
    @Nullable String sortedBy;
    int notSortedBy;

    public Foo(@Nullable String sortedBy) {
        this.sortedBy = sortedBy;
    }

    public Foo() {
    }
}