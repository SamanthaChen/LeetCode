/*
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

Hint:

Beware of overflow.
*/
#pragma once
#include "LeetCode.h"
class NumberofDigitOne
{
public:
	NumberofDigitOne();
	~NumberofDigitOne();
	/*
	这个题目是让数出来一共有多少个1
	而不是一共有多少个数字含有1
	0ms
	从高位到低位依次分析
	*/
	int countDigitOne(int n) {
		int maxBase = pow(10, countDigits(n) - 1);//比如n有5位：65314，那就从10000开始考虑
		int product = 1;//这个用来统计每次应该乘多少
		int sum = 0;
		while (maxBase > 0) {
			//取最高位
			int i = n / maxBase;
			if (i > 1)//三种不同的方式分别计算sum
				sum += maxBase*product;
			else if (i == 1)
				sum += (n - maxBase + 1) + maxBase*(product - 1);
			else if (i == 0)
				sum += maxBase*(product-1);
			product = (product - 1) * 10 + i + 1;//这里是超级核心的地方，根据规律总结
			if (i)//如果i的值是0，则n不变
				n -= i*maxBase;
			maxBase /= 10;
		}
		return sum;
	}
	//用于获取n一共有几位数字
	int countDigits(int n) {
		int re = 0;
		while (n) {
			re++;
			n /= 10;
		}
		return re;
	}
};

