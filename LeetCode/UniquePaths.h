/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/
#pragma once
#include "LeetCode.h"
class UniquePaths
{
public:
	UniquePaths();
	~UniquePaths();
	/*
	直接用阶乘，终究会越界，所以还是乖乖的一个一个数吧
	*/
	int uniquePaths(int m, int n) {
		return jianCheng(n - 1) / (jianCheng(m - 1)*jianCheng(n + m - 2));
	}
	int jianCheng(int n) {
		if (n == 0) return 1;
		else return n*jianCheng(n - 1);
	}
	/*
	这次要用到动态规划了 结合递归
	0ms 没啥疑问了
	*/
	int uniquePaths_Dwyer(int m, int n) {
		//首先要有一个数组记录访问过的节点到终点有多少距离！！
		vector<vector<int>> visited(m);
		for (int i = 0;i < m;i++)
			visited[i].assign(n,0);
		return uniquePaths_Dwyer(visited, 0, 0);
	}
	int uniquePaths_Dwyer(vector<vector<int>> &visited, int m, int n) {
		if (visited[m][n] == 0) {
			if (m == visited.size() - 1 && n == visited[0].size() - 1) return 1;
			int mPath = m < visited.size() - 1 ? uniquePaths_Dwyer(visited, m + 1, n) : 0;
			int nPath = n < visited[0].size() - 1 ? uniquePaths_Dwyer(visited, m, n + 1) : 0;
			visited[m][n] = mPath + nPath;
		}
		return visited[m][n];
	}
};

