/*
Search for a Range 
    Given a sorted array of integers, find the starting and ending 
position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    For example,
        Given [5, 7, 7, 8, 8, 10] and target value 8,
        return [3, 4].
*/

public class Solution {
    public int[] searchRange(int[] A, int target) {
        if(A == null || A.length == 0)
            return null;
        
        int index = -1;
        // Binary Search
        int low = 0, high = A.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(A[mid] == target){
                index = mid;
                break;
            }
            else if(target < A[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        int[] range = new int[2];
        if(index == -1){
            range[0] = -1;
            range[1] = -1;
        }
        else{
            int start = index, end = index;
            while(start >= 0 && A[start] == A[index]){
                start --;
            }
            while(end < A.length && A[end] == A[index]){
                end ++;
            }
            range[0] = start + 1;
            range[1] = end - 1;
        }
        return range;
    }
}




