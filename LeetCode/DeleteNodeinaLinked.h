/*
	Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

	Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

	直接给定一个节点，然后删除这个节点,有些人说这题傻逼，但想想其实这题还行
	本质思想就是肯定有一个指针指向这个对象，那么别修改指针，直接将这个对象改为下一个对象
	就可以让原指针指向下一个对象
*/
#pragma once
#include "LeetCode.h"
class DeleteNodeinaLinked
{
public:
	DeleteNodeinaLinked();
	~DeleteNodeinaLinked();

	void deleteNode(ListNode* node) {
		*node = *node->next;
	}
};

