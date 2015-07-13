/***********************
*Date:2015.7.6
*Problems:Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
*题目：给定一个整数，返回罗马数字的写法
*关于罗马数字：
基本字符   相应的阿拉伯数字表示为
I			1
V			5
X			10
L			50
C			100
D			500
M			1000
*感悟：看了下别人做的后，觉得自己这个思路已经很棒了
***********************/

#pragma once
#include <string>
#include <map>
#include <vector>
using namespace std;

class Integer2Roman
{
public:
	Integer2Roman();
	~Integer2Roman();

	/********************
	*描述:这个是我写的方法，核心思路是构造出来的map
	*LeetCode效果:3999个数字64ms
	*核心：罗马数字可以每次处理一个最高位，与低位无关
	********************/
	string intToRoman_Dwyer(int num) {
		//依次除以vector中的元素
		vector<int> v{ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		//将映射关系存在一个map中
		map<int, string> m = { { 1, "I" }, { 4, "IV" }, { 5, "V" }, { 9, "IX" }, { 10, "X" }, { 40, "XL" }, { 50, "L" }
		, { 90, "XC" }, { 100, "C" }, { 400, "CD" }, { 500, "D" }, { 900, "CM" }, { 1000, "M" } };
		//待返回值
		string s;
		//依次处理拆分
		vector<int>::iterator it = v.begin();
		int num_front;//存num的第一位字符
		int num_front_int;//第一位代表的数值
		//每次处理最高位
		while (num){
			num_front = num / (*it);
			num_front_int = num_front*(*it);
			//根据最高位的位置以及数值去确定最高位的罗马数字
			while (num_front){
				s += m.find(*it)->second;
				--num_front;
			}
			//处理完最高位后去掉最高位
			num %= *it;
			++it;
		}
		return s;
	}
};

