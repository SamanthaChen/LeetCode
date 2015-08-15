/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse
order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
#pragma once
#include "LeetCode.h"
class AddTwoNumbers
{
public:
	AddTwoNumbers();
	~AddTwoNumbers();
	/*
	直接由前往后加 然后返回就是了
	44ms
	以下代码相当精简
	*/
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
		int flag = 0;//进位标志
		ListNode *newHead = new ListNode(0), *headbackup = newHead;
		while (l1 || l2 || flag) {//第三个flag用于最后l1,l2加完了，但是flag还是1。这个while还能处理空的情况
			int n = l1 ? l1->val : 0; +l2 ? l2->val : 0; +flag;
			flag = n / 10;
			ListNode* newNode = new ListNode(n % 10);
			newHead->next = newNode;
			newHead = newHead->next;
			l1 = (l1 ? l1->next : nullptr);
			l2 = (l2 ? l2->next : nullptr);
		}
		return headbackup->next;
	}
};

