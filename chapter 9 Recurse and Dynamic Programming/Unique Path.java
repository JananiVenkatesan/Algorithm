/*
    A robot is located at the top-left corner of a m x n grid 

    The robot can only move either down or right at any point 
in time. The robot is trying to reach the bottom-right corner 
of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?
*/

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m < 0 || n < 0)
            return -1;
        int[][] count = new int[m][n];
        return uniquePaths(m - 1, n - 1, count);
    }
    
    public int uniquePaths(int m, int n, int[][] count){
        if(m == 0 && n == 0){
            return 1;
        }
        
        if(count[m][n] != 0){
            return count[m][n];
        }
        int sum = 0;
        if(m > 0 && n >= 0){
            sum += uniquePaths(m - 1, n, count);
        }
        if(m >= 0 && n > 0){
            sum += uniquePaths(m, n - 1, count);
        }
        count[m][n] = sum;
        return count[m][n];
    }
}


