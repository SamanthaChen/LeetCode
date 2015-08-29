/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/
#pragma once
#include "LeetCode.h"
class SearchinRotatedSortedArrayII
{
public:
	SearchinRotatedSortedArrayII();
	~SearchinRotatedSortedArrayII();
	/*
	我的结论是不影响，直接拿过来用
	原来还是会影响的！！！！！！！！！
	因为可能把相同的给切开了！
	比如2,2,2,2,2,0,0,1,1,2,2,2

	用了新的方法，强行遍历！！
	一遍过，8ms
	perfect
	*/
	bool search(vector<int>& nums, int target) {
		int f = 0, b = nums.size() - 1, mid;
		if (nums[f] == nums[b] && target == nums[f]) return true;
		while (f < b) {
			mid = (f + b) / 2;
			if (nums[mid] == target || nums[f] == target || nums[b] == target) return true;//防止与任何一个相等
			if (nums[mid]>nums[f]) {//target可能处于nums[f] nums[mid] nums[b]切成的四个区间内，要把每种情况都覆盖到
				if (target > nums[f] && target < nums[mid]) b = mid;
				else if (target > nums[mid] || target < nums[f]) f = mid+1;
			}else if (nums[mid] < nums[f]) {//target可能处于nums[f] nums[mid] nums[b]切成的四个区间内，要把每种情况都覆盖到
				if (target < nums[mid]||target>nums[f]) b = mid;
				else if (target>nums[mid] && target < nums[f]) f = mid+1;
			}
			else if (nums[mid] == nums[f]) {
				f++;//这种情况时间复杂度是O(n)
			}
		}
		return nums[f] == target ? true:false;
	}
};

