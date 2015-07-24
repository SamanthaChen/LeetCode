/*
	Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/
#pragma once
#include "LeetCode.h"
class MaximumDepthofBinaryTree
{
public:
	MaximumDepthofBinaryTree();
	~MaximumDepthofBinaryTree();
	/*
		简单得很 用递归
	*/
	int maxDepth(TreeNode* root) {
		if (root == nullptr) return 0;
		else if (root->left == nullptr&&root->right == nullptr) return 1;
		int a = maxDepth(root->left);
		int b = maxDepth(root->right);
		return a > b ? a+1 : b+1;
	}
};

