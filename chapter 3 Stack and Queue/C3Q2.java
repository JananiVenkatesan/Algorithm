/*
Problem:
    How would you design a stack which, in addition to push 
and pop, also has a function min which returns the minimum 
element? Push, pop and min should all operate in 0(1) time.

Solution:
    page 215
*/

class NodeWithMin{
	public int value;
	public int min;
	public NodeWithMin(int v, int m){
		value = v;
		min = m;
	}
}

public class StackWithMin extends Stack<NodeWithMin>{
	public void push(int value){
		int min = Math.min(value, min());
		super.push(new NodeWithMin(value, min);
	}

	public int min(){
		if(!this.isEmpty()){
			return peek().min;
		}else{
			return Integer.MAX_VALUE;
		}
	}
}

//-------------------

class StackWithMin2 extends Stack<Integer>{
	Stack<Integer> s2 = new Stack<Integer>();

	public void push(int value){
		if(value <= min()){
			s2.push(value);
		}
		super.push(value);
	}

	public Integer pop(){
		int value = super.pop();
		if(value = min()){
			s2.pop();
		}
		return value;
	}

	public int min(){
		if(s2.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return s2.peek();
		}
	}
}














