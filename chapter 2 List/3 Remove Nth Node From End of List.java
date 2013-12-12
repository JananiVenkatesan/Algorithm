/*
	Given a linked list, remove the nth node from the end of 
list and return its head.

	For example,
    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked 
list becomes 1->2->3->5.

 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null || n < 0)
            return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode fast = newHead, slow = newHead;
        for(int i = 0; i < n - 1; i ++){
            fast = fast.next;
            if(fast == null){
                return null;
            }
        }
        ListNode prev = null;
        while(fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return newHead.next;
    }
}