/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
#pragma once
#include "LeetCode.h"
class MergekSortedLists
{
public:
	/*
	我的方法
	如果采用最小堆，可以将时间复杂度降到nlgk，空间k
	后来我居然没有使用堆，用了vector结合min_element，这样每次都要找最小的，复杂度应该是nk
	然而该方法超时了！！
	*/
	ListNode* mergeKLists(vector<ListNode*>& lists) {
		if (lists.empty()) return nullptr;
		ListNode* head = new ListNode(0);
		ListNode* prehead = head;
		int k = lists.size();
		vector<ListNode*> v;
		for (size_t i = 0;i < k;++i)
			if (lists[i])
				v.push_back(lists[i]);
		while (!v.empty()) {
			auto it = min_element(v.begin(), v.end(), [](ListNode* a, ListNode* b) { return a->val < b->val; });
			head->next = *it;
			head = head->next;
			if ((*it)->next)
				*it = (*it)->next;
			else
				v.erase(it);
		}
		return prehead->next;
	}

	/*
	我勒个去！！！
	看到主流的方法就是使用堆，然而我竟然应为觉得写比较规则比价复杂，觉得不会是这样的，居然放弃了这种方法！！！
	简直服了自己
	再次好好写吧！！顺便学一下写堆的比较规则，也就是set
	420ms
	华丽通过
	所以做完这个题一定要学会set的使用，这是个特别的角色，能将时间复杂度降到lgn
	*/
	ListNode* mergeKLists_Dwyer(vector<ListNode*>& lists) {
		if (lists.empty()) return nullptr;
		ListNode* head = new ListNode(0);
		ListNode* prehead = head;
		multiset<ListNode*, com> s;
		auto it = lists.begin();
		while (it != lists.end()) {
			if (*it)
				s.insert(*it);
			++it;
		}
		while (!s.empty()) {
			auto b = s.begin();
			head->next = *b;
			head = head->next;
			if ((*b)->next) 
				s.insert((*b)->next);
			s.erase(b);
		}
		return prehead->next;
	}
	struct com {
		bool operator() (ListNode *a, ListNode *b) {
			return a->val < b->val;
		}
	};
};