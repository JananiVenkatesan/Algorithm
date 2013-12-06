/*

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode head = new ListNode(0);
        if(lists == null)
            return null;
        
        for(int i = lists.size() - 1; i >= 0; i --){  // Eliminate all the Nulls in lists 
            if(lists.get(i) == null){
                lists.remove(i);
            }
        }
        if(lists.size() == 0){
            return null;
        }
        
        ListNode cur = head;
        while(lists.size() != 0){
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int index = -1;
            for(int i = 0; i < lists.size(); i ++){
                if(lists.get(i).val < min.val){
                    min.val = lists.get(i).val;
                    index = i;
                }
            }
            cur.next = min;
            cur = cur.next;
            if(lists.get(index).next == null)
                lists.remove(index);
            else
                lists.set(index, lists.get(index).next);
        }
        return head.next;
    }
}