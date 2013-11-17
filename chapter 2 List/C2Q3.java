/*

Problem:

    Implement an algorithm to delete a node in the middle of a 
singly linked list, given only access to that node.


Solution:

    In this problem, you are not given access to the head of the linked list. You 
only have access to that node. The solution is simply to copy the data from the 
next node over to the current node, and then to delete the next node.

*/

public boolean deleteNode(LinkedListNode node){
	if(n == null || n.next == null)
		return false;
	node.data = node.next.data;
	node.next = node.next.next;
	return true;
}