/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
寻找最长连续子序列
*/
#pragma once
#include "LeetCode.h"
class LongestConsecutiveSequence
{
public:
	LongestConsecutiveSequence();
	~LongestConsecutiveSequence();
	//将数字存进一个set中，set是排序的
	//一遍ac 28ms
	int longestConsecutive(vector<int>& nums) {
		int n = nums.size();
		if (n < 2) return n;
		set<int> s(nums.begin(), nums.end());
		int max = 1, count = 1;
		auto it = s.begin();
		int pre=*it;
		it++;
		while (it != s.end()) {
			if (*it == pre + 1){
				count++;
				pre = *it;
			}
			else {
				if (count > max)
					max = count;
				count = 1;
				pre = *it;
			}
			it++;
		}
		if (count > max)
			max = count;
		return max;
	}
};

