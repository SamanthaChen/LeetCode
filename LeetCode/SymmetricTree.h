/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

1
/ \
2   2
/ \ / \
3  4 4  3
But the following is not:
1
/ \
2   2
\   \
3    3

//既然尝试递归，又让尝试迭代器
注意一个事，是针对根节点对称！！而不是每个节点都对称
*/
#pragma once
#include "LeetCode.h"
class SymmetricTree
{
public:
	SymmetricTree();
	~SymmetricTree();
	//理解清楚以后用递归确实1遍过
	//4ms 最快
	//比价麻烦的是递归得从根的左右节点开始，而且递归函数是新的接受两个节点的
	bool isSymmetric(TreeNode* root) {
		if (!root) return true;
		return valEqual(root->left, root->right);
	}
	bool valEqual(TreeNode* a, TreeNode* b){
		if (!a&&!b) return true;
		if (a&&b&&a->val == b->val)
			return valEqual(a->left, b->right) && valEqual(a->right, b->left);
		return false;
	}

	/*
	下面是非递归的方法
	我打算用两个队列实现
	照样是4ms
	a队列先进左边的，再进右边的
	b对列先进右边，再进左边
	如果对称，a，b的值应该始终一致
	*/
	bool isSymmetric_Dwyer1(TreeNode* root) {
		if (!root) return true;
		deque<TreeNode*> a, b;
		a.push_back(root->left);
		b.push_back(root->right);
		while (!a.empty() && !b.empty()){
			if (a.front() && b.front()){
				if (a.front()->val != b.front()->val)
					return false;
				a.push_back(a.front()->left);
				a.push_back(a.front()->right);
				b.push_back(b.front()->right);
				b.push_back(b.front()->left);
				a.pop_front();
				b.pop_front();
				continue;
			}
			if (!a.front() && !b.front()){
				a.pop_front();
				b.pop_front();
				continue;
			}
			return false;
		}
		if (!a.empty() || !b.empty()) return false;
		return true;
	}
};

