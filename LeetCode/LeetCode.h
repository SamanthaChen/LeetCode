#pragma once
#include <vector>
#include <string>
#include <sstream>
#include <stack>
#include <algorithm>
#include <unordered_map>
#include <set>
#include <functional>
#include <stdint.h>
#include <memory>
#include <map>
#include <iostream>
#include <ctype.h>
#include <random>
#include <mutex>
#include <thread>
using namespace std;

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

struct TreeLinkNode {
	int val;
	TreeLinkNode *left, *right, *next;
	TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

struct RandomListNode {
	int label;
	RandomListNode *next, *random;
	RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
};