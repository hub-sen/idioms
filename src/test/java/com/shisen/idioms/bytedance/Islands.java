package com.shisen.idioms.bytedance;

import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/5/25 15:38
 * </pre>
 */
public class Islands {


    @Test
    public void islands() {
        //int[][] islands = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] islands = {{1, 1, 1, 0, 1}, {1, 1, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 0, 0, 0}, {1, 1, 0, 1, 1}};

        int nums = 0;

        for (int i = 0, lon = islands.length; i < lon; i++) {
            for (int j = 0, lan = islands[i].length; j < lan; j++) {
                if (islands[i][j] == 1) {
                    getNums(islands, i, j);
                    nums++;
                }
            }
        }

        System.out.println("nums = " + nums);

    }

    private void getNums(int[][] islands, int i, int j) {

        if (islands == null || (i < 0 || i >= islands.length) || (j < 0 || j >= islands[i].length)) {
            return;
        }
        if (islands[i][j] != 1) {
            return;
        }

        islands[i][j] = 0;

        // 上
        getNums(islands, i - 1, j);

        // 下
        getNums(islands, i + 1, j);

        // 左
        getNums(islands, i, j - 1);

        // 右
        getNums(islands, i, j + 1);

    }


}
