/*
	House Robber 
	You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

	Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

	说白了 这个题目就是给一个vector找出任意两个不相邻数字的最大值int rob(vector<int>& nums) {
       ！！！！！！！！说白个蛋啊 把这个题意思都理解错了好么
	   意思是你随便偷多少个房子都行，只要没有相邻的就可以
    }
*/
#pragma once
#include "LeetCode.h"

class HouseRobber
{
public:
	HouseRobber();
	~HouseRobber();
	/*
		我需要两个值a,b
		比如现在走到n了，那a代表的就是偷n-1的最大回报，b代表的就是不偷n-1的最大回报
		那么现在要决定要不要偷n，偷了的话最大回报是b+nums【n】
		不偷的话是a
		所以要比较b+nums【n】和a的值谁更大
	*/
	int rob(vector<int>& nums) {
		int a = 0, b = 0;
		for (int i = 0;i < nums.size();i++) {
			if (b + nums[i] >= a){//如果偷了i的值更大
				int temp = a;
				a = b + nums[i];//a就更新成偷了i的新值
				b = temp;//b变成了原来的a
			}
			else {//如果偷了还不如不偷
				b = a;//a的最大收益应该还是原来的，b也变成a了
			}
		}
		return max(a, b);
	}
};

