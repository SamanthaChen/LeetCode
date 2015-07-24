/*
	Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/
#pragma once
#include "LeetCode.h"
#include <stdint.h>
class Numberof1Bits
{
public:
	Numberof1Bits();
	~Numberof1Bits();
	/*
		不难 主要看你会不会位操作
		4ms 最快的
	*/
	int hammingWeight(uint32_t n) {
		uint32_t i = 1;
		int count = 0;
		while (i != 0){
			if (n&i) 
				++count;
			i = i << 1;
		}
		return count;
	}
};

