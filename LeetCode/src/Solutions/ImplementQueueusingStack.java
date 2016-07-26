package Solutions;

import java.util.Stack;

public class ImplementQueueusingStack {
	class MyQueue {
	    
	    //��������ջ������
	    
	    public Stack in = new Stack();
	    public Stack out = new Stack();

	    //ʹ��inһֱΪ��Ԫ��״̬��outһֱΪ��(java 120ms,8.5%)
	    // // Push element x to the back of queue.
	    // public void push(int x) {
	    //     in.push(x);
	 
	    // }

	    // // Removes the element from in front of queue.
	    // public void pop() {
	    //     while(!in.empty())
	    //         out.push(in.pop());//��inջԪ�ص�����Ȼ��ѹ��outջ(��ʱinΪ��)
	    //     out.pop();//�Ѷ��׵�����
	    //     while(!out.empty()) 
	    //         in.push(out.pop());//ʣ�µ�ѹ��ȥinջ����ʱoutΪ��,in����
	    // }

	    // // Get the front element.
	    // public int peek() {
	    //     while(!in.empty()){
	    //         out.push(in.pop());//��inջԪ�ص�����Ȼ��ѹ��outջ��inΪ�գ�
	    //     }
	    //     int peek = (int)out.peek();
	    //     while(!out.empty()) //��ȡ��peekԪ�أ��ָ�ԭ�����ӣ�outΪ��,in����
	    //         in.push(out.pop());
	    //     return peek;
	    // }

	    // // Return whether the queue is empty.
	    // public boolean empty() {
	    //     return in.empty();//����inһֱ��������״̬��outһֱ���ֿգ���������in
	        
	        
	        
	     //����һֱ����outΪ�� ,ʡȥ�ظ��Ľ�ջ��ջ (114ms ,22.44%) ������һ��
	     // Push element x to the back of queue.
	    public void push(int x) {
	        in.push(x);
	 
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        peek();//��out��Ϊ�գ�����outջ��������inѹ��ջ
	        out.pop();
	    }

	    // Get the front element.
	    public int peek() {
	        if(out.empty()){//�������Ԫ���ǿյ�ʱ�򣬼��in�Ƿ�Ϊ��
	            while(!in.empty()) out.push(in.pop());//in��Ϊ�գ�outΪ�գ�����Ԫ��ѹ��ջ
	        }
	        return (int) out.peek();//out��Ϊ�գ���������֮ǰ����
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        return in.empty() && out.empty();
	    }
	        
	}
}
