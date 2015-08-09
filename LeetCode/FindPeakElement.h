/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/
#pragma once
#include "LeetCode.h"
class FindPeakElement
{
public:
	FindPeakElement();
	~FindPeakElement();
	/*
	这个题看似简单，但仔细想想肯定又是指望你在lgn内搞定
	那么就要想到二分查找
	继续思考，因为存在peak，所以至少存在趋势先加后减（如果是先减后加的话，那么第一个数就是了）
	所以每次二分后，判断是在往上走还是往下走，往上走的话，left=mid，否则right=mid
	终于特么ac了
	8ms
	*/
	int findPeakElement(vector<int>& nums) {
		if (nums.size() <= 1) return 0;
		int n = nums.size();
		int left = 0, right = n - 1;
		int mid;
		if (nums[0]>nums[1]) return 0;
		if (nums[right]>nums[right - 1]) return right;
		while (left<right) {
			mid = (left + right) / 2;
			if ((nums[mid] > nums[mid - 1]) && (nums[mid]>nums[mid + 1]))//这句话还是加上好！！！
				return mid;
			else if (nums[mid] > nums[mid - 1])
				left = mid;
			else
				right = mid;
		}
		return left;
	}
};

