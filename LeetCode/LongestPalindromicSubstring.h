/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
and there exists one unique longest palindromic substring.
*/
#pragma once
#include "LeetCode.h"
class LongestPalindromicSubstring
{
public:
	LongestPalindromicSubstring();
	~LongestPalindromicSubstring();
	/*
	事实证明 我的方法是错的，注意回文并不一定是奇数个！！！！！！abbc也是，bb也是，abccba也是，我的方法没法处理这种情况
	//这是我想到的方法
	//遍历s，然后对每个char看他的左边右边是不是相等，相等说明有回文，一直数到不相等，每次出现新的最大的数字就保存
	*/
	string longestPalindrome_DwyerWrong(string s) {
		if (s.size()<=1) return s;
		int maxLength = 1;
		int pos, length;
		int n = s.size();
		for (int i = 1;i < n-1;i++) {
			int j = 1;
			while (i - j >= 0 && i + j < n&& s[i - j] == s[i + j])
				++j;
			if (maxLength < 1 + (j - 1) * 2){
				maxLength = 1 + (j - 1) * 2;
				pos = i;
				length = j-1;
			}
		}
		return s.substr(pos-length,maxLength);
	}

	/*
		新想的
		8ms  一遍过 主流时间
		依旧是遍历s，
		如果s的下一个和s不相等，用上面的方法
		如果s和下一个相等，保留s的位置pos1，继续往后走，找到最后一个相等的位置pos2，然后左右比较
		下次i直接跳到pos2+1的位置开始
	*/
	string longestPalindrome(string s) {
		if (s.size() <= 1) return s;
		int pos1,pos2,maxLength=1, lengthOneside,n = s.size();
		for (int i = 0;i < n - 1;i++) {
			int pos1temp = i;
			while (i<n-1&&s[pos1temp] == s[i+1])
				++i;
			int pos2temp = i;
			int j = 1;
			while (pos1temp - j >= 0 && pos2temp + j < n && s[pos1temp - j] == s[pos2temp + j])
				++j;
			int newLength = pos2temp - pos1temp + 1 + (j - 1) * 2;
			if (newLength > maxLength) {
				maxLength = newLength;
				pos1 = pos1temp;
				pos2 = pos2temp;
				lengthOneside = j-1;
			}
		}
		return s.substr(pos1 - lengthOneside, maxLength);
	}
};

