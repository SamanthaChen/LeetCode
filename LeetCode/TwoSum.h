/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
#pragma once
#include "LeetCode.h"
class TwoSum
{
public:
	TwoSum();
	~TwoSum();
	/*
	1.可以用暴力法，但这样时间复杂度为n平方
	2.使用map换时间！！
	16ms
	注意要考虑到可能出现两个相等的值的情况 比如 1,2,3,4,3   6 那么要把两个3的位置输出
	下面这个方法就能避免以上情况的意外
	但是如果先遍历一遍全部存进map，然后在遍历map，就可能出现有一个3丢失的情况
	*/
	vector<int> twoSum(vector<int>& nums, int target) {
		vector<int> v;
		unordered_map<int, int> m;
		for (size_t i = 0;i < nums.size();++i) {
			int temp = target - nums[i];
			if (m.find(temp) != m.end()) {
				v.push_back(m[temp] + 1);
				v.push_back(i + 1);
				break;
			}
			m[nums[i]] = i;
		}
		return v;
	}
};

