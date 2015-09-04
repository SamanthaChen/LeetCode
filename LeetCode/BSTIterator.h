/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

28ms
核心思想就是用堆栈stack
*/
#pragma once
#include "LeetCode.h"
class BSTIterator
{
public:
	BSTIterator();
	~BSTIterator();
	stack<TreeNode*> sta;
	BSTIterator(TreeNode *root) {
		if (!root)
			return;
		while (!sta.empty())
			sta.pop();
		sta.push(root);
		while (root->left) {
			sta.push(root->left);
			root = root->left;
		}
	}

	/** @return whether we have a next smallest number */
	bool hasNext() {
		return !sta.empty();
	}

	/** @return the next smallest number */
	int next() {
		TreeNode *re=sta.top(), *temp = sta.top();
		sta.pop();
		if (temp->right) {
			sta.push(temp->right);
			temp = temp->right;
			while (temp->left) {
				sta.push(temp->left);
				temp = temp->left;
			}
		}
		return re->val;
	}
};

