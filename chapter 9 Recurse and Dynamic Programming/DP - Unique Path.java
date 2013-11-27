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

/*
Follow up:

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid == null)
            return 0;
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return 0;
        int[][] count = new int[grid.length][grid[0].length];
        return uniquePathsWithObstacles(grid, grid.length - 1, grid[0].length - 1, count);
    }
    
    public int uniquePathsWithObstacles(int[][] grid, int row, int col, int[][] count){
        if(row == 0 && col == 0 ){
            return 1;
        }
        if(count[row][col] != 0){
            return count[row][col];
        }
        int sum = 0;
        if(row > 0 && col >= 0 && grid[row - 1][col] != 1){
            sum += uniquePathsWithObstacles(grid, row - 1, col, count);
        }
        if(row >= 0 && col > 0 && grid[row][col - 1] != 1){
            sum += uniquePathsWithObstacles(grid, row, col - 1, count);
        }
        count[row][col] = sum;
        return sum;
    }
}
