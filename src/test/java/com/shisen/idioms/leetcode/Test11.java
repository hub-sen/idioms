package com.shisen.idioms.leetcode;

import org.junit.Test;

/**
 * <pre>
 * Description  盛最多水的容器
 * @author shishi
 * 2020/8/31 14:28
 * </pre>
 */
public class Test11 {

    private int[] high = {1, 8, 6, 2, 5, 8, 4, 3, 7};


    @Test
    public void app() {
        int i = maxArea2(high);
        System.out.println("i = " + i);
    }


    public int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tempMaxArea = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, tempMaxArea);
            }
        }

        return maxArea;
    }

    public int maxArea2(int[] height) {

        int left = 0, right = height.length - 1;


        int maxArea = 0;

        while (left < right) {
            int tempArea = Math.min(height[left], height[right]) * (right - left);

            maxArea = Math.max(maxArea, tempArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return maxArea;
    }

}
