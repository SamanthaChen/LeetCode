/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Follow up:
Can you solve it without using extra space?

一个证明;

Step 1: Determine whether there is a cycle

1.1) Using a slow pointer that move forward 1 step each time

1.2) Using a fast pointer that move forward 2 steps each time

1.3) If the slow pointer and fast pointer both point to the same location after several moving steps, there is a cycle;

1.4) Otherwise, if (fast->next == NULL || fast->next->next == NULL), there has no cycle.

Step 2: If there is a cycle, return the entry location of the cycle

2.1) L1 is defined as the distance between the head point and entry point

2.2) L2 is defined as the distance between the entry point and the meeting point

2.3) C is defined as the length of the cycle

2.4) n is defined as the travel times of the fast pointer around the cycle When the first encounter of the slow pointer and the fast pointer

According to the definition of L1, L2 and C, we can obtain:

the total distance of the slow pointer traveled when encounter is L1 + L2

the total distance of the fast pointer traveled when encounter is L1 + L2 + n * C

Because the total distance the fast pointer traveled is twice as the slow pointer, Thus:

2 * (L1+L2) = L1 + L2 + n * C => L1 + L2 = n * C => L1 = (n - 1)* C + (C - L2)
*/
#pragma once
#include "LeetCode.h"
class LinkedListCycleII
{
public:
	LinkedListCycleII();
	~LinkedListCycleII();
	/*
	一个走两步一个走一步能判断循环，但找不到第一个点
	还有一个规律就是，找到slow和fast相等的点后，让head一步一步走，slow一步一步走，他们重合的点就是循环的入口
	关于这个规则的证明，见上
	这个算法很快啊 12ms
	一定要确保自己理解或者记住
	*/
	ListNode *detectCycle(ListNode *head) {
		if (!head||head==head->next) return head;
		ListNode *slow = head, *fast = head, *entry = head;
		while (fast->next&&fast->next->next) {
			slow = slow->next;
			fast = fast->next->next;
			if (slow == fast) {
				while (slow != entry) {
					slow = slow->next;
					entry = entry->next;
				}
				return entry;
			}
		}
		return nullptr;
	}
};