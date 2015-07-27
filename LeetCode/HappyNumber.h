/*
	Write an algorithm to determine if a number is "happy".

	A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

	Example: 19 is a happy number

	12 + 92 = 82
	82 + 22 = 68
	62 + 82 = 100
	12 + 02 + 02 = 1
	*/
#pragma once
#include "LeetCode.h"
class HappyNumber
{
public:
	HappyNumber();
	~HappyNumber();
	/*
		并不难 
		运用了map以及其下标的特性
		8ms，算不上快的
	*/
	bool isHappy(int n) {
		if (n == 1) return true;
		unordered_map<int, int> m;//key means num,value means count
		int sum = 0;
		m[n] = 1;
		while (1)
		{
			while (n){
				sum += (n % 10)*(n % 10);
				n /= 10;
			}
			n = sum;
			sum = 0;
			if (n == 1)
				return true;
			else if (m[n]++ == 1)
				return false;
		}
		return false;
	}
};

