/*
Problem:
    Find the contiguous subarray within an array (containing at 
least one number) which has the largest sum. Return the sum.

    For example, given the array [−2,1,−3,4,−1,2,1,−5,4], return 
6 since the contiguous subarray [4,−1,2,1] has the largest sum = 6.


Solution:
    This problem is easy.

    Keep tracking the sum of previous numbers. If it's getting lower 
after adding the current one, it tells us that this number should not 
be included in the largest-sum-subarray, so, reset the sum to 0.


*/


public class Solution {
    public int maxSubarray(int[] A){
        int max = Integer.MIN_VALUE;
        if(A == null)
            return max;

        int sum = 0;
        for(int i : A){
            sum += i;
            max = Math.max(max, sum);
            if(sum < 0)
                sum = 0;
        }
        return max;
    }
}







