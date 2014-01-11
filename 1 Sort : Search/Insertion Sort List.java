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
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        
        ListNode cur = head.next;
        head.next = null;
        
        while(cur != null){
            ListNode temp = cur;
            cur = cur.next;
            temp.next = null;
            
            ListNode current = newhead.next, prev = newhead;
            while(current != null && temp.val > current.val){
                current = current.next;
                prev = prev.next;
            }
            
            if(current == null){
                prev.next = temp;
            }
            else{
                temp.next = current;
                prev.next = temp;
            }
        }
        return newhead.next;
    }
}