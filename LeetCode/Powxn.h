/*
Implement pow(x, n).

Hide Tags
*/
#pragma once
#include "LeetCode.h"
class Powxn
{
public:
	Powxn();
	~Powxn();
	/*
	好吧，n可以是负数，我考虑到了
	但是x为0、1、-1的情况，我却没有考虑到
	注意要考虑到x是double型的，double型比较相等的时候的方法
	所以这道题的难点主要落在了double类型上！！！！！！！
	4ms 最快
	*/
	double myPow(double x, int n) {
		vector<double> v;
		if (n == 0) return 1.0;
		if (abs(x - 0.0) < 0.0001) return 0.0;
		if (abs(x - 1.0) < 0.0000001) return 1.0;
		if (abs(x + 1.0) < 0.0000001) return n & 1 ? -1.0 : 1.0;
		int flag = false;
		if (n < 0) {
			flag = true;
			n = -n;
		}
		int i = 2;
		v.push_back(x);
		while (i < n) {
			v.push_back(*v.rbegin()**v.rbegin());
			i *= 2;
		}
		i /= 2;
		int k = n - i, count = 0;
		double re = *v.rbegin();
		while (k) {
			if (k & 1)
				re *= v[count];
			k = k >> 1;
			count++;
		}
		return flag ? (1.0 / re) : re;
	}
	/*
	还有一种方法是直接从n入手
	每次都给x翻倍，不同的是如果是奇数，给ans*x
	偶数只翻倍
	也容易理解
	*/
	double myPow_Other(double x, int n) {
		double ans = 1;
		unsigned long long p;
		if (n < 0) {
			p = -n;
			x = 1 / x;
		}
		else {
			p = n;
		}
		while (p) {
			if (p & 1)
				ans *= x;
			x *= x;
			p >>= 1;
		}
		return ans;
	}
};

