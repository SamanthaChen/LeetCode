/***********************
*Date:	2015.7.16
*Problems:	Determine whether an integer is a palindrome. Do this without extra space.
*分析:
*题目：
*感悟：	我的很快 在c++最前面 76ms 但是新定义了两个int型 不满足条件 继续改进
***********************/
#pragma once
//log10以及floor都在amp-Math中
#include <amp_math.h>
class PalindromeNumber
{
public:
	PalindromeNumber();
	~PalindromeNumber();
	/********************
	*描述:别人的方法，开辟，了一个空间，它的巧妙之处在于只走了一半就停下判断是否相等了
	*LeetCode效果:80ms
	********************/
	bool isPalindrome1(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) return false;
		int y = 0;
		while (y < x){
			y = y * 10 + (x % 10);
			x /= 10;
		}
		return (y == x) || (y / 10 == x);
	}

	/********************
	*描述:	别人的方法，真正做到了没有开辟新的空间
			特别之处在于巧妙的用了log以及pow从而得到头和尾
			还要考虑到中途存在0的情况
	*LeetCode效果:80ms
	********************/
	bool isPalindrome2(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) return false;
		while (x){
			//只要小于10了，就可以结束了
			if (x / 10 == 0) return true;
			//x / (pow10(size(x)))是头   x % 10是尾
			if (x / (pow10(size(x))) != x % 10) return false;
			//pow10(zerosAfterHead(x) + 1数出来有多少0然后+1，x % pow10(zerosAfterHead(x) + 1)可以准确取出来抛掉0后剩下的
			//如果刚好剩1位，那就继续下次循环，如果剩多位，那就算了
			if ((x % pow10(zerosAfterHead(x) + 1)) / 10 > 0) return false;

			//去尾的时候要根据尾前面0的位置去，保证一次把0去干净
			x = x / pow10(zerosAfterHead(x) + 1);
			//去头的时候
			x = x % (pow10(size(x)));
		}
		return true;
	}

private:
	int pow10(int x){
		return pow(10, x);
	}
	int size(int x){
		//floor是取下限
		//log10是取log
		return (int)floor(log10(x));
	}
	int zerosAfterHead(int x){
		return size(x) - size(x % (pow10(size(x)))) - 1;
	}
};

