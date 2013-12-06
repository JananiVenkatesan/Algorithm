public class Solution {
    public int[] searchRange(int[] A, int target) {
        if(A == null || A.length == 0)
            return null;
        
        int left = 0, right = A.length - 1, index = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(A[mid] == target){
                index = mid;
                break;
            }
            else if(target < A[mid]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        
        int[] range = new int[2];
        if(index != -1){
            int start = index, end = index;
            while(start > 0 && A[start] == A[start - 1]){
                start --;
            }
            while(end < A.length - 1 && A[end] == A[end + 1]){
                end ++;
            }
            range[0] = start;
            range[1] = end;
        }
        else{
            range[0] = -1;
            range[1] = -1;
        }
        return range;
    }
}