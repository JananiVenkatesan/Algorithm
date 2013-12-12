/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if(numRows < 0)
            return null;
            
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0){
            return lists;
        }
        else if(numRows == 1){  // When numRows = 1 
            return n1(lists);
        }
        else if(numRows == 2){  // When numRows = 2
            return n2(lists);
        }
        else{  // When numRows >= 3
            lists = n2(lists);
            int n = 3;
            ArrayList<Integer> l = null;
            while(n <= numRows){
                ArrayList<Integer> prev = lists.get(n - 2);
                l = new ArrayList<Integer>();
                Integer p = null;
                // Loop Integers in prev
                for(Integer i : prev){
                    if(p == null){
                        l.add(i);
                    }else{
                        l.add(p + i);
                    }
                    p = i;
                }
                l.add(prev.get(0));
                lists.add(l);
                n++;
            }
            return lists;
        }
    }
    // When numRows = 1
    public ArrayList<ArrayList<Integer>> n1(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(1);
        lists.add(l);
        return lists;
    }
    // When numRows = 2
    public ArrayList<ArrayList<Integer>> n2(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        lists.add(l1);
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        l2.add(1);
        lists.add(l2);
        return lists;    
    }
}