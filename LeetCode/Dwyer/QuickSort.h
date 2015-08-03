#pragma once
#include"../LeetCode.h"
class QuickSort
{
public:
	QuickSort();
	~QuickSort();
	void quickSort(vector<int> &nums) {
		if (nums.size() < 2) return;
		return sort(nums, 0, nums.size() - 1);
	}

	void sort(vector<int> &nums, int front, int back) {
		int index = partition(nums, front, back);
		if (index - front > 1)
			sort(nums, front, index);
		if (back - index > 1)
			sort(nums, index + 1, back);
		return;
	}

	int partition(vector<int> &nums, int front, int back) {
		int index = (front + back) / 2;
		swap(nums[index], nums[back]);
		int small = front - 1;
		for (index = front;index < back;index++) {
			if (nums[index] < nums[back]) {
				++small;
				if(small!=index)
					swap(nums[small], nums[index]);
			}
		}
		++small;
		swap(nums[small], nums[back]);
		return small;
	}
};

