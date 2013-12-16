public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i ++){
            if(hm.containsKey(A[i])){
                hm.put(A[i], hm.get(A[i]) + 1);
            }
            else{
                hm.put(A[i], 1);
            }
        }
        
        Set<Integer> coll = hm.keySet();
        int single = 0;
        for(Integer i : coll){
            if(hm.get(i) != 3)
                single = i;
        }
        return single;
    }
}public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0)
            return 0;
            
        int n = A[0];
        for(int i = 1; i < A.length; i ++)
            n = n^A[i];
        return n;
    }
}