/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
#pragma once
#include "LeetCode.h"
class CountandSay
{
public:
	/*
	不算快8ms
	但大家基本都是一样的做法
	另外注意int转string用to_string
	*/
	string countAndSay(int n) {
		if (n == 0) return "";
		if (n == 1) return "1";
		string oldstr = "1";
		for (size_t i = 1; i < n; ++i){
			int count = 0;
			char val = oldstr[0];
			string newstr;
			for (size_t j = 0; j < oldstr.size(); j++){
				if (oldstr[j] == val){
					++count;
				}
				else{
					newstr = newstr+to_string(count);
					newstr = newstr + val;
					count = 1;
					val = oldstr[j];
				}
			}
			newstr = newstr + to_string(count);
			newstr = newstr + val;
			oldstr = newstr;
		}
		return oldstr;
	}
};

