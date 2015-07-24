#pragma once
#include <vector>
#include <string>
#include <sstream>
#include <stack>
#include <algorithm>
using namespace std;

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};