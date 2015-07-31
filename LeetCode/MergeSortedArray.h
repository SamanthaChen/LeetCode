 /*
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
#pragma once
#include "LeetCode.h"
class MergeSortedArray
{
public:
	MergeSortedArray();
	~MergeSortedArray();
	//nums1的大小已经是m+n，只不过后面的用不到的部分默认为0而已
	//为了保留nums1的值，所以要从后往前一个一个填就行了
	//4ms最快的
	void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
		auto rb1 = nums1.rbegin()+n, rb2 = nums2.rbegin(),rb1_new=nums1.rbegin();
		
		while (rb1_new != nums1.rend()) {
			if (rb1 == nums1.rend())
				*(rb1_new++) = *(rb2++);
			else if (rb2 == nums2.rend())
				*(rb1_new++) = *(rb1++);
			else
				*(rb1_new++) = *rb1 > *rb2 ? *(rb1++) : *(rb2++);
		}
	}
};

