/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

*首先
 */
#pragma once
#include "LeetCode.h"
class ReorderList
{
public:
	ReorderList();
	~ReorderList();
	/*
	一个时间n空间n的最简单思路
	果断ac 64ms
	大部分都是这个时间，极少数更快
	还有一种方法其实我也想到了，但是觉得写起来时间还是n所以没实施
	也就是一个两步一个一步找到中间的，然后从中间的开始反转一下
	然后将两部分拼接起来
	*/
	void reorderList(ListNode* head) {
		if (!head) return;
		vector<ListNode*> v;
		while (head) {
			v.push_back(head);
			head = head->next;
		}
		auto front = v.begin();
		auto back = v.end() - 1;
		while (front < back) {
			(*front)->next = *back;
			++front;
			(*back)->next = *front;
			--back;
		}
		(*front)->next = nullptr;
	}
};

