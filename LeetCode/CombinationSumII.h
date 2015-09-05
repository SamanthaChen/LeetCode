/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
*/
#pragma once
#include "LeetCode.h"
class CombinationSumII
{
public:
	CombinationSumII();
	~CombinationSumII();
	/*
		这个只考虑出现1次
	*/
	vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
		if (candidates.empty()) return vector<vector<int>>{};
		set<vector<int>> re;
		vector<int> path;
		sort(candidates.begin(), candidates.end());//因为要求结果是升序的，所以还是提前排序
		combinationSum2(re, candidates, path, 0, target);
		return vector<vector<int>>(re.begin(),re.end());
	}
	void combinationSum2(set<vector<int>> &re, vector<int>& candidates, vector<int> &path, int index, int target) {
		if (!target) {
			re.insert(path);//一旦符合，立马加入
			return;
		}
		for (int i = index;i < candidates.size() && candidates[i] <= target;i++) {
			path.push_back(candidates[i]);
			//以下这句如果把i+1改成i，就是允许一个数字重复出现多次
			combinationSum2(re, candidates, path, i + 1, target - candidates[i]);
			path.pop_back();
		}
	}
};

