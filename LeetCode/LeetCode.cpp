// LeetCode.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "BSTIterator.h"
int _tmain(int argc, _TCHAR* argv[])
{
	
	TreeNode *root = new TreeNode(1);
	BSTIterator i = BSTIterator(root);
	while (i.hasNext())
		cout << i.next() << endl;
	return 0;
}
