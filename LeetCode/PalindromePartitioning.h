/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
["aa","b"],
["a","a","b"]
]
*/
#pragma once
#include "LeetCode.h" 
class PalindromePartitioning
{
public:
	/*
	这个方法用了递归，而且在一个map中不断的保存着结果
	我的方法可以被称作递归，但不是回溯法！！！！而且我的方法需要大量的空间保存已经统计出来的字符串
	所以时间比较慢
	后面还有真正回溯法
	*/
	vector<vector<string>> partition(string s) {
		if (s.empty()) return vector<vector<string>>{};
		unordered_map<int, vector<deque<string>>> m;
		vector<deque<string>> re = partition(s, 0, m);
		vector<vector<string>> reV;
		for (int i = 0;i < re.size();i++) {
			vector<string> temp;
			for (int j = 0;j < re[i].size();++j)
				temp.push_back(re[i][j]);
			reV.push_back(temp);
		}
		return  reV;
	}
	vector<deque<string>> partition(string &s, int index, unordered_map<int, vector<deque<string>>> &m) {
		vector<deque<string>> re;
		if (index == s.size() - 1) {
			vector<deque<string>> temp{ { s.substr(index,1) } };
			return temp;
		}if (index == s.size())
			return vector<deque<string>>{};
		int indexBack = index;
		while (index < s.size()) {
			if (palindrome(s, indexBack, index)) {//如果存起始位置，到index位置是回文的话
				vector<deque<string>> temp;//temp保存着存（index+1）到末尾的所有回文结果
				if (m.find(index + 1) == m.end()) {
					temp = partition(s, index + 1, m);
					m[index + 1] = temp;
				}
				else
					temp = m[index + 1];
				for (int i = 0;i < temp.size();++i) {
					temp[i].push_front(s.substr(indexBack, index - indexBack + 1));
					re.push_back(temp[i]);
				}if (temp.empty())
					re.push_back(deque<string>{s.substr(indexBack, index - indexBack + 1)});
				index++;
			}
			else//如果不是回文，继续向后找，知道找到s的倒数第二个数字
				index++;
		}
		return re;
	}

	//判断从begin到end是不是回文
	bool palindrome(string& s, int begin, int end) {
		if (end == begin) return true;
		while (begin < end)
			if (s[begin++] != s[end--])
				return false;
		return true;
	}


	/*
	这个是真的回溯法
	12ms
	*/
	vector<vector<string>> partition_Dwyer(string s) {
		vector<vector<string> > ret;
		if (s.empty()) return ret;

		vector<string> path;//path存放每次得到得路径！！！！！
		dfs(0, s, path, ret);

		return ret;
	}
	void dfs(int index, string& s, vector<string>& path, vector<vector<string> >& ret) {
		if (index == s.size()) {
			ret.push_back(path);
			return;
		}
		for (int i = index; i < s.size(); ++i) {
			if (palindrome(s, index, i)) {//如果存index到i是回文，如果不是，一直++i到找到回文为止，如果知道最后都没有找到回文，什么也不做
				path.push_back(s.substr(index, i - index + 1));//则将这部分回文插入path
				dfs(i + 1, s, path, ret);//然后继续往下走
				path.pop_back();//然后把path中这部分拿出来，继续i++
			}
		}
	}
};

