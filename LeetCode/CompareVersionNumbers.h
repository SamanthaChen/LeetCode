/***********************
*Date:2015.7.14
*Problems:Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*题目：比较版本
*感悟：	草，各种意外啊，一个easy的题花了足足一个小时啊！！！
		要考虑到1/1.0末尾为0的情况。以及一个长一个短的情况。
***********************/
#pragma once
#include <string>
using namespace std;
class CompareVersionNumbers
{
public:
	CompareVersionNumbers();
	~CompareVersionNumbers();
	/********************
	*描述:这个是我写的方法
	*LeetCode效果:0ms
	*感悟:自己写的算法LOW爆了，居然一下一下比较各种可能的情况
	********************/
	int compareVersion_Dwyer(string version1, string version2) {
		while (!version1.empty() && !version2.empty()){
			auto p1 = version1.find('.');
			auto p2 = version2.find('.');
			if (p1 == string::npos&&p2 != string::npos){
				if (atoi(version1.c_str()) > atoi(version2.substr(0, p2).c_str())) return 1;
				if (atoi(version1.c_str()) < atoi(version2.substr(0, p2).c_str())) return -1;
				//防止1与1.0的可能
				if (atoi(version1.c_str()) == atoi(version2.substr(0, p2).c_str())){
					version2.erase(0, p2 + 1);
					if (atoi(version2.c_str()) == 0) return 0;
					else return -1;
				}
			}
			if (p1 != string::npos&&p2 == string::npos){
				if (atoi(version2.c_str()) > atoi(version1.substr(0, p2).c_str())) return -1;
				if (atoi(version2.c_str()) < atoi(version1.substr(0, p2).c_str())) return 1;
				//防止1与1.0的可能
				if (atoi(version2.c_str()) == atoi(version1.substr(0, p1).c_str())){
					version1.erase(0, p1 + 1);
					if (atoi(version1.c_str()) == 0) return 0;
					else return 1;
				}
			}
			if (p1 == string::npos&&p2 == string::npos){
				if (atoi(version2.c_str()) > atoi(version1.c_str())) return -1;
				if (atoi(version2.c_str()) < atoi(version1.c_str())) return 1;
				if (atoi(version2.c_str()) == atoi(version1.c_str())) return 0;
			}
			if (version1.substr(0, p1) == version2.substr(0, p2)){
				version1.erase(0, p1 + 1);
				version2.erase(0, p2 + 1);
				continue;
			}
			if (atoi(version1.substr(0, p1).c_str()) > atoi(version2.substr(0, p2).c_str())) return 1;
			if (atoi(version1.substr(0, p1).c_str()) < atoi(version2.substr(0, p2).c_str())) return -1;
			if (atoi(version1.substr(0, p1).c_str()) == atoi(version2.substr(0, p2).c_str())) return 0;
		}
		if (version1.empty() && version2.empty()) return 0;
		if (version1.empty()) return -1;
		if (version2.empty()) return 1;
	}


	/********************
	*描述:这个是别人的方法
	*LeetCode效果:1ms
	*感悟:截取每个小数点前的数字，一个字符一个字符的处理，转换为10进制，而不是像我一样，一次处理一个小数点间的一段，这就会导致
			我要判断各种可能的情况。如1.0/1。
			关于小数点长度不同，while (i<n1 || j<n2)一句搞定!!!!!!!!!!!!!
	********************/
	int compareVersion(string version1, string version2) {
		int i = 0;
		int j = 0;
		int n1 = version1.size();
		int n2 = version2.size();

		int num1 = 0;
		int num2 = 0;
		while (i<n1 || j<n2)//必须两个都达到结尾才会结束，有效防止1.1/1的情况 perfect!!!!!!!!
		{
			//每个小数点间的用十进制表示 万一其中一个已经结束，就不满足i<n1 ,num始终为0！！！！！！perfect
			while (i<n1 && version1[i] != '.'){
				num1 = num1 * 10 + (version1[i] - '0');
				i++;
			}

			while (j<n2 && version2[j] != '.'){
				num2 = num2 * 10 + (version2[j] - '0');;
				j++;
			}

			if (num1>num2) return 1;
			else if (num1 < num2) return -1;

			//还原回去
			num1 = 0;
			num2 = 0;
			//让i，j跨过小数点
			i++;
			j++;
		}

		return 0;
	}
};

