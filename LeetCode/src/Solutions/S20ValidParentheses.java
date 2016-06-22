package Solutions;

import java.util.Stack;

public class S20ValidParentheses {
    public boolean isValid(String s) {
        //ÓÃÒ»¸öÕ»
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if(a =='(' || a =='{' || a == '['){
                stack.push(a);
            }
            else if(a ==')' || a =='}' || a == ']'){
                if(!stack.empty()) {
                    char b = stack.pop();
                    if(a ==')'){
                        if(b != '(') return false;
                    }
                    if(a =='}'){
                        if(b != '{') return false;
                    }
                    if(a ==']'){
                        if(b != '[') return false;
                    }
                }else{
                    return false;
                }
            }else{
                continue;
            }
        }
        return stack.empty();
    }
}
