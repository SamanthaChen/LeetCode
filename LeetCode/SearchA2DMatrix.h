/***********************
*Date:	2015.7.11
*Problems:	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*分析:	二维数组，可以首先遍历每个数组的头，然后找到第一个头数字比target大的的前一行，然后遍历所在的那一行，因为已经排好序了，所以都是
		从前往后遍历就行了
*题目：	给定一个有规律的数组，查找某个值
*感悟：	binary_search比find要快！！！！！！！！！
		仔细想想，这个题最合适的就是二叉搜索！！因为是从小到大有序的，这要比遍历快！！
		即便用普通的遍历也比find要快！！！！！！！！！！！！！
		妈的，这种题都根本没人借助数组的特别之处进行处理，都特么的用的暴力遍历
***********************/
#pragma once
#include <vector>
#include <algorithm>
using namespace std;
class SearchA2DMatrix
{
public:
	SearchA2DMatrix();
	~SearchA2DMatrix();
	/********************
	*描述:这个是我写的方法 就是首先根据每一行的第一个数字找到寻找target的那一行，然后调用find算法找3
	*时间复杂度：O(n)
	*LeetCode效果:16ms
	********************/
	bool searchMatrix_Dwyer(vector<vector<int>>& matrix, int target) {
		vector<vector<int>>::iterator row = matrix.begin();
		vector<vector<int>>::iterator front_row = row;
		if (matrix.size() == 0 || matrix[0].size() == 0 || matrix[0][0] > target) return false;
		while (row != matrix.end()){
			if ((*row)[0] > target)
				break;
			front_row = row;
			++row;
		}
		if (find((*front_row).begin(), (*front_row).end(), target) != (*front_row).end())
			return true;
		return false;
	}

	/********************
	*描述:这个是我写的第二个方法 纯粹调用系统提供的算法
	*时间复杂度：O(n)
	*LeetCode效果:同样耗时16ms
	********************/
	bool searchMatrix_Dwyer2(vector<vector<int>>& matrix, int target) {
		for (int i = 0; i < matrix.size();i++)
			if (find(matrix[i].begin(), matrix[i].end(), target) != matrix[i].end())
				return true;
		return false;
	}

	/********************
	*描述:这个是我写的第三个方法 改用binary_search
	*时间复杂度：O(n)
	*LeetCode效果:改成binary_search 只用12ms，看来算法的选择影响挺大的
	********************/
	bool searchMatrix_Dwyer3(vector<vector<int>>& matrix, int target) {
		for (int i = 0; i < matrix.size(); i++)
			if (binary_search(matrix[i].begin(), matrix[i].end(), target))
				return true;
		return false;
	}

	/********************
	*描述:这个是我写的第一=个方法把find用binary_search代替
	*时间复杂度：O(n)
	*LeetCode效果:同样达到了12ms
	********************/
	bool searchMatrix_Dwyer4(vector<vector<int>>& matrix, int target) {
		vector<vector<int>>::iterator row = matrix.begin();
		vector<vector<int>>::iterator front_row = row;
		if (matrix.size() == 0 || matrix[0].size() == 0 || matrix[0][0] > target) return false;
		while (row != matrix.end()){
			if ((*row)[0] > target)
				break;
			front_row = row;
			++row;
		}
		if (binary_search((*front_row).begin(), (*front_row).end(), target))
			return true;
		return false;
	}

	/********************
	*描述:这个是我写的第一个方法把find用普通的遍历代替
	*时间复杂度：O(n)
	*LeetCode效果:也能做到12ms！！！！！！！！
	********************/
	bool searchMatrix_Dwyer5(vector<vector<int>>& matrix, int target) {
		vector<vector<int>>::iterator row = matrix.begin();
		vector<vector<int>>::iterator front_row = row;
		if (matrix.size() == 0 || matrix[0].size() == 0 || matrix[0][0] > target) return false;
		while (row != matrix.end()){
			if ((*row)[0] > target)
				break;
			front_row = row;
			++row;
		}
		vector<int > ::iterator begin = (*front_row).begin();
		while (begin != (*front_row).end()){
			if (*begin == target)
				return true;
			++begin;
		}
		return false;
	}
};

