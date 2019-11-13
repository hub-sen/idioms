package com.shisen.idioms.baldStrong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/5/29 10:58
 * </pre>
 */
public class Java8Map {
    //给定一个 List<String>，统计每个元素出现的所有位置
    //["a", "b", "b", "c", "c", "c", "d", "d", "d", "f", "f", "g"]


    private static Map<String, List<Integer>> getElementPositions(List<String> list) {
        HashMap<String, List<Integer>> positionMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            List<Integer> positions = positionMap.get(str);
            if (null == positions) {
                positions = new ArrayList<>();
                positionMap.put(str, positions);
            }
            positions.add(i);
        }
        return positionMap;
    }


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "b", "c", "c", "c", "d", "d", "d", "f", "f", "g");
        Map<String, List<Integer>> elementPositions = getElementPositions(strings);
        System.out.println("elementPositions = " + elementPositions);
        Map<String, List<Integer>> elementPositions2 = getElementPositions2(strings);
        System.out.println("elementPositions2 = " + elementPositions2);
        Map<String, List<Integer>> elementPositions3 = getElementPositions3(strings);
        System.out.println("elementPositions3 = " + elementPositions3);
        Map<String, List<Integer>> elementPositions4 = getElementPositions4(strings);
        System.out.println("elementPositions4 = " + elementPositions4);
        Map<String, List<Integer>> elementPositions5 = getElementPositions5(strings);
        System.out.println("elementPositions5 = " + elementPositions5);
        Map<String, Long> elementCounts = getElementCounts(strings);
        System.out.println("elementCounts = " + elementCounts);


        System.out.println("--------------------------------------------------");










    }


    private static Map<String, List<Integer>> getElementPositions2(List<String> list) {
        HashMap<String, List<Integer>> positionMap = new HashMap<>(16);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            positionMap.putIfAbsent(s, new ArrayList<>(1));
            positionMap.get(s).add(i);
        }
        return positionMap;
    }

    private static Map<String, List<Integer>> getElementPositions3(List<String> list) {
        HashMap<String, List<Integer>> positionMap = new HashMap<>(16);
        for (int i = 0; i < list.size(); i++) {
            positionMap.compute(list.get(i), (k, oldVale) -> null == oldVale ? new ArrayList<>(1) : oldVale).add(i);
        }

        return positionMap;
    }

    private static Map<String, List<Integer>> getElementPositions4(List<String> list) {
        Map<String, List<Integer>> positionMap = new HashMap<>(16);
        for (int i = 0; i < list.size(); i++) {
            positionMap.computeIfAbsent(list.get(i), k -> new ArrayList<>(1)).add(i);
        }

        return positionMap;
    }

    private static Map<String, List<Integer>> getElementPositions5(List<String> list) {
        HashMap<String, List<Integer>> positionMap = new HashMap<>(16);

        Iterables.forEach(list, (index, str) -> positionMap.computeIfAbsent(str, k -> new ArrayList<>(1)).add(index));

        return positionMap;
    }

    private static Map<String, Long> getElementCounts(List<String> list) {
        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


    static class Iterables {

        static <E> void forEach(Iterable<? extends E> elements, BiConsumer<Integer, ? super E> action) {
            Objects.requireNonNull(elements);
            Objects.requireNonNull(action);

            int index = 0;
            for (E element : elements) {
                action.accept(index++, element);
            }
        }
    }
}