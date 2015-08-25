/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
For example, given array S = {-1 0 1 2 -1 -4},

A solution set is:
(-1, 0, 1)
(-1, -1, 2)
*/
#pragma once
#include "LeetCode.h"
class ThreeSum
{
public:
	ThreeSum();
	~ThreeSum();
	/*
	可以先取其中的一个数字，然后用twoSum那个函数去后面找
	如果提前排一下序的话，当找到大于0那个数就没必要继续循环了
	64ms
	别忘了排序序以后很优美，可以用一个front一个back，一遍过
	*/
	vector<vector<int>> threeSum(vector<int>& nums) {
		vector<vector<int>> re;
		if (nums.size() < 3) return re;
		sort(nums.begin(), nums.end());
		int n = nums.size();
		for (size_t i = 0;i < n&&nums[i]<=0;++i) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int target = 0 - nums[i];
			set<int> s;
			int front = i + 1, back = n - 1;
			while (front < back) {
				if (nums[front] + nums[back] == target){
					re.push_back(vector<int>{nums[i], nums[front], nums[back]});
					front++;
					while (front < back && nums[front] == nums[front - 1]) front++;
					back--;
					while (front < back && nums[back] == nums[back + 1]) back--;
				}
				else if (nums[front] + nums[back] < target)
					front++;
				else
					back--;
			}
		}
		return re;
	}
};

