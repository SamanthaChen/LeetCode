/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
#pragma once
#include "LeetCode.h"
class FirstMissingPositive
{
public:
	FirstMissingPositive();
	~FirstMissingPositive();
	/*
	首先用partion把大于0的找出来
	然后就知道一共有多少个大于0的
	然后做异或运算就行了

	我真是日了狗了！！！！！！！！！居然有重复元素存在！！！！！！！！！！
	这样的话用我的方法即便找出来所有正数的部分也没法通过异或或者求和算出来丢失的数字，草！！
	*/
	int firstMissingPositive(vector<int>& nums) {
		if (nums.empty()) return 1;
		int index = partion(nums, 0);
		int n = nums.size();
		if (index == n) return 1;//全是负数
		int num_positive = n - index;//正数的数量
		int count = 1;
		int re = nums[index]^count++;
		for (int i = index + 1;i < n;i++)
			re = re^nums[index] ^ count++;
		re = re^count;
		return re;
	}
	int partion(vector<int>& nums,int pivot){
		int n = nums.size();
		int small = -1;
		for (int i = 0;i < n;i++) {
			if (nums[i] <= pivot) {
				small++;
				if (small != i)
					swap(nums[small], nums[i]);
			}
		}
		return small + 1;
	}

	/*
	得换个思路了！！！！！
	直接看别人的，我之前考虑过这种方法，但是为什么当时觉得不可行呢
	直接把对应的数字挪到对应的下标！！如果已经一致了，就跳过
	如1挪到小标0,2挪到1,4挪到3       注意是交换！！swap
	这样如果每次挪动数字nums[i]绝对能放到正确的位置上，而且不会破坏已有的
	这样可能面临一个问题
		因为交换前期把一个很大的数字交换到了很前面
		但是不用担心，因为除了一个数字全部是连续的，所以早晚会有一个数字再把这个数字给换到后面
		如果到最后这个数字还是在最前面，只能说明这个下标对应的数字不存在！！直接返回这个下标对应的数字
	4ms
	*/
	int firstMissingPositive_Dwyer2(vector<int>& nums) {
		int n = nums.size();
		for (int i = 0; i < n; i++)
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i])
				swap(nums[i], nums[nums[i] - 1]);
		for (int i = 0; i < n; i++)
			if (nums[i] != i + 1)
				return i + 1;
		return n + 1;
	}
};

