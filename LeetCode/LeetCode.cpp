// LeetCode.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "ThreeSumClosest.h"

int &fun() {
	int a = 10;
	return a;
}
int _tmain(int argc, _TCHAR* argv[])
{
	ThreeSumClosest ThreeSumClosest;
	ThreeSumClosest.threeSumClosest(vector<int>{1, 1, 1, 0}, 100);
	return 0;
}
