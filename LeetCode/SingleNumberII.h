/*
Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
#pragma once
#include "LeetCode.h"
class SingleNumberII
{
public:
	SingleNumberII();
	~SingleNumberII();
	int singleNumber(vector<int>& nums) {
		if (nums.empty()) return 0;
		if (nums.size() == 1) return nums[0];
		for (size_t i = 0;i < nums.size()-1;i+=2) {
			nums[i] = nums[i] | nums[i+1];
		}
		for (size_t i = 0;i < nums.size()-2;i += 2) {
			nums[0] = nums[0] ^ nums[i + 2];
		}
		return nums[0];
	}
};

