/*
Given a string, find the length of the longest substring without repeating characters.
For example, the longest substring without repeating letters for "abcabcbb" is "abc",
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
#pragma once
#include "LeetCode.h"
class LongestSubstringWithoutRepeatingCharacters
{
public:
	LongestSubstringWithoutRepeatingCharacters();
	~LongestSubstringWithoutRepeatingCharacters();
	/*
	果然要提前想清楚啊
	这个题用队列简单爆了(好吧，考虑欠周全，根本不行)
	搞定，一遍过，112ms，好慢啊
	重中之重就是我的smallerIndex 可以帮助维护map
	我傻逼了，又用map去存char了，敢不敢用int啊，怎么这么不长脑子啊！！！

	！用int代替map后立马提升到了16ms，最快级别
	*/
	int lengthOfLongestSubstring(string s) {
		int maxLen = 0, nowLen = 0, n = s.size();
		int smallerIndex = INT_MIN;//这个标志特别重要，所有value比它小的即便存在也认为无意义
		int m[256];
		for (int i = 0;i < 256;i++)
			m[i] = -1;
		for (size_t i = 0;i < n;i++) {
			if (m[s[i]] == -1 || m[s[i]] < smallerIndex) {
				nowLen++;
				m[s[i]] = i;
			}
			else {
				if (maxLen < nowLen) maxLen = nowLen;
				smallerIndex = m[s[i]];
				nowLen = i - m[s[i]];
				m[s[i]] = i;
			}
		}
		if (maxLen < nowLen) maxLen = nowLen;
		return maxLen;
	}
};