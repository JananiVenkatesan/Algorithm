/*
Problem:    
    Write code to partition a linked list around a value x, such that all 
nodes less than x come before all nodes greater than or equal to x.

Solution:    
    If this were an array, we would need to be careful about how we shifted 
elements. Array shifts are very expensive.

    However, in a linked list, the situation is much easier. Rather than 
shifting and swapping elements, we can actually create two different linked 
lists: one for elements less than x, and one for elements greater than or 
equal to x.

    We iterate through the linked list, inserting elements into our before 
list or our after list. Once we reach the end of the linked list and have 
completed this splitting, we merge the two lists.


Solution #1:
	Pass in the head of the linked list and the value to partition around 
*/

public ListNode partition(ListNode n, int x){
	if(n == null)
		return nul;
	ListNode lowStart = null, lowEnd = null, highStart = null, highEnd = null;

	while(n != null){
		ListNode cur = n;
		n = n.next;
		cur.next = null;
		if(n.val < x){
			if(lowStart == null){
				lowStart = cur;
				lowEnd = cur;
			}
			else{
				lowEnd.next = cur;
				lowEnd = lowEnd.next;
			}
		}
		else{
			if(highStart == null){
				highStart = cur;
				highEnd = cur;
			}
			else{
				highEnd.next = cur;
				highEnd = highEnd.next;
			}
		}
	}

	if(lowStart == null)
		return highStart;
	
	lowEnd.next = highStart;
	return lowStart;
}

/*
Solution #2:
   The second solution operates in a slightly different way. Instead of inserting 
nodes into the end of the before 11st and the after list, it inserts nodes into 
the front of them.
*/

public LinkedListNode partiton(LinkedListNode node, int x){
	LinkedListNode beforeStart = null;
	LinkedListNode afterStart = null;

	// Partition list
	while(node != null){
		LinkedListNode next = node.next;
		if(node.data < x){
			// Insert node into start of before list
			node.next = beforeStart;
			beforeStart = node;
		}else{
			// Insert node into start of before list
			node.next = afterStart;
			afterStart = node;
		}
		node = next;
	}
	// Merge before list and after list
	if(beforeStart == null)
		return afterStart;

	// Find end of before list, and merge the lists
	LinkedListNode head = beforeStart;
	while(beforeStart.next != null){
		beforeStart = beforeStart.next;
	}
	beforeStart.next = afterStart;
	return head;
}

