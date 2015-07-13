/***********************
*Date:	2015.6.28
*Problems:	Given a column title as appear in an Excel sheet, return its corresponding column number.
	For example:

		A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 
*分析:	实际上是26进制  基于字符对应的16进制可以很容易知道-64就是对应的数字 然后char强行转为int计算
*题目：	给定一个字母组成的字符串，输出对应的数字
*感悟：	这次我的算法已经相当高效了，哈哈哈哈哈
***********************/

#pragma once

#include <string>
#include <math.h>

using namespace std;

class ExcelSheetColumnNumber
{
public:
	ExcelSheetColumnNumber();
	~ExcelSheetColumnNumber();
	int titleToNumber_Dwyer(string s) {
		int size = s.size(), sum = 0;
		for (auto c : s)
			sum += (c - 64) * pow(26,--size);
		return sum;
	}
};

