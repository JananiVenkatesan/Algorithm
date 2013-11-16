/*

Problem:

    Given an image represented by an N x N matrix, where each pixel in the 
image is 4 bytes, write a method to rotate the image by 90 degrees. Can you 
do this in place?


Solution:
    
    A better way to do this is to implement the swap index by index. In 
this case, we do the following:

	1 for i =0 to n
	2 temp = top[i]j
	3 top[i] = left[i]
	4 left[i] = bottom[i] 
	5 bottom[i] = right[i]
	6 right[i] = temp
*/

public class C1Q6{
	public static void main(String[] args){
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		displayMatrix(matrix);
		rotate(matrix);
		displayMatrix(matrix);
	}

	public static int[][] rotate(int[][] matrix){
		// n dimension
		int n = matrix[0].length;
		// layer number start from 0
		for(int layer = 0; layer < n/2; layer++){
			// left and right index of the first element to be rotated in a layer
			int first = layer;
			// right index of the last element
			int last = n - 1 -layer;
			// rotate one layer
			for(int i = first; i < last; i++){
				// save top
				int temp = matrix[first][i];
				int offset = i - first;
				// left->top
				matrix[first][i] = matrix[last-offset][first];
				// bottom->left
				matrix[last-offset][first] = matrix[last][last-offset];
				// right->bottom
				matrix[last][last-offset] = matrix[i][last];
				// top->right
				matrix[i][last] = temp;
			}
		}
		return matrix;
	}

	public static void displayMatrix(int[][] matrix){
		int n = matrix[0].length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.print(" "+matrix[i][j]);
			System.out.println("");	
		}
	}
}









