#pragma once
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
ÌøÔ¾ÓÎÏ·
*/
#include "LeetCode.h"
class JumpGame
{
public:
	JumpGame();
	~JumpGame();
	bool canJump(vector<int>& nums) {
		int n = nums.size();
		if (n == 0) return false;
		int reach = 0, i = 0;
		for (;i < n&&i <= reach;i++) {
			reach = max(i + nums[i], reach);
			if (reach >= n - 1) return true;
		}
		return false;
	}
};

