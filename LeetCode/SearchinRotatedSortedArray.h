/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
#pragma once
#include "LeetCode.h"
class SearchinRotatedSortedArray
{
public:
	SearchinRotatedSortedArray();
	~SearchinRotatedSortedArray();
	/*
	这是另一种方法，先找到那个拐点，然后在那个拐点处一侧再找
	4ms
	*/
	int search_two(vector<int>& nums, int target) {
		if (nums.empty()) return -1;
		if (nums.size() == 1)
			if (nums[0] == target) return 0;
			else return -1;
			int n = nums.size();
			int f = 0, b = n - 1;
			while (f < b) {
				int mid = (f + b) / 2;
				if (nums[mid]>nums[n - 1])
					f = mid + 1;
				else
					b = mid;
			}
			//index指向最大的那个数
			int index = f == 0 ? n - 1 : f - 1;
			if (target <= nums[index] && target>nums[n - 1] || index == n - 1) {
				//前面二分
				f = 0;
				b = index;
			}
			else {
				//后面
				f = index + 1;
				b = n - 1;
			}
			while (f < b) {
				int mid = (f + b) / 2;
				if (nums[mid] == target) return mid;
				if (nums[mid] > target) b = mid;
				else f = mid + 1;
			}
			if (nums[f] == target) return f;
			return -1;

	}

	/*
	8ms 算不上快，貌似主流时间是4ms
	而且修正了特么的好多次啊，靠靠
	代码可读性还那么差
	*/
	int search(vector<int>& nums, int target) {
		if (nums.empty()) return -1;
		if(nums[nums.size()-1]>nums[0])
			return binarySearch(nums, 0, nums.size() - 1, target, false);
		return binarySearch(nums, 0, nums.size() - 1, target,true);
	}
	//这里第五个参数表示剩下的部分是全部有序还是有旋转后的部分，如果有旋转后的部分，则为true
	int binarySearch(vector<int>& nums, int front, int back, int target,bool rotateExit) {
		if (front == back && nums[front] == target) return front;
		if (front == back) return -1;
		int mid = (front + back) / 2;
		if (nums[mid] == target) return mid;
		if (!rotateExit) {//纯有序
			if(nums[mid]>target) return binarySearch(nums, front, mid, target, false);
			else return binarySearch(nums, mid+1, back, target, false);
		}
		else {//front与back后面还是旋转过来的元素
			//mid大于target
			if(target<nums[mid]&&nums[mid]<nums[back])
				return binarySearch(nums, mid+1, back, target, false);
			if (target<nums[mid]){
				int re = binarySearch(nums, front, mid, target, false);
				return re == -1 ? binarySearch(nums, mid+1, back, target, true) : re;
			}
			//mid小于target
			if (target > nums[mid]&&nums[mid]>nums[back])
				return binarySearch(nums, mid + 1, back, target, true);
			if (target > nums[mid]) {
				int re = binarySearch(nums, front, mid, target, true);
				return re == -1 ? binarySearch(nums, mid + 1, back, target, false) : re;
			}
		}
	}
};

