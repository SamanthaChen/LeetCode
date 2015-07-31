/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/
#pragma once
#include "LeetCode.h"
class ProductofArrayExceptSelf
{
public:
	ProductofArrayExceptSelf();
	~ProductofArrayExceptSelf();
	/*
	不让用除法，用的话很easy，还不需要开辟新空间，把所有的乘起来，然后到那个除以哪个就可以了
	可以扩展nums，将n以后分别push1到n-1的内容
	这样的话 i的新的值就是i+1一直往后乘n-1次
	这样做本质上还是n*n 不行！！！！！！！！
	*/
	vector<int> productExceptSelf_Dwyer(vector<int>& nums) {
		int n = nums.size();
		for (size_t i = 0;i < n - 1;i++)
			nums.push_back(nums[i]);
		for (size_t i = 0;i < n;i++)
			for (size_t j = i + 1;j < i + n;j++)
				nums[i] *= nums[j];
		return nums;
	}
	/*
	68ms 不算快 不过可以了
	用两个数组，一个存从前往后乘的值，另一个存从后往前乘的值
	然后i前面的乘积在第一个数组的又前往后i的位置
	i后面的乘积在第二个数组由后往前i个位置
	乘起来即可
	时间负责度3n
	空间复杂度2n
	*/
	vector<int> productExceptSelf(vector<int>& nums) {
		vector<int> a,b;
		a.push_back(1);
		b.push_back(1);
		for (int i = 1;i < nums.size() - 1;i++) 
			a.push_back(a[i - 1] * nums[i - 1]);
		for (int i = 1;i < nums.size();i++)
			b.push_back(b[i - 1] * nums[nums.size() - i]);
		for (int i = 0;i < nums.size();i++)
			nums[i] = a[i] * b[nums.size() - i - 1];
		return nums;
	}

};

