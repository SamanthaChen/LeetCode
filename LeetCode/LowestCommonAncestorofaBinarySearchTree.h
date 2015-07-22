/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

_______6______
/              \
___2__          ___8__
/      \        /      \
0      _4       7       9
/  \
3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

* 分析：给定一棵树 以及其中的两个节点，找到这两个节点的最小共用父节点
注意这棵树是BST 可以总结出来
如果采用广度搜索，肯定可以，1.需要自己写搜索算法；2.会有浪费掉的时间，搜完根节点还得搜子节点

*/
#pragma once
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class LowestCommonAncestorofaBinarySearchTree
{
public:
	LowestCommonAncestorofaBinarySearchTree();
	~LowestCommonAncestorofaBinarySearchTree();

	//这个方法是看别人的，并不是自己的
	//主要是我还是没找到规律，找到的话却是很简单
	//最小父节点能保证一个在左侧一个在右侧，如果不是最小的话，肯定同时在左侧或者同时在右侧
	//仔细想想确实是啊！！直接比较节点的值就搞定了啊
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
		if (p->val < root->val && q->val < root->val)
			return lowestCommonAncestor(root->left,p,q);
		if (p->val > root->val && q->val > root->val)
			return lowestCommonAncestor(root->right, p, q);
		return root;
	}
};

