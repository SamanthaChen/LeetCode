package Solutions;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueue {
	class MyStack {
	    //只用一个队列(102ms,86.37%)
	    public Queue q = new LinkedList<Integer>();
	    // Push element x onto stack.
	    public void push(int x) {
	        q.add(x);
	        for(int i = 0; i< q.size()-1 ; i++){//添加新的元素后，原来元素往后移
	            q.add(q.poll());
	        }
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        q.poll();
	    }

	    // Get the top element.
	    public int top() {
	        return (int)q.peek();
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	       return q.size() == 0; 
	    }
	}
}
