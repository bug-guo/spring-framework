package com.smart.smile.test;

import java.util.Scanner;


public class TestMain {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		String numsStr = scanner.nextLine();
		// 男生人数
		String[] s = numsStr.split(" ");
		int n = Integer.parseInt(s[0]);
		// 女生人数
		int m = Integer.parseInt(s[1]);

		// 构建二维数组  列为女生编号， 行为男生编号
		int[][] dances = new int[n+1][m+1];
		for (int i = 1; i <= n; i++) {
			String str = scanner.nextLine();
			String[] s1 = str.split("  ");
			for (int j = 1; j <= s1.length; j++) {
				dances[i][Integer.parseInt(s1[j])]=1;
			}
		}

		for (int i = 1; i <= m; i++) {
			String str = scanner.nextLine();
			String[] s1 = str.split("  ");
			for (int j = 1; j <= s1.length; j++) {
				dances[Integer.parseInt(s1[j])][i]=1;
			}
		}

		// 计算
	}

	public static int calc(int[][] dances, int n, int m) {
		// 存储编号
		int[] num = new int[m];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (dances[i][j]==1 && num[j]!=0){
					dances[i][j]=0;
					num[j]=1;
				}
			}
		}
		return 0;
	}
}