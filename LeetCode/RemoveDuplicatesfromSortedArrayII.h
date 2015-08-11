/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

*/
#pragma once
#include "LeetCode.h"
class RemoveDuplicatesfromSortedArrayII
{
public:
	RemoveDuplicatesfromSortedArrayII();
	~RemoveDuplicatesfromSortedArrayII();
	/*
	index由前往后进行覆盖
	count数出现了多少次
	20ms 
	*/
	int removeDuplicates(vector<int>& nums) {
		if (nums.size() < 3) return nums.size();
		int index=0, count = 1;
		int n = nums.size();
		bool flag = true;//用于第一次标注index的位置以后就用不着了
		for (size_t i = 1;i < n;++i) {
			if (nums[i] == nums[i - 1]){
				count++;
				if(count<3&&!flag)
					nums[index++] = nums[i];
			}
			else {
				count = 1;
				if(!flag)
					nums[index++] = nums[i];
			}
			if (count == 3&&flag) {
				index = i;
				flag = false;
			}
		}
		return flag?n:index;
	}

	/*
	好吧可以用更简单的搞定，不要用count数啊，二货，直接和上上个比较就行了啊，草
	*/
	int removeDuplicates2(vector<int>& nums) {
		int i = 0;
		for (int n : nums)
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		return i;
	}
};

