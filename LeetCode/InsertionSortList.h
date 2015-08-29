/*
Sort a linked list using insertion sort.
*/
#pragma once
#include "LeetCode.h"
class InsertionSortList
{
public:
	InsertionSortList();
	~InsertionSortList();
	/*
	o(n*n)
	始终要有一个指向head，一个指向待处理的
	一遍通过 80ms
	最主流的时间
	然后看到有人很快，他们用的真的是插入排序吗
	*/
	ListNode* insertionSortList(ListNode* head) {
		if (!head || !head->next) return head;
		ListNode* curr = head->next, *preCurr = head;
		while (curr) {
			ListNode* front = head;
			ListNode* preFront = front;
			while(front!=curr&&front->val<curr->val){
				preFront = front;
				front = front->next;
			}
			if (front == head) {//插入最前面
				ListNode* temp = curr->next;
				curr->next = front;
				head = curr;
				curr = temp;
				preCurr->next = temp;
			}
			else if (front == curr) {//不用插入，已经有序
				preCurr = curr;
				curr = curr->next;
			}
			else {//中间插入
				ListNode* temp = curr->next;
				preFront->next = curr;
				curr->next = front;
				curr = temp;
				preCurr->next = temp;
			}
		}
		return head;
	}
};

