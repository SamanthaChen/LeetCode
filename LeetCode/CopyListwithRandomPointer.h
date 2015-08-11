 /*
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */
#pragma once
#include "LeetCode.h"
class CopyListwithRandomPointer
{
public:
	CopyListwithRandomPointer();
	~CopyListwithRandomPointer();
	/*
	这道题就是剑指offer里面的那个复制复杂链表
	将每个节点copy一个连起来，然后在操作random节点
	最后断开
	返回
	*/
	RandomListNode *copyRandomList(RandomListNode *head) {
		if (!head) return head;
		//复制一份连起来
		RandomListNode *p = head;
		while (p) {
			RandomListNode *copy = new RandomListNode(p->label);
			copy->next = p->next;
			copy->random = p->random;
			p->next = copy;
			p = copy->next;
		}
		//开始修改random指针
		p = head;
		while (p) {
			if (p->random)//注意存在random时才修改，否则没意义，报错
				p->next->random = p->random->next;
			p = p->next->next;
		}
		//断开原有的，取出新的
		//注意还不能破坏原有的结构，所以要把原有的还原回去
		p = head;
		RandomListNode *newHead = p->next;
		while (p->next&&p->next->next) {
			RandomListNode *temp = p->next;
			p->next = p->next->next;
			temp->next = temp->next->next;
			p = p->next;
		}
		return newHead;
	}
};

