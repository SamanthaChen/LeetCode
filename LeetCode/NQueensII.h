/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

这个题是n个皇后放在n*n的板子上，行列以及对角线不能相撞
毫无疑问一行应该放一个皇后，一列也只放一个
所以可以采用排列的方式，递归实现
然后判断每个排列是否符合规则
*/
#pragma once
#include "LeetCode.h"
class NQueensII
{
public:
	NQueensII();
	~NQueensII();
	/*
	可以新建一个大小为n的数组v，然后v[i]的值就是第i列皇后所在的行号
	我开始干的事是让v的任意一位从0到n-1，但这样是不对的！！！！！！！！！！！！！！！
	如果某个数字已经出现过了，那么剩下的数字就不应该再次出现，这样就能保证不在一行！！！！！！！！！！！
	用一个set存尚未填写的数字
	8ms
	*/
	int totalNQueens(int n) {
		if (n < 1) return 0;
		if (n == 1) return 1;
		if (n < 4) return 0;
		vector<int> v(n, 0);
		int count = 0;
		int index = 0;
		vector<int> lastNums(n);
		while (n)
			lastNums[--n] = 1;
		n = v.size();
		totalNQueens(v, index, count, n, lastNums);
		return count;
	}
	/*
	index是v当下应该填的位置
	count是总的计数器
	*/
	void totalNQueens(vector<int> &v, int& index, int& count, const int&n, vector<int> lastNums) {
		if (index == n) {
			if (judge(v, n))
				++count;
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
					totalNQueens(v, ++index, count, n, lastNums);
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
};

