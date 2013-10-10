/*
Problem:
    Implement an algorithm to find the kth to last element of a singly linked list.


Solution:
    Assume that the length of the LinkedList is unknown.



Approach 1: Don't Return the Element - Recursion

*/

 int nthToLast(LinkedListNode head, int k){
	if(head == null)
		return 0;
	int i = nthToLast(head.next, k) + 1;
	if(i == k)
		System.out.println(head.data);
	return i;
}

/*

Approach 2: Create a Wrapper Class
 	because we couldn't simultaneously return a counter and an index

*/

class IntWrapper{
	public int value = 0;
}

LinkedListNode nthToLast(LinkedListNode head, int k, IntWrapper i){
	if(head == null)
		return null;
	LinkedListNode node = nthToLast(head.next, k, i);
	i.value = i.value + 1;
	if(i.value == k)
		return head;
	return node;
}

/*

Approach 3: Iterative  !!!!!

*/

LinkedListNode nthToLast(LinkedListNode head, int k){
	if(k <= 0)
		return null;

	LinkedListNode p1 = head;
	LinkedListNode p2 = head;

	// Move p2 -forward k nodes into the list
	for(int i = 0; i < k; i++){
		if(p2 == null)
			return null;
		p2 = p2.next;
	}
	if(p2 == null)
		return null;

	/* Now, movee p1 and p2 at the same speed. When p2 hits the end, 
	p1 will be at the right element. */
	while(p2.next != null){
		p1 = p1.next;
		p2 = p2.next;
	}
	return p1;
}











