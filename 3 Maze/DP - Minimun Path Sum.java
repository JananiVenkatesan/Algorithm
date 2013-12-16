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

*/

// Recursive
public class Solution {
    public int minPathSum(int[][] grid) {  
        if(grid == null)
            return - 1;
        return minPathSum(grid, 0, 0);
    } 
    
    private int minPathSum(int[][] grid, int row, int col){
        if(row == grid.length - 1 && col == grid[0].length - 1){
            return grid[row][col];
        }
        // Record sums in two ways 
        int sum = Integer.MAX_VALUE;
        if(row < grid.length - 1 && col < grid[0].length){
            sum = minPathSum(grid, row + 1, col);
        }
        if(row < grid.length && col < grid[0].length - 1){
            sum = Math.min(sum, minPathSum(grid, row, col + 1));
        }
        return sum + grid[row][col];
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
        int sum = Integer.MAX_VALUE;
        if(row < grid.length - 1 && col < grid[0].length){
            sum = Math.min(sum, minPathSum(grid, row + 1, col, count));
        }
        if(row < grid.length && col < grid[0].length - 1){
            sum = Math.min(sum, minPathSum(grid, row, col + 1, count));
        }
        
        count[row][col] = sum + grid[row][col];
        
        return count[row][col];
    }
}