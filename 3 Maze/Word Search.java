/*
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

    For example,
    Given board =

    [
      ["ABCE"],
      ["SFCS"],
      ["ADEE"]
    ]
    word = "ABCCED", -> returns true,
    word = "SEE", -> returns true,
    word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null)
            return false;
    
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    boolean b = exist(board, word, i, j, 0, visited);
                    if(b){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word, int row, int col, int index, boolean[][] visited){
        if(visited[row][col]){
            return false;
        }
        visited[row][col] = true;

        if(index == word.length() - 1){
            return true;
        }

        boolean flag = false;
        char next = word.charAt(index + 1);
        if(isValid(row + 1, col, board) && board[row + 1][col] == next)
            flag = exist(board, word, row + 1, col, index + 1, visited);
            
        if(!flag && isValid(row - 1, col, board) && board[row - 1][col] == next)
            flag = exist(board, word, row - 1, col, index + 1, visited);
            
        if(!flag && isValid(row, col + 1, board) && board[row][col + 1] == next)
            flag = exist(board, word, row, col + 1, index + 1, visited);
            
        if(!flag && isValid(row, col - 1, board) && board[row][col - 1] == next)
            flag = exist(board, word, row, col - 1, index + 1, visited);
        
        // IMPORTANT! If not feaible, change it back to unvisited
        visited[row][col] = false; 
        return flag;
        
    }
    
    public boolean isValid(int row, int col, char[][] board){
        if(row >=0 && row < board.length && col >=0 && col < board[0].length)
            return true;
        else
            return false;
    }
}




public class Solution {
    public boolean exist(char[][] board, String word) {
        // ...
    }
    
    public boolean exist(char[][] board, String word, int row, int col, int index, boolean[][] visited){
        // --------------------------------------------------------
        if(visited[row][col]){
            return false;
        }

        if(board[row][col] != word.charAt(index)){
            return false;
        }
        visited[row][col] = true; 

        if(index == word.length() - 1){
            return true;
        }

        boolean flag = false;
        
        if(isValid(row + 1, col, board) )
            flag = exist(board, word, row + 1, col, index + 1, visited);

        if(!flag && isValid(row - 1, col, board) )
            flag = exist(board, word, row - 1, col, index + 1, visited);

        if(!flag && isValid(row, col + 1, board) )
            flag = exist(board, word, row, col + 1, index + 1, visited);          
        if(!flag && isValid(row, col - 1, board))
            flag = exist(board, word, row, col - 1, index + 1, visited);
        
        visited[row][col] = false; 
        return flag;
        // --------------------------------------------------------
    }
    
    public boolean isValid(int row, int col, char[][] board){
        // ...
    }
}