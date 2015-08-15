/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
1            <---
/   \
2     3         <---
\     \
5     4       <---
You should return [1, 3, 4].
*/
#pragma once
#include "LeetCode.h"
class BinaryTreeRightSideView
{
public:
	BinaryTreeRightSideView();
	~BinaryTreeRightSideView();
	/*
	假设你站在右边，一层一层看
	如果本节点有左节点，那你看到的是左边的
	没有的话你看到的是右边的
	要去下一层的话，要考虑a有b和c，c是叶子，但b不是，那么下一层是b的下一层
	所以你还需要保留父节点，用某个数据结构
	可以考虑成层次遍历，那么就需要用到队列，每次看到的是每层的最右边，时间复杂度就是n

	搞定 一遍过 4ms 最快且是主流时间 大家大概都这么做的
	*/
	vector<int> rightSideView(TreeNode* root) {
		vector<int> v;
		deque<TreeNode*> q;
		int countEveryLevel=1;
		if (!root) return v;
		q.push_back(root);
		while (!q.empty()) {
			if (q.front()->left) q.push_back(q.front()->left);
			if (q.front()->right) q.push_back(q.front()->right);
			if (countEveryLevel == 1) {
				v.push_back(q.front()->val);
				q.pop_front();
				countEveryLevel = q.size();
			}
			else {
				q.pop_front();
				countEveryLevel--;
			}
		}
		return v;
	}
};

