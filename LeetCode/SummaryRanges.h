/*Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given[0, 1, 2, 4, 5, 7], return["0->2", "4->5", "7"].
* 给定连续范围
" 0,1,2" form a continuous range, where each element is 1+ previous element. eg: [0,1,4,7,8,9] will be ["0->1", "4", "7->9"]
*
*/
#pragma once
#include <vector>
#include <stack>
#include <deque>
#include <string>
using namespace std;

class SummaryRanges
{
public:
	SummaryRanges();
	~SummaryRanges();
	//0ms 我的
	//这个题用queue这种数据结构是相当棒的，有头有尾
	vector<string> summaryRanges_Dwyer(vector<int>& nums) {
		deque<int> q;
		vector<string> v;
		auto begin = nums.begin();

		while (begin != nums.end()){
			if (q.empty() || *begin == q.back() + 1){
				q.push_back(*begin);
				++begin;
			}
			if (begin == nums.end() || *begin !=q.back() + 1){
				string str;
				if (q.size() == 1)
					str = to_string(q.front());
				else
					str += to_string(q.front()) + "->" + to_string(q.back());
				
				v.push_back(str);
				q.clear();
			}
		}
		return v;
	}
};

