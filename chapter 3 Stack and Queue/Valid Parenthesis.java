public class Solution {
    public boolean isValid(String s) {
        if(s == null){
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            
            if(c == ')' || c == ']' || c == '}'){
                if(!stack.isEmpty()){
                    char p = stack.pop();
                    if( (c == ')' && p != '(') || (c == ']' && p != '[') || (c == '}' && p != '{')){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}