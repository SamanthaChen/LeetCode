/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3]
*/
#pragma once
#include "LeetCode.h"
class CombinationSum
{
public:
	CombinationSum();
	~CombinationSum();
	/*
	看到过类似的问题，就是给定不限量的1,2,5硬币，组合10有多少种方法。
	一遍过 80ms，慢，因为我用的递归并没有结合回溯的思想，导致不断在开辟新的path空间
	然后我要把它改进成回溯的思想
	改造以后16ms
	*/
	vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
		vector<vector<int>> re;
		if (candidates.empty()) return re;
		vector<int> path;
		sort(candidates.begin(), candidates.end());//因为要求结果是升序的，所以还是提前排序
		combinationSum(re,candidates,path,0,target);
		return re;
	}
	void combinationSum(vector<vector<int>> &re, vector<int>& candidates, vector<int> &path,int index, int target) {
		if (!target) {
			re.push_back(path);//一旦符合，立马加入
			return;
		}
		//所以回溯法，一定要保证把nums[0]的所有可能都处理完，然后把nums[0]pop（）出来，才去考虑nums[1]
		for (int i = index;i < candidates.size() && candidates[i] < target;++i) {
			path.push_back(candidates[i]);
			combinationSum(re, candidates, path, i, target-candidates[i]);//注意这里传递的是i！！！！
			path.pop_back();//然后把最后一个pop（）
		}
	}
};

