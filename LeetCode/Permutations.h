/***********************
*Date:	2015.6.28
*Problems:	Given a collection of numbers, return all possible permutations.
		For example,
		[1,2,3] have the following permutations:
		[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*分析:	根据这个题目，至少会产生n的阶乘个结果，那么时间复杂度就至少是O（n的n次方），没法避免
*题目：	给定一个整数数组，输出所有排列
*感悟：	今天觉得n的阶乘的效率恐怖爆了
		不要局限于人家给定类型的参数，有时候会限制算法的效率，比如这次的我就需要不断开辟新的空间
		而最佳算法直接新写了函数，可以多传参数

		还有一点就是可能是人家提前想清楚算法了，然后需要新写有不同参数的函数。而我想的算法和人家就不同。
		那究竟是被人家限制了，还是自己想算法能力不够呢。都有关系吧！！！！
***********************/


#pragma once

#include <vector>
#include <string>
#include <sstream>

using namespace std;

class Permutations
{
public:
	/********************
	*描述:这个是我写的方法，采用递归的思路
	*时间复杂度：O(n的n次方)
	*LeetCode效果:25个测试集28ms
	*测试:如果有8个数据可能已经没法忍了
			常规可能从前往后交换，但vector不支持push_front，所以选择了从后往前
	********************/
	vector<vector<int>> permute_Dwyer(vector<int>& nums){
		vector<vector<int>> result;
		vector<vector<int>> newResult;//存放去掉最后一个元素的所有的排列
		vector<int> newNums;//存放去掉最后一个元素的nums
		if (!nums.empty()){
			vector<int>::iterator back = nums.end() - 1;
			vector<int>::iterator front = nums.begin();
			vector<vector<int>>::iterator nbegin;
			//本次遍历让前面所有的与最后一个数字调换位置
			while (front != nums.end()){
				swap(*front, *back);//调换
				//事实上这个就是结束条件
				if (nums.size() == 1)
					result.push_back(nums);
				else{
					newNums.assign(nums.begin(), nums.end() - 1);
					//递归，将最后一个前面所有的进行排列，得到newResult
					newResult = permute(newNums);
					newNums.clear();
					nbegin = newResult.begin();
					//遍历newResult，然后加上最后一个元素即可
					while (nbegin != newResult.end()){
						newNums.assign((*nbegin).begin(), (*nbegin).end());
						newNums.push_back(*back);
						result.push_back(newNums);
						newNums.clear();
						++nbegin;
					}
				}
				swap(*front, *back);//调换回来
				++front;
			}
		}
		return result;
	}


	/********************
	*描述:这个是有两个人投票的算法
	*时间复杂度：O(n的n次方)
	*LeetCode效果:25个测试集12ms
	*测试:如果有8个数据也需要挺久，但是比我写的还是要快
	*感悟：基本思路和我的是一致的，他的代码比我的精简如此之多，很大程度上是因为他不断的交换数值，然后插入
			并没有开辟新的空间，所以他的可能相对更难理解一些
			还有一个巨大的差别是，我每次调用的都是只有一个参数的vector<int>& nums，没法存储当前置换到哪里了，所以只能
			开辟一个新的newNums，这个的开头就相当于begin类似的。而他重写了一个函数，有一个参数begin，这样就用不着开辟新空间了
	********************/
	vector<vector<int>> permute(vector<int>& nums) {
		vector<vector<int>> ans;
		//自己新搞得函数，得到从首元素开始的序列
		permute(ans, nums, 0);
		return ans;
	}

	void permute(vector<vector<int>>& ans, vector<int>& perm, int begin)
	{
		//结束条件
		if (begin == perm.size()) {
			ans.push_back(perm);
			return;
		}
		//i从begin开始遍历
		for (int i = begin; i<perm.size(); i++) {
			//如果出现和begin所在位置的值相等的元素，跳过，进入下次循环
			//if (i != begin && perm[i] == perm[begin]) continue;
			//交换i和begin位置的值
			swap(perm[i], perm[begin]);
			//得出交换元素后从begin+1位置的排列
			permute(ans, perm, begin + 1);
			//把位置调换回来
			swap(perm[i], perm[begin]);
		}

	}
};

