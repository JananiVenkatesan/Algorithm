/*
Problem:
    Write a program to sort a stack in ascending order (with biggest items on top). 
You may use at most one additional stack to hold items, but you may not copy the 
elements into any other data structure (such as an array). The stack supports the 
following operations: push, pop, peek, and isEmpty.

Solution:
    page 215
*/

// This algorithm is O(N2) time and O(N) space.
public static Stack<Integer> sort(Stack<Integer> s){
	Stack<Integer> r = new Stack<Integer>();
	while(!s.isEmpty()){
		int temp = s.pop();  // Step 1
		while(!r.isEmpty() && r.peek() > temp){  // Step 2
			s.push(r.pop());
		}
		r.push(temp);  // Step 3
	}
	return r;
}