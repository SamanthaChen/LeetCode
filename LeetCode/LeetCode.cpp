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
#include "IsomorphicStrings.h"

using namespace std;

int _tmain(int argc, _TCHAR* argv[])
{
	vector<int> nums = { 2, 2,2 };
	int val = 2;
	if (nums.empty()) return 0;
	sort(nums.begin(), nums.end());
	auto begin = nums.begin();
	while (begin != nums.end() && (*begin) <= val){
		if ((*begin) == val){
			begin = nums.erase(begin);
		}else
			++begin;
	}
	return nums.size();
	return 0;
}

