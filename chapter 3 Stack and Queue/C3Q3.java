/*
Problem:
    Imagine a (literal) stack of plates. If the stack gets too high, 
it might topple. Therefore, in real life, we would likely start a new 
stack when the previous stack exceeds some threshold. Implement a data 
structure SetOfStacks that mimics this. SetOfStacks should be composed 
of several stacks and should create a new stack once the previous one 
exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should 
behave identically to a single stack (that is, pop() should return 
the same values as it would if there were just a single stack).

Solution:
    page 217
*/

class SetOfStacks{
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	private int capacity;
	
	public SetOfStacks(int c){
		capacity = c;
	}
	
	public void push(int v){
		Stack s = getLastStack();
		if(s != null && !s.isFull()){  // add to s stack
			s.push(v);
		}else{  // must create new stack
			Stack stack = new Stack(capacity);
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop(){
		Stack s = getLastStack();
		int v = s.pop();
		if(s.isEmpty()){
			stacks.remove(s);
		}
		return v;
	}

	public Stack getLastStack(){
		if(stacks.isEmpty()){
			return null;
		}
		return stacks.get(stacks.size() - 1);
	}
}

/*

FOLLOW UP

    Implement a function popAt(int index) which performs a pop 
operation on a specific sub-stack.



Solution:
    page 218
*/
public class SetOfStacks{
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	private int capacity;

	public SetOfStacks(int c){
		capacity = c;
	}

	public Stack getLastStack(){
		if(stacks.size() == 0){
			return stacks.get(stacks.size() - 1);
		}
	}

	public void push(int v){
		Stack s = getsStack();
		if(s != null && !s.isFull()){
			s.push(v);
		}else{
			Stack stack = new Stack();
			stack.push(v);
			stacks.add(stack);
		}
	}

	public int pop(){
		Stack s = getsStack();
		int v = s.pop();
		if(s.size() == 0){
			stacks.remove(s);
		}
		return v;
	}

	public boolean isEmpty(){
		Stack s = getLastStack();
		return s == null || s.isEmpty();
	}

	public int popAt(int index){
		return leftShift(index, true);
	}

	public int leftShift(int index, boolean removeTop){
		Stack s = stacks.get(index);
		int removed_item;
		if(removeTop){
			removed_item = s.pop();
		}else{
			removed_item = s.removeBottom();
		}
		// if index points to the s stack
		if(s.isEmpty()){
			stacks.remove(index);
		}else if(stacks.size() > index + 1){ // if index points to the rest stack
			int v = leftShift(index + 1, false);
			s.push(v);
		}
		return removed_item;
	}
}

public class Stack{
	private int capacity;
	public Node top, bottom;
	public int size = 0;

	public Stack(int c){
		capacity = c
	}
	public boolean isFull{
		return capacity == size;
	}

	public void join(Node higher, Node lower){
		if(lower != null){
			lower.above = higher;
		}
		if(higher != null){
			higher.below = lower;
		}
	}

	public boolean push(int v){
		if(size >= capacity){
			return false;
		}
		size++;
		Node n = new Node(v);
		if(size == 1){
			bottom = n;
		}
		join(n,top);
		top = n;
		return true;
	}

	public int pop(){
		if(size == 0)
			return Integer.MIN_VALUE;
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int removeBottom(){
		Node b = bottom;
		bottom = bottom.above;
		if(bottom != null){
			bottom.below = null;
		}
		size--;
		return b.value;
	}
}
















