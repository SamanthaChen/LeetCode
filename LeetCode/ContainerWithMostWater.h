/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

这个题解释，坐标系中，x轴是0-n每个点，对应的值是a[n]
然后画出[i,0]到[i,a[i]]的线段
取任意两条线段，使其以x轴为底，能容纳最多的水
*/
#pragma once
#include "LeetCode.h"
class ContainerWithMostWater
{
public:
	ContainerWithMostWater();
	~ContainerWithMostWater();
	/*
	就用o（n*n）两个遍历吧
	结果leetcode不允许！！！！！！！
	超时了
	*/
	int maxArea_DwyerTimeLimit(vector<int>& height) {
		int n = height.size();
		if (n < 2) return 0;
		int maxArea = INT_MIN;
		for (int i = 0;i < n - 1;++i) {
			for (int j = i + 1;j < n;++j) {
				int a = area(height, i, j);
				if ( a> maxArea)
					maxArea = a;
			}
		}
		return maxArea;
	}

	/*
	得新想一个方法了 然而我没想到 看的别人的
	32ms 不快 但至少是O（n）
	两边搜索，短板往里走。因为往里走，代表宽度减小，那么宽度小的时候，只有遇上更高的高度才能组成更加大的container。
	以上这段话别处看的！！！！！！！但是真特么足够清楚啊
	*/
	int maxArea(vector<int>& height) {
		int n = height.size();
		if (n < 2) return 0;
		int maxArea = INT_MIN;
		int low = 0, high = n - 1;
		while (low < high) {
			maxArea = max(maxArea, (high-low)*min(height[high],height[low]));
			if (height[low] < height[high])
				++low;
			else
				--high;
		}
		return maxArea;
	}


	//计算容量的方法，横坐标的差乘以纵坐标小的那个
	int area(vector<int>& height,int&x, int&y) {
		return min(height[x], height[y])*(y - x);
	}
};

