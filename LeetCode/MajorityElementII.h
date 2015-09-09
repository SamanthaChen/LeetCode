/*
Given an integer array of size n, find all elements that appear more than ? n/3 ? times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
Do you have a better hint? Suggest it!
*/
#pragma once
#include "LeetCode.h"
/*
寻找出现超过三分之一的数字
最多2个
那就维护两个num,每次出现相等的++，不等的--,变成0的话切换
那么最终如果有的话一定是num1或num2
这时候再走一遍数一下具体的数目
24ms
*/
class MajorityElementII
{
public:
	MajorityElementII();
	~MajorityElementII();
	vector<int> majorityElement(vector<int>& nums) {
		vector<int> re;
		int num1 = 0, num2 = 1;
		int count1 = 0, count2 = 0;
		for (int i = 0;i < nums.size();i++) {
			if (nums[i] == num1) count1++;
			else if (nums[i] == num2) count2++;
			else if (count1 == 0) { num1 = nums[i];count1++; }
			else if (count2 == 0) { num2 = nums[i];count2++; }
			else { count1--;count2--; }
		}
		//经历了上面的步骤，如果存在的话，那么必然是num1和num2，也有可能不存在
		count1 = 0, count2 = 0;
		for (int i = 0;i < nums.size();i++) {
			if (nums[i] == num1) count1++;
			if (nums[i] == num2) count2++;
		}
		if (count1 > nums.size() / 3) re.push_back(num1);
		if (count2 > nums.size() / 3) re.push_back(num2);
		return re;
	}
};

