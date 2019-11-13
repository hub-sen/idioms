package com.shisen.idioms.baldStrong.Part6;

import org.junit.Test;

import static java.lang.System.out;

/**
 * <pre>
 * Description
 * Copyright:	Copyright (c)2019
 * Company:		上海天地汇
 * Author:		shisen
 * Version:		1.0
 * Created at:	2019/7/4 13:12
 * </pre>
 */
public class TDH {

	double U = 0.06, V = 0.025, M = 1.1, N = 1.2;


	@Test
	public void tes3() {
		for (double y = 2.0; y > -2; y -= 0.06) {
			for (double x = -2.0; x < 2; x += 0.029) {
				if (x * x + y * y <= 1) {
					out.print("*");
				} else {
					out.print(" ");
				}
			}
			out.println();

		}
	}

	/**
	 * 爱心
	 */
	@Test
	public void test1() {

		float x, y, m, n;

		for (y = 2; y >= -2; y -= U) {
			for (x = -1.2f; x <= 1.2; x += V) {
				if (Math.pow((Math.pow(x, 2) + Math.pow(y, 2) - 1), 3) - Math.pow(x, 2) * Math.pow(y, 3) <= 0) {
					out.print("*");
				} else {
					out.print(" ");
				}
			}
			out.println();
		}
	}

	@Test
	public void print_heart_arrow() {
		float x, y;
		double U = 0.04;         //Y轴方向步进值
		double V = 0.02;         //X轴方向步进值
		double P = 0.9;          //P决定两颗心之间的间距
		double K = 0.27;         //箭轴向直线的斜率
		double R = 0.14;         //箭与（0，0）点相对应的距离
		double B = 0.03;         //B决定箭轴的宽度
		double M = 1.05;         //M改变内部心形X轴方向的大小
		double N = 1.05;         //N改变内部心形Y轴方向的大小
		double KW_UP = -1;       //箭尾上部直线斜率
		double KW_DOWM = 3.73;   //箭尾下部直线斜率
		double KT_R = 0.58;      //箭头右边直线斜率
		double KT_L = -3.7;      //箭头左边直线斜率

		for (y = 1.8f; y >= -1.8; y -= U) {
			for (x = -2.8f; x <= 0; x += V) {
				if ((((((x + P) * (x + P) + y * y - 1) * ((x + P) * (x + P) + y * y - 1) * ((x + P) * (x + P) + y * y - 1) - (x + P) * (x + P) * y * y * y) <= 0))          //左侧心形部分
						&& ((((M * (x + P) * M * (x + P) + N * N * y * y - 1) * (M * (x + P) * M * (x + P) + N * N * y * y - 1) * (M * (x + P) * M * (x + P) + N * N * y * y - 1) - M * (x + P) * M * (x + P) * N * N * N * y * y * y) >= 0))
						|| (y >= (K * x + R - B) && y <= (K * x + R + B)) && (x <= -1.2) && (x >= -2.1)                                    //左侧心形的箭轴部分
						|| ((y < K * x + 0.14 + 0.1) && (y < KW_UP * x - 2.24) && (y > KW_UP * x - 3.008) && (y > K * x + 0.14))         //箭尾在箭轴以上的区间
						|| ((y > K * x + 0.14 - 0.1) && (y < K * x + 0.14) && (y > KW_DOWM * x + 6.624) && (y < KW_DOWM * x + 8.718)))   //箭尾在箭轴以下的区间
				{
					out.print("*");
				} else {
					out.print(" ");
				}
			}

			for (x = 0; x <= 3; x += V) {
				if ((((((x - P) * (x - P) + y * y - 1) * ((x - P) * (x - P) + y * y - 1) * ((x - P) * (x - P) + y * y - 1) - (x - P) * (x - P) * y * y * y) <= 0))                               //右侧心形部分
						&& ((((M * (x - P) * M * (x - P) + N * N * y * y - 1) * (M * (x - P) * M * (x - P) + N * N * y * y - 1) * (M * (x - P) * M * (x - P) + N * N * y * y - 1) - M * (x - P) * M * (x - P) * N * N * N * y * y * y) >= 0))
						|| (((((x + P) * (x + P) + y * y - 1) * ((x + P) * (x + P) + y * y - 1) * ((x + P) * (x + P) + y * y - 1) - (x + P) * (x + P) * y * y * y) <= 0))                              //左侧心形在右侧的部分
						&& ((((M * (x + P) * M * (x + P) + N * N * y * y - 1) * (M * (x + P) * M * (x + P) + N * N * y * y - 1) * (M * (x + P) * M * (x + P) + N * N * y * y - 1) - M * (x + P) * M * (x + P) * N * N * N * y * y * y) >= 0))
						|| (y >= K * x + R - B) && (y <= K * x + R + B) && (x >= 2) && (x < 2.6)    //右侧心形的箭轴部分
						|| ((y > KT_R * x - 0.79) && (y > KT_L * x + 10.5) && (y < 0.95)))        //箭头区间
				{
					out.print("*");
				} else {
					out.print(" ");
				}
			}

			out.print("\n");
		}

	}

}
