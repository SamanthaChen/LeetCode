/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB
*/
#pragma once
#include "LeetCode.h"
class ExcelSheetColumnTitle
{
public:
	ExcelSheetColumnTitle();
	~ExcelSheetColumnTitle();
	/*
	注意对‘Z’的处理，因为z取模后是0，但我们要让它代表26
	如果出现这种情况，还要让n--才行
	*/
	string convertToTitle(int n) {
		if (n < 1) return "";
		string str;
		while (n) {
			int m = n % 26;
			str = (m==0?'Z':char(m + 64)) + str;
			n /= 26-(m==0?1:0);
		}
		return str;
	}

	/*
	或者提前把n-1，然后运算，这样就是正常的26进制了
	*/
	string convertToTitle2(int n) {
		if (n < 1) return "";
		string str;
		while (n) {
			--n;//注意在while内--
			str = char(n%26 + 65) + str;
			n /= 26;
		}
		return str;
	}
};

