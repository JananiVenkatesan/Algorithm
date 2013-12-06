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
        if(A == null)
            return;
        printLineRight(A, 0, 0);
        printLineDown(A, 1, 0);
    }

    public void printDiagonalRight(char[][] A, int row, int col){
        if(!(row < A.length && col < A[0].length))
            return;
        int i = row, j = col;
        while(i < A.length && j < A[0].length){
            System.out.print(A[i][j]);
            i ++;
            j ++;
        }
        System.out.println();
        printLineRight(A, row, col + 1);
    }

    public void printDiagonalDown(char[][] A, int row, int col){
        if(!(row < A.length && col < A[0].length))
            return;
        int i = row, j = col;
        while(i < A.length && j < A[0].length){
            System.out.print(A[i][j]);
            i ++;
            j ++;
        }
        System.out.println();
        printLineDown(A, row + 1, col);
    }
}
