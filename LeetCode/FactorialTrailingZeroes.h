/*
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
给定一个数字，算这个数字的阶乘末尾有几个0
慢慢分析吧
5->0
10->00
15->000
20->0000
25->000000(注意这里，25意味可以出现*4的情况，会多出2个0)
30->0000000
35->00000000
40->000000000
45->0000000000
50->000000000000(同理会多出2个0)
75，100，125，150->(2个0)
125中含一个25一个5，所以会多出来3个0
625中含两个25 所以会多出来4个0

所以对于5多出来一个0
5平方2个
立方3
4次方4
*/
#pragma once
class FactorialTrailingZeroes
{
public:
	FactorialTrailingZeroes();
	~FactorialTrailingZeroes();
	/*
	4 ms
	自己结合别人的想法

	*/
	int trailingZeroes(int n) {
		int i = 0;
		int k = 5;
		while (k<=n){
			i += n / k;
			k *= 5;
		}
		return i;
	}
};

