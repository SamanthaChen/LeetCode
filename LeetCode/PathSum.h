/***********************
*Date:	2015.7.19
*Problems:	Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
5
/ \
4   8
/   / \
11  13  4
/  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*分析:	深度搜索，一但大于22或者到了叶子却不等于22，则返回父节点，跳到父节点的右侧节点
还要考虑到sum有可能是负数，所以不能严格按照大于22，必须每一次都保证走到了叶子节点，判断等于或者不等于才行
叶子节点的特征是左右儿子都是空

*题目：
*感悟：
***********************/
#pragma once
#include "LeetCode.h"
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class PathSum
{
public:
	PathSum();
	~PathSum();
	/********************
	*描述:这个是我写的方法，采用递归的思路，深度搜索
	*时间复杂度：最坏情况要遍历每个节点，也就是o(n)
	*LeetCode效果:12s
	*测试:一遍通过，思路清晰
	********************/
	bool hasPathSum_Dwyer(TreeNode* root, int sum) {
		if (root == nullptr) return false;
		if (root->left == NULL && root->right == NULL && root->val == sum) return true;
		if (hasPathSum_Dwyer(root->left, sum - root->val) || hasPathSum_Dwyer(root->right, sum - root->val)) return true;
		return false;
	}
};

