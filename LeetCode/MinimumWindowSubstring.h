/***********************
*Date:	2015.7.12
*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*分析:	可以用一个map更新T的每个字符的位置，每次更新，都给出一个包含t的最小区间（int，int）存在一个二维数组内，结束后在在二维数组中距离
最小的那个，就是起点和终点
*感悟：	这个题想了很久，感觉自己写代码过急了，还是应该首先用纸笔考虑清楚自己的思路，然后再动手
***********************/
#pragma once
#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

class MinimumWindowSubstring
{
public:
	MinimumWindowSubstring();
	~MinimumWindowSubstring();
	/********************
	*描述:这个是我写的方法，没能通过，原因是没考虑到t中出现重复char的可能
	*时间复杂度：O(n)
	*LeetCode效果:大约通过了一半，100多个，但是当t中出现重复字符时就没法通过了
	********************/
	string minWindow_Dwyer(string s, string t) {
		int front = -1, back = -1;
		unordered_map<int, int> m;//存储并更新t中的每个字符的位置 第一个int是t中字符的位置，第二个是s中最新的位置
		int pos = 0;//当前遍历到了s的哪个位置

		//开始遍历s
		for (char c : s){
			if (t.find(c) != string::npos){//这个字符存在于t中
				m[t.find(c)] = pos;
				if (m.size() == t.size()){//如果t中的每个char都已经至少找到过一次了
					vector<int> vt;
					for (auto pair : m){
						vt.push_back(pair.second);
					}
					sort(vt.begin(), vt.end());
					if (back == -1) {
						front = vt[0];
						back = *(vt.end() - 1);
					}
					else{
						int newdistance = *(vt.end() - 1) - vt[0];
						if (newdistance < (back - front)){
							front = vt[0];
							back = *(vt.end() - 1);
						}
					}
				}
			}
			++pos;
		}
		if (back == -1) return "";
		return s.substr(front, (back - front) + 1);
	}


	string minWindow_Dwyer2(string s, string t) {
		int front = -1, back = -1;
		unordered_map<int, int> m;//存储并更新t中的每个字符的位置 第一个int是t中字符的位置，第二个是s中最新的位置

		for (int pos_s = 0; pos_s < s.size(); ++pos_s)
		{
			if (m.size() != t.size()){
				auto pos_t = t.find(s[pos_s]);
				int k = 0;
				string t_copy(t);
				while (pos_t != string::npos)
				{
					if (m.find(pos_t + k) == m.end())
					{
						m[pos_t + k] = pos_s;
						break;
					}
					else
					{
						t_copy.erase(pos_t, 1);
						++k;
						pos_t = t_copy.find(s[pos_s]);
					}
				}
				if (m.size() == t.size()){
					vector<int> vt;
					for (auto pair : m){
						vt.push_back(pair.second);
					}
					sort(vt.begin(), vt.end());
					front = vt[0];
					back = *(vt.end() - 1);
				}
			}
			else
			{
				//找到该字符在t中的所有位置，然后选择最小的那个进行替换即可
				vector<int> v;//v中存放所有的位置
				auto pos_t = t.find(s[pos_s]);
				int k = 0;
				string t_copy(t);
				while (pos_t != string::npos)
				{
					v.push_back(pos_t + k);
					t_copy.erase(pos_t, 1);
					++k;
					pos_t = t_copy.find(s[pos_s]);
				}

				//v中存的是m的下标，找到最小的后替换之
				if (!v.empty()){
					int j = m[v[0]];
					int temp = 0;
					for (auto vc : v){
						if (j > (m[vc])){
							j = m[vc];
							temp = vc;
						}
					}
					m[temp] = v[temp];

					vector<int> vt;
					for (auto pair : m){
						vt.push_back(pair.second);
					}
					sort(vt.begin(), vt.end());
					int newdistance = *(vt.end() - 1) - vt[0];
					if (newdistance < (back - front)){
						front = vt[0];
						back = *(vt.end() - 1);
					}
				}
			}
		}
		if (back == -1) return "";
		return s.substr(front, (back - front) + 1);
	}
};