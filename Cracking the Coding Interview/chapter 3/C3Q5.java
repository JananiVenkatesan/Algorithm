/*
Problem:
    Implement a MyQueue class which implements a queue using two stacks.

Solution:
    page 214
*/

public class MyQueue<T>{  // use generics  泛型
	Stack<T> stackNew, stackOld;

	public MyQueue(){
		stackNew = new Stack<T>();
		stackOld = new Stack<T>();
	}

	public int size(){
		return stackNew.size() + stackOld.size();
	}

	public void add(T value){
		/*  Push onto stackNewest, which always has the newest 
		elements on top
		*/
		stackNew.push(value);
	}

	/* 
	    Move elements from stackNewest into stackOldest. This is
    usually done so that we can do operations on stackOldest.
	*/
	private void shiftStacks(){
		if(stackOld.isEmpty()){
			while(!stackNew.isEmpty()){
				stackOld.push(stackNew.pop());
			}
		}
	}

	public T peek(){
		shiftStacks();  // Ensure stackOld has the current elements
		return stackOld.peek();  // retrieve the oldest item
	}

	public T remove(){
		shiftStacks();  // Ensure stackOldest hasthe current elements
		return stackOld.pop();   // pop the oldest item.
	}

}








