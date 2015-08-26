/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
#pragma once
#include "LeetCode.h"
class NextPermutation
{
public:
	NextPermutation();
	~NextPermutation();
	/*
	c++自带这个函数
	*/
	void nextPermutation(vector<int>& nums) {
		next_permutation(nums.begin(),nums.end());
	}
	/*
	自己写的话可以这么找
	向后找到第一个正序排列的位置，然后将这个数字与后面所有数字中比它大的最小的那个与它交换，然后对后面的进行正序排列
	如果整个已经逆序排列，那么返回该数组的正序排列
	一遍过 12ms
	与c++自带的效率一样
	*/
	void nextPermutation_Dwyer(vector<int>& nums) {
		if (nums.size()<2) return;
		int n = nums.size(), i = n - 1;
		while (i > 0 && nums[i - 1] >= nums[i]) i--;
		if (i == 0) reverse(nums.begin(), nums.end());
		else {
			int j = i+1,index=i;
			for (;j < n;j++) {
				if (nums[j]>nums[i - 1] && nums[j] < nums[index])
					index = j;
			}
			swap(nums[i - 1], nums[index]);
			auto front = nums.end() - (n - i);
			reverse(front, nums.end());
		}
		return;
	}
};

