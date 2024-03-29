/*
Remove Duplicates from Sorted List I

	Given a sorted linked list, delete all duplicates such that each 
element appear only once.

	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.

 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null){
            if(curr.val == prev.val){
                prev.next = curr.next;
                curr = prev.next;
            }else{
            prev = curr;
            curr = curr.next;
        }
    }
}

/*
Remove Duplicates from Sorted List II

	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

	For example,
	Given 1->2->3->3->4->4->5, return 1->2->5.
	Given 1->1->1->2->3, return 2->3.
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = head;
        ListNode cur = newHead, prev = newHead, current = head;
        while(current.next != null){
            if(current.val != prev.val && current.val != current.next.val){
                cur.next = current;
                cur = cur.next; // Don't forget to shift cur !!
                current = current.next;
            }else{
                current = current.next;
            }
            prev = prev.next;
        }
        if(current.val == prev.val){
            cur.next = null;
        }else{
            cur.next = current;
        }
        return newHead.next;
    }
}



