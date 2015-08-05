/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

千万要注意这个题所谓的数独就是已经输入数字的符合规则，并没要求让你计算存在存在将所有空白填满后符合数独规则
*/
#pragma once
#include "LeetCode.h"
class ValidSudoku
{
public:
	ValidSudoku();
	~ValidSudoku();
	/*
		强行遍历！
		12ms  最快 有极其极其少的估计有10ms 大部分12
		注意遍历三宫格可能稍微有些复杂
		数组一定要初始化！!!
	*/
	bool isValidSudoku(vector<vector<char>>& board) {
		//一行一行遍历先
		for (int i = 0;i < 9;++i) {
			int a[58] = {0};//1-9共9个49-57，外加一个点是46 最大下标57
			for (int j = 0;j < 9;++j) {
				if (board[i][j] != '.')
					if (++a[board[i][j]] == 2)
						return false;
			}
		}

		//一列一列
		for (int j = 0;j < 9;++j) {
			int a[58] = {0};//1-9共9个49-57，外加一个点是46 最大下标57
			for (int i = 0;i < 9;++i) {
				if (board[i][j] != '.')
					if (++a[board[i][j]] == 2)
						return false;
			}
		}

		//三宫格遍历
		int count = -1;
		while (++count < 9) {
			int a[58] = {0};//1-9共9个49-57，外加一个点是46 最大下标57
			int i = count / 3 * 3;
			int j = count % 3 * 3;
			for (int m = i;m < i+3;m++)
				for (int n = j;n < j+3;n++){
					if (board[m][n] != '.')
						if (++a[board[m][n]] == 2)
							return false;
				}
		}
		return true;
	}
};

