/*
	Rotate an array of n elements to the right by k steps.

	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

	Note:
	Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

	[show hint]

	Hint:
	Could you do it in-place with O(1) extra space?
	Related problem: Reverse Words in a String II


	*/
#pragma once
#include "LeetCode.h"
class RotateArray
{
public:
	RotateArray();
	~RotateArray();
	/*
		这是我的其中一种方法
		效率为毛那么低啊
		72ms
		很靠后
		可能是insert与erase导致的，因为每次这么做都会导致vector在内存中的重新分配
		所以慢
		但这样会比较精简，理论上没有开辟空间，而且时间耗费主要来自vector
		*/
	void rotate_Dwyer(vector<int>& nums, int k) {
		if (nums.size() < 2) return;
		k = k%nums.size();
		if (k == 0) return;
		while (k){
			nums.insert(nums.begin(), *(nums.rbegin()));
			nums.erase(nums.end() - 1);
			--k;
		}
	}
	/*
		我再用一次开辟新数组的方式
		24 ms
		立马就变快了
		在最快的阵容
		*/
	void rotate_Dwyer1(vector<int>& nums, int k) {
		if (nums.size() < 2) return;
		k = k%nums.size();
		if (k == 0) return;
		vector<int> v(nums.size(), 0);
		copy(nums.begin(), nums.end() - k, v.begin() + k);
		copy(nums.end() - k, nums.end(), v.begin());
		copy(v.begin(), v.end(), nums.begin());
	}

	/*
		别人的 在不断地交换值
		思想，每次将最后k个和最前面k个置换
		然后将新的最后k个与，0+k个位置开始置换
		然后最后k个与0+k+k个
		结束条件是k能整除剩下的位置
		也就是k %= n; n -= k
		*/
	/*void rotate_Dwyer2(vector<int>& nums, int k) {
		int n = nums.size();
		for (; k %= n; n -= k, nums+= k)
			for (int i = 0; i < k; i++)
				swap(nums[i], nums[n - k + i]);
	}*/
};

