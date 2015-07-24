/***********************
*Date:	2015.7.22
*Problems:	Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*分析:	判断两个字符串是否同形
*感悟：
***********************/
#pragma once
#include <string>
#include <unordered_map>
#include <set>
using namespace std;
class IsomorphicStrings
{
public:
	IsomorphicStrings();
	~IsomorphicStrings();
	/*
	28ms O(n)
	一个map搞定
	注意事项：No two characters may map to the same character 
	另外：a往b映射，不代表b必须往a映射
	*/
	bool isIsomorphic_Dwyer(string s, string t) {
		unordered_map<char, char> m;
		set<char> cs;
		for (size_t i = 0; i < s.size(); i++){
			if (m.find(s[i]) == m.end()){
				if (cs.find(t[i])==cs.end()){//这里处理的就是注意事项
					cs.insert(t[i]);
					m[s[i]] = t[i];
				}
				else
					return false;
			}
			if (m[s[i]] != t[i])
				return false;
		}
		return true;
	}

	//数组要比map快!!!!!!!!!亲自用数组写一个然后测试吧 
	bool isIsomorphic(string s, string t) {
		int m1[128] = { 0 }, m2[128] = {0};
		for (size_t i = 0; i < s.size(); i++){
			if (m1[s[i]] ==0){
				if (m2[t[i]] == 0){
					m2[t[i]] = 1;
					m1[s[i]] = t[i];
				}
				else
					return false;
			}
			if (m1[s[i]]!=t[i])
			{
				return false;
			}
		}
		return true;
	}
};

