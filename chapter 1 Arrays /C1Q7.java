/*

Problem:

    Write an algorithm such that if an element in an M x N 
matrix is 0, its entire row and column are set to 0.



Solution:
*/

public void setZero(int[][] matrix){
	if(matrix == null)
		return;

	boolean[] rows = new boolean[matrix.length];
	boolean[] cols = new boolean[matrix[0].length];
	for(int i = 0; i < rows.length; i ++){
		for(int j = 0; j < cols.length; j ++){
			if(matrix[i][j] == 0){
				rows[i] = true;
				cols[j] = true;
			}
		}
	}

	for(int i = 0; i < rows.length; i ++){
		for(int j = 0; j < cols.length; j ++){
			if(rows[i] || cols[j]){
				matrix[i][j] = 0;
			}
		}
	}
}