/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/
#pragma once
#include "LeetCode.h"
class ConvertSortedArraytoBinarySearchTree
{
public:
	ConvertSortedArraytoBinarySearchTree();
	~ConvertSortedArraytoBinarySearchTree();
	/*
	高度要平衡，也就是左右高度差最大为1
	因为已经排序，所以直接二分
	20ms
	主流时间
	*/
	TreeNode* sortedArrayToBST(vector<int>& nums) {
		if (nums.empty()) return NULL;
		return sortedArrayToBST(nums, 0, nums.size()-1);
	}
	TreeNode* sortedArrayToBST(vector<int>& nums, int front, int back) {
		if (front > back) return NULL;
		int mid = (front + back) / 2;
		TreeNode* root = new TreeNode(nums[mid]);
		if (front == back) return root;
		TreeNode* root_back = root;
		root->left = sortedArrayToBST(nums, front, mid - 1);
		root->right = sortedArrayToBST(nums, mid + 1, back);
		return root_back;
	}
};

