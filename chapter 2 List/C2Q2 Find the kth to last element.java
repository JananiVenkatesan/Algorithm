/*
Problem:
    Implement an algorithm to find the kth to last element of a 
singly linked list.

Solution:
    Assume that the length of the LinkedList is unknown.
*/


// Approach 3: Iterative  !!!!!
public ListNode nthToLast(ListNode n, int k){
	if(n == null || k < 0){
		return null;
	}

	ListNode fast = n;
	for(int i = 0; i < k; i ++){
		fast = fast.next;
		if(fast == null)
			return null;
	}

	ListNode slow = n;
	while(fast.next != null){
		fast = fast.next;
		slow = slow.next;
	}
	return slow;
}


// Approach 1: Don't Return the Element - Recursion
public int nthToLast(ListNode head, int k){
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

public ListNode nthToLast(ListNode head, int k, IntWrapper i){
	if(head == null)
		return null;
	ListNode node = nthToLast(head.next, k, i);
	i.value = i.value + 1;
	if(i.value == k)
		return head;
	return node;
}












