/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

1
/ \
2   5
/ \   \
3   4   6
The flattened tree should look like:
1
\
2
\
3
\
4
\
5
\
6
*/
#pragma once
#include "LeetCode.h"
class FlattenBinaryTreetoLinkedList
{
public:
	FlattenBinaryTreetoLinkedList();
	~FlattenBinaryTreetoLinkedList();
	/*
	要修改树
	基本原则是前序遍历说明是stack
	easy

	然而用stack遇到点问题
	于是就改用递归了
	*/
	void flatten(TreeNode* root) {
		if (!root || (!(root->left) && !(root->right))) return;
		flatten(root->left);
		flatten(root->right);
		TreeNode*left = root->left, *leftBackup = left;
		if (left) {
			while (left->right)
				left = left->right;
			left->right = root->right;
			root->left = nullptr;
			root->right = leftBackup;
		}
	}
};

