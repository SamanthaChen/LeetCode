/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/
#pragma once
#include "LeetCode.h"
class PermutationSequence
{
public:
	PermutationSequence();
	~PermutationSequence();
	/*
	不断更新k，与两个数组，然后每次循环就能确定一位
	8ms
	搞了很多遍才过去

	*/
	string getPermutation(int n, int k) {
		string re;
		if (n < 1 || k < 1) return re;
		if (n == 1) return "1";
		vector<int> vJC = { 1 };//存放1到n-1的阶乘
		for (size_t i = 1;i < n - 1;i++)
			vJC.push_back((i + 1)*vJC[i - 1]);
		if (k > (*vJC.rbegin())*n) return re;
		vector<int> vNums(n);//存放n个数字
		for (size_t i = 0;i < n;i++)
			vNums[i] = (i + 1);
		auto index = vJC.rbegin();//这个由后往前遍历阶乘
		while (index != vJC.rend()) {
			int index4Nums = (k - 1) / (*index);//计算下标核心
			re = re + char(vNums[index4Nums] + '0');
			auto it = find(vNums.begin(), vNums.end(), vNums[index4Nums]);
			vNums.erase(it);//这个是导致8ms的原因
			k = k % (*index);//修改k的核心代码
			if (k == 0) k = *index;//这个是导致那么多次过不去的原因！！！！！！！
			index++;
		}
		re = re + char(vNums[0] + '0');
		return re;
	}
};

