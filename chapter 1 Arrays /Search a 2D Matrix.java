//http://www.youtube.com/watch?v=0-rX-Wocuew
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null)
            return false;
            
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                col --;
            }
            else{
                row ++;
            }
        }
        return false;
    }
}



public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        // Record the row number
        int rowIndex = -1;
        for(int i = 0; i < rows; i++){
            // If target is the last elements of that row
            if(target == matrix[i][cols - 1]){
                return true;
            }
            // Target is in this row
            if(target < matrix[i][cols - 1]){
                rowIndex = i;
                break;
            }
        }
        // Failed to find a row containing target
        if(rowIndex == -1){
            return false;
        }
        return binearySearch(matrix[rowIndex], target);
    }
    
    public boolean binearySearch(int[] num, int target){
        int low = 0, high = num.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(num[mid] == target){
                return true;
            }else if(num[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
    
}