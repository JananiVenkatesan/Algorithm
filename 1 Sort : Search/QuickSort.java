public void quicksort(int[] arr){
  quicksort(arr, 0, arr.length - 1);
}

public void quicksort(int[] arr, int left, int right){
  if(left < right){
      int partition  = partition(arr, left, right);
      quickSort(arr, left, partition - 1);
      quickSort(arr, partition + 1, right);
  }
}

public int partition(int[] arr, int left, int right){
  int pivot = arr[left];
  while(left < right){
      while(left < right && arr[right] >= pivot){
          right--;
      }
      if(left < right){
          arr[left] = arr[right];
          left++;
      }
      while(left < right && arr[left] <= pivot){
          left++;
      }
      if(left < right){
          arr[right] = arr[left];
          right--;
      }
  }
  
  arr[left] = pivot;
  return left;
}