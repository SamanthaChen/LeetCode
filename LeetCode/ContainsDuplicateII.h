/***********************
*Date:2015.6.28
*Problems:Given an array of integers and an integer k, find out whether there there are two distinct indices i 
	and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*题目：给定一个整数数组，判断是否存在两个相同的数字，他们的下标距离最大为k
*感悟：	今天觉得n平方是不能忍受的
		有时候是会不会用好C++这个工具的问题，并非纯算法
		也不知道找工作需要的是下面这种能力，还是纯算法，当然都有的话最好了，但这的确是两种不同的能力
***********************/

#pragma once

#include <vector>
#include <unordered_map>
#include <iostream>
#include <algorithm>

using namespace std;
class ContainsDuplicateII
{
public:
	ContainsDuplicateII();
	~ContainsDuplicateII();
	
	/********************
	*描述:这个是我写的方法，用了最常规的思路，也就是两个for循环
	*时间复杂度：O(n平方)
	*LeetCode效果:17个测试集12ms
	*测试:等了很久后， 10000个数组直接挂掉了
	********************/
	bool containsNearbyDuplicate_Dwyer(vector<int>& nums, int k) {
		if (k > nums.size())
			k = nums.size();
		while (!nums.empty() && k > 0 && k <= nums.size()){
			vector<int>::iterator it1 = nums.begin();
			vector<int>::iterator it2 = it1;
			while (it1 != nums.end() - k + 1){
				while (it2 != it1 + k){
					++it2;
					if (*it1 == *it2)
						return true;
				}
				++it1;
				it2 = it1;
			}
			return false;
		}
		return false;
	}

	/********************
	*描述:这个是看到的最棒的
		用了unordered_map，本质思想是把下标当做value，把值当做key，也就是反了一下
		然后采用map，刚好又省掉了新建数组可能导致的空间复杂度过大的问题
	*测试:这个算法相当快，10000的数组分分钟
	*LeetCode效果:17个测试集52ms
	*时间复杂度：O(n平方)
	********************/
	bool containsNearbyDuplicate_Best(vector<int>& nums, int k) {
		unordered_map<int, int> m;
		for (int i = 0; i<nums.size(); i++){
			//这里m.find(nums[i]) != m.end() 可以保证每次插入的值如果是第一次出现，直接添加到map
			//如果能到m[nums[i]] >= i - k，就表示这个值至少是第二次出现了,这种情况下m[nums[i]]存的是最近一次出现的nums[i]这个值
			//m[nums[i]]就是离i最近的相同的值的下标，然后去保证这个下标与i的距离最大为k即可
			if (m.find(nums[i]) != m.end() && m[nums[i]] >= i - k)
				return true;
			m[nums[i]] = i;
		}
		return false;
	}

	/********************
	*描述:这个是看到的另一种思路，用了很多泛型算法
		基本思路每次遍历调用find函数寻找是否有相同值，外围循环了n词，内围用了find，所以他算法的优劣其实取决于find的优劣
		我是不明白，find不也应该属于遍历n吗，为何效率会这么高？
	*测试:这个算法相当快，10000的数组分分钟，稍微慢一些
	*时间复杂度：O(n平方)
	*LeetCode效果:17个测试集32ms
	********************/
	bool containsNearbyDuplicateII(vector<int>& nums, int k) {
		if (nums.empty() || k<1)
			return false;
		vector<int> temp = nums;
		//C++标准库排序，具体用哪种排序我现在不知道，但排序10000的数组特别快，注意这里用了temp
		sort(temp.begin(), temp.end());
		cout << "排序完成" << endl;
		//unique把不重复的从前往后单独放一个，返回不重复的最后一个
		auto it = unique(temp.begin(), temp.end());
		//这个是判断是否本来就没有相同值
		if (it == temp.end())
			return false;

		//这里不能用temp了，因为排序后小标丢失了，不能用
		for (auto it1 = nums.begin(); it1 != nums.end() - 1; ++it1){
			//寻找是否有与*it1相同的值
			auto it2 = find(it1 + 1, nums.end(), *it1);
			//如果有的话判断他的小标和it1距离是否不超过K
			if (it2 != nums.end()){
				if (it2 - it1 <= k){
					return true;
				}
			}
		}
		return false;
	}
};

