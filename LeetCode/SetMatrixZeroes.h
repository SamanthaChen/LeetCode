/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/
#pragma once
#include "LeetCode.h"
class SetMatrixZeroes
{
public:
	SetMatrixZeroes();
	~SetMatrixZeroes();
	/*
	88ms
	*/
	void setZeroes(vector<vector<int>>& matrix) {
		//第一遍遍历将0的数字对应的第一行和第一列设为0，但是（0,0）同时属于第一行和第一列，所以要为他另外加个标志位
		int flag = -1;//-1什么也不是，0只代表行，1只代表列，2同时代表
		for (int i = 0;i < matrix.size();++i) {
			for (int j = 0;j < matrix[0].size();++j) {
				if (matrix[i][j]) continue;
				matrix[i][0] = 0;
				matrix[0][j] = 0;
				if (i == 0 || j == 0) {
					if (j != 0) {
						if (flag == -1) flag = 0;
						else if (flag == 1) flag = 2;
					}
					else if (i != 0) {
						if (flag == -1) flag = 1;
						else if (flag == 0) flag = 2;
					}
					else
						flag = 2;
				}
			}
		}
		//首先根据第一行的0将所有0所在的列置为0
		for (int i = 1;i < matrix[0].size();i++) {
			if (matrix[0][i] == 0)
				for (int j = 0;j < matrix.size();j++)
					matrix[j][i] = 0;
		}
		//然后根据第一列的0将所有的0所在的0置为0
		for (int i = 1;i < matrix.size();i++) {
			if (matrix[i][0] == 0)
				for (int j = 0;j < matrix[0].size();j++)
					matrix[i][j] = 0;
		}
		//最后根据状态位判断0,0 是0的情况
		if (matrix[0][0] == 0) {
			if (flag == 0 || flag == 2)
				for (int i = 1;i < matrix[0].size();i++)
					matrix[0][i] = 0;
			if (flag == 1 || flag == 2)
				for (int i = 1;i < matrix.size();i++)
					matrix[i][0] = 0;
		}
	}
};

