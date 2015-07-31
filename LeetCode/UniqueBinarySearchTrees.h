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
	
	这个规律是错的！！！！！！！！！！！！！！！！！！！！
	分析出来的规律就是numTrees(n)=numTrees(n-1)+numTrees(n-1)+numTrees(n-2)+...+numTrees(1)
	第一个numTrees（n-1）是把n当做root的所有情况，第二个numTrees（n-1）是n挂在n-1右边的所有情况
	numTrees（n-2）是n挂在n-2右边的所有情况


	以下才是正确的规律
	这个题是一个典型的 卡特兰数
	让n的每个节点都做root，然后把所有节点做root的和加起来
	比如n=9，目前的root让4做，那么4左边会有1,2，3这个是numTrees（3） 然后（5,6,7,8,9）做右边 ，这个其实相当于numTrees（5）
	所以h（n）=h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)h(0) (n>=2)
	h(1)=1毫无疑问，但是h（0）直观的理解应该是0，但事实上应该置为1.

	这个题我估计大部分人都是抄的，最后的时间都是0ms
	*/
	int numTrees(int n) {
		if (n == 0) return 1;
		if (n == 1) return 1;
		vector<int> v(n+1,0);
		v[0] = 1;
		v[1] = 1;
		for (int i = 2; i < n+1; i++){
			for (int j = 0; j < i; j++){
				v[i] += (v[j]*v[i-j-1]);
			}
		}
		return v[n];
	}
};

