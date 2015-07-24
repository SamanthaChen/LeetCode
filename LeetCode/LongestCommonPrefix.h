/***********************
*Date:	2015.7.22
*Problems:	Write a function to find the longest common prefix string amongst an array of strings.
*分析:	找到所有字符串的共有前缀
*感悟：
***********************/
#pragma once
#include "LeetCode.h"

class LongestCommonPrefix
{
public:
	LongestCommonPrefix();
	~LongestCommonPrefix();
	/*
	8ms
	首先将第一个作为pre，然后依次与每个比较对pre进行修改
	*/
	string longestCommonPrefix_Dwyyer(vector<string>& strs) {
		if (strs.empty()) return "";
		auto begin = strs.begin();
		string pre = *(begin++);
		while (begin != strs.end() && pre != ""){
			size_t n = (pre.size() > (*begin).size() ? (*begin).size() : pre.size());
			pre.erase(n, pre.size() - n);//把pre的长度截取到较短的那个
			for (size_t i = 0; i < n; ++i){
				if (pre[i] != (*begin)[i]){
					pre.erase(i, pre.size() - i);//一但出现不同，则截取
					break;
				}
			}
			++begin;
		}
		return pre;
	}
};

