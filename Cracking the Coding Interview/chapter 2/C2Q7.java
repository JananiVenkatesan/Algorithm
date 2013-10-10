/*
Problem:
    Implement a function to check if a linked list is a palindrome


Solution #1: Reverse and Compare

    Our first solution is to reverse the linked list and comparethe reversed list 
to the original list. If they're the same,the lists are identical.
    
    !! Note that when we compare the linked list to the reversed list, we only 
actually need to compare the first half of the list. If the first half of the normal 
list matches the first half of the reversed list, then the second half of the normal 
list must match the second half of the reversed list.


Solution #2: Iterative Approach !!!

    We want to detect linked lists where the front half of the list is the reverse of the 
second half. How would we do that? <!!! By reversing the front half of the list. A 
stack can accomplish this. >

    We need to push the first half of the elements onto a stack. We can do this in 
two different ways, depending on whether or not we know the size of the linked list.

    If we know the size of the linked list, we can iterate through the first half of 
the elements in a standard for loop, pushing each element onto a stack. We must be 
careful, of course, to handle the case where the length of the linked list is odd.

    If we don't know the size of the linked list, we can iterate through the linked 
list, using the fast runner/slow runner technique described in the beginning of the 
chapter. At each step in the loop, we push the data from the slow runner onto a stack.
When the fast runner hits the end of the list, the slow runner will have reached the 
middle of the linked list. By this point, the stack will have all the elements from the front of the linked list, 
but in reverse order.

    Now, we simply iterate through the rest of the linked list. At each iteration, 
we compare the node to the top of the stack. If we complete the iteration without 
finding a difference, then the linked list is a palindrome.

*/


public boolean isPalindrome(LinkedListNode head){
	LinkedListNode fast = head;
	LinkedListNode slow = head;

	Stack<Integer> stack = new Stack<Integer>();

	/* Push elements from first half of linked list onto stack. When 
	 * fast runner (which is moving at 2x speed) reaches the end of 
	 * the linked list, then we know we're at the middle */
	while(fast != null && fast.next != null){
		stack.push(slow.data);
		slow = slow.next;
		fast = fast.next.next;
	}

	/* Has odd number of elements, so skip the middle element */
	if(fast != null){
		slow = slow.next;
	}

	while(slow != null){
		int top = stack.pop().intValue();
		/* If values are different, then it's not a palindrome */
		if(top != slow.data){
			return false;
		}
		slow = slow.next；
	}
	return true;
}


/*
Solution #3: Recursive Approach
    page 208
*/

class Result{
	public LinkedListNode node;
	public boolean result;
}

public Result isPalindromeRecurse(LinkedListNode head, int length){
	if(head == null || length == null){
		return new Result(null, true);
	}else if(length == 1){
		return new Result(head.next, true);
	}else if(length == 2){
		return new Result(head.next.next, head.data == head.next.data);
	}
	Result res = isPalindrome(head.next, length - 2);
	if(!res.result || res.node == null){
		return res;
	}else{
		res.result = head.data == res.node.data;
		res.node = res.node.next;
		return res;
	}
}

public boolean isPalindrome(LinkedListNode head){
	Result p = isPalindromeRecurse(head, listSize(head));
	return p.result;
}
















