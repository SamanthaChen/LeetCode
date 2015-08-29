/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/
#pragma once
#include "LeetCode.h"
class MergeIntervals
{
public:
	MergeIntervals();
	~MergeIntervals();
	/*
	思路：
		先按照start排序，然后遍历，当back的第一个比前面end最大的还大时，插入
	现在我们假设start都要<=end 虽然没说，但这样才像区间啊！！
	之前第一遍做的时候没有考虑到可能存在区间覆盖导致没有AC
	别忘了考虑这种情况啊
	580ms
	*/
	vector<Interval> merge(vector<Interval>& intervals) {
		if (intervals.size() < 2) return intervals;
		vector<Interval> re;
		sort(intervals.begin(), intervals.end(), [](const Interval &a, const Interval &b) {return a.start < b.start;});
		auto front = intervals.begin(), back = intervals.begin()+1;
		int max = (*front).end;
		while (back!= intervals.end()) {
			if (max < (*back).start) {
				re.push_back(Interval((*front).start, max));
				front=back;
				max = (*front).end;
				back++;
			}else{
				if (max < (*back).end)
					max = (*back).end;
				back++;
			}
		}
		re.push_back(Interval((*front).start, max));
		return re;
	}
};

