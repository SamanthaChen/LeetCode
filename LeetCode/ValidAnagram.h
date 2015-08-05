/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.
*/
#pragma once
#include "LeetCode.h"
class ValidAnagram
{
public:
	ValidAnagram();
	~ValidAnagram();
	/*
	这是我的解法，用了两个map

	我看到还有别的解法，用一个map，第一次遍历++，第二次遍历--，最后判断是不是全0
	这个方法好过我的，省了一半空间

	还有一个方法，对两个string直接排序，然后比较是不是相等，搞定
	*/
	bool isAnagram(string s, string t) {
		if ( s.size() != t.size()) return false;
		unordered_map<char, int> ms;
		unordered_map<char, int> mt;
		for (auto c : s)
			ms[c]++;
		for (auto c : t)
			mt[c]++;
		int n = s.size();
		auto it = ms.begin();
		while (it != ms.end()){
			if (it->second != mt[it->first])
				return false;
			++it;
		}
		return true;
	}
};

