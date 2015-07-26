/*
	Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

感悟：这个题百度真的出现过
		我用的是动态规划的思想
		如果某个位置以前是可切词的，则将这个位置存入一个vector
		然后每新加一个字符，就便利前期所有可切词的位置到新位置是否可以切词
		如果可以，则新位置可切词，下一个字符
		不可以的话，下一个
本质：如果这个位置可切词，那从某个位置到这个位置可切
		同时某个位置前面也全部可切
*/
#pragma once
#include <string>
#include <unordered_set>
using namespace std;
class WordBreak
{
public:
	WordBreak();
	~WordBreak();
	/*
		12ms
	*/
	bool wordBreak_Dwyer(string s, unordered_set<string>& wordDict) {
		if (s.empty()) return false;
		vector<int> v;//这个v存储所有可以被切分的位置，比如10在里面，表示10之前的部分可以被切分
		v.push_back(-1);
		for (size_t i = 0; i < s.size(); ++i){
			auto begin = v.begin();
			while (begin != v.end()){
				if (wordDict.find(s.substr((*begin) + 1, i - (*begin))) != wordDict.end()){
					v.push_back(i);
					break;
				}
				++begin;
			}
		}
		if (v.back() == s.size()-1) return true;
		return false;
	}
};

