/***********************
*Date:2015.7.11
*Problems:Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
[ 1, 2, 3 ],
[ 8, 9, 4 ],
[ 7, 6, 5 ]
]
*感悟：	首先固定x,只加y，然后固定y，只加x，然后固定x，只减y，然后固定y，只减x。。。。。
每次变按照下面的规律
规律n->(n-1)两次->(n-2)两次->...->1两次结束
		这个方法外人看起来可能不易理解，但时间复杂度的确最低了，也没有看别人的代码，因为觉得都挺复杂的
***********************/
#include <vector>
using namespace std;
#pragma once
class SpiralMatrixII
{
public:
	SpiralMatrixII();
	~SpiralMatrixII();

	/********************
	*描述:这个是我写的方法，然而实在不是什么好方法，需要用到大量的标志位用于标志何时变化k的值，何时变化应该加还是减
	*时间复杂度：O(n的平方)
	*LeetCode效果:21个测试集4ms，处于最靠前的位置
	********************/
	vector<vector<int>> generateMatrix_Dwyer(int n) {
		//初始化vector
		vector<vector<int>> v(n, vector<int>(n,0));

		int x = 0, y = 0;//x,y代表，行与列的下标

		int j = 0, k = n;;//j用来为k技术，每次搞够k，就把j置为0

		int flag_twice_k = 1,flag_twice_plus = 0;//flag_twice_k每次达到2，k就减1;flag_twice_plus每次到2，加变减，减变加

		bool flag_x = false;//count每变化一次，flag_x就变化一次，true时变化x，false时变化y
		bool flag_plus = true;//true 表示要++，false表示要--；count每次count每次为1的时候变化值

		for (size_t i = 0; i < n*n; i++)
		{
			//如果不初始化v的话，以下这句会报错
			v[x][y] = i + 1;
			++j;

			//核心代码，对标置位的控制
			if (j == k){
				j = 0; 
				flag_x = !flag_x;
				++flag_twice_k;
				++flag_twice_plus;
				if (flag_twice_k == 2){
					--k;
					flag_twice_k = 0;
				}
				if (flag_twice_plus == 2){
					flag_plus = !flag_plus;
					flag_twice_plus = 0;
				}
			}

			if (flag_x && flag_plus) ++x;
			if (flag_x && !flag_plus)--x;
			if (!flag_x && flag_plus) ++y; 
			if (!flag_x && !flag_plus) --y;
		}
		return v;
	}
};

