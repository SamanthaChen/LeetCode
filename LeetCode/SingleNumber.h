/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
#pragma once
#include "LeetCode.h"
class SingleNumber
{
public:
	SingleNumber();
	~SingleNumber();
	/*
		我的方法，sort用时间了
		然后while又用了
		leetcode 44ms，不快
	*/
	int singleNumber_Dwyer(vector<int>& nums) {
		sort(nums.begin(), nums.end());
		auto begin = nums.begin();
		while (begin != nums.end()){
			if (*begin != *(begin + 1))
				return *begin;
			begin += 2;
		}
		return NULL;
	}

	/*
		别人的 完美线性时间，没有新空间 
		^是异或符号
		核心，一个数字与另一个数字异或两次，这个数字会完美保留下来！！！！！！！
		20ms
	*/
	int singleNumber(vector<int>& nums) {
		for (size_t i = 1; i < nums.size(); ++i)
			nums[0] ^= nums[i];
		return nums[0];
	}
};

