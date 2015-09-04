/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/
#pragma once
#include "LeetCode.h"
class Sqrtx
{
public:
	Sqrtx();
	~Sqrtx();
	//直接用二分查找
	//8ms  最快
	//
	int mySqrt(int x) {
		if (x == 1) return 1;
		int left = 0, right = x;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (mid>x/mid) right = mid;
			else if (mid < x/mid) left = mid;
			else return mid;
		}
		return left;
	}
};

