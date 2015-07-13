/***********************
*Date:	2015.7.11
*Problems:	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*分析:	本题的本质是一个前向链表删除节点的过程，也就是forward_list，它的特别之处在于他有首前迭代器
		forward_list困难之处在于删除节点的过程中需要保持前一个节点，但是链表只能往后走，所以需要一个pre_f保存当前节点的前一个节点
		本题控制边界条件的代码比较多也是因为没有一个方便的首前迭代器
*感悟：	边界条件我控制的太差了，虽然已经有所进步，但是考虑的还是不够周全
*Leetcode： 12ms，算挺快的
***********************/
#pragma once
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class RemoveDuplicatesFromSortedListII
{
public:
	RemoveDuplicatesFromSortedListII();
	~RemoveDuplicatesFromSortedListII();
	ListNode* deleteDuplicates_Dwyer(ListNode* head) {
		if (head == NULL)	return head;
		ListNode *pre_f, *front = head;
		ListNode *back = head->next;
		bool flag = false;
		while (back != NULL){
			if (front->val == back->val){//出现重复
				flag = true;
				back = back->next;
			}
			else{
				if (flag == true){//找到重复部分，结束的位置，将pre指向back
					flag = false;
					if (front == head){//万一是从head开始重复的，则重置head
						head = back;
						pre_f = head;
						front = head;
						back = back->next;
						continue;
					}
					pre_f->next = back;
					front = back;
					back = back->next;
				}
				else{//否则后移
					pre_f = front;
					front = front->next;
					back = back->next;
				}
			}
		}
		if (flag == true)
			pre_f->next = NULL;
		if (flag == true && front == head)
			head = NULL;
		return head;
	}
};

