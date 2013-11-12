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
    public int maxSubArray(int[] A){
        int maxSum = Integer.MIN_VALUE;
        if(A == null)
            return maxSum;
        int sum = 0;
        for(int n : A){
            sum += n;
            maxSum = Math.max(maxSum, sum);
            if(sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}