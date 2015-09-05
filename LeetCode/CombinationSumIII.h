/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/
#pragma once
#include "LeetCode.h"
class CombinationSumIII
{
public:
	/*
		1-9中找k个，和为n，并且每个数字只能用1次
		0ms
		一遍过
	*/
	vector<vector<int>> combinationSum3(int k, int n) {
		vector<vector<int>> re;
		if (k <= 0 || n <= 0) return re;
		vector<int> path;
		vector<int> nums{ 1,2,3,4,5,6,7,8,9 };
		combinationSum3(re, path, nums, 0, n, k);
	}
	void combinationSum3(vector<vector<int>> &re, vector<int> &path, const vector<int> &nums, int index, int n, int k) {
		if (path.size() == k) {
			if (0 == n) re.push_back(path);
			return;
		}
		for (int i = index;i < nums.size() && nums[i] <= n;i++) {
			path.push_back(nums[i]);
			combinationSum3(re, path, nums, i + 1, n - nums[i], k);
			path.pop_back();
		}
	}
};

