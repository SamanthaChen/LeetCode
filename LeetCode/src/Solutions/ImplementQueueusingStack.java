package Solutions;

import java.util.Stack;

public class ImplementQueueusingStack {
	class MyQueue {
	    
	    //创建两个栈来保存
	    
	    public Stack in = new Stack();
	    public Stack out = new Stack();

	    //使得in一直为有元素状态，out一直为空(java 120ms,8.5%)
	    // // Push element x to the back of queue.
	    // public void push(int x) {
	    //     in.push(x);
	 
	    // }

	    // // Removes the element from in front of queue.
	    // public void pop() {
	    //     while(!in.empty())
	    //         out.push(in.pop());//把in栈元素弹出，然后压入out栈(此时in为空)
	    //     out.pop();//把队首弹出，
	    //     while(!out.empty()) 
	    //         in.push(out.pop());//剩下的压回去in栈（此时out为空,in满）
	    // }

	    // // Get the front element.
	    // public int peek() {
	    //     while(!in.empty()){
	    //         out.push(in.pop());//把in栈元素弹出，然后压入out栈（in为空）
	    //     }
	    //     int peek = (int)out.peek();
	    //     while(!out.empty()) //获取完peek元素，恢复原来样子（out为空,in满）
	    //         in.push(out.pop());
	    //     return peek;
	    // }

	    // // Return whether the queue is empty.
	    // public boolean empty() {
	    //     return in.empty();//由于in一直保持满的状态，out一直保持空，还是留着in
	        
	        
	        
	     //不必一直保持out为空 ,省去重复的进栈出栈 (114ms ,22.44%) 提升了一点
	     // Push element x to the back of queue.
	    public void push(int x) {
	        in.push(x);
	 
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        peek();//若out不为空，弹出out栈顶，否则将in压入栈
	        out.pop();
	    }

	    // Get the front element.
	    public int peek() {
	        if(out.empty()){//该输出的元素是空的时候，检查in是否为空
	            while(!in.empty()) out.push(in.pop());//in不为空，out为空，将新元素压入栈
	        }
	        return (int) out.peek();//out不为空，继续返回之前队首
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return in.empty() && out.empty();
	    }
	        
	}
}
