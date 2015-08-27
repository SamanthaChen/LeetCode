/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
#pragma once
#include "LeetCode.h"
class FindMinimuminRotatedSortedArray
{
public:
	FindMinimuminRotatedSortedArray();
	~FindMinimuminRotatedSortedArray();
	/*
	4ms 思路就是二分查找
	*/
	int findMin(vector<int>& nums) {
		if (nums.empty()) return -1;
		if (nums.size() == 1) return nums[0];
		int f = 0, b = nums.size() - 1;
		while (f + 1 < b) {
			int mid = (f + b) / 2;
			//以下的代码要注意，每次找到中间的元素是与最后一个元素进行比较
			if (nums[mid] < nums[b])
				b = mid;
			else
				f = mid;

			//如果每次找到元素与最前的元素进行比价，在已经有序的情况下就bug了
		}
		return nums[f] < nums[b] ? nums[f] : nums[b];
	}
};

