/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
#pragma once
#include "LeetCode.h"
class SearchInsertPosition
{
public:
	SearchInsertPosition();
	~SearchInsertPosition();
	//未免太简单
	//要考虑到上边界和下边界
	//8ms最快
	int searchInsert(vector<int>& nums, int target) {
		if (nums.empty()) return 0;
		if (nums[nums.size() - 1] < target) return nums.size();
		for (size_t i = 0;i < nums.size();++i) 
			if (nums[i] >= target) return i;
	}

	//看到众大神对有序的序列查找，又开始使用二叉查找
	int searchInsert_Binary(vector<int>& nums, int target) {
		if (nums.empty()) return 0;
		if (nums[nums.size() - 1] < target) return nums.size();
		if (nums[0] > target) return 0;
		int i = 0, j = nums.size() - 1;
		while (i < j) {
			int mid = (j - i) / 2 + i;
			if (nums[mid] == target)
				return mid;
			if (nums[mid]>target)
				j = mid;
			else
				i = mid;
		}
		return i;
	}
};

