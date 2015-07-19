/*
用stack实现queue
这个题做完了以后才理解了
总体就是这个类是个Queue，然后定义一个变量queue，这个queue有push,pop，peek，empty的方法。调用这些方法的时候能保证合理操作
每次往queue的末端输值，就往input里加元素
每次需要取queue头值，就把input逆过来全部存在output中即可
每次需要去头，就把input逆过来全部存在output中，然后去掉output最外面
input+output是整个queue的值。
队列的话只能尾部进，头部出
*/
#pragma once
#include <stack>
using namespace std;
class ImplementQueueusingStacks
{
	//不好理解啊 草 这个input最上面，相当于queue的最后面
	stack<int> input, output;

public:
	ImplementQueueusingStacks();
	~ImplementQueueusingStacks();

	// Push element x to the back of queue.
	void push(int x) {
		input.push(x);
	}

	// Removes the element from in front of queue.
	void pop(void) {
		if (output.empty())
			while (input.size())
				output.push(input.top()), input.pop();
		output.pop();
	}

	// Get the front element.
	int peek(void) {
		if (output.empty())
			while (input.size())
				output.push(input.top()), input.pop();
		return output.top();
	}

	// Return whether the queue is empty.
	bool empty(void) {
		return input.empty() && output.empty();
	}
};

