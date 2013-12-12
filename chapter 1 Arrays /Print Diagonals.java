import java.util.*;
import java.io.*;

public class Test{
    public static void main(String[] args){
        char[][] A = new char[][]{{'a','b','c','d'}, 
                                  {'e','f','g','h'}, 
                                  {'i','j','k','l'},
                                  {'m','n','o','p'}};
        Solution s = new Solution();
        s.printDiagonal(A);
    }
}

class Solution{
    public void printDiagonal(char[][] A){
        if(A == null){
            return;
        }
        printToRight(A, 0, 0);
        if(A.length > 1){
            printToBottom(A, 1, 0);
        }
    }

    public void printToRight(char[][] A, int row, int col){
        if(isValid(A, row, col)){
            printDiagonal(A, row, col);
            printToRight(A, row, col + 1);
        }
    }
    public void printToBottom(char[][] A, int row, int col){
        if(isValid(A, row, col)){
            printDiagonal(A, row, col);
            printToBottom(A, row + 1, col);
        }
    }
    public void printDiagonal(char[][] A, int row, int col){
        int i = row, j = col;
        while(isValid(A, i, j)){
            System.out.print(A[i][j]);
            i ++;
            j ++;
        }
        System.out.println();
    }

    public boolean isValid(char[][] A, int row, int col){
        if(row >= 0 && row < A.length && col >= 0 && col < A[0].length){
            return true;
        }
        else{
            return false;
        }
    }
}
