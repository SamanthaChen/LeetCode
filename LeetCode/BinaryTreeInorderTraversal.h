/*
	Given a binary tree, return the inorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	1
	\
	2
	/
	3
	return [1,3,2].

	Note: Recursive solution is trivial, could you do it iteratively?

	中序遍历二叉树，还是可以用堆栈实现
	中序指的是，先左边然后父节点然后右边
	*/
#pragma once
#include "LeetCode.h"
class BinaryTreeInorderTraversal
{
public:
	BinaryTreeInorderTraversal();
	~BinaryTreeInorderTraversal();
	/*
		我的方法，一遍ac，爽
		0ms
	*/
	vector<int> inorderTraversal(TreeNode* root) {
		vector<int> v;
		if (root == nullptr) return v;
		stack<TreeNode *> st;
		TreeNode * temp;
		st.push(root);
		while (!st.empty()){
			//左右同时为空 取值 然后pop
			if (st.top()->left == nullptr&& st.top()->right == nullptr){
				v.push_back(st.top()->val);
				st.pop();
				continue;
			}
			//有左，将左push，切断联系
			else if (st.top()->left != nullptr){
				temp = st.top()->left;
				st.top()->left = nullptr;
				st.push(temp);
				continue;
			}
			//无左有右，首先取top的值，然后pop，然后将右节点push
			else if (st.top()->right != nullptr){
				v.push_back(st.top()->val);
				temp = st.top()->right;
				st.pop();
				st.push(temp);
				continue;
			}

		}

		return v;
	}
};

