/***********************
*Date:	2015.6.28
*Problems:	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*分析:	要把标点符号，空格什么的都去掉，滞留字符
要考虑到空串的情况，如果为空，默认就是回文字符串
*题目：	判断是否是回文字符串
*感悟：	对比了以下，觉得我这个已经是很好的方法了，效率也高
		考虑到了空的情况，大小写的情况
		而且考虑到了连续出现两个比如空格啊，逗号啊等字符的情况

		后来我看到别人的思路后简单改进了一下，这样就用不着新开辟空间了，一次遍历全部搞定
***********************/

#pragma once
#include <string>

using namespace std;

class ValidPalindrome
{
public:
	ValidPalindrome();
	~ValidPalindrome();
	/********************
	*描述:这个是我写的方法 首先纯粹的提取出只有字母和数字的字符串 然后从前到后比较即可
	*时间复杂度：O(n)
	*LeetCode效果:425个测试集12ms
	*测试:
	********************/
	bool isPalindrome_Dwyer(string s) {
		//空字符串
		if (s.empty()) return true;

		//比较
		auto front = s.begin();
		auto back = s.end() - 1;
		while (front < back){
			//前面无效
			if (!isalnum(*front)) ++front;
			//后面无效
			else if (!isalnum(*back)) --back;
			//出现不相等
			else if (!(tolower(*front) == tolower(*back)))
				return false;
			//相等，继续比较下一组
			else{
				++front;
				--back;
			}
		}
		return true;
	}
};

