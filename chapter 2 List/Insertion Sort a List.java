/*

Sort a linked list using insertion sort.

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

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        
        ListNode cur = head.next;
        head.next = null;
        
        while(cur != null){  // Loop all the nodes
            // Isolate the node
            ListNode temp = cur;
            cur = cur.next;
            temp.next = null;
            
            // Find the insert position
            ListNode pos = newhead.next, prev = newhead;
            while(pos != null && pos.val < temp.val){  // IMPORTANT! ->  pos != null
                pos = pos.next;
                prev = prev.next;
            }

            // If the insert position is at the end
            if(pos == null){
                // System.out.println("prev = "+ prev.val);
                prev.next = temp;
            }
            else{
                temp.next = pos;
                prev.next = temp;
            }

            /*
            ListNode h = newhead.next;
            while(h != null){
                System.out.print(h.val);
                h = h.next;
            }
            System.out.println();
            */
        }
        return newhead.next;
    }
}