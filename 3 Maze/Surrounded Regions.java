/*
-   Start from those boundary cells, use BFS or DFS to traverse all 
non-flipable 'O' cells, and mark them with a special sign, say 'N'.

-   Revisit the board, flip all remaining 'O' cells to 'X' and also 
flip back 'N' cells to 'O'.

*/
public class Solution {
    public void solve(char[][] board) {
        if(board == null)
            return;
            
        int rows = board.length, cols = board[0].length;
        for(int col = 0; col < cols; col ++){
            if(board[0][col] == 'O'){
                checkSurrounded(board, 0, col);
            }
            if(board[rows - 1][col] == 'O'){
                checkSurrounded(board, rows - 1, col);
            }
        }
        
        for(int row = 0; row < rows; row ++){
            if(board[row][0] == 'O'){
                checkSurrounded(board, row, 0);
            }
            if(board[row][cols - 1] == 'O'){
                checkSurrounded(board, row, cols - 1);
            }
        }
        
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'N'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void checkSurrounded(char[][] board, int i, int j){
        board[i][j] = 'N';
        
        if(isValid(board, i + 1, j) && board[i + 1][j] == 'O'){
            checkSurrounded(board, i + 1, j);
        }
        if(isValid(board, i - 1, j) && board[i - 1][j] == 'O'){
            checkSurrounded(board, i - 1, j);
        }
        if(isValid(board, i, j + 1) && board[i][j + 1] == 'O'){
            checkSurrounded(board, i, j + 1);
        }
        if(isValid(board, i, j - 1) && board[i][j - 1] == 'O'){
            checkSurrounded(board, i, j - 1);
        }
    }

    private boolean isValid(char[][] board, int row, int col){
        if(0 <= row && row < board.length && 0 <= col && col <board[0].length){
            return true;
        }
        else{
            return false;
        }
    }
}


/* 
Solution 2: redudant solution

Traverse the whole matrix, if an element is 'O', then mark it 
to 'N', if the region is surrounded, then change all the 'N's 
to 'X's

*/
public class Solution {
    public void solve(char[][] board) {
        if(board == null)
            return;
        for(int i = 1; i < board.length - 1; i ++){
            for(int j = 1; j < board[0].length - 1; j ++){
                if(board[i][j] == 'O'){
                    boolean f = isSurrounded(board, i, j);
                    if(f){
                        paint(board, 'X');
                    }
                }
            }
        }
        paint(board, 'O');
    }
    
    private boolean isSurrounded(char[][] board, int i, int j){
        if(isBorder(board, i, j) && board[i][j] == 'O'){
            return false;
        }
        board[i][j] = 'I';
        boolean[] flag = new boolean[4];
        for(int k = 0; k < 4; k ++){
            flag[k] = true;
        }
        if(isValid(board, i + 1, j) && board[i + 1][j] == 'O'){
            flag[0] = isSurrounded(board, i + 1, j);
        }
        if(isValid(board, i - 1, j) && board[i - 1][j] == 'O'){
            flag[1] = isSurrounded(board, i - 1, j);
        }
        if(isValid(board, i, j + 1) && board[i][j + 1] == 'O'){
            flag[2] = isSurrounded(board, i, j + 1);
        }
        if(isValid(board, i, j - 1) && board[i][j - 1] == 'O'){
            flag[3] = isSurrounded(board, i, j - 1);
        }
        return (flag[0] && flag[1] && flag[2] && flag[3]);
    }
    
    private void paint(char[][] board, char ch){
        for(int i = 1; i < board.length - 1; i ++){
            for(int j = 1; j < board[0].length - 1; j ++){
                if(board[i][j] == 'I')
                    board[i][j] = ch;
            }
        }
    }
    
    private boolean isBorder(char[][] board, int row, int col){
        if(row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isValid(char[][] board, int row, int col){
        if(0 <= row && row < board.length && 0 <= col && col <board[0].length){
            return true;
        }
        else{
            return false;
        }
    }
}