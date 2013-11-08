/*

Problem:

    Given a circular linked list, implement an algorithm which returns the 
node at the beginning of the loop.



Solution:

    This is a modification of a classic interview problem: detect if a linked 
list has a loop. Let's apply the Pattern Matching approach.

    To summarize, we move FastPointer twice as fast as SlowPointer. When SlowPointer
enters the loop, after k nodes, FastPointer is k nodes into the linked list. This 
means that FastPointer and SlowPointer are LOOP_SIZE - k nodes away from each other.

    Next,if FastPointer moves two nodes for each node that SlowPointer moves,they 
move one node closer to each other on each turn. Therefore, they will meet after 
LOOP_ SIZE - k turns. Both will be k nodes from the front of the loop.

    The head of the linked list is also k nodes from the front of the loop. So, if 
we keep one pointer where it is, and move the other pointer to the head of the linked 
list, then they will meet at the front of the loop.

    Our algorithm is derived directly from parts 1,2 and 3.
1. Createtwo pointers, FastPointer and SlowPointer.
2. Move FastPointer at a rate of 2 steps and SlowPointer at a rate of 1step.
3. When they collide, move SlowPointer to LinkedListHead.Keep FastPointerwhere it is.
4. Move SlowPointer and FastPointer at a rate of one step. Return the new collision point.

*/

public LinkedListNode FindLoopBeginning(LinkedListNode head){
	LinkedListNode slow = head;
	LinkedListNode fast = head;
	//  Find meeting point. This will be LOOP_SIZE - k steps into the linked list
	while(slow != fast){
		slow = slow.next;
		fast = fast.next.next;
	}
	/* 
	    Move slow to Head. Keep fast at Meeting Point. Each are k steps from the Loop Start. 
	    If they move at the same pace, they must meet at Loop Start
	*/
	fast = head;
	while(slow != fast){
		slow = slow.next;
		fast = fast.next;
	}

	return slow;
}









