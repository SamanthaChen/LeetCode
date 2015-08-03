// Dwyer.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "QuickSort.h"

int main()
{
	vector<int> v{2,1,2,1,3,4,3,5,5,4,3};
	QuickSort QuickSort;
	QuickSort.quickSort(v);
    return 0;
}

