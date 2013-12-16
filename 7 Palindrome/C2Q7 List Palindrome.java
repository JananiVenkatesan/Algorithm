/*
Problem:
    Implement a function to check if a linked list is a palindrome

Solution #1: Reverse and Compare
    Our first solution is to reverse the linked list and compare the reversed list 
to the original list. If they're the same,the lists are identical.
    
    !! Note that when we compare the linked list to the reversed list, we only 
actually need to compare the first half of the list. If the first half of the normal 
list matches the first half of the reversed list, then the second half of the normal 
list must match the second half of the reversed list.

*/

// Solution #1: Iterative Approach !!!
public boolean isPalindrom(ListNode head){
	ListNode slow = head, fast = head;
	
	Stack<Integer> stack = new Stack<Integer>();
	while(fast != null && fast.next != null){
		stack.push(slow.val);
		slow = slow.next;
		fast = fast.next.next;
	}

	if(fast != null){
		slow = slow.next;
	}

	while(!stack.isEmpty()){
		if(slow.val != stack.pop().val){
			return false;
		}
		slow = slow.next;
	}
	return true;
}


/*
Solution #3: Recursive Approach
    page 208
*/

class Result{
	public ListNode node;
	public boolean result;
}

public Result isPalindromeRecurse(ListNode head, int length){
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

public boolean isPalindrome(ListNode head){
	Result p = isPalindromeRecurse(head, listSize(head));
	return p.result;
}


