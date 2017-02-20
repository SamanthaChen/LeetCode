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
	 * ��������������⣨ps.��Ҫ�������� ת�Ʒ��̣� ��dp[i,j]��ʾ������,���Ӵ�Ϊx��y 1����Xi = Yj����
	 * dp[i,j]=dp[i-1,j-1]+1 2�������ȣ��� dp[i,j]=max(dp[i-1,j],dp[i,j-1])
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
		System.out.println("����������г��ȣ�" + dp[x.length][y.length]);
		// ��ӡ����������
		printLCS(dp, x, y, x.length, y.length, new LinkedList<Character>());

	}

	public static void printLCS(int[][] dp, char[] x, char[] y, int i, int j, LinkedList<Character> list) {
		// �ݹ��������
		if (i == 0 || j == 0) {
			System.out.println(list);
			return;// �����ݹ�
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
	 * ������Ӵ����⣨Ҫ�������� ��ת�Ʒ��̣� ��dp[i,j]��ʾ��Ӵ�,���Ӵ�Ϊx��y 1����Xi = Yj����
	 * dp[i,j]=dp[i-1,j-1]+1 2�������ȣ��� dp[i,j]=0
	 */
	public static void LCommonSubArray(char[] x, char[] y) {
		int[][] dp = new int[x.length + 1][y.length + 1];
		int maxlen = 0;
		int startid = 0;
		for (int i = 1; i <= x.length; i++) {
			for (int j = 1; j <= y.length; j++) {
				if (x[i - 1] == y[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					// ��ǰdp��ȫ�����ֵ
					if (dp[i][j] > maxlen) {
						maxlen = dp[i][j];
						startid = i - maxlen;//
					}
				}
			}
		}
		// ��ӡ������Ӵ�
		System.out.println("������Ӵ����ȣ�" + maxlen);
		System.out.println(new String(x).substring(startid, startid + maxlen));
	}

	/**
	 * ����������У�dp[i]��ʾ��iΪֹ��LIS���� ��j<i����a[j]<a[i],��dp[i]=dp[j]+1
	 */
	public static void LIS(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;// ��ʼ״̬�����ٳ���Ϊ1
		int maxlen = 0;
		int[] pre = new int[nums.length + 1];// ��ǰ��ָ��
		Arrays.fill(pre, -1);
		;// ��ʼ״̬
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
		// ��ӡ���
		System.out.println("����������У�" + maxlen);
		StringBuffer sb = new StringBuffer();
		for (int i = pre.length - 1; i >= 0; i--) {
			if (pre[i] != -1) {
				sb.insert(0, nums[pre[i]]);
			}
		}

		System.out.println(sb.toString());
	}

	/**
	 * �ڼ���ÿһ��f(i)ʱ����Ҫ�ҳ�����f(j)(j<i)��������f(j)û��˳��ֻ��˳���������aj<ai����f(j)��
	 * ����ܽ���f(j)���򣬾Ϳ���ʹ�ö��ֲ��ң������㷨��ʱ�临�ӶȾͿ��ܽ���O(nlogn)��
	 * �����뵽��һ������B���洢�������еġ������������е���ĩԪ�أ�����B[f(j)] = aj
	 * �ڼ���f(i)ʱ��������B���ö��ֲ��ҷ��ҵ�����j<i��B[f(j)]=aj<ai������j,����B[f[j]+1]��Ϊai
	 */
	public static void LIS2(int[] nums) {
		int[] B = new int[nums.length];
		B[0] = nums[0];
		int start = 0, mid;// ���ֲ��ҵ�����ֵ
		int end = 0;// B��������һ��Ԫ�ص�index
		for (int i = 1; i < nums.length; i++) {
			// �����ǰ����B�����һ�������󣬿���ֱ�����
			if (nums[i] > B[end]) {
				B[++end] = nums[i];
				continue;
			}
			// ���򣬶��ֲ��ҵ��滻λ��--��һ������nums[i]��λ��
			while (start < end) {
				mid = start + (end - start) / 2;// ��ֹ���
				if (B[mid] < nums[i]) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
			// �ҵ��Ժ����¸�ֵ
			B[start] = nums[i];

		}

		System.out.println(end + 1);// end����B��LIS�ĵ���ĩԪ�ص��±�
		// ��ӡLIS

	}
}
