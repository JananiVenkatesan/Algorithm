public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null)
            return Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i ++){
            try{
                int n = Integer.parseInt(tokens[i]);
                stack.push(n);
            }
            catch(Exception e){
                int x2 = stack.pop();
                int x1 = stack.pop();
                int result = 0;
                if(tokens[i].equals("+"))
                    result = x1 + x2;
                else if(tokens[i].equals("-"))
                    result = x1 - x2;
                else if(tokens[i].equals("*"))
                    result = x1 * x2;
                else if(tokens[i].equals("/"))
                    result = x1 / x2;
                stack.push(result);
            }
        }
        return stack.peek();
    }
}