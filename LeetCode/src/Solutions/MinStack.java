package Solutions;

import java.util.Stack;

public class MinStack {
	/** initialize your data structure here. */
	Stack<Integer> datastack;// 存所有的值
	Stack<Integer> minstack;// 辅助栈，存当前最小值

	public MinStack() {
		this.datastack = new Stack<Integer>();
		this.minstack = new Stack<Integer>();
	}

	public void push(int x) {
		int min = 0;
		if (datastack.isEmpty()) {
			min = x;
		} else {
			if (x < minstack.peek())
				min = x;
			else
				min = minstack.peek();
		}
		datastack.push(x);
		minstack.push(min);
	}

	public void pop() {
		datastack.pop();
		minstack.pop();
	}

	public int top() {
		return datastack.peek();
	}

	public int getMin() {
		return minstack.peek();
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(-2);
		stack.push(0);
		stack.push(-3);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.top());
		System.out.println(stack.getMin());

	}

}
