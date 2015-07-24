/***********************
*Date:2015.7.22
*Problems:Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*题目：给定数组判断是否有重复
*感悟：	想想都应该用map
***********************/
#pragma once
#include <vector>
#include <unordered_map>
#include <set>
using namespace std;
class ContainsDuplicate
{
public:
	ContainsDuplicate();
	~ContainsDuplicate();
	/*
	我的方法
	简单的很 52ms
	*/
	bool containsDuplicate_Dwyer(vector<int>& nums) {
		unordered_map<int, int> m;
		for (size_t i = 0; i < nums.size(); i++){
			if (m.find(nums[i]) == m.end())
				m[nums[i]] = i;
			else
				return true;
		}
		return false;
	}

	/*
	别人方法，直接存在一个set中，然后判断大小，太牛逼!!!!!!!!!
	简单的很 52ms
	*/
	bool containsDuplicate(vector<int>& nums) {
		return nums.size() > set<int>(nums.begin(), nums.end()).size();
	}
};

