/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
[0,0,0],
[0,1,0],
[0,0,0]
]
The total number of unique paths is 2.
*/
#pragma once
#include "LeetCode.h"
class UniquePathsII
{
public:
	UniquePathsII();
	~UniquePathsII();
	/*
	这方法居然超时了！！！！！！！！！！！！！！
	是因为调用函数太多了吗？
	*/
	int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
		int m = obstacleGrid.size(), n = obstacleGrid[0].size();
		//首先要有一个数组记录访问过的节点到终点有多少距离！！
		vector<vector<int>> visited(m, vector<int>(n, 0));
		return uniquePaths(visited, obstacleGrid, 0, 0, m, n);
	}
	int uniquePaths(vector<vector<int>> &visited, vector<vector<int>>& obstacleGrid, int m, int n, const int& row, const int& col) {
		if (obstacleGrid[m][n] == 1)
			return 0;
		if (visited[m][n] == 0) {
			if (m == row - 1 && n == col - 1) return 1;
			int mPath = m < row - 1 ? uniquePaths(visited, obstacleGrid, m + 1, n, row, col) : 0;
			int nPath = n < col - 1 ? uniquePaths(visited, obstacleGrid, m, n + 1, row, col) : 0;
			visited[m][n] = mPath + nPath;
		}
		return visited[m][n];
	}

	/*
	再找一个非递归的方法！！
	看的别人的
	这个算法是逆着来的！我原来在m，n的位置存的是到终点的路径，这个方法存的是到起点的路径
	这算法不好理解，不是好算法：
		如果是我的话，我会给dp[m][n]赋值为1，然后双层循环分别m--，n--，计算dp[m-1][n] dp[m][n-1]这个样子，最后返回dp[1][1]的值

	4ms
	*/
	int uniquePathsWithObstacles_Dwyer(vector<vector<int>>& obstacleGrid) {
		int m = obstacleGrid.size(), n = obstacleGrid[0].size();
		vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));//注意多搞了一行，多搞了一列！
		dp[0][1] = 1;
		//事实上一下的循环把第一行，第一列去掉了！！！！！！！！！这就是多搞了一行一列的原因
		for (int i = 1; i <= m; ++i)//循环的时候把最后一行也带上了
			for (int j = 1; j <= n; ++j)//最后一列也带上了
				if (!obstacleGrid[i - 1][j - 1])//如果是1直接不管了
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];//当前的i,j 就等于dp[i - 1][j] + dp[i][j - 1]
		return dp[m][n];
	}
};

