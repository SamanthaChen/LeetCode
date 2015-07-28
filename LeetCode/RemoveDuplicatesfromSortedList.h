/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/
#pragma once
#include "LeetCode.h"
class RemoveDuplicatesfromSortedList
{
public:
	RemoveDuplicatesfromSortedList();
	~RemoveDuplicatesfromSortedList();
	/*
	简单 1遍过
	12ms
	最快
	*/
	ListNode* deleteDuplicates(ListNode* head) {
		if (!head) return head;
		ListNode* headKeeper(head);
		while (head->next){
			if (head->next->val == head->val){
				head->next = head->next->next;
				continue;
			}
			head = head->next;
		}
		return headKeeper;
	}
};