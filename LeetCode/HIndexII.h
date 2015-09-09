#pragma once
#include "LeetCode.h"
class HIndexII
{
public:
	HIndexII();
	~HIndexII();
	int hIndex(vector<int>& citations) {
		int n = citations.size();
		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (citations[mid] == n - mid) return n - mid;
			if (citations[mid]<n - mid) left = mid + 1;
			else right = mid - 1;
		}
		return n - left;
	}
};

