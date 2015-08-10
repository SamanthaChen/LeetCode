// LeetCode.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "ReverseNodesinkGroup.h"

int _tmain(int argc, _TCHAR* argv[])
{
	ReverseNodesinkGroup ReverseNodesinkGroup;
	ListNode *a = new ListNode(1), *b = new ListNode(2), *c = new ListNode(3), *d = new ListNode(4);
	a->next = b;
	b->next = c;
	c->next = d;
	vector<ListNode*> v{a,c};
	ReverseNodesinkGroup.reverseKGroup(a,2);
	return 0;
}

