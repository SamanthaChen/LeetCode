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
	用一个stack实现也不难
	需要注意的是每次要将一个节点push到栈，则需要将父节点和这个节点的联系斩断
	leetcode 4ms
	*/
	vector<int> preorderTraversal_Dwyer(TreeNode* root) {
		vector<int> v;
		stack<TreeNode*> st;
		TreeNode* temp;
		if (root == nullptr) return v;
		st.push(root);
		v.push_back(root->val);
		while (!st.empty()){
			if (st.top()->left == nullptr && st.top()->right == nullptr){
				st.pop();
				continue;
			}
			if (st.top()->left != nullptr){
				temp = st.top()->left;
				st.top()->left = nullptr;
				st.push(temp);
				v.push_back(temp->val);
				continue;
			}
			if (st.top()->right != nullptr){
				temp = st.top()->right;
				st.top()->right = nullptr;
				st.push(temp);
				v.push_back(temp->val);
				continue;
			}
		}
		return v;
	}

	/*
		别人的方法  这个只需要0ms
		基本思想：二话不说push right，然后push left
				下次循环取完后每次把这个节点再给pop出来，然后取值，然后继续这个取出来的值得右边左边
				自然就先取出了left的值，然后是right的值，
				所以人家对堆栈的应用比我的那个要好
				虽然同是堆栈，但却是不一样的思路
	*/
	vector<int> preorderTraversal(TreeNode* root) {
		stack<TreeNode*> nodeStack;
		vector<int> result;
		//base case
		if (root == NULL)
			return result;
		nodeStack.push(root);
		while (!nodeStack.empty())
		{
			TreeNode* node = nodeStack.top();
			result.push_back(node->val);
			nodeStack.pop();
			if (node->right)
				nodeStack.push(node->right);
			if (node->left)
				nodeStack.push(node->left);
		}
		return result;
	}
};