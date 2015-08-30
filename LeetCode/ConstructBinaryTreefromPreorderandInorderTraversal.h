/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
#pragma once
#include "LeetCode.h"
class ConstructBinaryTreefromPreorderandInorderTraversal
{
public:
	ConstructBinaryTreefromPreorderandInorderTraversal();
	~ConstructBinaryTreefromPreorderandInorderTraversal();
	/*
	如果重载这个函数，给它加上各种起始位和结束位，就可以在不新建空间的情况下完成这个题目
	20ms 算是挺快的
	*/
	TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
		if (preorder.empty()) return nullptr;
		unordered_map<int, int> m;//保存中序遍历的各个节点的位置
		for (int i = 0;i < inorder.size();i++)
			m[inorder[i]] = i;
		return buildTree(preorder, inorder, m, 0, preorder.size() - 1, 0, inorder.size() - 1);
	}
	TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder, unordered_map<int, int> &m, int preBegin, int preEnd, int inBegin, int inEnd) {
		TreeNode *root = new TreeNode(preorder[preBegin]);
		int index = m[preorder[preBegin]];
		root->left = index == inBegin ? nullptr : buildTree(preorder, inorder, m, preBegin + 1, preBegin + (index - inBegin), inBegin, index - 1);
		root->right = index == inEnd ? nullptr : buildTree(preorder, inorder, m, preBegin + (index - inBegin) + 1, preEnd, index + 1, inEnd);
		return root;
	}
};

