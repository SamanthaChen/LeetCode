/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
*/
#pragma once
#include "LeetCode.h"
class SortColors
{
public:
	SortColors();
	~SortColors();
	/*
	已经知道只有0,1,2了
	可以先过一遍数出来有多少个0，多少个1，多少个2，然后重新排布一下就行了
	遍历了两遍

	第二种方法，三个指针，一个指向0可以替换的位置，1个指向2可以替换的位置，第三个遍历一遍，第三个与第二个重合时就停止
	4ms属于最快
	*/
	void sortColors(vector<int>& nums) {
		int n = nums.size();
		if (n < 2) return;
		int p0 = 0, p2 = n - 1;
		while (nums[p0] == 0) p0++;
		while (nums[p2] == 2) p2--;
		if (p0 >= n - 1 || p2 <= 0 || p0 >= p2) return;
		int p = p0;
		while (p <= p2) {
			if (nums[p] == 0) {
				swap(nums[p0], nums[p]);
				p0++;
				p++;//注意这里，p能保证前面只有0和1，p0能保证前面全是0，p0与p1间全是1.所以swap以后要给两个都++
			}
			else if (nums[p] == 2) {
				swap(nums[p2], nums[p]);
				if (nums[p] == 1) p++;//注意这里，从p2那里换到是1的话p++，
				while (nums[p2] == 2) p2--;//换完以后p2再度检查
			}
			else
				p++;
		}
	}
};

