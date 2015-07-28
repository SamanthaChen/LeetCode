/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/
#pragma once
#include "LeetCode.h"
class RemoveDuplicatesfromSortedArray
{
public:
	RemoveDuplicatesfromSortedArray();
	~RemoveDuplicatesfromSortedArray();
	/*
	直接调用标准库的unique函数
	快快的
	方便的很
	32ms
	最快的
	注意unique返回一个迭代器，指向那些被移到最后面的元素的第一个位置
	*/
	int removeDuplicates(vector<int>& nums) {
		auto it = unique(nums.begin(), nums.end());
		auto begin = nums.begin();
		int i = 0;
		while (begin++ != it)
			++i;
		return i;
	}

	/*
	这次自己来
	一次遍历
	事实上，除了返回长度，还要把nums修改成合适的才能ac
	It doesn't matter what you leave beyond the new length.\
	注意这句话，有了这句话就可以不管超出长度的部分是什么值了.所以就可以将第count个位置，置为新出现的不同的值
	核心：nums[count++] = nums[i];
	32ms

	*/
	int removeDuplicates_Dwyer2(vector<int>& nums) {
		if (nums.size()<2) return nums.size();
		int count = 1;
		for (int i = 1; i < nums.size(); ++i){
			if (nums[i] != nums[i - 1])
				nums[count++] = nums[i];
		}
		return count;
	}
};