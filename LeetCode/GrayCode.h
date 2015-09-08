/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
关键词：格雷码
*/
#pragma once
#include "LeetCode.h"
class GrayCode
{
public:
	GrayCode();
	~GrayCode();
	/*
	一遍过
	4ms
	*/
	vector<int> grayCode(int n) {
		vector<int> re;
		if (n < 0) return re;
		if (n == 0) return vector<int>{0};
		if (n == 1) {
			re.push_back(0);
			re.push_back(1);
			return re;
		}
		int g = 1<<(n-1);
		vector<int> reN = grayCode(n - 1);
		re.assign(reN.begin(), reN.end());
		for (int i = reN.size() - 1;i >= 0;i--) 
			re.push_back(g^reN[i]);
		return re;
	}
};

