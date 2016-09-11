package DP;

import java.util.Arrays;
import java.util.LinkedList;

public class LCS {

	public static void main(String[] args) {
		// String s1 = "12345678";
		// String s2 = "23242628";
		// LCommonSubsequence(s1.toCharArray(), s2.toCharArray());
		//
		// String s3 = "abcdefghappyijklmn";
		// String s4 = "qqqqhappywwww";
		// LCommonSubArray(s3.toCharArray(), s4.toCharArray());

		int[] nums = { 7, 7, 7, 2, 4, 7, 6, 7, 8, 10 };
		LIS2(nums);
	}

	/**
	 * 最长公共子序列问题（ps.不要求连续） 转移方程： 设dp[i,j]表示子序列,设子串为x和y 1、若Xi = Yj，则
	 * dp[i,j]=dp[i-1,j-1]+1 2、若不等，则 dp[i,j]=max(dp[i-1,j],dp[i,j-1])
	 * 
	 */
	public static void LCommonSubsequence(char[] x, char[] y) {
		int[][] dp = new int[x.length + 1][y.length + 1];
		for (int i = 1; i <= x.length; i++) {
			for (int j = 1; j <= y.length; j++) {
				if (x[i - 1] == y[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println("最长公共子序列长度：" + dp[x.length][y.length]);
		// 打印公共子序列
		printLCS(dp, x, y, x.length, y.length, new LinkedList<Character>());

	}

	public static void printLCS(int[][] dp, char[] x, char[] y, int i, int j, LinkedList<Character> list) {
		// 递归结束条件
		if (i == 0 || j == 0) {
			System.out.println(list);
			return;// 跳出递归
		}
		if (x[i - 1] == y[j - 1]) {
			list.add(0, x[i - 1]);
			printLCS(dp, x, y, i - 1, j - 1, list);
		} else if (dp[i - 1][j] >= dp[i][j - 1]) {
			printLCS(dp, x, y, i - 1, j, list);
		} else {
			printLCS(dp, x, y, i, j - 1, list);
		}

	}

	/**
	 * 最长公共子串问题（要求连续） 。转移方程： 设dp[i,j]表示最长子串,设子串为x和y 1、若Xi = Yj，则
	 * dp[i,j]=dp[i-1,j-1]+1 2、若不等，则 dp[i,j]=0
	 */
	public static void LCommonSubArray(char[] x, char[] y) {
		int[][] dp = new int[x.length + 1][y.length + 1];
		int maxlen = 0;
		int startid = 0;
		for (int i = 1; i <= x.length; i++) {
			for (int j = 1; j <= y.length; j++) {
				if (x[i - 1] == y[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					// 当前dp与全局最大值
					if (dp[i][j] > maxlen) {
						maxlen = dp[i][j];
						startid = i - maxlen;//
					}
				}
			}
		}
		// 打印最长公共子串
		System.out.println("最长公共子串长度：" + maxlen);
		System.out.println(new String(x).substring(startid, startid + maxlen));
	}

	/**
	 * 最长递增子序列：dp[i]表示到i为止的LIS长度 若j<i并且a[j]<a[i],则dp[i]=dp[j]+1
	 */
	public static void LIS(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;// 初始状态，至少长度为1
		int maxlen = 0;
		int[] pre = new int[nums.length + 1];// 存前驱指针
		Arrays.fill(pre, -1);
		;// 初始状态
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = dp[j] + 1;
					if (dp[i] > maxlen) {
						maxlen = dp[i];
						pre[i + 1] = j;
					}
				}
			}
		}
		// 打印结果
		System.out.println("最长递增子序列：" + maxlen);
		StringBuffer sb = new StringBuffer();
		for (int i = pre.length - 1; i >= 0; i--) {
			if (pre[i] != -1) {
				sb.insert(0, nums[pre[i]]);
			}
		}

		System.out.println(sb.toString());
	}

	/**
	 * 在计算每一个f(i)时，都要找出最大的f(j)(j<i)来，由于f(j)没有顺序，只能顺序查找满足aj<ai最大的f(j)，
	 * 如果能将让f(j)有序，就可以使用二分查找，这样算法的时间复杂度就可能降到O(nlogn)。
	 * 于是想到用一个数组B来存储“子序列的”最大递增子序列的最末元素，即有B[f(j)] = aj
	 * 在计算f(i)时，在数组B中用二分查找法找到满足j<i且B[f(j)]=aj<ai的最大的j,并将B[f[j]+1]置为ai
	 */
	public static void LIS2(int[] nums) {
		int[] B = new int[nums.length];
		B[0] = nums[0];
		int start = 0, mid;// 二分查找的三个值
		int end = 0;// B数组的最后一个元素的index
		for (int i = 1; i < nums.length; i++) {
			// 如果当前数比B中最后一个数还大，可以直接添加
			if (nums[i] > B[end]) {
				B[++end] = nums[i];
				continue;
			}
			// 否则，二分查找到替换位置--第一个大于nums[i]的位置
			while (start < end) {
				mid = start + (end - start) / 2;// 防止溢出
				if (B[mid] < nums[i]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
			// 找到以后重新赋值
			B[start] = nums[i];

		}

		System.out.println(end + 1);// end的是B中LIS的的最末元素的下标
		// 打印LIS

	}
}
