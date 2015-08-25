/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

A solution set is:
(-1,  0, 0, 1)
(-2, -1, 1, 2)
(-2,  0, 0, 2)
*/
#pragma once
#include "LeetCode.h"
class FourSum
{
public:
	FourSum();
	~FourSum();
	/*
	可以考虑这样做
	类似于3sum的方法，最好不过n*n*n
	100ms
	终于ac了
	*/
	vector<vector<int>> fourSum(vector<int>& nums, int target) {
		sort(nums.begin(), nums.end());
		vector<vector<int>> re;
		int n = nums.size();
		if (n < 4) return re;//防止bug
		for (size_t i = 0;i < n - 3;++i) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;//防止出现重复
			int targetThree = target - nums[i];
			for (size_t j = i + 1;j < n - 2;++j) {
				if (j > i + 1 && nums[j] == nums[j - 1]) continue;//防止出现重复
				int targetTwo = targetThree - nums[j];
				int front = j + 1;
				int back = n - 1;
				while (front < back) {
					if (nums[front] + nums[back] == targetTwo) {
						re.push_back(vector<int>{nums[i],nums[j], nums[front], nums[back]});
						front++;
						while (front < back && nums[front] == nums[front - 1]) front++;
						back--;
						while (front < back && nums[back] == nums[back + 1]) back--;
					}
					else if (nums[front] + nums[back] < targetTwo)
						front++;
					else
						back--;
				}
			}
		}
		return re;
	}
};

