/*Reverse a singly linked list.
	将链表反向
*/
#pragma once
#include <deque>
using namespace std;
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class ReverseLinkedList
{
public:
	ReverseLinkedList();
	~ReverseLinkedList();
	/*
	12 ms   我的
	将节点全部存到queue中，然后依次修改每个节点的next即可
	*/
	ListNode* reverseList_Dwyer(ListNode* head) {
		if (head == nullptr || head->next == NULL) return head;
		deque<ListNode*> q;
		while (head != nullptr){
			q.push_back(head);
			head = head->next;
		}
		auto b = q.begin();
		(*b)->next = nullptr;
		++b;
		while (b != q.end()){
			(*b)->next = *(b - 1);
			++b;
		}
		return q.back();
	}

	/*
	别人的 从前到后一下一下修改每一个节点的next，一点也不难，为什么我首先想到的却是从最后一个节点开始修改
	草
	8ms
	*/
	ListNode *reverseList(ListNode *head) {
		ListNode *pre = nullptr;
		while (head != nullptr){
			ListNode *next = head->next;//把head的原本next先存下来
			head->next = pre;//修改head的next指向pre
			pre = head;//pre现在应该是head了
			head = next;//head后移一个节点
		}
		return pre;//注意这里要返回pre，而不是head
	}
};

