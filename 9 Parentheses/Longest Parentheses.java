public class Solution {
    public int longestValidParentheses(String s){
    	int max = 0, last = -1;
    	Stack<Integer> stack = new Stack<Integer>();
    	for(int i = 0; i < s.length(); i ++){
    		if(s.charAt(i) == '('){
    			stack.push(i);
    		}
    		else{
    			if(stack.isEmpty()){
    				last = i;
    			}
    			else{
    				stack.pop();
    				if(stack.isEmpty()){
    					max = Math.max(max, i - last);
    				}
    				else{
    					max = Math.max(max, i - stack.peek());
    				}
    			}
    		}
    	}
    	return max;
    }
}