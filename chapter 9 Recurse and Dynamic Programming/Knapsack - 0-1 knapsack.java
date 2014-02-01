/**
http://coma-coding.com/blog/algorithms/knapsack-algorithm-in-java
http://www.coma-coding.com/code/java/Knapsack.java


	case 1:
		do not include item(i) and check item(i - 1)
	case 2:
		include item(i) and check item(i - 1)

	F(i, j) = max{ F(i - 1, j), F(i - 1, j - weight(k)) + value(k)}


	Item	Value	Weight
	1		7		2
	2		4		3
	3		8		5
	4		6		4
	5		2		2
	6		5		3


	Using the given values and weights, we build the following solution matrix:
	
	capacity
item	0	1	2	3	4	5	6	7	8	9
	0	0	0	0	0	0	0	0	0	0	0
	1	0	0	7	7	7	7	7	7	7	7
	2	0	0	7	7	7	11	11	11	11	11
	3	0	0	7	7	7	11	11	15	15	15
	4	0	0	7	7	7	11	13	15	15	17
	5	0	0	7	7	9	11	13	15	15	17
	6	0	0	7	7	9	12	13	15	16	18

*/


public int[][] knapsack(int[] value, int[] weight, int capacity){
	int[][] matrix = new int[value.length + 1][weight.length + 1]; 
	int N = value.length;  // Total number of items
	int capacity;  // Total weight boundary

	for(int n = 1; n <= N; n ++){
		for(int w = 1; w <= capacity; w ++){
			if(weight[n] > w){  // Don't put #n item
				matrix[n][w] = matrix[n - 1][w];
			}
			else{
				matrix[n][w] = Math.max(matrix[n - 1][w], matrix[n - 1][w - weight[n]] + value[n])
			}
		}
	}

	return matrix;
}

public int[] getOptimalSubset(int[][] matrix, int[] weight){
	int[] subset = new int[weight.length];
	int numItems = 0;

	int row = matrix.length - 1;
	for(int col = matrix[0].length - 1; col >= 0 && row > 0; row --){
		if(matrix[row][col] != matrix[row - 1][col]){
			subset[numItems] = row;
			numItems ++;
			col = col - weight[row - 1]
		}
	}

}


















