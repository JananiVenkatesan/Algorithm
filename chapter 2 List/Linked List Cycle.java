/*
Given a linked list, determine if it has a cycle in it.

Follow up:
    Can you solve it without using extra space?
*/

// Linked List Cycle 
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next;
            if(fast == slow)
                return true;
            fast = fast.next;
            if(fast == slow)
                return true;
            slow = slow.next;
        }
        return false;
    }
}

/*
    Given a linked list, return the node where the cycle begins. 
    If there is no cycle, return null.
*/
    
// Linked List Cycle II
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}