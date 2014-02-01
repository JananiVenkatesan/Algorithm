/**

	case 1:
		do not include item(i) and check item(i - 1)
	case 2:
		include item(i) and still stays with item(i) to see if more is required

	F(i, j) = max{ F(i - 1, j), F(i, j - weight(k)) + value(k)}

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
				matrix[n][w] = Math.max(matrix[n - 1][w], matrix[n][w - weight[n]] + value[n])
			}
		}
	}

	return matrix;
}