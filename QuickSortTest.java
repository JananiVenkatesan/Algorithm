/*
	Author: Bowen Li, Carnegie Mellon University
	Description: Partition and QuickSort
*/

import java.util.*;


public class QuickSortTest{
	public static void main(String[] args){
		int[] arr = new int[]{9,4,7,2,4,8,1,23,343,87,98,123,43,54,37,95,10,234};

		QuickSort qs = new QuickSort(arr);

		qs.displayArray();
		qs.quickSort();
		qs.displayArray();

	}
}

class QuickSort{
	private int[] arr;
	private int length;

	QuickSort(int[] array){
		arr = array;
		length = arr.length;
		System.out.println(length);
	}

	public void quickSort(){
		recQuickSort(0,length-1);
	}

	public void recQuickSort(int left, int right){
		if(left>=right)
			return;
		else{
			int pivot = getMedianIndex(left, right); // choose pivot as the median of the left, the middle, and the right element
			System.out.println(arr[pivot]);

			if(pivot!=right)
				swap(pivot, right);  // swap pivot the right end

			int partition = partitionIt(left, right);
			recQuickSort(left, partition-1);
			recQuickSort(partition+1,right);
		}
	}

	public int partitionIt(int left, int right){
		int leftPtr = left-1;  // left (after ++)
		int rightPtr = right;  // right-1 (after --)
		int pivot = right;     // pivot is the right end element

		while(true){
			while(arr[++leftPtr] < arr[pivot])  // find an element bigger than pivot
				;

			while(arr[--rightPtr] > arr[pivot])  // find an element smaller than pivot
				;

			if(leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);
		}

		swap(leftPtr, right);   // put pivot into the partition position
		return leftPtr;
	}

	private int getMedianIndex(int left, int right){
		int[] temp = new int[3];
		temp[0] = arr[left];
		temp[1] = arr[(left+right)/2];
		temp[2] = arr[right];

		Arrays.sort(temp);

		if(temp[1]==arr[left])
			return left;
		else if(temp[1]==arr[(left+right)/2])
			return (left+right)/2;
		else 
			return right; 
	}

	private void swap(int x, int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public void displayArray(){
		for(int i=0; i<length;i++)
			System.out.print(arr[i]+"  ");

		System.out.println("");
	}
}