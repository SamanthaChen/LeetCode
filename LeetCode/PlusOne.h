/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
#pragma once
#include "LeetCode.h"
class PlusOne
{
public:
	PlusOne();
	~PlusOne();
	/*
	4 ms
	对每一位单独操作，注意细节
	8999-》9000
	9-》10
	123-》124
	*/
	vector<int> plusOne(vector<int>& digits) {
		auto back = digits.rbegin();
		auto flag = 0;
		while (back != digits.rend()) {
			if (*back + 1 == 10) {
				*back = 0;
				flag = 1;
			}
			else {
				*back = *back + 1;
				return digits;
			}
			back++;
		}
		if (flag == 1) digits.insert(digits.begin(), 1);
		return digits;
	}
};

