/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
#pragma once
#include "LeetCode.h"
class PermutationsII
{
public:
	PermutationsII();
	~PermutationsII();
	/*
		递归结合回溯
			让每一个元素做一个首元素，然后递归输出剩下的排列

		一定要注意，只要这个元素和某个值换过了，那么以后再出现这个值就不换了
		我这里用了一个set保存每次递归用过的值
		36ms
		终于ac了啊
	*/
	vector<vector<int>> permuteUnique(vector<int>& nums) {
		vector<vector<int>> re;
		if (nums.empty()) return re;
		//因为要不断地swap将元素放在首位置，所以其实nums本身，就可以做path，没必要开辟新的path
		permuteUnique(re, nums, 0);
		return re;
	}

	void permuteUnique(vector<vector<int>> &re, vector<int>& nums,int index) {
		if (index == nums.size()) {
			re.push_back(nums);
			return;
		}
		set<int> swaped;//!!!!!!这里是重要的使用
		for (int i = index;i < nums.size();i++) {
			if (swaped.find(nums[i]) != swaped.end()) continue;//防止换过的数字再次被替换
			swap(nums[i], nums[index]);
			permuteUnique(re, nums, index+1);
			swap(nums[i], nums[index]);
			swaped.insert(nums[i]);
		}
	}
};

