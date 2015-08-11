/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can
*/
#pragma once
#include "LeetCode.h"
class SwapNodesinPairs
{
public:
	SwapNodesinPairs();
	~SwapNodesinPairs();
	/*
	两个两个交换
	用递归
	一遍过 4ms 快
	*/
	ListNode* swapPairs(ListNode* head) {
		if (!head||!head->next) return head;
		ListNode* pre = head, *temp;
		head = head->next;
		ListNode*headBackup = head;
		temp = head->next;
		head->next = pre;
		head = temp;
		pre->next = swapPairs(head);
		return headBackup;
	}
};

