/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/
#pragma once
#include "LeetCode.h"
class ConstructBinaryTreefromInorderandPostorderTraversal
{
public:
	ConstructBinaryTreefromInorderandPostorderTraversal();
	~ConstructBinaryTreefromInorderandPostorderTraversal();
	/*
	16ms 挺快的
	*/
	TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
		if (postorder.empty()) return nullptr;
		unordered_map<int, int> m;//保存中序遍历的各个节点的位置
		for (int i = 0;i < inorder.size();i++)
			m[inorder[i]] = i;
		return buildTree(inorder, postorder, m, 0, postorder.size() - 1, 0, inorder.size() - 1);
	}
	TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder, unordered_map<int, int> &m, int postBegin, int postEnd, int inBegin, int inEnd) {
		TreeNode *root = new TreeNode(postorder[postEnd]);
		int index = m[postorder[postEnd]];
		root->left = index == inBegin ? nullptr : buildTree(inorder, postorder, m, postBegin, postBegin + (index - inBegin)-1, inBegin, index - 1);
		root->right = index == inEnd ? nullptr : buildTree(inorder, postorder, m, postBegin + (index - inBegin), postEnd-1, index + 1, inEnd);
		return root;
	}
};

