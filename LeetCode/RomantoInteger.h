/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/
#pragma once
#include "LeetCode.h"
class RomantoInteger
{
public:
	RomantoInteger();
	~RomantoInteger();
	/*
	88ms
	ÓÐÐ©Âý
	*/
	int romanToInt(string s) {
		int re = 0;
		if (s.empty()) return re;
		map<string, int> m = { { "I", 1 }, { "IV", 4 }, { "V", 5 }, { "IX", 9 }, { "X", 10 }, { "XL", 40 }, { "L", 50 }
		, { "XC", 90 }, { "C", 100 }, { "CD", 400 }, { "D", 500 }, { "CM", 900 }, { "M", 1000 } };
		for (size_t i = 0; i < s.size(); ++i){
			if (i != s.size() - 1){
				if (m.find(s.substr(i, 2))!=m.end()){
					re += m[s.substr(i, 2)];
					++i;
				}
				else
					re += m[s.substr(i, 1)];
			}
			else{
				re += m[s.substr(i, 1)];
			}
		}
		return re;
	}
};

