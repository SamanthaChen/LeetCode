/***********************
*Date:2015.7.14
*Problems:Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*题目：给一个数字，把这个数字反过来，还得考虑到溢出的情况
*感悟：	大家用的基本都是while都数字一下一下取模取余，然后得出一个整数，然后判断是否溢出
		可是我特么用的是转成字符串，然后逆字符串，结果特么的atoi溢出了，leetcode居然不能识别溢出
		我特么vs2013明明溢出了啊！草。所以我写了一个和大家思想一样的，丝毫不难

***********************/

#pragma once
#include <string>
#include <sstream>
using namespace std;
class ReverseInteger
{
public:
	ReverseInteger();
	~ReverseInteger();
	//我这个通不过纯粹就是leetcode对c++支持不好(后来发现差别在于leetcode和vs对atoi的处理不同)
	//以后尽量避免使用atoi，多用stoi，stoll 等，这个是c++11标准\
	//12ms
	int reverse_Dwyer(int x) {
		long long re;
		bool nagitive = x<0;
		if (nagitive)
			x = -x;
		
		stringstream ss;
		ss << x;
		string  s = ss.str();
		auto b = s.rbegin();
		string rs;
		while (b != s.rend()){
			rs += *b;
			++b;
		}

		if (nagitive)
			re = -stoll(rs);
		else
			re = stoll(rs);
		return re>INT_MAX || re < INT_MIN ? 0 : re;
	}

	int reverse_Dwyer2(int x) {
		long long re = 0;//这里一定要是long long
		bool nagitive = x<0;
		if (nagitive)
			x = -x;
		while (x / 10){
			re = re * 10 + x % 10;
			x /= 10;
		}
		re = re * 10 + x;
		if (nagitive)
			re = -re;
		return re>INT_MAX || re < INT_MIN ?  0 :  re;
	}
};

