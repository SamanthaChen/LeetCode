/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
#pragma once
#include "LeetCode.h"
class AddBinary
{
public:
	AddBinary();
	~AddBinary();
	/*
		我尝试用这种方式，but！！超时了
		而且这种方式可能溢出！！！！！！！！！
		万一字符串有几百个1或者0呢，那用整型甚至longlong都处理不了
		换思路
		*/
	string addBinary_Dwyer(string a, string b) {
		string str;
		stack<char> st;
		int na = 0, nb = 0;
		for (char c : a)
			na = na * 2 + (c - 48);
		for (char c : b)
			nb = nb * 2 + (c - 48);
		na += nb;
		while (na){
			if (na % 2)
				st.push('1');
			else
				st.push('0');
			na = na >> 1;
		}
		while (!st.empty()){
			str += st.top();
			st.pop();
		}
		return str;
	}

	/*
	4ms
	最快
	可是string完全可以用下标操作，你神经病干嘛用stack啊
	*/
	string addBinary_Dwyer1(string a, string b) {
		stack<char> sta, stb, stre;
		string str;
		for (char c : a)
			sta.push(c);
		for (char c : b)
			stb.push(c);
		int flag = 0;//进位标志
		int x, y, z;
		while (!sta.empty() || !stb.empty()){
			x = sta.empty() ? 48 : sta.top();
			y = stb.empty() ? 48 : stb.top();
			z = x + y + flag;
			switch (z)
			{
			case 96:
				stre.push('0');
				break;
			case 97:
				stre.push('1');
				flag = 0;
				break;
			case 98:
				stre.push('0');
				flag = 1;
				break;
			case 99:
				stre.push('1');
				break;
			}
			if (!sta.empty()) sta.pop();
			if (!stb.empty()) stb.pop();
		}
		if (flag) stre.push('1');
		while (!stre.empty()){
			str += stre.top();
			stre.pop();
		}
		return str;
	}
	/*
	我要改进上面的代码量
	基本上是别人的 但自己写了一遍
	为了精简代码真是拼了
	4ms
	*/
	string addBinary_Dwyer2(string a, string b) {
		string str;
		int flag = 0;
		int i = a.size() - 1;
		int j = b.size() - 1;
		while (i>=0 || j>=0 || flag){
			//flag先加a的，再加b的
			flag += i >= 0 ? a[i--] - 48 : 0;//兼顾了i--、i>=0、然后-48
			flag += j >= 0 ? b[j--] - 48 : 0;
			str = char(flag%2+'0') + str;//这里用到了类型转换 char  还有一个重点就是 这样可以给str前面加char  如果是0，2，则补0，如果是1，3，则补1
			flag /= 2;//flag如果是0，1 则新的为0，如果是2，3，则新的为1
		}
		return str;
	}
};

