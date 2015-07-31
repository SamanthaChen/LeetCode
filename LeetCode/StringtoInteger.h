/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
*/
#pragma once
#include "LeetCode.h"
class StringtoInteger
{
public:
	StringtoInteger();
	~StringtoInteger();
	/*
	这题也是能把人搞哭
	因为对stoi可能有些情况不知道
	1.前后有空格的情况
	2.中间有数字的话
	3.越界
	4.正号
	12ms 还行吧 不是啥有技术含量的题
	*/
	int myAtoi(string str) {
		if (str.empty()) return 0;
		int pos_front = 0, pos_back = str.size() - 1;
		//前后有空格
		for (size_t i = 0;i < str.size();++i) {
			if (str[i] == ' ') pos_front++;
			else break;
		}
		for (int i = str.size()-1;i >=0;--i) {
			if (str[i] == ' ') pos_back--;
			else break;
		}
		if (pos_front > pos_back)
			return 0;
		if (pos_front == pos_back && !isdigit(str[pos_front])) return 0;

		//第一个必须是+，-或者数字
		if (!isdigit(str[pos_front]) && str[pos_front] != '-'&&str[pos_front] != '+')
			return 0;
		int flag = 1;
		if (str[pos_front] == '-') {
			flag = -1;
			pos_front++;
		}
		else if (str[pos_front] == '+')
			pos_front++;
		//然后下一个位置必须是数字  "  -0012a42"这种应该返回-12
		if (!isdigit(str[pos_front])) return 0;

		long long re = 0;
		for (size_t i = pos_front;i <= pos_back;++i){
			//"  -0012a42"  遇到不是数字的立马结束
			if (!isdigit(str[i]))
				break;
			re = (re * 10 + str[i] - 48);
			//判断越界
			if (re*flag > INT_MAX)
				return INT_MAX;
			if (re*flag < INT_MIN)
				return INT_MIN;
		}
		return re*flag;
	}
};

