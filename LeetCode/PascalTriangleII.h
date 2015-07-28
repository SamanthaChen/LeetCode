/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
*/
#pragma once
#include "LeetCode.h"
class PascalTriangleII
{
public:
	PascalTriangleII();
	~PascalTriangleII();
	/*
	0ms 一遍过
	v每次修改完后在最后加一个1
	*/
	vector<int> getRow(int rowIndex) {
		//要求开辟的空间是O(k)
		vector<int> v;
		v.push_back(1);
		if (rowIndex == 0)
			return v;
		for (size_t i = 1; i < rowIndex + 1; ++i){
			auto begin = v.begin();
			int old = *begin;
			//这是修改v的方法
			while (++begin!= v.end()){
				int temp = *begin;
				*begin = old + *begin; //修改
				old = temp;				//old保存上次修改前的值
			}
			v.push_back(1);
		}
		return v;
	}

	/*
	看了别人的发现可以更简单
	一定要从后往前加
	这样不会丢失被覆盖的数字
	*/
	vector<int> getRow_Bieren(int rowIndex) {
		vector<int> v(rowIndex+1,0);
		v[0] = 1;
		for (int i = 1; i < v.size()+1; ++i)
			for (int j = i; j >= 1; j--)
				v[j] = v[j] + v[j - 1];
		return v;
	}
};

