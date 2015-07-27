/*
	House Robber 
	You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

	Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

	说白了 这个题目就是给一个vector找出任意两个不相邻数字的最大值int rob(vector<int>& nums) {
        
    }
*/
#pragma once
#include "LeetCode.h"

class HouseRobber
{
public:
	HouseRobber();
	~HouseRobber();
	int rob(vector<int>& nums) {
		if (nums.empty()||nums.size()==2) return 0;
		if (nums.size() == 1) return nums[0];
		if (nums.size() == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
		//至少有三家人供偷
		sort(nums.begin(), nums.end(), greater<int>());
	}
};

