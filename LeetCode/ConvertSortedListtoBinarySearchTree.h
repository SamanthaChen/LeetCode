/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/
#pragma once
#include "LeetCode.h"
class ConvertSortedListtoBinarySearchTree
{
public:
	ConvertSortedListtoBinarySearchTree();
	~ConvertSortedListtoBinarySearchTree();
	/*
	因为是已排序的链表
	所以想到的还是二分法
	与ConvertSortedArraytoBinarySearchTree其实是一个做法
	一遍过 28ms 主流时间
	*/
	TreeNode* sortedListToBST(ListNode* head) {
		if (!head) return NULL;
		if (!head->next) return new TreeNode(head->val);
		int n = 0;
		ListNode *head_backup = head;
		while (head) {
			++n;
			head = head->next;
		}
		head = head_backup;
		int mid = n / 2;
		for (int i = 0;i < mid - 1;++i)
			head = head->next;
		TreeNode* root = new TreeNode(head->next->val);
		root->right = sortedListToBST(head->next->next);
		head->next = NULL;
		root->left = sortedListToBST(head_backup);
		return root;
	}

	/*
	上面的方法多遍历了一次数n
	事实上两个指针一个两步两步走，一个一步一步走即可
	还是28ms
	*/
	TreeNode* sortedListToBST(ListNode* head) {
		if (!head) return NULL;
		if (!head->next) return new TreeNode(head->val);
		ListNode *slow = head, *fast = head,*pre= head;
		while (fast&&fast->next) {
			pre = slow;
			slow = slow->next;
			fast = fast->next->next;
		}
		TreeNode* root = new TreeNode(slow->val);
		root->right = sortedListToBST(slow->next);
		pre->next = NULL;
		root->left = sortedListToBST(head);
		return root;
	}
};

