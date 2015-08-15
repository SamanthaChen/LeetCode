/*
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.
*/
#pragma once
#include "LeetCode.h"
class MultiplyStrings
{
public:
	MultiplyStrings();
	~MultiplyStrings();
	/*
	乘法的本质是加法，所以我可以自己定义一个做string加法的函数
	另外要加num2次，所以要会给num2实现-1的功能
	结果溢出了！！！！！太笨了，为毛首先想到是加啊！！！！！！！！！！！！
	直接从后到前乘啊，靠！！！
	*/
	string multiply_timeLimit(string num1, string num2) {
		string sum = "0";
		if (num1 == "0") return sum;
		while (num2 != "0") {
			sum = addString(sum, num1);
			minusOne(num2);
		}
		return sum;
	}

	string addString(string &num1, string &num2) {
		auto it1 = num1.rbegin(), it2 = num2.rbegin();
		int flag = 0;
		string str;
		while (it1 != num1.rend() || it2 != num2.rend() || flag) {
			int sum = (it1 != num1.rend() ? (*it1 - 48) : 0) + (it2 != num2.rend() ? (*it2 - 48) : 0) + flag;
			flag = sum / 10;
			str = char(sum % 10 + 48) + str;
			if (it1 != num1.rend())
				it1++;
			if (it2 != num2.rend())
				it2++;
		}
		return str;
	}
	void minusOne(string &num) {
		if (num.size() == 1 && num[0] == '1') {
			num = "0";
			return;
		}
		auto it = num.rbegin();
		while (it != num.rend()) {
			if (*it > '0') {
				*it = *it - char(1);
				break;
			}
			else {
				*it = '9';
				it++;
			}
		}
		//1000-1=0999要把前面的0都去掉
		auto begin = num.begin();
		if (*begin == '0')
			num.erase(begin);
	}

	/*
	8ms 最快的
	*/
	string multiply(string num1, string num2) {
		int n1 = num1.size(), n2 = num2.size();
		string re(n1 + n2, '0');//re最长也就是n1+n2
		for (int i = n1 - 1;i >= 0;--i) {
			int carry = 0;//进位
			for (int j = n2 - 1;j >= 0;--j) {
				int sum = (re[i + j + 1] - 48) + (num1[i] - 48)*(num2[j] - 48) + carry;
				carry = sum / 10;
				re[i + j + 1] = char(sum % 10 + 48);
			}
			if (carry)//万一还有进位,注意根据乘法规律，这里的进位每次都是新的一位，所以直接覆盖就行了
				re[i] = char(carry + 48);
		}
		//去掉头部的0
		auto it = re.begin();
		while (*it == '0'&&it!=re.end()-1)
			it = re.erase(it);
		return re;
	}
};