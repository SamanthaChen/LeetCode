#pragma once
#include "LeetCode.h"
class TrieNode
{
public:
	TrieNode(){};
	TrieNode(char c) {
		val = c;
	};
	char val;
	map<TrieNode*,int> sons;
	bool operator<(TrieNode &t) const {
		return val < t.val;
	}
};

