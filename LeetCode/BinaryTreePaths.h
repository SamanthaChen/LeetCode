/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

1
/   \
2     3
\
5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/
#pragma once
#include "LeetCode.h"
class BinaryTreePaths
{
public:
	BinaryTreePaths();
	~BinaryTreePaths();
	/*
	递归
	一遍过
	4ms
	*/
	vector<string> binaryTreePaths(TreeNode* root) {
		vector<string> re;
		if (!root) return re;
		if (!root->left && !root->right) {
			re.push_back(to_string(root->val));
			return re;
		}
		vector<string> left = binaryTreePaths(root->left);
		vector<string> right = binaryTreePaths(root->right);
		for (size_t i = 0;i < left.size();++i) {
			left[i] = "->" + left[i];
			left[i] = to_string(root->val) + left[i];
		}
		for (size_t i = 0;i < right.size();++i) {
			right[i] = "->" + right[i];
			right[i] = to_string(root->val) + right[i];
		}
		//拼接两个vector的方法
		re.insert(re.end(), left.begin(), left.end());
		re.insert(re.end(), right.begin(), right.end());
		return re;
	}
};

