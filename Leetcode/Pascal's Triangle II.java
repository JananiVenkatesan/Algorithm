/*

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1]

*/


public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(rowIndex < 0)
            return null;
            
        if(rowIndex == 0){  // [1]
            return n0();
        }
        else if(rowIndex == 1){  // [1,1]
            return n1();
        }
        else{  
            ArrayList<Integer> l = n1();
            int n = 2;
            while(n <= rowIndex){
                ArrayList<Integer> prev = l;
                l = new ArrayList<Integer>();
                Integer p = null;
                // Loop Integers in prev
                for(Integer i : prev){
                    if(p == null){
                        l.add(i);
                        p = i;
                    }else{
                        l.add(p + i);
                        p = i;
                    }
                }
                l.add(prev.get(0));
                n++;
            }
            return l;
        }
    }
    public ArrayList<Integer> n0(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(1);
        return l;
    }
    public ArrayList<Integer> n1(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(1);
        return l;    
    }
}