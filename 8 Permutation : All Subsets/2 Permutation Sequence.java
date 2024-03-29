/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

public String getPermutation(int n, int k){
	if(n <= 0 || k <= 0)
		return "";
	int[] f = new int[n];
	StringBuilder nums = new StringBuilder();
	for(int i = 1; i <= n; i ++){
		nums.append(i);
		if(i == 1)
			f[i - 1] = 1;
		else
			f[i - 1] = f[i - 2] * i;
	}

	// Normalize k so that it is within range [0 .. n!]
	while(k > f[n - 1])
		k -= f[n - 1];
	k --;  // Convert to 0-based
      
	for(int i = 0; i < n - 1; i ++){
		int factorial = f[n - 2 - i];  // (n - 1 - i)!
		int id = k / factorial + i;
		// Shift the numbers
		char num = nums.charAt(id);
		for(int j = id; j > i; j --){
			nums.setCharAt(j, nums.charAt(j - 1));
		}
		nums.setCharAt(i, num);
		while(k >= factorial){
			k -= factorial;
		}
	}

	// Convert to string
	return nums.toString();
}