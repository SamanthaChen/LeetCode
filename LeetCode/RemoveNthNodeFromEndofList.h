/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
#pragma once
#include "LeetCode.h"
class RemoveNthNodeFromEndofList
{
public:
	RemoveNthNodeFromEndofList();
	~RemoveNthNodeFromEndofList();
	/*
	8ms
	即便是这个方法，我也是看了tag以后才知道的
	而且中途出了很多次wrong
	同时 居然还有比这个更快的方法！！！！！！
	这个的思想：两个指针差n，当一个走到末尾时，另一个next跳一下搞定
	看了下discuss大家用的方法和这个一样
	*/
	ListNode* removeNthFromEnd(ListNode* head, int n) {
		if (!head) return head;
		ListNode* fast = head;
		ListNode* slow = head;
		while (n--) fast = fast->next;
		if (!fast) return head->next;
		while (fast->next){
			fast = fast->next;
			slow = slow->next;
		}
		slow->next = slow->next->next;
		return head;
	}
};

