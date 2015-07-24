/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

这种问题用递归最好不过了(还是思考的不够周全) 

然而并不是，递归会让计算过的一遍一遍的重复计算！！
改用for循环
*/
#pragma once
#include "LeetCode.h"
class ClimbingStairs
{
public:
	ClimbingStairs();
	~ClimbingStairs();
	/*
	这个方法正确但是会超时
	因为会把计算过的一次一次计算
	*/
	int climbStairs_Dwyer1(int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		if (n == 2) return 2;
		return climbStairs_Dwyer1(n - 1) + climbStairs_Dwyer1(n - 2);
	}

	/*
	用for循环 立马0ms
	其实这就像一个斐波那契数列
	*/
	int climbStairs_Dwyer2(int n) {
		if (n <= 0 || n==1 ||n==2) return n;
		vector<int> v(n+1, 0);
		v[1] = 1;
		v[2] = 2;
		for (size_t i = 3; i <= n; ++i){
			v[i] = v[i - 1] + v[i - 2];
		}
		return v[n];
	}
};

