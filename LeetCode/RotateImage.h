/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?]

旋转图像90度
*/
#pragma once
#include "LeetCode.h"
class RotateImage
{
public:
	RotateImage();
	~RotateImage();
	/*
		找规律，每次(x1,y1)要换到（y1,n-1-x1）的位置
		n*n的 第一次从（0,0）到（0，n-2)
				第二次从（1,1）到（1，n-3）
				...
				最后一次从（n/2-1,n/2-1） 到 (n/2-1,(n-2)-(n/2-1))

		一遍过 8ms不快
	*/
	void rotate(vector<vector<int>>& matrix) {
		int n = matrix.size();
		if (n <= 1) return;
		for (int i = 0;i < n / 2;i++) {
			for (int j = i;j <= n - 2 - i;j++) {
				int temp = matrix[j][n-1-i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = temp;
			}
		}
	}

	/*
	* 这是别人那里看到的 第一遍上下反过来
	* clockwise rotate
	* first reverse up to down, then swap the symmetry
	* 1 2 3     7 8 9     7 4 1
	* 4 5 6  => 4 5 6  => 8 5 2
	* 7 8 9     1 2 3     9 6 3
	*/
	void rotate(vector<vector<int> > &matrix) {
		reverse(matrix.begin(), matrix.end());//上小反过来
		for (int i = 0; i < matrix.size(); ++i) {
			for (int j = i + 1; j < matrix[i].size(); ++j)
				swap(matrix[i][j], matrix[j][i]);
		}
	}

	/*
	* 假如是逆时针的话，就首先左右逆过来，然后按照对角线交换
	* anticlockwise rotate
	* first reverse left to right, then swap the symmetry
	* 1 2 3     3 2 1     3 6 9
	* 4 5 6  => 6 5 4  => 2 5 8
	* 7 8 9     9 8 7     1 4 7
	*/
	void anti_rotate(vector<vector<int> > &matrix) {
		for (auto vi : matrix) reverse(vi.begin(), vi.end());
		for (int i = 0; i < matrix.size(); ++i) {
			for (int j = i + 1; j < matrix[i].size(); ++j)
				swap(matrix[i][j], matrix[j][i]);
		}
	}
};

