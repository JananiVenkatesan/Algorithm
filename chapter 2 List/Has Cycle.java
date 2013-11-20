/*

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null)
            return false;
        ListNode fast = head, slow = head;
        while(fast != null){
            fast = fast.next;
            if(fast == slow)
                return true;
            if(fast != null){
                fast = fast.next;
                if(fast == slow)
                    return true;
            }
            slow = slow.next;
        }
        return false;
    }
}