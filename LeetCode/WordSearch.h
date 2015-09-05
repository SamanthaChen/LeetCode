/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
["ABCE"],
["SFCS"],
["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
#pragma once
#include "LeetCode.h"
class WordSearch
{
public:
	/*
	* 回溯法 从第一个数据的上、小、左、右开始找；需要一个index标志现在匹配到string的哪个位置了
	* 需要一个能够记录走过的路径的东东，每次找不到，可以原路撤销，用一个一样大小的board，用全0和全1表示
	* false表示没访问，true表示访问过了
	* 20ms
	*/
	bool exist(vector<vector<char>>& board, string word) {
		if (board.empty() || word.empty()) return false;
		int m = board.size(), n = board[0].size();
		if (word.size() > m*n) return false;
		for (int i = 0;i < m;i++)
			for (int j = 0;j < n;j++)
				if (exist(board, i, j, word, 0, m, n))
					return true;
		return false;
	}
	bool exist(vector<vector<char>>& board, int x, int y, string &word, int index, const int &m, const int &n) {
		if (board[x][y] == ' ' || board[x][y] != word[index]) return false;
		if (index == word.size() - 1) return true;
		bool up = false, down = false, left = false, right = false;
		char temp = board[x][y];
		board[x][y] = ' ';
		//开始找,依次找上下左右
		//!!!!!!!!!!!这个题做了好多好多遍！！！！！！！
		//一直超时，超时，原因就是我没有在发现true的第一时间返回
		if (x > 0){
			up = exist(board, x - 1, y, word, index + 1,m,n);
			if (up) return true;//只要是true就返回！！！！！！ 如果不这样做，超时很厉害的
		}
		if (x < m - 1){
			down = exist(board, x + 1, y, word, index + 1, m, n);
			if (down) return true;
		}
		if (y > 0){
			left = exist(board, x, y - 1, word, index + 1, m, n);
			if (left) return true;
		}
		if (y < n - 1){
			right = exist(board, x, y + 1, word, index + 1, m, n);
			if (right) return true;
		}
		board[x][y] = temp;
		return false;
	}
};

