// LeetCode.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "CourseSchedule.h"

int _tmain(int argc, _TCHAR* argv[])
{
	CourseSchedule CourseSchedule;
	vector<pair<int, int>> v{ pair<int,int>{1,0}, pair<int,int>{2,6}, pair<int,int>{1,7}, pair<int,int>{5,1},
		pair<int,int>{6,4}, pair<int,int>{7,0}, pair<int,int>{0,5},pair<int,int>{5,1},pair<int,int>{6,4} };
	CourseSchedule.canFinish(8,v);
	return 0;
}

