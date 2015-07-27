/*
	Sort a linked list in O(n log n) time using constant space complexity.
	对一个链表进行排序，要求时间是n logn 空间是常量
	因为出现了logn 这就意味着要与2有关，应该想到归并排序
	又要求用常量空间
	*/
#pragma once
#include "LeetCode.h"
class SortList
{
public:
	SortList();
	~SortList();
	/*
		这个是我调用泛型算法实现的
		系统自带的sort方法，但是时间复杂度我不知道(我不知道sort用的什么排序)，空间复杂度是o(n)
		leetcode 84ms 不快
		后来我将head == nullptr换成了！head 结果时间提高到了68ms！！！！！！！！！！！！！！！！！！！！
		*/
	ListNode* sortList_Dwyer(ListNode* head) {
		vector < ListNode * > v;
		if (!head) return head;
		while (head){
			v.push_back(head);
			head = head->next;
		}
		sort(v.begin(), v.end(), [](const ListNode* a, const ListNode* b){return a->val < b->val; });
		for (size_t i = 0; i < v.size() - 1; ++i){
			v[i]->next = v[i + 1];
		}
		v[v.size() - 1]->next = nullptr;
		head = v[0];
		return head;
	}

	/*
		哈哈 这个是我自己写的归并算法
		62ms 属于主流时间
		要写出来严格的代码得注意head什么的都是指针，然后每一个ListNode就在空间中不动，动过来东过去的只是其中的next这个指针的部分
		所以并没有开辟新空间
	*/
	ListNode* sortList(ListNode* head) {
		if (!head || !(head->next)) return head;//链表为1和空的条件
		ListNode* headkeep = head;
		int n=0;
		while (head){
			++n;
			head = head->next;
		}

		ListNode *mid = headkeep;
		for (size_t i = 0; i < n / 2-1; i++)
			mid = mid->next;
		ListNode *temp = mid->next;
		mid->next = nullptr;
		return Merge(sortList(headkeep), sortList(temp));//对两半分别排序，然后进行融合
	}

	ListNode* Merge(ListNode* first, ListNode* second) {
		if (!first || !second) return first ? first : second;
		//经过分析，新开辟一个head，并不是新建了一个链表，只是多了一个指针而已
		ListNode a(0);
		ListNode *head = &a;
		ListNode *re = head;//这里比较恶心，写了三行就是为了初始化一个head，后面还得去掉
		while (first && second){
			if (first->val < second->val){//谁小存谁
				head->next = first;
				first = first->next;
				head = head->next;
			}
			else{
				head->next = second;
				second = second->next;
				head = head->next;
			}
		}
		if (first) head->next = first;//把剩下的部分接上
		if (second) head->next = second;
		return re->next;//前面加了一个没用的头，得去掉
	}
};

