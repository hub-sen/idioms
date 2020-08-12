package com.shisen.idioms.feng;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/9 18:08
 * </pre>
 */
public class ArrTest {

    private Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void px() {


        Map<Boolean, List<Integer>> collect = Arrays.stream(nums)
                .collect(Collectors.partitioningBy(e -> (e & 1) == 1))
                .entrySet()
                .stream()
                .peek(x -> {
                    if (x.getKey()) {
                        x.getValue().sort(Comparator.naturalOrder());
                    } else {
                        x.getValue().sort(Comparator.reverseOrder());
                    }
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("collect = " + collect);
    }

}
