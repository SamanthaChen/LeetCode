/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
我原来用set实现的
后来按照要求改成了vector
一遍通过
4ms
*/

#pragma once
#include "LeetCode.h"
class DifferentWaystoAddParentheses
{
public:
	//以下代码是我通过set已经成功跑出来的，但是他题目居然把相同的值也给打印出来了
	DifferentWaystoAddParentheses();
	~DifferentWaystoAddParentheses();
	/*
	我们假设所有输入都是合法的
	假设不论怎么操作都没有溢出
	为了防止相同值，需要一个set存储最后的结果
	思路：
		不难，递归每个符号的左边和右边，得到左边和右边所有的可能，然后按照这个符号做组合即可
	*/ 
	struct pair {
		int begin;
		int end;
		pair(int a, int b) {
			begin = a;
			end = b;
		}
		//这里是个难点，应该在a不等的情况下比a，a相等的情况下比b
		bool operator< (const pair& pair2) const {
			if (begin < pair2.begin)
				return true;
			if (begin == pair2.begin)
				if (end < pair2.end)
					return true;
			return false;
		}
	};
	
	vector<int> diffWaysToCompute(string input) {
		vector<int> re;
		set<int> reSet;
		if (input.size() == 0) return re;
		map<pair, set<int>> m;//这个m保存了每个不同pair之间的所有可能的计算结果
		//因为考虑到输入的整数可能不只是一位的，所以我想先把input拆解开，拆解成两个数组，一个存放数字，另一个存放运算符
		//要注意规律，inputNums要比inputOpe多一位。
		vector<int> inputNums;
		vector<char> inputOpe;
		readInput(input, inputNums, inputOpe);
		//返回一个set,set方便
		pair p(0, inputNums.size() - 1);
		reSet = diffWaysToCompute(inputNums, inputOpe,p, m);
		re.insert(re.end(), reSet.begin(), reSet.end());
		return re;
	}

	set<int> diffWaysToCompute(const vector<int> &inputNums, const vector<char> &inputOpe, pair p, map<pair,set<int>>& m) {
		set<int> s;
		if (m.find(p) != m.end()) return m[p];//如果已经计算过就不用再次计算了
		if (p.begin == p.end) {//结束条件
			s.insert(inputNums[p.begin]);
			return s;
		}
		for (size_t i = p.begin;i < p.end;++i) {//遍历每个运算符
			pair leftP(p.begin,i);
			set<int> left = diffWaysToCompute(inputNums, inputOpe, leftP, m);
			pair rightP(i+1,p.end);
			set<int> right = diffWaysToCompute(inputNums, inputOpe, rightP, m);
			//开始生成新set
			set<int>::iterator itL, itR;
			switch (inputOpe[i])
			{
			case '+':
				itL = left.begin();
				while (itL != left.end()) {
					itR = right.begin();
					while (itR != right.end()) {
						s.insert((*itL) + (*itR));
						itR++;
					}
					itL++;
				}
				break;
			case '-':
				itL = left.begin();
				while (itL != left.end()) {
					itR = right.begin();
					while (itR != right.end()) {
						s.insert((*itL) - (*itR));
						itR++;
					}
					itL++;
				}
				break;
			case '*':
				itL = left.begin();
				while (itL != left.end()) {
					itR = right.begin();
					while (itR != right.end()) {
						s.insert((*itL) * (*itR));
						itR++;
					}
					itL++;
				}
				break;
			default:
				break;
			}
		}
		m[p] = s;
		return s;
	}

	//以上是对基于set的老代码的备份
	/*
	//以下是给予vector的
	vector<int> diffWaysToCompute(string input) {
		vector<int> re;
		if (input.size() == 0) return re;
		map<pair, vector<int>> m;//这个m保存了每个不同pair之间的所有可能的计算结果
							  //因为考虑到输入的整数可能不只是一位的，所以我想先把input拆解开，拆解成两个数组，一个存放数字，另一个存放运算符
							  //要注意规律，inputNums要比inputOpe多一位。
		vector<int> inputNums;
		vector<char> inputOpe;
		readInput(input, inputNums, inputOpe);
		//返回一个set,set方便
		pair p(0, inputNums.size() - 1);
		re = diffWaysToCompute(inputNums, inputOpe, p, m);
		return re;
	}
	
	vector<int> diffWaysToCompute(const vector<int> &inputNums, const vector<char> &inputOpe, pair p, map<pair, vector<int>>& m) {
		vector<int> s;
		if (m.find(p) != m.end()) return m[p];//如果已经计算过就不用再次计算了
		if (p.begin == p.end) {//结束条件
			s.push_back(inputNums[p.begin]);
			return s;
		}
		for (size_t i = p.begin;i < p.end;++i) {//遍历每个运算符
			pair leftP(p.begin, i);
			vector<int> left = diffWaysToCompute(inputNums, inputOpe, leftP, m);
			pair rightP(i + 1, p.end);
			vector<int> right = diffWaysToCompute(inputNums, inputOpe, rightP, m);
			//开始生成新set
			vector<int>::iterator itL, itR;
			switch (inputOpe[i])
			{
			case '+':
				itL = left.begin();
				while (itL != left.end()) {
					itR = right.begin();
					while (itR != right.end()) {
						s.push_back((*itL) + (*itR));
						itR++;
					}
					itL++;
				}
				break;
			case '-':
				itL = left.begin();
				while (itL != left.end()) {
					itR = right.begin();
					while (itR != right.end()) {
						s.push_back((*itL) - (*itR));
						itR++;
					}
					itL++;
				}
				break;
			case '*':
				itL = left.begin();
				while (itL != left.end()) {
					itR = right.begin();
					while (itR != right.end()) {
						s.push_back((*itL) * (*itR));
						itR++;
					}
					itL++;
				}
				break;
			default:
				break;
			}
		}
		m[p] = s;
		return s;
	}*/
	//假设输入是合法的
	void readInput(const string &input, vector<int> &inputNums, vector<char> &inputOpe) {
		auto it = input.begin();
		int temp = 0;
		while (it != input.end()) {
			if (*it != '*'&&*it != '+'&&*it != '-')
				temp = temp * 10 + (*it - '0');
			else {
				inputNums.push_back(temp);
				temp = 0;
				inputOpe.push_back(*it);
			}
			it++;
		}
		inputNums.push_back(temp);
	}
};

