/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
#pragma once
#include "LeetCode.h"
class MajorityElement
{
public:
	MajorityElement();
	~MajorityElement();
	/*
		一遍过，
		速度中等
		28ms
		核心是map的使用
	*/
	int majorityElement(vector<int>& nums) {
		unordered_map<int, int> m;
		for (size_t i = 0; i < nums.size(); ++i)
			if (++m[nums[i]] > nums.size() / 2)
				return nums[i];
		return 0;
	}
	/*
		16 ms
		下面是看到的一个Moore's voting algorithm 摩尔投票算法
		教程链接：http://www.cs.utexas.edu/~moore/best-ideas/mjrty/example.html
		算法:
			初始化值count为0
			向后遍历：
				如果count==0，n=a[i],count++,下次循环
				如果a[i]==n,count++
				如果a[i]!=n,count--
			返回n
		以下是我的实现
	*/
	int majorityElement_DwyerMoore(vector<int>& nums) {
		int n,count=0;
		for (int i = 0; i < nums.size(); ++i){
			if (count == 0){
				n = nums[i];
				count++;
				continue;
			}
			if (nums[i] == n) count++;
			else count--;
		}
		return n;
	}
};