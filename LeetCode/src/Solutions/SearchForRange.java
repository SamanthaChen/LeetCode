package Solutions;

import java.util.Arrays;
import java.util.Scanner;

public class SearchForRange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			// ��һ�еĶ���
			String s = sc.nextLine();
			int target = sc.nextInt();
			String[] sa = s.split(" ");
			int[] nums = new int[sa.length];
			for (int i = 0; i < sa.length; i++) {
				nums[i] = Integer.valueOf(sa[i]);
			}

			SearchForRange m = new SearchForRange();
			int[] res = m.searchRange(nums, target);
			System.out.println(res[0] + " " + res[1]);
		}
		sc.close();
	}

	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];
		Arrays.fill(res, -1);
		// 1.�����Ҷ�����left
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		if (nums[left] != target)
			return res;
		else
			res[0] = left;
		// 2.��right
		right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2 + 1;// ������(left + right) / 2
			if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid; // ��ֹ����
			}
		}
		res[1] = right;
		return res;
	}

}
