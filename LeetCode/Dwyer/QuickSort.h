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
	//这个是stl源码
	int partition(vector<int> &nums, int front, int back) {
		int index = (front + back) / 2;
		swap(nums[index], nums[back]);//把key放最后一位
		int small = front - 1;// small指向当前扫描到的小于key的最后一个
		for (index = front;index < back;index++) {//index走到最后一位之前
			if (nums[index] < nums[back]) {//如果大于key，index后移
				++small;//如果出现小于key，就是时候置换了，small的下一位是第一个大于key的
				if(small!=index)//为了防止，index开始就出现小于的情况，这种情况下small index位置相同，直接跳过
					swap(nums[small], nums[index]);
			}
		}
		++small;//最后把key值放到small的位置上
		swap(nums[small], nums[back]);
		return small;
	}
};

