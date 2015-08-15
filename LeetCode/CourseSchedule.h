/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also
have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists
and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/
#pragma once
#include "LeetCode.h"
class CourseSchedule
{
public:
	CourseSchedule();
	~CourseSchedule();
	/*
	这个题是一个拓扑排序问题
	可以用深度优先，如果存在环的话，同一门课会再次出现
	深度优先可以用堆栈实现
	比较麻烦的是图结构的存储，我计划着开辟很多set存储图结构
	然后还要找到所有入度为0的节点

	通过了 靠！！！！！！！而且时间是252ms，挺快的
	*/
	bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
		vector<set<int>> v(numCourses);
		vector<int> searched(numCourses, 0);//如果一个点已经进过一次栈，那以后再也不需要把这个点当做for循环的第一个点
		for (auto p : prerequisites)
			v[p.second].insert(p.first);
		stack<int> s;
		for (int i = 0;i < numCourses&&searched[i] == 0;++i) {
			s.push(i);
			searched[i] = 1;
			vector<int> allready(numCourses, 0);//这个与递归是判断是不是已经出现过了，每次进栈置为1，出栈置为0。如果进栈是已经是1了，说明有环，返回false
			allready[i] = 1;
			while (!s.empty()) {
				int top = s.top();
				if (!v[s.top()].empty()) {
					auto it = v[top].begin();
					if (allready[*it] == 1)
						return false;
					else {
						allready[*it] = 1;
						searched[*it] = 1;
						s.push(*it);
						v[top].erase(it);
					}
				}
				else {
					allready[top] = 0;
					s.pop();
				}
			}
		}
		return true;
	}
};

