/*
    Given a m x n grid filled with non-negative numbers, find 
a path from top left to bottom right which minimizes the sum 
of all numbers along its path.
    
    Note: You can only move either down or right at any point 
in time.

    Suppose we have a m by n table for the sum results.
        
    sum[i][j] is the minimum sum of all numbers from grid[0][0] 
    to grid[i][j], inclusively.
        
    The DP formular becomes 
    sum[i][j] = grid[i][j] + min( sum[i-1][j], sum[i][j-1] )
        
    Furthermore, noticing that we only need the neighbor to the 
    left and the one above the current one. We can use just two rows 
    and switch back and forth.

*/

// Recursive
public class Solution {
    public int minPathSum(int[][] grid) {  
        if(grid == null)
            return - 1;
        return minPathSum(grid, 0, 0);
    } 
    
    public int minPathSum(int[][] grid, int row, int col){
        if(row == grid.length - 1 && col == grid[0].length - 1){
            return grid[row][col];
        }
        // Record sums in two ways 
        int sum1 = 0, sum2 = 0;
        if(row < grid.length - 1 && col < grid[0].length){
            sum1 = minPathSum(grid, row + 1, col);
        }
        if(row < grid.length && col < grid[0].length - 1){
            sum2 = minPathSum(grid, row, col + 1);
        }
        return Math.min(sum1, sum2) + grid[row][col];
    }
}

// Dynamic Programming
public class Solution {
    public int minPathSum(int[][] grid) {  
        if(grid == null)
            return -1;
        int[][] count = new int[grid.length][grid[0].length];
        return minPathSum(grid, 0, 0, count);
    }
    
    public int minPathSum(int[][] grid, int row, int col, int[][] count){
        if(row == grid.length - 1 && col == grid[0].length - 1){
            return grid[row][col];
        }
        if(count[row][col] != 0){
            return count[row][col];
        }
        int sum = 0, sum2 = 0;
        boolean flag1 = false, flag2 = false;
        if(row < grid.length - 1 && col < grid[0].length){
            sum1 = minPathSum(grid, row + 1, col, count);
            flag1 = true;
        }
        if(row < grid.length && col < grid[0].length - 1){
            sum2 = minPathSum(grid, row, col + 1, count);
            flag2 = true;
        }
        if(flag1 && flag2){
            count[row][col] = Math.min(sum1, sum2) + grid[row][col];
        }
        else if(flag1 || flag2){
            count[row][col] = (flag1 ? sum1 : sum2) + grid[row][col];
        }
        else{
            count[row][col] = grid[row][col];
        }
        return count[row][col];
    }
}