/*

    Given a sorted array and a target value, return the index if the 
target is found. If not, return the index where it would be if it 
were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/

public class Solution {
    public int searchInsert(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(A == null)
            return -1;
    
        int i = 0;
        while(i < A.length){
            if(target <= A[i])
                return i;
            i ++;
        }
        return i;
    }
}