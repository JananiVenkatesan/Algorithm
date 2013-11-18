/*
Problem:
    Implement a MyQueue class which implements a queue using two stacks.

Solution:
    page 214
*/

public class MyQueue<T>{  // use generics  泛型
	Stack<T> newer, older;

	public MyQueue(){
		newer = new Stack<T>();
		older = new Stack<T>();
	}
	public int size(){
		return newer.size() + older.size();
	}
	public void add(T t){
		/*  Push onto stackNewest, which always has the newest 
		elements on top
		*/
		newer.push(t);
	}
	/* 
	    Move elements from stackNewest into stackOldest. This is
    usually done so that we can do operations on stackOldest.
	*/
	private void shiftStacks(){
		if(older.isEmpty()){
			while(!newer.isEmpty()){
				older.push(newer.pop());
			}
		}
	}
	public T peek(){
		shiftStacks();  // Ensure stackOld has the current elements
		return older.peek();  // retrieve the oldest item
	}
	public T remove(){
		shiftStacks();  // Ensure stackOldest hasthe current elements
		return older.pop();   // pop the oldest item.
	}
}



