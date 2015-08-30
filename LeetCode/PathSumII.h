/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
5
/ \
4   8
/   / \
11  13  4
/  \    / \
7    2  5   1
return
[
[5,4,11,2],
[5,8,4,5]
]
*/
#pragma once
#include "LeetCode.h"
class PathSumII
{
public:
	PathSumII();
	~PathSumII();
	/*
	12ms最快的，杠杠的
	*/
	vector<vector<int>> pathSum(TreeNode* root, int sum) {
		vector<vector<int>> re;
		vector<int> path;
		pathSum(root, sum, path, re);
		return re;
	}
	void pathSum(TreeNode* root, int sum, vector<int>& path, vector<vector<int>> &re) {
		if (!root) return;
		path.push_back(root->val);
		if (!root->left&&!root->right) {
			if (sum == root->val)
				re.push_back(path);
			path.pop_back();
			return;
		}
		pathSum(root->left, sum - root->val, path, re);
		pathSum(root->right, sum - root->val, path, re);
		path.pop_back();
	}
};

