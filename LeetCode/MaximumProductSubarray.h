/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
#pragma once
#include "LeetCode.h"
class MaximumProductSubarray
{
public:
	MaximumProductSubarray();
	~MaximumProductSubarray();
	/*
		因为是整数，所以不考虑负数的话，肯定越乘越大
		所以这个题的本质是负数的处理
		也不能排序，会破坏顺序
		那么结果中或者没有负数，或者有偶数个负数
		4ms 最快
	*/
	int maxProduct(vector<int>& nums) {
		if (nums.size() == 1) return nums[0];
		//maxP与maxN是重量级，一个存走到当前位置能乘出来的最大正数，一个存负数
		int maxRe = INT_MIN, n = nums.size(), maxP = 0, maxN = 0;
		for (int i = 0;i < n;i++) {
			if (nums[i] == 0) {
				if (0 > maxRe) maxRe = 0;
				maxP = 0;maxN = 0;
				continue;
			}
			else if (nums[i] > 0) {//要考虑到为0的情况
				maxP = maxP?maxP*nums[i]:nums[i];
				maxN = maxN ? maxN*nums[i] : 0;
			}
			else {
				int temp = maxP;
				maxP = maxN?maxN*nums[i]:0;
				maxN = temp?temp*nums[i]:nums[i];
			}
			if (maxP > maxRe) maxRe = maxP;
		}
		return maxRe;
	}
};

