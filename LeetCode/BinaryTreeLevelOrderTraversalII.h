/*
	Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
依旧是层次遍历二叉树
但这次要逆着来
顺着有了，直接把顺着的逆着存一遍肯定行
*/
#pragma once
#include "LeetCode.h"
class BinaryTreeLevelOrderTraversalII
{
public:
	BinaryTreeLevelOrderTraversalII();
	~BinaryTreeLevelOrderTraversalII();
	/*
		用正向的方法
		然后调用reverse函数
		依旧是4ms
	*/
	vector<vector<int>> levelOrderBottom(TreeNode* root) {
		//一下的部分是我直接从顺着的那里粘过来的
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
		//这里开始是把顺的逆过来就行了
		reverse(vv.begin(),vv.end());
		return vv;
	}
};

