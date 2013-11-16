/*
Remove Duplicates from Sorted List I

	Given a sorted linked list, delete all duplicates such that each element appear only once.

	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.



 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
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



 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
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
                cur = cur.next;
                prev = current;
                current = current.next;
            }else{
                prev = current;
                current = current.next;
            }
        }
        if(current.val == prev.val){
            cur.next = null;
        }else{
            cur.next = current;
        }
        return newHead.next;
    }
}