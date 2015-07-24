/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
1
\
2
/
3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
给定一棵树，广度优先输出
*/
#pragma once
#include "LeetCode.h"
class BinaryTreePreorderTraversal
{
public:
	BinaryTreePreorderTraversal();
	~BinaryTreePreorderTraversal();
	/*
	不让使用递归的方法
	让使用迭代的方法
	*/
	vector<int> preorderTraversal(TreeNode* root) {
		vector<int> v;
		stack<TreeNode*> st;
		if (root == nullptr) return v;
		st.push(root);
		v.push_back(root->val);
		while (!st.empty()){
			if (st.top()->left == nullptr && st.top()->right == nullptr){
				st.pop();
			}
			if (st.top()->left != nullptr){
				st.push(st.top()->left);
				v.push_back(st.top()->left->val);
				st.top()->left = nullptr;
				continue;
			}
			if (st.top()->right != nullptr){
				st.push(st.top()->right);
				v.push_back(st.top()->right->val);
				st.top()->right = nullptr;
				continue;
			}
		}
		return v;
	}
};