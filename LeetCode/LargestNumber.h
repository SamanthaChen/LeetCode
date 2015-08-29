/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/
#pragma once
#include "LeetCode.h"
class LargestNumber
{
public:
	LargestNumber();
	~LargestNumber();
	/*
	8ms
	注意全0的情况
	string ab = a + b;string ba = b + a;return ab > ba;
	最核心的代码！！
	*/
	string largestNumber(vector<int>& nums) {
		vector<string> numsStr;
		bool zero = true;
		for (auto i : nums){
			if (i) zero = false;
			numsStr.push_back(to_string(i));
		}
		if (zero) return "0";
		sort(numsStr.begin(), numsStr.end(), [](const string&a, const string &b) {string ab = a + b;string ba = b + a;return ab > ba;});
		string re;
		for (auto i : numsStr)
			re += i;
		return re;
	}
};

