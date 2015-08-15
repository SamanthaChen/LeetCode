/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:

[
["ate", "eat","tea"],
["nat","tan"],
["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/
#pragma once
#include "LeetCode.h"
class GroupAnagrams
{
public:
	GroupAnagrams();
	~GroupAnagrams();
	/*
	只能一下一下遍历了 n平方的复杂度
	用map
	这个方法通过了，然而又特么的超时了！！！！！！！！！！！
	*/
	vector<vector<string>> groupAnagrams(vector<string>& strs) {
		vector<vector<string>> re;
		vector<int> v(strs.size(), 0);//如果是0说明还没找到组织，如果是1直接跳过
		int n = strs.size();
		if (n == 0) return re;
		int index = -1;
		for (size_t i = 0;i < n&&v[i] == 0;i++) {
			re.push_back(vector<string>{strs[i]});
			index++;
			v[i] = 1;
			unordered_map<char,int> m;
			for (auto c : strs[i])
				m[c]++;
			unordered_map<char, int> m_backup = m;
			for (size_t j = i+1;j < n&&v[j] == 0;++j) {
				for (auto ch : strs[j])
					--m[ch];
				auto it = m.begin();
				while (it != m.end()){
					if (it->second != 0) 
						break; 
					++it;
				}
				if (it != m.end()) continue;
				re[index].push_back(strs[j]);
				v[j] = 1;
				m = m_backup;
			}
		}
		//全部存完以后还要考虑排序
		auto b = re.begin();
		while (b != re.end()) {
			sort((*b).begin(), (*b).end());
			++b;
		}
		return re;
	}

	/*
	新方法 不用map了 直接调用stl
	把strs中的每一个string看作是容器 进行排序
	76ms
	*/
	vector<vector<string>> groupAnagrams2(vector<string>& strs) {
		vector<vector<string>> result;
		vector<string> sortedStrs = strs;
		unordered_map<string, vector<int>> map;
		for (int i = 0; i < strs.size(); i++) {
			sort(sortedStrs[i].begin(), sortedStrs[i].end());//对每一个string排序
			map[sortedStrs[i]].push_back(i);//然后放进一个map
		}
		int index = -1;
		for (auto it = map.begin(); it != map.end(); it++) {
			result.push_back(vector<string>{});
			index++;
			for (int i = 0; i < it->second.size(); i++) {
				result[index].push_back(strs[it->second[i]]);
			}
		}
		auto b = result.begin();
		while (b != result.end()) {
			sort((*b).begin(), (*b).end());
			++b;
		}
		return result;
	}
};

