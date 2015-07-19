// LeetCode.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include <vector>
#include <iostream>
#include "ContainsDuplicateII.h"
#include "Permutations.h"
#include "ExcelSheetColumnNumber.h"
#include "ValidPalindrome.h"
#include "Integer2Roman.h"
#include "SpiralMatrixII.h"
#include <vector>
#include <string>
#include "MinimumWindowSubstring.h"
#include "CompareVersionNumbers.h"
#include "ReverseInteger.h"
#include "PalindromeNumber.h"
#include "SummaryRanges.h"

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	deque<int> q;
	q.push_back(2);
	q.push_back(7);
	auto x = q.front();
	cout << q.front() << " " << q.back() << endl;
	SummaryRanges SummaryRanges;
	vector<int> v{-1};
	SummaryRanges.summaryRanges_Dwyer(v);
	return 0;
}

