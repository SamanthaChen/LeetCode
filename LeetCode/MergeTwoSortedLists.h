/*
	Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

*/
#pragma once
#include "LeetCode.h"
class MergeTwoSortedLists
{
public:
	MergeTwoSortedLists();
	~MergeTwoSortedLists();
	/*
		8ms
		最快
		因为做链表归并排序的时候已经做过这个了
		所以很容易
	*/
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
		if (!l1 || !l2) return l1?l1:l2;
		ListNode* head = new ListNode(0);
		ListNode* re = head;
		while (l1&&l2){
			if (l1->val < l2->val){
				head->next = l1;
				l1 = l1->next;
				head = head->next;
			}
			else{
				head->next = l2;
				l2 = l2->next;
				head = head->next;
			}
		}
		if (l1) head->next = l1;
		if (l2) head->next = l2;
		return re->next;
	}
};

