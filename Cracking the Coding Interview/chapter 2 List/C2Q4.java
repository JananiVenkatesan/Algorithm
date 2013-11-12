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

public LinkedListNode partition(LinkedListNode node, int x){
	LinkedListNode lowerStart  = null;
	LinkedListNode lowerEnd    = null;
	LinkedListNode higherStart = null;
	LinkedListNode higherEnd   = null;

	// Partition list
	while(node != null){
		LinkedListNode next = node.next;
		node.next = null;  // seperate the node with the following ones
		if(node.data < x){
			// Insert node into end of before list
			if (lowerStart == null) {
				lowerStart = node;
				lowerEnd = lowerStart;
			}else{
				lowerEnd.next = node;
				lowerEnd = lowerEnd.next;
			}
		}else{
			// Insert node into end of after list
			if(higherStart == null){
				higherStart = node;
				higherEnd = higherStart;
			}else{
				higherEnd.next = node;
				higherEnd = higherEnd.next;
			}
		}
		node = next;
	}

	if(lowerStart == null)
		return higherStart;

	// Merge before list and after list
	lowerEnd.next = higherStart;
	return lowerStart;
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

