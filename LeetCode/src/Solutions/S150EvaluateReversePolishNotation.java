package Solutions;

import java.util.Stack;

public class S150EvaluateReversePolishNotation {
    //思路：利用栈来存储计算数和值
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        String operator = "+-*/";
        int ans = 0;
        for(String t : tokens){
            if(!operator.contains(t)){
                stack.push(Integer.valueOf(t));
            }else{
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());
                switch(t){
                    case("+"): ans = a+b; break;
                    case("-"): ans = a-b; break;
                    case("*"): ans = a*b; break;
                    case("/"):
                        if(b==0) return 0;
                        ans = a/b;
                        break;
                }
                stack.push(ans);
            }
        }
        ans = stack.pop();
        return ans;
    }
}
