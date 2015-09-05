/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4],
]
*/
#pragma once
#include "LeetCode.h"
class Combinations
{
public:
	Combinations();
	~Combinations();
	/*
		1到n中
		取出k个数字的所有组合
		一遍过 12ms
	*/
	vector<vector<int>> combine(int n, int k) {
		vector<vector<int>> re;
		if (n <= 0 || k <= 0) return re;
		vector<int> nums;
		for (int i = 1;i <= n;i++) nums.push_back(i);
		vector<int> path;
		combine(re, nums, path, k, 0);
	}
	void combine(vector<vector<int>> &re, vector<int> &nums, vector<int> &path,const int &k,int index) {
		if (path.size() == k) {
			re.push_back(path);
			return;
		}
		for (int i = index;i < nums.size();i++) {
			path.push_back(nums[i]);
			combine(re, nums, path, k, i+1);
			path.pop_back();
		}
	}
};

