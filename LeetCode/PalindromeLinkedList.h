/***********************
*Date:2015.7.16
*Problems:Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*感悟：	我的方法O(n)但是空间做不到O(1)
		有很多人把链表翻转了一下，但是这开辟了空间
		有人说空间做不到O（n）因为：
			(1) a program using O(1) space is computationally equivalent to a finite automata, or a regular expression checker; 
			(2) the pumping lemma states that the set of palindrome strings does not form a regular set.
***********************/
#pragma once
#include <vector>
using namespace std;
class PalindromeLinkedList
{
public:
	struct ListNode {
		int val;
		ListNode *next;
		ListNode(int x) : val(x), next(NULL) {}
		
	};

	PalindromeLinkedList();
	~PalindromeLinkedList();
	bool isPalindrome(ListNode* head) {
		vector<int> v;
		while (head != NULL){
			v.push_back(head->val);
			head = head->next;
		}
		if (v.size() < 2) return true;
		auto front= v.begin();
		auto back = --v.end();
		while (front < back){
			if (*front != *back)
				return false;
			++front;
			--back;
		}
		return true;
	}
};

