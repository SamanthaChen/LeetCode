/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
#pragma once
#include "LeetCode.h"
class MinimumPathSum
{
public:
	MinimumPathSum();
	~MinimumPathSum();
	/*
	找左上到右下的最短路径
	可以建一个数组，存放每个点到右下的最短路径和
		由右下到左上一个一个填写
	28ms 最快
	*/
	int minPathSum(vector<vector<int>>& grid) {
		int m = grid.size(), n = grid[0].size();
		vector<vector<int>> min(m + 1, vector<int>(n + 1, INT_MAX));//初始化为最大
		min[m - 1][n] = 0;//注意这个给补个0
		for (int i = m - 1;i >= 0;--i)
			for (int j = n - 1;j >= 0;--j)
				min[i][j] = min[i + 1][j] > min[i][j + 1] ? min[i][j + 1] + grid[i][j] : min[i + 1][j] + grid[i][j];//替换原则
		return min[0][0];
	}
};

