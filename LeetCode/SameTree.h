/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 
 很简单 直接递归
*/
#pragma once
#include "LeetCode.h"
class SameTree
{
public:
	SameTree();
	~SameTree();
	bool isSameTree(TreeNode* p, TreeNode* q) {
		if (p == nullptr && q == nullptr) return true;
		else if (p == nullptr || q == nullptr) return false;
		else if (p->val != q->val) return false;
		else return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
	}
};

