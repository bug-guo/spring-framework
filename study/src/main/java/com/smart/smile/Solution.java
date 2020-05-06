package com.smart.smile;

public class Solution {
	/**
	 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
	 * 每一次只能向左，右，上，下四个方向移动一格，
	 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
	 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
	 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
	 *
	 * @param threshold
	 * @param rows
	 * @param cols
	 * @return
	 */
	public int movingCount(int threshold, int rows, int cols) {
		// 创建数组
		int[][] arrive = new int[rows][cols];
		// 能够到达 1
		return calcStep(threshold, rows, cols, 0, 0, arrive);
	}

	public int calcStep(int threshold, int rows, int cols, int i, int j, int[][] flags) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || calcSum(i) + calcSum(j) > threshold || flags[i][j] == 1) {
			return 0;
		}
		flags[i][j] = 1;
		return calcStep(threshold, rows, cols, i - 1, j, flags)
				+ calcStep(threshold, rows, cols, i + 1, j, flags)
				+ calcStep(threshold, rows, cols, i, j - 1, flags)
				+ calcStep(threshold, rows, cols, i, j + 1, flags)
				+ 1
				;

	}

	public int calcSum(int x) {
		int x_sum = x;
		if (x >= 10) {
			x_sum = 0;
			while (x > 0) {
				x_sum += x % 10;
				x = x / 10;
			}
		}
		return x_sum;
	}
}