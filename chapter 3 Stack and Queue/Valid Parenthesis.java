public class Solution {
    public boolean isValid(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(s == null){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        // Loop the characters
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