/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/
#pragma once
#include "LeetCode.h"
class RotateList
{
public:
	RotateList();
	~RotateList();
	/*
	不确定k是不是大于n，如果不大于n还好
	大于n的话就要提前走一遍然后取模
	好吧服了，果然要考虑k大于等于n的情况
	12ms 主流时间
	*/
	ListNode* rotateRight(ListNode* head, int k) {
		if (!head || !head->next || k == 0) return head;
		ListNode* headbackup = head, *slow = head, *fast = head;
		int n = 0;
		while (head) {
			++n;
			head = head->next;
		}
		k = k%n;
		if (k == 0) return headbackup;
		//fast 先走k步
		for (int i = 0;i < k;i++)
			fast = fast->next;
		while (fast->next) {
			slow = slow->next;
			fast = fast->next;
		}
		ListNode *newhead = slow->next;
		slow->next = nullptr;
		fast->next = headbackup;
		return newhead;
	}
};

