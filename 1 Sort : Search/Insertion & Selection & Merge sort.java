/**
* Selection Sort
*/

public void selectionSort(int[] arr){
	int out, in, min;

	for(int out = 0; out < arr.length; out ++){
		min = out;

		for(int in = out; in < arr.length; in ++){
			if(arr[in] < arr[min])
				min = in;
		}

		swap(min, out);
	}
}

/**
* Insertion Sort
*/

public void insertionSort(int[] arr){
	int out, in, min;

	for(int out = 1; out < arr.length; out ++){
		int temp = out;
		in = out;

		while(in > 0 && a[in - 1] >= temp){
			a[in] = a[in - 1];
			in --;
		}

		a[in] = temp;
	}
}


/**
* Merge Sort
*/

public void mergeSort(int[] arr){
	recMergeSort(arr, 0, arr.length);
}

public void recMergeSort(int[] arr, int lower, int upper){
	if(lower == upper)
		return;
	else{
		int mid = lower + (upper - lower) / 2;

		recMergeSort(arr, lower, mid);
		recMergeSort(arr, mid + 1, upper);

		merge(arr, lower, mid + 1, upper);
	}
}

public void merge(int[] arr, int lowPtr, int highPtr, int upperBound){
	int mid = highPtr - 1;
	int lowerBound = lowPtr;

	int n = upperBound - lowerBound + 1;

	int j = 0;
	while(lowPtr <= mid && highPtr <= upperBound){
		if(a[lowPtr] < a[highPtr])
			arr[j ++] = a[lowPtr ++]
	}
}



