/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [?2,1,?3,4,?1,2,1,?5,4],
the contiguous subarray [4,?1,2,1] has the largest sum = 6.

这个题之前看过
直接一遍过
如果总和小于0抛弃
每次出现最大和都保存
*/
#pragma once
#include "LeetCode.h"
class MaximumSubarray
{
public:
	MaximumSubarray();
	~MaximumSubarray();
	/*
	8ms 最快
	*/
	int maxSubArray(vector<int>& nums) {
		if (nums.empty()) return 0;
		int n = nums.size();
		int largeSum = INT_MIN;
		int curSum = 0;
		for (size_t i = 0;i < n;++i) {
			if (curSum > 0)
				curSum += nums[i];
			else
				curSum = nums[i];
			if (curSum > largeSum)
				largeSum = curSum;
		}
		return largeSum;
	}
};

