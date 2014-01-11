/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0)
            return null;
        for(int i = lists.size() - 1; i >= 0; i --){  // IMPORTANT!!! From end to start
            if(lists.get(i) == null)
                lists.remove(i);
        }
        
        if(lists.size() == 0)
            return null;
            
        ListNode newhead = new ListNode(0);
        ListNode cur = newhead;
        while(lists.size() != 0){
            ListNode min = new ListNode(Integer.MAX_VALUE);
            int index = -1;
            for(int i = 0; i < lists.size(); i ++){
                if(min.val > lists.get(i).val){
                    min = lists.get(i);
                    index = i;
                }
            }
            cur.next = min;
            cur = cur.next;
            if(lists.get(index).next == null){
                lists.remove(index);
            }
            else{
                lists.set(index, lists.get(index).next);
            }
            cur.next = null;
        }
        return newhead.next;
    }
}

