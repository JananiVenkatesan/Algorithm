/*
Problem:
	Write code to remove duplicates from an unsorted linked list. 
	

Solution:
	In order to remove duplicates from a linked list, we need to be able 
to track duplicates. A simple hash table will work well here.
*/

// use buffer - Time Efficiency -> O(N)
void deleteDups(LinkedListNode n){
	if(n == null)
		return false;
	
	HashTable<LinkedListNode, Boolean> ht = new HashTable<LinkedListNode, Boolean>();
	LinkedListNode prev = null;
	while(n != null){
		if(ht.containsKey(n))
			prev.next = n.next;
		else{
			ht.put(n, true);
			prev = n;
		}
		n = n.next;
	}
}


/*

FOLLOW UP
    How would you solve this problem if a temporary buffer is not allowed?

*/

// no buffer used - Time Efficiency -> O(N^2)
void deleteDups(LinkedListNode n){
	if(n != null)
		return;

	LinkedListNode current = n;
	while(current != null){
		LinkedListNode runner = current;
		while(runner.next ! = null){
			if(runner.next.data == current.data)
				runner.next.next = runner.next;
			else
				runner = runner.next;
		}
		current = current.next;
	}
}






