/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
寻找旋转后的数组中的最小元素
8ms
最快
*/
#pragma once
#include "LeetCode.h"
class FindMinimuminRotatedSortedArrayII
{
public:
	FindMinimuminRotatedSortedArrayII();
	~FindMinimuminRotatedSortedArrayII();
	int findMin(vector<int>& nums) {
		int n = nums.size();
		if (n == 1) return nums[0];
		int left = 0, right = n - 1;
		while (left<right) {
			if (nums[left] == nums[n-1]) {
				left++;
				continue;
			}
			int mid = (left + right) / 2;
			if (nums[mid] > nums[n - 1]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return nums[left];
	}
};

