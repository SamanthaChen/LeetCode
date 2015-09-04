/*
Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]
Hide Tags Array Backtracking Bit Manipulation
*/
#pragma once
#include "LeetCode.h"
class Subsets
{
public:
	Subsets();
	~Subsets();
	/*
		注意这个题目没有重复元素，有重复元素的话，一下的写法就不妥了，比如1,3,3，可能出现两个【3】，两次【1,3】
		这个题有一种解法就是比如有10个元素，那么就整一个数字从0到2的10次方-1，然后这个数字对应的0的位置不管，1的位置加入subsets，绝对可以无死角
		但是时间复杂度是n*n
	*/
	/*
		还有一个解法，把元素当做一个一个添加进去的，最初为空，然后加了1，那就多了【1】，又加了2，就多了【1,2】，【2】。。。
		这样的话n的阶乘就能搞定
		为了升序，注意提前排序
		一遍AC，8ms
	*/
	vector<vector<int>> subsets(vector<int>& nums) {
		vector<vector<int>> re;
		sort(nums.begin(), nums.end());
		vector<int> nullVec;
		re.push_back(nullVec);
		for (int i = 0;i < nums.size();i++) {
			int n = re.size();
			for (int j = 0;j < n;j++) {
				vector<int> temp = re[j];
				temp.push_back(nums[i]);
				re.push_back(temp);
			}
		}
		return re;
	}
};

