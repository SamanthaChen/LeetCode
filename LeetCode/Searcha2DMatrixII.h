/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
[1,   4,  7, 11, 15],
[2,   5,  8, 12, 19],
[3,   6,  9, 16, 22],
[10, 13, 14, 17, 24],
[18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/
#pragma once
#include "LeetCode.h"
class Searcha2DMatrixII
{
public:
	Searcha2DMatrixII();
	~Searcha2DMatrixII();
	/*
	从左上角开始搜
	给定两个下标
	x和y x代表行 y代表列
	成功通过！！352ms吓哭了
	*/
	bool searchMatrix(vector<vector<int>>& matrix, int target) {
		if (matrix.empty()) return false;
		int x = 0, y = matrix[0].size() - 1;
		while (x != matrix.size() && y != -1) {
			if (matrix[x][y] == target)
				return true;
			else if (matrix[x][y] > target)
				--y;
			else
				++x;
		}
		return false;
	}
};

