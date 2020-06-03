package com.shisen.idioms.bytedance;

import org.junit.Test;

import java.util.Arrays;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/3/26 16:19
 * </pre>
 */
public class KnuthShuffle {

    private int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    public void shuffle() {
        for (int i = a.length - 1; i > 0; i--) {
            swap(a, i, (int) (Math.random() * (i + 1)));
        }
        System.out.println("a = " + Arrays.toString(a));
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
