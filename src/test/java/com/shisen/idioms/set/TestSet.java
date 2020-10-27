package com.shisen.idioms.set;

import org.junit.Test;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/3/11 9:59
 * </pre>
 */
public class TestSet {

    @Test
    public void app() {
        int[][] x = new int[5][5];
        desktop(x);

    }

    public void desktop(int[][] desktop) {

        int xLength = desktop.length;
        int yLength = desktop[0].length;
        int xIndex = 0;
        int yIndex = 0;
        int xStep = 1;
        int yStep = 1;
        int turnBack = -2;
        boolean xTurn;
        boolean yTurn;

        do {
            xIndex += xStep;
            yIndex += yStep;

            xTurn = false;
            yTurn = false;

            if (yIndex >= yLength || yIndex <= 0) {
                yStep = -yStep;
                yTurn = true;
                turnBack++;
            }

            if (xIndex >= xLength || xIndex <= 0) {
                xStep = -xStep;
                xTurn = true;
                turnBack++;
            }

            System.out.println("xIndex, yIndex = " + xIndex + ", " + yIndex);

        } while (!(xTurn && yTurn));

        System.out.println("turnBack = " + turnBack);

    }
}
