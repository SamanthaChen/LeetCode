/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).

我本来想到的方法是中序遍历，势必很容易
结果看到了最优的时间是lgn
所以可以这么做，先一直向左找到最小的
然后k-- 依次寻找父节点然后是右节点
但是这样还是需要一个结构用来保存父节点才行啊
*/
#pragma once
#include "LeetCode.h"
class KthSmallestElementinaBST
{
public:
	KthSmallestElementinaBST();
	~KthSmallestElementinaBST();
	/*
	24ms 不快也不慢
	看到还是有人用递归的方法
	*/
	int kthSmallest(TreeNode* root, int k) {
		stack<TreeNode*> st;
		st.push(root);
		while (st.top()->left != NULL)
			st.push(st.top()->left);
		while (k--!=1) {
			if (st.top()->right) {
				TreeNode* temp = st.top();
				st.pop();
				st.push(temp->right);
				while (st.top()->left)
					st.push(st.top()->left);
			}
			else
				st.pop();
		}
		return st.top()->val;
	}
};

