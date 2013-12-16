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
}

/*
创建一个长度为32的数组a，a[i]表示所有数字在i位出现的次数。
假如a[i]是3的整数倍，则忽略；否则就把该位取出来组成答案。
空间复杂度O(1).
*/

public class Solution {
    public int singleNumber(int[] A){
        if(A == null || A.length == 0)
            return 0;
        
        int[] count = new int[32];
        int result = 0;
        for(int i = 0; i < 32; i ++){
            count[i] = 0;
            for(int j = 0; j < A.length; j ++){
                if( ((A[j] >> i) & 1) == 1)
                    count[i] = (count[i] + 1) % 3;
            }
            result |= (count[i] << i);
        }
        return result;
    }
}



