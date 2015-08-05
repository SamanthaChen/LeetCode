/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
#pragma once
#include "LeetCode.h"
class ImplementstrStr
{
public:
	ImplementstrStr();
	~ImplementstrStr();
	/*
	4ms一遍过 最快
	*/
	int strStr(string haystack, string needle) {
		if (needle.empty()) return 0;
		if (haystack.size()<needle.size()) return -1;
		int n = needle.size();
		int m = haystack.size();
		for (size_t i = 0; i + n <= m; ++i){
			if (haystack[i] == needle[0])
				if (haystack.substr(i, n) == needle)
					return i;
		}
		return -1;
	}
};

