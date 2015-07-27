/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
3
/ \
9  20
/  \
15   7
return its level order traversal as:
[
[3],
[9,20],
[15,7]
]
层次遍历2叉树
*/
#pragma once
#include "LeetCode.h"
class BinaryTreeLevelOrderTraversal
{
public:
	BinaryTreeLevelOrderTraversal();
	~BinaryTreeLevelOrderTraversal();
	/*
		一遍过 4ms 最快的
		队列！！！！！！！！！！！
		同时需要两个计数器，分别用来数本层的是否取够了
		以及下一层的存进去多少个了
		层次遍历树要用队列！！！！！！！！！！！！！！！
	*/
	vector<vector<int>> levelOrder(TreeNode* root) {
		vector<vector<int>> vv;
		if (!root) return vv;
		deque<TreeNode*> q;
		vector<int> v;

		q.push_back(root);
		int count = 1;
		int nextCount = 0;
		while (!q.empty()){
			v.push_back(q.front()->val);
			if (q.front()->left) { 
				q.push_back(q.front()->left); 
				++nextCount;
			}
			if (q.front()->right) {
				q.push_back(q.front()->right);
				++nextCount;
			}
			q.pop_front();
			if (--count == 0){
				vv.push_back(v);
				v.clear();
				count = nextCount;
				nextCount = 0;
			}
		}
	}
};

