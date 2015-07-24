/***********************
*Date:	2015.7.19
*Problems:	Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
*分析:	将一个二叉树反过来，似乎并没有什么难的，继续用递归的思路
		将每一个节点的左右互换
*感悟：	
***********************/
#pragma once
#include <algorithm>
using namespace std;
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class InvertBinaryTree
{
public:
	InvertBinaryTree();
	~InvertBinaryTree();
	/*
	我的方法
	递归确实很简单
	4ms
	*/
	TreeNode* invertTree_Dwyer(TreeNode* root) {
		if (root == nullptr) return root;
		if (root->left == NULL && root->right == NULL) return root;
		std::swap(root->left, root->right);
		invertTree_Dwyer(root->left);
		invertTree_Dwyer(root->right);
		return root;
	}
};

