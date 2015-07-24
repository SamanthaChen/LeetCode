/*
7.22
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

很明显要用堆栈
*/
#pragma once
#include "LeetCode.h"
class ValidParentheses
{
public:
	ValidParentheses();
	~ValidParentheses();
	/*
	0ms
	没什么好解释的
	注意要考虑到直接输入一个闭字符的情况以及最后stack不是空的情况
	*/
	bool isValid(string s) {
		stack<char> st;
		for (auto c : s){
			if (c == ')'){
				if (st.empty() || st.top() != '(')
					return false;
				else{
					st.pop();
					continue;
				}
			}
			if (c == ']'){
				if (st.empty() || st.top() != '[')
					return false;
				else{
					st.pop();
					continue;
				}
			}
			if (c == '}'){
				if (st.empty() || st.top() != '{')
					return false;
				else{
					st.pop();
					continue;
				}
			}
			st.push(c);
		}
		return st.empty();
	}
};

