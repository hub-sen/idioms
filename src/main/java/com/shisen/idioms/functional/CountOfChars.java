package com.shisen.idioms.functional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Author:		shisen
 * Created at:	2019/3/18 15:16
 * </pre>
 */
public class CountOfChars {


    private static Map<Character, Integer> getCharacterIntegerMap(String str) {
        Map<Character, Integer> countAndChar = new HashMap<>();

        for (int i = 0, length = str.length(); i < length; i++) {
            char c = str.charAt(i);
            //Integer count = countAndChar.getOrDefault(c, 0);
            //countAndChar.put(c, ++count);

            countAndChar.merge(c, 1, Integer::sum);
        }
        return countAndChar;
          /*     Map<Character, Integer> countAndChar = getCharacterIntegerMap(str);

        System.out.println("countAndChar = " + countAndChar);


        Map<String, Long> collect = Stream.of(str).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("collect = " + collect);*/
    }

    public static void main(String[] args) {
        String str = "今天天气真好,今天阳光也很好.";

        String[] keyword = {"今天", "天气"};

        Map<String, Long> countAndKey = getStringIntegerMap(str, keyword);


        System.out.println("countAndKey = " + countAndKey);
    }

    private static Map<String, Long> getStringIntegerMap(String str, String[] keyword) {

        Objects.requireNonNull(str);
        Objects.requireNonNull(keyword);

        Map<String, Long> countAndKey = new LinkedHashMap<>();

        for (String key : keyword) {
            for (int j = 0, keyLength = key.length(), length = str.length(), tempIndex; j < length; j = tempIndex + keyLength) {
                tempIndex = str.indexOf(key, j);
                if (tempIndex > -1) {
                    countAndKey.merge(key, 1L, Long::sum);
                } else {
                    break;
                }
            }
        }

        return countAndKey.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }


}
