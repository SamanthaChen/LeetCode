/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3
*/
#pragma once
#include "LeetCode.h"
class UniqueBinarySearchTrees
{
public:
	UniqueBinarySearchTrees();
	~UniqueBinarySearchTrees();
	/*
	这个题用动态规划 不要用递归
	分析出来的规律就是numTrees(n)=numTrees(n-1)+numTrees(n-1)+numTrees(n-2)+...+numTrees(1)
	第一个numTrees（n-1）是把n当做root的所有情况，第二个numTrees（n-1）是n挂在n-1右边的所有情况
	numTrees（n-2）是n挂在n-2右边的所有情况
	*/
	int numTrees(int n) {
		if (n == 0) return 1;
		if (n == 1) return 1;
		vector<int> v(n,0);
		v[0] = 1;
		for (int i = 1; i < n; i++){
			v[i] += v[i - 1];
			for (int j = i-1; j >= 0; j--){
				v[i] += v[j];
			}
		}
		return v[n - 1];
	}
};

