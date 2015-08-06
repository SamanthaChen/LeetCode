/*

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
[".Q..",  // Solution 1
"...Q",
"Q...",
"..Q."],

["..Q.",  // Solution 2
"Q...",
"...Q",
".Q.."]
]
*/
#pragma once
#include "LeetCode.h"
class NQueens
{
public:
	NQueens();
	~NQueens();
	/*
	 这个题与另一个的不同之处在于这个题要输出每种结果，然而丝毫不难
	 12ms
	*/
	vector<vector<string>> solveNQueens(int n) {
		vector<vector<string>> re;
		if (n < 1) return re;
		if (n == 1) return vector<vector<string>>{ {"Q"}};
		if (n < 4) return re;
		vector<int> v(n, 0);
		int count = 0;
		int index = 0;
		vector<int> lastNums(n);
		while (n)
			lastNums[--n] = 1;
		n = v.size();
		totalNQueens(v, index, re, n, lastNums);
		return re;
	}
	/*
	index是v当下应该填的位置
	count是总的计数器
	*/
	void totalNQueens(vector<int> &v, int& index, vector<vector<string>>& re, const int&n, vector<int> &lastNums) {
		if (index == n) {
			if (judge(v, n))
				add(v, re);
			--index;
			return;
		}
		else {
			for (size_t i = 0;i < n;++i) {
				if (lastNums[i]) {
					v[index] = i;
					if (!judge(v, index + 1)) //千万注意，如果不这样做就超时了！！！这样做是一种提前终止的方法。
						continue;
					lastNums[i] = 0;
					totalNQueens(v, ++index, re, n, lastNums);
					lastNums[i] = 1;
				}
			}
			--index;
			return;
		}
	}

	/*
	判断是否符合原则
	v中的数字不能在对角线
	*/
	bool judge(vector<int> &v, const int& n) {
		for (size_t i = 0;i < n - 1;++i)
			for (size_t j = i + 1;j < n;j++)
				if (abs(v[i] - v[j]) == (j - i))
					return false;
		return true;
	}

	void add(vector<int>& v, vector<vector<string>> &re) {
		int n = v.size();
		vector<string> temp;
		for (int i = 0;i < n;i++) {
			string str(n,'.');
			str[v[i]] = 'G';
			temp.push_back(str);
		}
		re.push_back(temp);
	}
};

