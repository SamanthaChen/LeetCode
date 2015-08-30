/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
#pragma once
#include "LeetCode.h"
class MaximalSquare
{
public:
	/*
	新建一个数组（m+1，n+1），由右下往左上填
	每次填的值
		如果自己是0，直接填0
		如果是1
			如果在最外侧的边上，填1
			如果周围三个有0，则填1，
			如果周围三个（右边下边右下边）没有0，则填周围三个最小的值+1
			填的过程中，记录下最大的值
	最后返回填的最大的值的平方即可
	20ms 自己想出来的 哈哈哈哈哈哈!!!!!!!!不是最快
	别人的核心思想也是这个，不过别人优化了，没看怎么优化的
	*/
	int maximalSquare(vector<vector<char>>& matrix) {
		if (matrix.empty()) return 0;
		int m = matrix.size(), n = matrix[0].size();
		vector<vector<int>> v(m, vector<int>(n, 0));
		int re = 0;
		for (int i = m - 1;i >= 0;i--) {
			for (int j = n - 1;j >= 0;j--) {
				if (matrix[i][j] != '0') {
					if (i == m - 1 || j == n - 1 || !v[i + 1][j] || !v[i][j + 1] || !v[i + 1][j + 1]) {
						v[i][j] = 1;
					}
					else {
						v[i][j] = (v[i + 1][j] > v[i + 1][j + 1] ? (v[i + 1][j + 1] > v[i][j + 1] ? v[i][j + 1] : v[i + 1][j + 1]) :
							(v[i + 1][j] > v[i][j + 1] ? v[i][j + 1] : v[i + 1][j]))+1;
					}
					if (re < v[i][j]) re = v[i][j];
				}
			}
		}
		return re*re;
	}
};

