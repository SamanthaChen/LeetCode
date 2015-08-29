/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
#pragma once
#include "LeetCode.h"
class GenerateParentheses
{
public:
	GenerateParentheses();
	~GenerateParentheses();
	/*
	*其实已经知道这个是卡特兰数，重点是怎么理解
	*卡特兰数1,1,2,5,14.。。。 还要保存之前的记录

	1. 每次到n，就新加了一对括号
	2. 这对括号，可以首先包住0对括号，剩余n-1对
	3. 然后包住1对括号，剩余n-2对；然后包住2对，剩余n-3对。。。。最后包住n对，剩余0对！
	4. 所以是卡特兰数


	*/
	vector<string> generateParenthesis(int n) {
		vector<vector<string>> backUp;
		if (n <= 0) return vector<string>{};
		if (n == 1) return vector<string>{"()"};

		backUp.push_back(vector<string>{""});
		backUp.push_back(vector<string>{"()"});
		for (size_t i = 2;i <= n;++i) {//最外层循环，每次循环给backUp中加入所有的n的可能，这样的确很耗空间
			vector<string> temp;
			for (size_t j = 0;j < i;j++) {//最新的第n对括号，分别包住j对括号的情况！！那么就剩余了n-1-j对括号在外面。循环内要做一个排列组合，将j对括号的的每一种情况，与n-1-j的每一种结合一遍
				string tempStr = "(";
				for (int x = 0;x < backUp[j].size();x++) {
					string tempStrX = tempStr + backUp[j][x]+")";
					for (int y = 0;y < backUp[i - 1 - j].size();y++) {
						string tempStrY = tempStrX + backUp[i - 1 - j][y];
						temp.push_back(tempStrY);
					}
				}
			}
			backUp.push_back(temp);
		}
		return *backUp.rbegin();
	}
};

