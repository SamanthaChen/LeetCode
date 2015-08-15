/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.
*/
#pragma once
#include "LeetCode.h"
class ReverseWordsinaString
{
public:
	ReverseWordsinaString();
	~ReverseWordsinaString();
	/*
	思想很简单，先全部翻转一遍，然后将两个空格之间的再翻转一遍即可
	只不过题目没说清楚空格怎么处理
	太蛋疼
	终于通过了，简直了
	*/
	void reverseWords(string &s) {
		if (s.empty()) return;
		//麻蛋，题目就没说清楚遇到s开始和末尾有连续空格怎么处理
		//也没说万一中间有连续空格怎么处理，草
		//测试的时候，发现如果全为空格的话要把空格去掉，那么我先把首尾的空格去掉
		//第二遍测试的时候发现如果中间有连续空格，则要当做一个空格处理，日了狗了
		//所以换个思路，只要连续出现空格，则用一个空格去代替，如果最后只剩一个空格，那么就把s置为空
		auto b = s.begin();
		while (b != s.end()-1) {
			if (*b == ' '&&*(b + 1) == ' ')
				b = s.erase(b);
			else
				++b;
		}
		if (s[0]==' ') {
			s.erase(s.begin());
			if(s=="")
				return;
		}
		if (s[s.size() - 1] == ' ')
			s.erase(s.end() - 1);
		reverse(s.begin(), s.end());
		auto front = s.begin();
		auto back = s.begin() + 1;
		for (;back != s.end();++back) {
			if (*back == ' ') {
				reverse(front, back);
				front = back + 1;
				if (front != s.end())
					back = front;
				else return;
			}
		}
		reverse(front, back);
	}
};

