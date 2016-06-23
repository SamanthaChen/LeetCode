package DataStructual;

import java.util.Stack;

public class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            
            min=x;
            System.out.println("x="+x+" put:0L"+" min="+min);
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
            System.out.println("x="+x+" put:"+(x-min)+" min="+min);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop=stack.pop();
 

        if (pop<0)  min=min-pop;//If negative, increase the min value
        System.out.println("pop="+pop+" min="+min);

    }

    public int top() {
        long top=stack.peek();
        if (top>0){
        	System.out.println("top="+(top+min)+" min="+min);
            return (int)(top+min);
        }else{
           System.out.println("top="+min+" min="+min);
           return (int)(min);
        }
    }
    public int getMin() {
    	System.out.println(" min="+min);
        return (int)min;
    }
}