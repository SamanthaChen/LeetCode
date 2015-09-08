/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
*/
#pragma once
#include "LeetCode.h"
class BestTimetoBuyandSellStock
{
public:
	BestTimetoBuyandSellStock();
	~BestTimetoBuyandSellStock();
	/*
		知道商品的价格，判断能够得到的最大利润
		也就是找i和j，i在j的前面，并且j-i的值最大，返回这个最大值
		动态规划的思想
		由前向后遍历，记录当前出现的最低价格
		并且保存已经出现的最大收益
		ac 8ms
	*/
	int maxProfit(vector<int>& prices) {
		if (prices.size() < 2) return 0;
		int currMin = prices[0];
		int re = INT_MIN;
		for (int i = 1;i < prices.size();i++) {
			currMin = min(currMin, prices[i]);
			re = max(re, prices[i] - currMin);
		}
		return re;
	}
};

