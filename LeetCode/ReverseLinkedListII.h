/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/
#pragma once
#include "LeetCode.h"
class ReverseLinkedListII
{
public:
	ReverseLinkedListII();
	~ReverseLinkedListII();
	/*
	front 存的是不用反转的最后一个元素
	back存最后一个元素
	搞定4ms 时间还不错
	*/
	ListNode* reverseBetween(ListNode* head, int m, int n) {
		if (!head || m == n) return head;
		ListNode* preHead = new ListNode(0);
		preHead->next = head;
		ListNode *front = preHead, *back,*temp, *pre;
		for (size_t i = 1;i <= n;++i) {
			if (i < m) {
				front = head;
				head = head->next;
			}
			else if (i == m) {
				pre = head;
				head = head->next;
				back = pre;
			}
			else {
				temp = head->next;
				head->next = pre;
				pre = head;
				head = temp;
			}
		}
		front->next = pre;//让front指向翻转后的第一个
		back->next = head;//让反转后的最后一个指向下一个
		return preHead->next;
	}
};

