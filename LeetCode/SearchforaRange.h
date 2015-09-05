/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/
#pragma once
#include "LeetCode.h"
class SearchforaRange
{
public:
	SearchforaRange();
	~SearchforaRange();
	/*
		原数组已排序，可以二分
		9.5号重写
		要求用O(lgn)的时间，所以不能用先找到target然后向两侧寻找的方法
		两次找，第一次找到下边界，第二次找到上边界
		一遍过
		12ms 最快
	*/
	vector<int> searchRange(vector<int>& nums, int target) {
		vector<int> re{-1,-1};
		int left = 0,right = nums.size() - 1;
		//这次我要找到左边界 让left指向左边界
		while (left < right) {
			if (nums[left] == target) break;
			int mid = (left + right) / 2;
			if (nums[mid] < target) left = mid + 1;
			if (nums[mid] > target) right = mid - 1;
			if (nums[mid] == target) {
				if(nums[mid-1]<nums[mid]){
					left = mid;
					break;
				}
				else
					right = mid;
			}
		}
		if (nums[left] != target) //说明根本不存在
			return re;
		re[0] = left;
		//这次我要找到右边界
		right = nums.size() - 1;
		while (left < right) {
			if (nums[right] == target) break;
			int mid = (left + right) / 2;
			if(nums[mid] < target) left = mid + 1;
			if (nums[mid] > target) right = mid - 1;
			if (nums[mid] == target) {
				if (nums[mid] < nums[mid + 1]) {
					right = mid;
					break;
				}
				else
					left = mid;
			}
		}
		re[1] = right;
		return re;
	}
};

