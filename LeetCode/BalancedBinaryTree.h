#pragma once
#include "LeetCode.h"
class BalancedBinaryTree
{
public:
	BalancedBinaryTree();
	~BalancedBinaryTree();
	/*
		16ms
		属于主流时间
		这属于一种自底向上的方法
		时间复杂度为O(n)
	*/
	bool isBalanced(TreeNode* root) {
		if (!root) return true;
		int a = height(root->left);
		int b = height(root->right);

		//前往不要忘记还要分别判断左右子树是否平衡！！！！！！！！！
		return abs(a-b)<=1 &&isBalanced(root->right)&&isBalanced(root->left);
	}
	int height(TreeNode* root){
		if (!root) return 0;
		return max(height(root->left),height(root->right))+1;
	}
};

