/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
#pragma once
#include "LeetCode.h"
class ZigZagConversion
{
public:
	ZigZagConversion();
	~ZigZagConversion();
	/*
	52ms 很慢啊
	我先初始化了numrows个数组
	然后遍历s，同时用一个count先加再减再加再减。。。控制当前s的字符应该往哪个数组存
	最后依次得到各个数组的字符即可
	*/
	string convert_Dwyer(string s, int numRows) {
		if (numRows < 1) return "";
		if (s.empty() || numRows == 1) return s;
		vector<vector<char>> v(numRows);
		int n = s.size();
		int count = 0;
		bool flag = true;
		for (size_t i = 0;i < n;++i) {
			v[count].push_back(s[i]);
			if (flag)
				if (count == numRows - 1) {
					flag = false;
					--count;
				}
				else
					count++;
			else if (!flag)
				if (count == 0) {
					flag = true;
					count++;
				}
				else
					count--;
		}
		string str;
		for (size_t i = 0;i < numRows;++i) {
			auto it = v[i].begin();
			while (it != v[i].end()) {
				str += *it;
				++it;
			}
		}
		return str;
	}


	/*
	这种方法是我观察出来的规律，应该是正统方法
	对第1行，第一个数字跳了numRows*2-2，第二个跳了0...
	对第2行，第一个数字跳了numRows*2-4，第二个跳了2...
	。。。
	对第numRows行，第一个数字跳了0，第二个跳了numRows*2-2...
	
	搞定
	16ms 最快
	注意第一次和最后一次会比较特别，不能加完first然后second
	*/
	string convert_Dwyer1(string s, int numRows) {
		if (numRows < 1) return "";
		if (s.empty() || numRows == 1) return s;
		if (numRows >= s.size()) return s;

		int n = s.size();
		int first = numRows * 2 - 2;
		int second = 0;
		string str;
		for (size_t i = 0;i < numRows;++i) {
			int index = i;
			int flag = 1;//0的时候条first，1的时候跳second
			while (index < n) {
				str += s[index];
				if (i == 0 || i == numRows - 1)
					index += (numRows * 2 - 2);
				else if (flag)
					index += first;
				else 
					index += second;
				flag = flag ? 0 : 1;
			}
			first -= 2;
			second += 2;
		}
		return str;
	}
};

