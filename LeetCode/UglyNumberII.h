/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
*/
#pragma once
#include "LeetCode.h"
class UglyNumberII
{
public:
	UglyNumberII();
	~UglyNumberII();
	/*
	要考虑到溢出
	80ms
	*/
	int nthUglyNumber(int n) {
		if (n <= 0) return -1;
		vector<int> vUgly = { 1 };
		vector<int> vMinUgly = { 2,3,5 };
		int p2 = 0, p3 = 0, p5 = 0;
		for (size_t i = 1;i < n;i++) {
			int index = findMin(vMinUgly);
			if (i == 1688)
				cout << "e" << endl;
			vUgly.push_back(vMinUgly[index]);
			updateVMin(vMinUgly, vUgly, index, p2, p3, p5);
		}
		return vUgly[n - 1];
	}

	int findMin(vector<int> &v) {
		int n = v.size();
		if (!n) return -1;
		int re = 0;
		for (size_t i = 1;i < n;i++) {
			if (v[i] < v[re])
				re = i;
		}
		return re;
	}
	/*
	这里要防止出现相同的数字
	*/
	void updateVMin(vector<int> &vMinUgly, vector<int> &vUgly, int &index, int& p2, int& p3, int& p5) {
		switch (index)
		{
		case 0:
			p2++;
			while (find(vMinUgly.begin(), vMinUgly.end(), vUgly[p2] * 2) != vMinUgly.end())
				p2++;
			if (vUgly[p2] > INT_MAX / 2)
				vMinUgly[index] = INT_MAX;
			else
				vMinUgly[index] = vUgly[p2] * 2;
			break;
		case 1:
			p3++;
			while (find(vMinUgly.begin(), vMinUgly.end(), vUgly[p3] * 3) != vMinUgly.end())
				p3++;
			if (vUgly[p3] > INT_MAX / 3)
				vMinUgly[index] = INT_MAX;
			else
				vMinUgly[index] = vUgly[p3] * 3;
			break;
		case 2:
			p5++;
			while (find(vMinUgly.begin(), vMinUgly.end(), vUgly[p5] * 5) != vMinUgly.end())
				p5++;
			if (vUgly[p5] > INT_MAX / 5)
				vMinUgly[index] = INT_MAX;
			else
				vMinUgly[index] = vUgly[p5] * 5;
			break;
		default:
			break;
		}
	}
};

