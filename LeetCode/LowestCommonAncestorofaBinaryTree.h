/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that
has both v and w as descendants (where we allow a node to be a descendant of itself).”

_______3______
/              \
___5__          ___1__
/      \        /      \
6      _2       0       8
/  \
7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is 
LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
*/
#pragma once
#include "LeetCode.h"
class LowestCommonAncestorofaBinaryTree
{
public:
	LowestCommonAncestorofaBinaryTree();
	~LowestCommonAncestorofaBinaryTree();
	/*
	想了很久终于想到方法
	注意各种可能
	用一个vector层次遍历之
	两个都找到后，由第一个找到的往前一个一个判断和更新
	如果有节点只是p的父节点，将p替换为这个节点
	知道找到同时是p和q父节点的节点
	返回之
	基本算是一遍搞定！！！！！！！！！！24ms最快的！！!!!!!!!!!
	这个因为提前终止了！比递归什么的都快！！！！！！！！！！！
	*/
	TreeNode* lowestCommonAncestor_Dwyer1(TreeNode* root, TreeNode* p, TreeNode* q) {
		if (!root) return root;
		if (!p||!q) return NULL;
		if (p == root || q == root) return root;
		if (p == q) return p;
		vector<TreeNode*> v;
		int pos_p = 0,pos_q = 0;
		v.push_back(root);
		int i = 0;
		while(!pos_p||!pos_q){//当两个都不为0是，说明vector就没必要继续往下填了
			if (v[i] == p)
				pos_p = i;
			if (v[i] == q)
				pos_q = i;
			if (v[i]->left)
				v.push_back(v[i]->left);
			if (v[i]->right)
				v.push_back(v[i]->right);
			++i;
		}
		//截至这里，p和q在v中的位置都已经找到！！！，下一次一步一步往前，注意p和q可能是父子关系！！
		int index = max(pos_p, pos_q)-1;
		while (index >= 0) {
			if ((v[index]->left == v[pos_p] && v[index]->right == v[pos_q]) 
				|| (v[index]->left == v[pos_q] && v[index]->right == v[pos_p])
				||(v[index]==v[pos_q]&&(v[index]->left == v[pos_p] || v[index]->right == v[pos_p]))
				|| (v[index] == v[pos_p] && (v[index]->left == v[pos_q] || v[index]->right == v[pos_q])))
				return v[index];
			else if (v[index]->left == v[pos_p] || v[index]->right == v[pos_p])
				pos_p = index;
			else if (v[index]->left == v[pos_q] || v[index]->right == v[pos_q])
				pos_q = index;
			index--;
		}
		return root;
	}


	/*
	草啊！！用递归可以很简单的啊！！！！！！！为毛没想到啊！！！！！！
	24ms
	并不比非递归的慢啊 ！！！！！！！！！！
	*/
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
		if (!root || p == root || q == root) return root;
		TreeNode* left = lowestCommonAncestor(root->left, p, q);
		TreeNode* right = lowestCommonAncestor(root->right, p, q);
		return !right ? left : !left ? right : root;
	}
};

