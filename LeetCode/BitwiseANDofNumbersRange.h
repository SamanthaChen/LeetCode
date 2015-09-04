/*
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

求一个给定区间内的所有数字的与的结果，包括给定的两个数字
我采用暴力法了，结果超时了
*/
#pragma once
#include "LeetCode.h"
class BitwiseANDofNumbersRange
{
public:
	BitwiseANDofNumbersRange();
	~BitwiseANDofNumbersRange();
	/*
		这个要注意到，只要n比m大，那么最后一位做&后一定是0
		所以每次处理完最后一位，将n与m各自右移一位，然后迭代判断就行了
		最后当n与m相等时，再把右移的全部移回来就是
		68ms
	*/
	int rangeBitwiseAnd(int m, int n) {
		return n > m ? rangeBitwiseAnd(m / 2, n / 2) << 1 : m;
	}
};

