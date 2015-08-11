/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
#pragma once
#include "LeetCode.h"
class PartitionList
{
public:
	PartitionList();
	~PartitionList();
	/*
	greater始终在往后走，寻找小于x的节点
	lastLess指向比x小的最后一个
	firstGreat永远指向第一个大于等于x的
	8ms 一遍过
	*/
	ListNode* partition(ListNode* head, int x) {
		if (!head || !head->next) return head;
		ListNode* preHead = new ListNode(0), *greater = head, *lastLess = preHead;
		preHead->next = head;
		while (greater&&greater->val < x) { //如果小于
			lastLess = greater;
			greater = greater->next;
		}
		ListNode* firstGreat = greater;
		if(!greater) return preHead->next;
		ListNode* preGreater = greater;
		greater = greater->next;
		while (greater) {
			if (greater->val < x) {
				lastLess->next = greater;
				preGreater->next = greater->next;
				greater->next = firstGreat;
				lastLess = lastLess->next;
				greater = preGreater->next;
				continue;
			}
			preGreater = greater;
			greater = greater->next;
		}
		return preHead->next;
	}
};

