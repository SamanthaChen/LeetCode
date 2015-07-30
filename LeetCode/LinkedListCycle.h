/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/
#pragma once
#include "LeetCode.h"
class LinkedListCycle
{
public:
	LinkedListCycle();
	~LinkedListCycle();
	/*
	12ms 一遍过 不难
	思想，每次遍历过得节点都让它指向首节点
	如果走着走着走回了首节点，说明存在cycle
	看了下排名很高的做法，我觉得不好，设置了一个fast每次走两步，一个slow每次走一步
	如果存在环，总有重合的时候
	但这样可能比较耗时间
	*/
	bool hasCycle(ListNode *head) {
		if (!head) return false;
		ListNode *headFlag = head;
		head = head->next;
		while (head&&head != headFlag){
			ListNode *temp = head->next;
			head->next = headFlag;
			head = temp;
		}
		if (head) return true;
		return false;
	}
};

