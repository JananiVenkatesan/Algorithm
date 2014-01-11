/*
    Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with 
the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the 
color red, white, and blue respectively.

*/
public class Solution {
    public void sortColors(int[] A) {
        if(A == null || A.length == 0)
            return;
        int[] color = {0,0,0};
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0){
                color[0] ++;
            }else if(A[i] == 1){
                color[1] ++;
            }else{
                color[2] ++;
            }
        }
        
        if(color[0] > 0){
            fill(A, 0, color[0] - 1, 0);
        }
        if(color[1] > 0){
            fill(A,  color[0] ,  color[0] + color[1] - 1, 1);
        }
        if(color[2] > 0){
            fill(A, color[0] + color[1], A.length - 1, 2);
        }
    }
    public void fill(int[] n, int start, int end, int k){
        for(int i = start; i <= end; i ++){
            n[i] = k;
        }
    }
}