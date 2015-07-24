/*
	Count the number of prime numbers less than a non-negative number, n.
	感悟：用到一个叫做Sieve of Eratosthenes 的思想
	就是比如2是质数，那么4，6，8，10都是合数
	然后3是质数，9，12，15，18都是合数
	7是质数 49，56.。都是合数
	
*/
#pragma once
#include <vector>
using namespace std;
class CountPrimes
{
public:
	CountPrimes();
	~CountPrimes();
	int countPrimes(int n) {
		if (n < 2) return 0;
		vector<bool> v(n, true);
		for (size_t i = 2; i <= sqrt(n); ++i){//只用考虑n的开平方就可以了！！
			if (v[i]){
				for (size_t j = i*i; j < n; j+=i){//这里每次j都从i的平方开始，因为比如i=5，对10，15，20的情况都在处理2，3，4的时候搞定了
					if (v[j])
						v[j] = false;
				}
			}
		}
		int count = 0;
		for (size_t i = 2; i < v.size(); ++i){
			if (v[i])
				count++;
		}
		return count;
	}
};

