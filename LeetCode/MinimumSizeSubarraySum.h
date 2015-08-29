/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/
#pragma once
#include "LeetCode.h"
class MinimumSizeSubarraySum
{
public:
	MinimumSizeSubarraySum();
	~MinimumSizeSubarraySum();
	/*
		暴力遍历肯定行 n*n
		有没有更好的呢？
		可以用空间换时间！！
		都是n
		千万不要忽略了存在大于等于s的元素的情况
		4ms 最快
	*/
	int minSubArrayLen(int s, vector<int>& nums) {
		if (s < 0 || nums.size() < 1) return 0;
		//新建一个数组，存由前往后的和,而且是升序
		vector<int> v;
		int sum = 0, n = nums.size(), index = 0;
		for (int i = 0;i < n;i++) {
			if (nums[i] >= s) return 1;//提前终止
			sum += nums[i];
			v.push_back(sum);
			if (sum >= s && index == 0)
				index = i;//存第一个大于等于s的位置
		}
		if (index == 0) return 0;
		int front = 0, minLen = index + 1;//初始大小，以后每次要保证至少小于这个
		for (;index < n;index++, front++) {//这个复杂度是O(n)
			while (v[index] - v[front] >= s) {
				front++;
				if (index - front + 1 < minLen) //注意front被移动了，要+1
					minLen = index - front + 1;
			}
		}
		return minLen;
	}
};

