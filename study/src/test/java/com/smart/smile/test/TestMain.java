package com.smart.smile.test;

import java.util.ArrayList;
import java.util.List;


public class TestMain {

	public static void main(String[] args) {
		TestMain demo = new TestMain();
		List<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(4);
		A.add(2);
		A.add(3);
		int target = 1;
		System.out.println(demo.MinAdjustmentCost(A, target));
	}

	public int numDistinct(String S, String T) {
		// write your code here
		if ("".equals(T)) {
			return 1;
		}
		int s = S.length();
		int t = T.length();
		int t_index = 0;
		int count = 0;
		for (int i = 0; i < s; i++) {
			int j = i;
			t_index = 0;
			if (S.charAt(j) != T.charAt(t_index)) {
				continue;
			}
			// 匹配剩余字符串
			while (j < s || t_index < t) {
				if (S.charAt(j) == T.charAt(t_index)) {
					t_index++;
				}
				j++;
			}
			if (t_index == t) {
				count++;
			}
		}
		return 0;
	}

	public int MinAdjustmentCost(List<Integer> A, int target) {
		// write your code here
		int m = 101;
		int n = A.size();
		int[][] dp = new int[n][m];
		for (int i = 0; i < m; i++) {
			dp[0][i] = Math.abs(A.get(0) - i);
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				int diff = Math.abs(j - A.get(i));
				int max = Math.min(100, j + target);
				int min = Math.max(0, target - j);
				for (int k = min; k <= max; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + diff);
				}
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			result = Math.min(result, dp[n - 1][i]);
		}

		return result;
	}

//	public static void main(String args[]) {
//		Scanner scanner = new Scanner(System.in);
//
//		String numsStr = scanner.nextLine();
//		// 男生人数
//		String[] s = numsStr.split(" ");
//		int n = Integer.parseInt(s[0]);
//		// 女生人数
//		int m = Integer.parseInt(s[1]);
//
//		// 构建二维数组  列为女生编号， 行为男生编号
//		int[][] dances = new int[n+1][m+1];
//		for (int i = 1; i <= n; i++) {
//			String str = scanner.nextLine();
//			String[] s1 = str.split("  ");
//			for (int j = 1; j <= s1.length; j++) {
//				dances[i][Integer.parseInt(s1[j])]=1;
//			}
//		}
//
//		for (int i = 1; i <= m; i++) {
//			String str = scanner.nextLine();
//			String[] s1 = str.split("  ");
//			for (int j = 1; j <= s1.length; j++) {
//				dances[Integer.parseInt(s1[j])][i]=1;
//			}
//		}
//
//		// 计算
//	}
//
//	public static int calc(int[][] dances, int n, int m) {
//		// 存储编号
//		int[] num = new int[m];
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				if (dances[i][j]==1 && num[j]!=0){
//					dances[i][j]=0;
//					num[j]=1;
//				}
//			}
//		}
//		return 0;
//	}
}