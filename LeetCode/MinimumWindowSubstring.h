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
*新分析:这个题搞了足足有一天半吧，终于大概有一个思路了
		需要用一个map存储t中每个字符以及该字符出现了几次
		然后需要一个map m_s存目前s走到的位置出现了t中的字符几次
		每次s中的每个字符的数量和t中每个字符的数量相同，就要重新计算距离。计算距离很简单，用一个front，只会往后走，走到第一个t中出现的字符就开始算front和tail的距离
		每次计算完距离后，就把front指的这个字符从m_s中移除，继续往后走s
		针对可能有的'bba'\'ba'的这种情况，每个人的代码都有一个charCounter，只有当目前m_s中切切实实的能够保证t中的字符出现了相同的数量，这个值才会置为t.size()

		这个题就看minWindow_Dwyer3这个函数就行了
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

	/********************
	*描述:这个是我写的第二个方法，已经通过了，但是超时
	*时间复杂度：
	*LeetCode效果：超时
	********************/
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

	/********************
	*描述:这个是我写的第三个方法，看了discuss以后写的
	主要不同是，它不是让每个位置都有值，而是看总数是否达到了T中字符的数量
	所以，我比人家差的是没有找到一个好的方法去判断何时才是移动front和back的时机
	我原来map中存的是位置，人家存的是数量，其实想想，没必要存位置的，因为已经有front和back了
	*时间复杂度：
	*LeetCode效果：152ms在cpp中属于最慢的
	*感悟：	这个算法实在值得好好看看，有些地方的确是你不曾想到的
	********************/
	string minWindow_Dwyer3(string s, string t) {
		int front = 0;
		int length = INT_MAX;
		int charCounter = 0;
		string result;
		unordered_map<char, int> m;//存储并更新t中的每个字符的位置 char是字符，int是数量
		unordered_map<char, int> w;//存s中在t中存在的字符，char是字符，int是数量。！！每当w中每个字符的数量都大于等于m，那么现在就是计算窗口的时机

		if (t.empty()) return result;

		for (auto c : t)
			++m[c];

		for (int i = 0; i < s.size(); ++i) {
			if (m.find(s[i]) != m.end()){
				//只要属于t就往w里加
				++w[s[i]];
				//但是只有当w中这个字符还比m中少时，才++charCounter
				//这样可以防止s=“bba”，t=“ba的情况”
				if (w[s[i]] <= m[s[i]])
					++charCounter;
			}
			if (charCounter == t.size()){
				//这个while很重要！！！
				//如果front当前指的字符不在t中，直接跳过
				//万一在t中，还得保证在'bba'/'ba'这种情况下，front指向第二个b：所以当w[s[front]]>m[s[i]]这种情况是，需要对--w[s[front]]同时后移front
				while (front<s.size() && ((m.find(s[front]) != m.end() && w[s[front]]>m[s[front]])) || m.find(s[front]) == m.end()){
					if (m.find(s[front]) != m.end())
						--w[s[front]];
					++front;
				}
				if (length > (i - front + 1)){
					length = i - front + 1;
					result = s.substr(front, length);
				}
				--charCounter;
				--w[s[front]];
				++front;
			}
		}
		return result;
	}


	/********************
	*描述:这个见到的效率最高的一个
	*时间复杂度：O(n)
	*LeetCode效果：12ms 属于最快的
	*感悟：	这个方法被接受了，然而实在没有什么新意，和上面152ms的算法没有什么思想上的差别，之所以能够做到12ms，可能是因为更多的利用
			了数组，数组属于c的范畴，这可能是它快的原因吧
	********************/
	std::string minWindow(std::string s, std::string t)
	{
		//因为ascii最多支持128个字符
		const size_t kCHARLEN = 128;

		int char_counts[kCHARLEN] = { 0 };

		//
		int unique_counts[kCHARLEN] = { 0 }; // use to judge if t contains char x in complexity O(1)

		size_t need_reduced_count = 0; // count of unique char in t

		// init
		for (std::string::iterator iter = t.begin();
			iter != t.end(); ++iter) {
			if (++unique_counts[*iter] == 1) {//将t中的字符存在数组unique_counts相应的下标，值是这个数字出现的次数
				++need_reduced_count;//存t中有多少个独立的字符
			}
			++char_counts[*iter];//将t中的字符存在数组char_counts相应的下标，值是这个数字出现的次数
		}

		size_t min_head = 0;
		size_t min_len = 0;

		// loop
		for (size_t head_pos = 0, tail_pos = 0; tail_pos < s.size(); ++tail_pos) {

			char tail = s[tail_pos];//当期字符

			// tail in t && fully contained in sub
			//如果这个字符在t中有并且刚好只出现了一次，则need_reduced_count--
			//同时char_counts也被--到0了才会need_reduced_count
			if (unique_counts[tail] > 0 && --char_counts[tail] == 0)
				--need_reduced_count;

			//只要need_reduced_count还不为0，说明还有字符没找到，直接继续循环
			if (need_reduced_count != 0)
				continue;

			//如果代码能够走到这里，说明当前t中所有的字符已经出现过一遍了
			//目前的状态是：need_reduced_count刚好等于0了，unique_counts始终是对t的直观表示，不会有变化
			//char_counts
			// reach a window

			bool is_window = true;//加了个标志位
			while (is_window && head_pos <= tail_pos) {//头在尾前 这个循环是在后移头
				char head = s[head_pos];//头所指的字符
				// head in t
				if (unique_counts[head] > 0) {//如果该字符在t中
					++char_counts[head];//char_counts这个字符+1
					// gonna break a window
					if (char_counts[head] > 0) {//如果>0
						++need_reduced_count;//need_reduced_count+1
						is_window = false;//结束循环。这种情况下要计算新的距离，然后还得让head_pos继续后移一下，同时need_reduced_count得加一下，表示又缺了一个字符，
						//同时char_counts也得加一下，以便知道缺了哪个字符
						// record min 计算距离
						if (min_len == 0 || tail_pos - head_pos < min_len) {
							min_head = head_pos;
							min_len = tail_pos - head_pos + 1;
						}
					}
				}
				++head_pos;
			}
		}

		return s.substr(min_head, min_len);
	}
};