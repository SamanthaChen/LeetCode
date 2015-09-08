/*
Ç°×ºÊ÷
×ÖµäÊ÷
140ms
*/
#pragma once
#include "TrieNode.h"
#include "LeetCode.h"
class Trie
{
public:
	Trie() {
		root = new TrieNode();
	};
	// Inserts a word into the trie.
	void insert(string word) {
		if (word.size() == 0) return;
		int index = 0, n = word.size();
		TrieNode *f = root;
		while (index < n) {
			auto it = f->sons.begin();
			for (;it != f->sons.end();it++) {
				if (it->first->val == word[index]) {
					index++;
					if (index == n)
						it->second++;
					f = it->first;
					break;
				}
			}
			if (it == f->sons.end()) {
				TrieNode *temp = new TrieNode(word[index]);
				(f->sons)[temp]=index==n-1?1:0;
			}
		}
	}

	// Returns if the word is in the trie.
	bool search(string word) {
		if (word.size() == 0) return false;
		int index = 0, n = word.size();
		TrieNode *f = root;
		auto it = f->sons.begin();
		while (index < n) {
			it = f->sons.begin();
			for (;it != f->sons.end();it++) {
				if (it->first->val == word[index]) {
					index++;
					f = it->first;
					break;
				}
			}
			if (it == f->sons.end()) return false;
		}
		if (it->second>0) return true;
		return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	bool startsWith(string prefix) {
		if (prefix.size() == 0) return false;
		int index = 0, n = prefix.size();
		TrieNode *f = root;
		while (index < n) {
			auto it = f->sons.begin();
			for (;it != f->sons.end();it++) {
				if (it->first->val == prefix[index]) {
					index++;
					f = it->first;
					break;
				}
			}
			if (it == f->sons.end()) return false;
		}
		return true;
	}
private:
	TrieNode* root;
};

