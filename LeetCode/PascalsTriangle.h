/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
[1],
[1,1],
[1,2,1],
[1,3,3,1],
[1,4,6,4,1]
]
*/
#pragma once
#include "LeetCode.h"

/*
我的 通过了 很快 0ms
代码有些长 5555555555
*/
class PascalsTriangle
{
public:
	PascalsTriangle();
	~PascalsTriangle();
	vector<vector<int>> generate(int numRows) {
		vector<vector<int>> re;
		if (numRows == 0)  return re;
		vector<int> oldV;
		oldV.push_back(1);
		re.push_back(oldV);
		for (size_t i = 1; i < numRows; ++i){
			auto front = oldV.begin(), back = front + 1;
			vector<int> newV;
			newV.push_back(*front);
			while (back != oldV.end()){
				newV.push_back(*front + *back);
				++front; ++back;
			}
			newV.push_back(*(back-1));
			oldV = newV;
			re.push_back(newV);
		}
		return re;
	}
};

