public class Solution {
    public int singleNumber(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A == null || A.length == 0)
            return 0;
            
        int n = A[0];
        for(int i = 1; i < A.length; i ++)
            n = n^A[i];
        return n;
    }
}