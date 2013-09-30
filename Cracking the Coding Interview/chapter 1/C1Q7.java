/*
Problem:
    Write an algorithm such that if an element in an M x N matrix is 0, 
its entire row and column are set to 0.

Solution:
*/

public class C1Q7{
	public static void main(String[] args){
		int[][] matrix = {{1,2,0,3,4},{5,0,7,8,9},{10,11,12,13,14}};

	}

	public static void setZero(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];

		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length; j++)
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}

		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length; j++)
				if(row[i]||column[j])
					matrix[i][j] = 0;
	}

}