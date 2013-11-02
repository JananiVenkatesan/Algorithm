/*
Problem:
    Implement a MyQueue class which implements a queue using two stacks.

Solution:
    page 214
*/

public class MyQueue<T>{  // use generics  泛型
	Stack<T> s1, s2;

	public MyQueue(){
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}

	public int size(){
		return s1.size() + s2.size();
	}

	public void add(T value){
		/*  Push onto stackNewest, which always has the newest 
		elements on top
		*/
		s1.push(value);
	}

	/* 
	    Move elements from stackNewest into stackOldest. This is
    usually done so that we can do operations on stackOldest.
	*/
	private void shiftStacks(){
		if(s1.isEmpty()){
			while(!s2.isEmpty()){
				s1.push(s2.pop());
			}
		}
	}

	public T peek(){
		shiftStacks();  // Ensure stackOld has the current elements
		return stackOld.peek();  // retrieve the oldest item
	}

	public T remove(){
		shiftStacks();  // Ensure stackOldest hasthe current elements
		return s1.pop();   // pop the oldest item.
	}

}








